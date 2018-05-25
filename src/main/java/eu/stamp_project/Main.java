package eu.stamp_project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.martiansoftware.jsap.JSAPResult;
import eu.stamp_project.dspot.Amplification;
import eu.stamp_project.ex2amplifier.catg.CATGExecutor;
import eu.stamp_project.testrunner.EntryPoint;
import eu.stamp_project.ex2amplifier.amplifier.Ex2Amplifier;
import eu.stamp_project.ex2amplifier.jbse.JBSERunner;
import eu.stamp_project.dspot.DSpot;
import eu.stamp_project.dspot.amplifier.AllLiteralAmplifiers;
import eu.stamp_project.dspot.amplifier.Amplifier;
import eu.stamp_project.dspot.amplifier.StatementAdd;
import eu.stamp_project.dspot.selector.ChangeDetectorSelector;
import eu.stamp_project.utils.AmplificationHelper;
import eu.stamp_project.utils.DSpotUtils;
import eu.stamp_project.utils.json.ClassTimeJSON;
import eu.stamp_project.utils.json.ProjectTimeJSON;
import eu.stamp_project.utils.sosiefier.InputConfiguration;
import eu.stamp_project.diff.SelectorOnDiff;
import eu.stamp_project.git.Cloner;
import eu.stamp_project.git.ParserPullRequest;
import eu.stamp_project.git.ProjectJSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spoon.reflect.declaration.CtType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 16/01/18
 */
public class Main {

    static String mavenHome = null;

    static boolean reverse = false;

    static boolean Ex2AmplifierMode = true;

    static boolean onlyAampl = false;

    static boolean JBSE = false;

    public static boolean verbose = false;

