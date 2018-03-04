package fr.inria.stamp;

import com.google.gson.Gson;
import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Switch;
import edu.emory.mathcs.backport.java.util.Collections;
import fr.inria.diversify.dspot.DSpot;
import fr.inria.diversify.dspot.amplifier.StatementAdd;
import fr.inria.diversify.dspot.amplifier.TestDataMutator;
import fr.inria.diversify.dspot.selector.ChangeDetectorSelector;
import fr.inria.diversify.utils.DSpotUtils;
import fr.inria.diversify.utils.sosiefier.InputConfiguration;
import fr.inria.stamp.ex2amplifier.Ex2Amplifier;
import fr.inria.stamp.git.Cloner;
import fr.inria.stamp.git.ParserPullRequest;
import fr.inria.stamp.git.ProjectJSON;
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
import java.util.List;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 16/01/18
 */
public class Main {

    private static boolean onlyAampl = false;

    private static boolean JBSE = false;

    public static boolean verbose = false;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static final JSAP options = initJSAP();

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {
        JSAPResult jsapConfig = options.parse(args);
        Main.verbose = jsapConfig.getBoolean("verbose");
        Main.onlyAampl = jsapConfig.getBoolean("aampl");
        Main.JBSE = jsapConfig.getBoolean("JBSE");
        if (jsapConfig.getBoolean("help")) {
            showUsage();
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
                final List<CtType> amplifiedTestClasses;
                if (jsapConfig.getString("testClass").isEmpty()) {
                    amplifiedTestClasses = Main.run(jsapConfig.getString("run"), jsapConfig.getInt("id"), "");
                } else {
                    amplifiedTestClasses = Main.run(jsapConfig.getString("run"), jsapConfig.getInt("id"), jsapConfig.getString("testClass"));
                }
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
            showUsage();
        }
    }

