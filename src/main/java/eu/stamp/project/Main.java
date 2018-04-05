package eu.stamp.project;

import com.google.gson.Gson;
import com.martiansoftware.jsap.JSAPResult;
import eu.stamp.project.ex2amplifier.amplifier.Ex2Amplifier;
import eu.stamp.project.ex2amplifier.jbse.JBSERunner;
import fr.inria.diversify.dspot.DSpot;
import fr.inria.diversify.dspot.amplifier.AllLiteralAmplifiers;
import fr.inria.diversify.dspot.amplifier.Amplifier;
import fr.inria.diversify.dspot.amplifier.ReplacementAmplifier;
import fr.inria.diversify.dspot.amplifier.StatementAdd;
import fr.inria.diversify.dspot.selector.ChangeDetectorSelector;
import fr.inria.diversify.utils.DSpotUtils;
import fr.inria.diversify.utils.sosiefier.InputConfiguration;
import fr.inria.stamp.diff.SelectorOnDiff;
import eu.stamp.project.git.Cloner;
import eu.stamp.project.git.ParserPullRequest;
import eu.stamp.project.git.ProjectJSON;
import eu.stamp.project.git.PullRequestJSON;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spoon.reflect.declaration.CtType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 16/01/18
 */
public class Main {

    private static String mavenHome = null;

    private static boolean reverse = false;

    private static boolean Ex2AmplifierMode = true;

    private static boolean onlyAampl = false;

    private static boolean JBSE = false;

    public static boolean verbose = false;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {
        JSAPResult jsapConfig = JSAPOptions.options.parse(args);
        Main.verbose = jsapConfig.getBoolean("verbose");
        fr.inria.stamp.Main.verbose = Main.verbose;
        Main.onlyAampl = jsapConfig.getBoolean("aampl");
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
                Main.clone(jsapConfig.getString("clone"), jsapConfig.getString("output"));
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
                        final InputConfiguration inputConfiguration = setupConfiguration(id, projectJSON, finalPath, pullRequestJSON);
                        final List<Amplifier> amplifiers;
                        if (Ex2AmplifierMode) {
                            final Ex2Amplifier ex2Amplifier = Ex2Amplifier.getEx2Amplifier(JBSE ?
                                    Ex2Amplifier.Ex2Amplifier_Mode.JBSE : Ex2Amplifier.Ex2Amplifier_Mode.CATG
                            );
                            ex2Amplifier.init(inputConfiguration);
                            amplifiers = Collections.singletonList(ex2Amplifier);
                        } else {
                            amplifiers = Arrays.asList(new StatementAdd(), new ReplacementAmplifier(), new AllLiteralAmplifiers());
                        }
                        final ChangeDetectorSelector changeDetectorSelector = new ChangeDetectorSelector();
                        final DSpot dSpot = new DSpot(
                                inputConfiguration,
                                1,
                                onlyAampl ? Collections.emptyList() : amplifiers,
                                changeDetectorSelector
                        );

                        ctTypes.addAll(
                                SelectorOnDiff.findTestClassesAccordingToADiff(inputConfiguration)
                                        .stream()
                                        .map(dSpot::amplifyTest)
                                        .collect(Collectors.toList())
                        );
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        return ctTypes;
    }

    @NotNull
    private static InputConfiguration setupConfiguration(int id,
                                                         ProjectJSON projectJSON,
                                                         String finalPath,
                                                         PullRequestJSON pullRequestJSON) throws IOException {
        final InputConfiguration inputConfiguration;
        if (new File(finalPath + projectJSON.name + id + ".properties").exists()) {
            inputConfiguration = new InputConfiguration(finalPath + projectJSON.name + id + ".properties");
            inputConfiguration.getProperties().setProperty("configPath", finalPath + projectJSON.name + id + ".properties");
        } else {
            inputConfiguration = new InputConfiguration(finalPath + projectJSON.name + ".properties");
            inputConfiguration.getProperties().setProperty("configPath", finalPath + projectJSON.name + ".properties");
        }

        if (reverse) {
            inputConfiguration.getProperties().setProperty("project",
                    inputConfiguration.getProperty("project") + "/" + pullRequestJSON.id + Cloner.SUFFIX_VERSION_2 + "/");
            inputConfiguration.getProperties().setProperty("folderPath",
                    inputConfiguration.getProperty("folderPath") + "/" + pullRequestJSON.id + "/");
        } else {
            inputConfiguration.getProperties().setProperty("project",
                    inputConfiguration.getProperty("project") + "/" + pullRequestJSON.id + "/");
            inputConfiguration.getProperties().setProperty("folderPath",
                    inputConfiguration.getProperty("folderPath") + "/" + pullRequestJSON.id + Cloner.SUFFIX_VERSION_2 + "/");
        }

        inputConfiguration.getProperties().setProperty("outputDirectory",
                inputConfiguration.getProperty("outputDirectory") + "/" +
                        getRightOutputSuffx(pullRequestJSON.id)
        );

        inputConfiguration.getProperties().setProperty("baseSha",
                reverse ? pullRequestJSON.headSha : pullRequestJSON.baseSha
        );

        if (Main.mavenHome != null) {
            inputConfiguration.getProperties().put("maven.home", Main.mavenHome);
        }

        return inputConfiguration;
    }

    private static String getRightOutputSuffx(int id) {
        String suffixExp = Main.reverse ? id + "_modified/" : id + "/";
        if (Main.onlyAampl) {
            return suffixExp + "A_ampl";
        } else if (!Main.Ex2AmplifierMode) {
            return suffixExp + "I_ampl";
        } else {
            if (Main.JBSE) {
                return suffixExp + Ex2Amplifier.Ex2Amplifier_Mode.JBSE.toString();
            } else {
                return suffixExp + Ex2Amplifier.Ex2Amplifier_Mode.CATG.toString();
            }
        }
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