    public static boolean useWorkingDirectory = true;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {
        JSAPResult jsapConfig = JSAPOptions.options.parse(args);
        Main.verbose = jsapConfig.getBoolean("verbose");
        AmplificationHelper.setTimeOutInMs(120000);
        EntryPoint.verbose = Main.verbose;
        Main.onlyAampl = jsapConfig.getBoolean("aampl");
        Amplification.preAmplify = Main.onlyAampl;
        Main.JBSE = jsapConfig.getBoolean("JBSE");
        Main.Ex2AmplifierMode = !jsapConfig.getBoolean("amplifiers");
        Main.reverse = jsapConfig.getBoolean("reverse");
        Main.mavenHome = jsapConfig.getString("maven-home");

        JBSERunner.depthScope = jsapConfig.getInt("depth");
        JBSERunner.countScope = jsapConfig.getInt("count");
        if (jsapConfig.getBoolean("help")) {
            JSAPOptions.showUsage();
        } else if (jsapConfig.getBoolean("get")) {
            Main.get(jsapConfig.getString("output"));
        } else if (jsapConfig.getString("clone") != null) {
            try {
                Main.cloneFromFork(jsapConfig.getString("clone"), jsapConfig.getString("output"), jsapConfig.getInt("id"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (jsapConfig.getString("run") != null) {
            try {
                final List<CtType> amplifiedTestClasses = Main.run(jsapConfig.getString("run"), jsapConfig.getInt("id"));
                // TODO assert fixer each test case
                // We will keep two versions of the same amplified test case: one that pass on the new version and one that fail
                // it aims a providing in any case, an amplified test case meargeable by developers
                // if the behavioral change is desired, we keep the version that pass
                // if the behavioral change is undesired, we keep the version that fail
                // TODO WARNING, this create a failing test classe
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            JSAPOptions.showUsage();
        }
    }

    private static List<CtType> run(String pathToJsonFile, int id) throws Exception {
        Gson gson = new Gson();
        final ProjectJSON projectJSON =
                gson.fromJson(new FileReader(pathToJsonFile), ProjectJSON.class);
        final String[] split = pathToJsonFile.split("/");
        String path = "";
        for (int i = 0; i < split.length - 1; i++) {
            path += split[i] + "/";
        }

        final List<CtType> ctTypes = new ArrayList<>();
        String finalPath = path;
        projectJSON.pullRequests.stream()
                .filter(pullRequestJSON -> pullRequestJSON.id == id || id == -1)
                .forEach(pullRequestJSON -> {
                    try {
                        final InputConfiguration inputConfiguration = InputConfigurationManager.setupConfiguration(id, projectJSON, finalPath, pullRequestJSON);
                        final List<Amplifier> amplifiers;
                        if (Ex2AmplifierMode) {
                            final Ex2Amplifier ex2Amplifier = Ex2Amplifier.getEx2Amplifier(JBSE ?
                                    Ex2Amplifier.Ex2Amplifier_Mode.JBSE : Ex2Amplifier.Ex2Amplifier_Mode.CATG
                            );
                            ex2Amplifier.init(inputConfiguration);
                            amplifiers = Collections.singletonList(ex2Amplifier);
                        } else {
                            amplifiers = Collections.singletonList(new AllLiteralAmplifiers());
                        }
                        final ChangeDetectorSelector changeDetectorSelector = new ChangeDetectorSelector();
                        final DSpot dSpot = new DSpot(
                                inputConfiguration,
                                Ex2AmplifierMode ? 1 : 3,
                                onlyAampl ? Collections.emptyList() : amplifiers,
                                changeDetectorSelector
                        );
                        CATGExecutor.setWorkingDirectory(new File(dSpot.getInputProgram().getProgramDir()));
                        final Map<String, List<String>> testMethodsAccordingToADiff =
                                SelectorOnDiff.findTestMethodsAccordingToADiff(inputConfiguration);
                        ctTypes.addAll(
                                testMethodsAccordingToADiff
                                        .keySet()
                                        .stream()
                                        .map(ctType -> dSpot.amplifyTest(ctType, testMethodsAccordingToADiff.get(ctType)))
                                        .collect(Collectors.toList())
                        );
                        updateProjectTimeJSON(inputConfiguration,
                                dSpot,
                                testMethodsAccordingToADiff,
                                changeDetectorSelector
                        );
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        return ctTypes;
    }

    private static void updateProjectTimeJSON(InputConfiguration inputConfiguration,
                                              DSpot dSpot,
                                              Map<String, List<String>> testMethodsAccordingToADiff,
                                              ChangeDetectorSelector changeDetectorSelector) throws FileNotFoundException {
        final String[] splittedPath = dSpot.getInputProgram().getProgramDir().split("/");
        final File projectJsonFile = new File(inputConfiguration.getOutputDirectory() +
                "/" + splittedPath[splittedPath.length - 1] + ".json");
        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        ProjectTimeJSON projectTimeJSON =
                gsonBuilder.fromJson(new FileReader(projectJsonFile), ProjectTimeJSON.class);
        testMethodsAccordingToADiff.keySet().stream()
                .forEach(testClassName -> {
                            final ClassTimeJSON classtimeJSONToBeUpdated = projectTimeJSON.classTimes.stream()
                                    .filter(classTimeJSON -> classTimeJSON.fullQualifiedName.equals(testClassName))
                                    .findFirst()
                                    .get();
                            classtimeJSONToBeUpdated.setNumberOfTestMethodToBeAmplified(
                                    testMethodsAccordingToADiff.get(testClassName).size()
                            );
                            classtimeJSONToBeUpdated.setNumberOfAmplifiedTestMethods(
                                    changeDetectorSelector.getNbOfAmplification(testClassName)
                            );
                        }
                );
        try (FileWriter writer = new FileWriter(projectJsonFile, false)) {
            writer.write(gsonBuilder.toJson(projectTimeJSON));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void cloneFromFork(String pathToJsonFile, String output, int prId) throws FileNotFoundException {
        Gson gson = new Gson();
        final ProjectJSON projectJSON =
                gson.fromJson(new FileReader(pathToJsonFile), ProjectJSON.class);
        LOGGER.info("Clone all data of pull request of {}", pathToJsonFile);
        LOGGER.info("{} Pull request to be cloned", projectJSON.pullRequests.size());
        projectJSON.pullRequests.stream()
                .filter(pr -> pr.id == prId || prId == -1)
                .forEach(pr -> {
                    Cloner.cloneBothVersionOfForReplicationOfExp(projectJSON.name, pr, output + "/" + projectJSON.name);
                    DSpotUtils.printProgress(projectJSON.pullRequests.indexOf(pr), projectJSON.pullRequests.size());
                });
    }

    private static void clone(String pathToJsonFile, String output) throws FileNotFoundException {
        Gson gson = new Gson();
        final ProjectJSON projectJSON =
                gson.fromJson(new FileReader(pathToJsonFile), ProjectJSON.class);
        LOGGER.info("Clone all data of pull request of {}", pathToJsonFile);
        LOGGER.info("{} Pull request to be cloned", projectJSON.pullRequests.size());
        projectJSON.pullRequests.forEach(pr -> {
            Cloner.cloneBothVersionOf(pr, output + "/" + projectJSON.name);
            DSpotUtils.printProgress(projectJSON.pullRequests.indexOf(pr), projectJSON.pullRequests.size());
        });
    }

    private static void get(String output) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(output + "/projects"))) {
            buffer.lines().forEach(project -> {
                LOGGER.info("getting pull request for {}", project);
                ParserPullRequest.buildPullRequestList(output, project);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