    private static List<CtType> run(String pathToJsonFile, int id, String testClassToBeAmplified) throws Exception {
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
                        final InputConfiguration inputConfiguration;
                        if (new File(finalPath + projectJSON.name + id + ".properties").exists()) {
                            inputConfiguration = new InputConfiguration(finalPath + projectJSON.name + id + ".properties");
                            inputConfiguration.getProperties().setProperty("configPath", finalPath + projectJSON.name + id + ".properties");
                        } else {
                            inputConfiguration = new InputConfiguration(finalPath + projectJSON.name + ".properties");
                            inputConfiguration.getProperties().setProperty("configPath", finalPath + projectJSON.name + ".properties");
                        }
                        inputConfiguration.getProperties().setProperty("project",
                                inputConfiguration.getProperty("project") + "/" + pullRequestJSON.id + "/");
                        inputConfiguration.getProperties().setProperty("folderPath",
                                inputConfiguration.getProperty("folderPath") + "/" + pullRequestJSON.id + Cloner.SUFFIX_VERSION_2 + "/");
                        inputConfiguration.getProperties().setProperty("outputDirectory",
                                inputConfiguration.getProperty("outputDirectory") + "/" + pullRequestJSON.id + "/" +
                                        (onlyAampl ? "A_ampl" :
                                                (JBSE ?
                                                        Ex2Amplifier.Ex2Amplifier_Mode.JBSE.toString() :
                                                        Ex2Amplifier.Ex2Amplifier_Mode.CATG.toString()
                                                )
                                        )
                        );
                        final Ex2Amplifier ex2Amplifier = Ex2Amplifier.getEx2Amplifier(JBSE ?
                                Ex2Amplifier.Ex2Amplifier_Mode.JBSE : Ex2Amplifier.Ex2Amplifier_Mode.CATG
                        );
                        ex2Amplifier.init(inputConfiguration);
                        final ChangeDetectorSelector changeDetectorSelector = new ChangeDetectorSelector();
                        final DSpot dSpot = new DSpot(
                                inputConfiguration,
                                1,
                                onlyAampl ? Collections.emptyList() : Arrays.asList(ex2Amplifier),
                                changeDetectorSelector
                        );
                        if (testClassToBeAmplified.isEmpty()) {
                            ctTypes.addAll(dSpot.amplifyAllTests());
                        } else {
                            ctTypes.addAll(dSpot.amplifyTest(testClassToBeAmplified));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        return ctTypes;
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

    private static void showUsage() {
        System.err.println();
        System.err.println("Usage: java -jar target/dspot-1.0.0-jar-with-dependencies.jar");
        System.err.println("                          " + options.getUsage());
        System.err.println();
        System.err.println(options.getHelp());
        System.exit(1);
    }

    private static JSAP initJSAP() {
        JSAP jsap = new JSAP();

        Switch help = new Switch("help");
        help.setLongFlag("help");
        help.setShortFlag('h');
        help.setHelp("shows this help");

        Switch verbose = new Switch("verbose");
        verbose.setLongFlag("verbose");
        verbose.setShortFlag('v');
        verbose.setHelp("enable verbose mode.");

        Switch get = new Switch("get");
        get.setLongFlag("get");
        get.setShortFlag('g');
        final String helpForGet =
                "[TASK] get all metadata about openned pull request" +
                        " of specified projects in dataset/projects."
                        + LINE_SEPARATOR + "Each project should be on" +
                        " one line, and in this format: <owner>/<repository-name>/."
                        + LINE_SEPARATOR + "the output is a json file contained in result/.";
        get.setHelp(helpForGet);

        Switch JBSEMode = new Switch("JBSE");
        JBSEMode.setLongFlag("jbse");
        JBSEMode.setShortFlag('j');
        JBSEMode.setHelp("enable de JBSE mode of the Ex2Amplifier");

        FlaggedOption clone = new FlaggedOption("clone");
        clone.setStringParser(JSAP.STRING_PARSER);
        clone.setAllowMultipleDeclarations(false);
        clone.setShortFlag('c');
        clone.setLongFlag("clone");
        clone.setHelp("[TASK] clone all pull request datas (base and head) of the specified json file.");

        FlaggedOption run = new FlaggedOption("run");
        run.setStringParser(JSAP.STRING_PARSER);
        run.setAllowMultipleDeclarations(false);
        run.setShortFlag('r');
        run.setLongFlag("run");
        run.setHelp("[TASK] run the Ex2Amplifier, using the ChangeDetectorSelector." + LINE_SEPARATOR
                + "You must specify options of DSpot after the flag separated with $.");

        FlaggedOption output = new FlaggedOption("output");
        output.setStringParser(JSAP.STRING_PARSER);
        output.setAllowMultipleDeclarations(false);
        output.setShortFlag('o');
        output.setLongFlag("output");
        output.setDefault("target/ex2amplifier_out/");
        output.setHelp("[optional] Specify the output path of the selected task. (default: target/ex2amplifier_out/");

        FlaggedOption idPr = new FlaggedOption("id");
        idPr.setStringParser(JSAP.INTEGER_PARSER);
        idPr.setAllowMultipleDeclarations(false);
        idPr.setShortFlag('i');
        idPr.setLongFlag("id");
        idPr.setDefault("-1");
        idPr.setHelp("[optional] specify a pr ID. If no value is given, it will process all the ids");

        FlaggedOption testClass = new FlaggedOption("testClass");
        testClass.setStringParser(JSAP.STRING_PARSER);
        testClass.setAllowMultipleDeclarations(false);
        testClass.setShortFlag('t');
        testClass.setLongFlag("testClass");
        testClass.setDefault("");
        idPr.setHelp("[optional] specify the full qualified name of test class to be amplified");

        Switch onlyAampl = new Switch("aampl");
        onlyAampl.setHelp("[optional] will use only A-amplification.");
        onlyAampl.setDefault("false");
        onlyAampl.setLongFlag("aampl");
        onlyAampl.setShortFlag('a');

        try {
            jsap.registerParameter(help);
            jsap.registerParameter(verbose);
            jsap.registerParameter(get);
            jsap.registerParameter(clone);
            jsap.registerParameter(run);
            jsap.registerParameter(output);
            jsap.registerParameter(idPr);
            jsap.registerParameter(testClass);
            jsap.registerParameter(JBSEMode);
            jsap.registerParameter(onlyAampl);
        } catch (JSAPException e) {
            showUsage();
        }
        return jsap;
    }

}
