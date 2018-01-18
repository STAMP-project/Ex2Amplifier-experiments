package fr.inria.stamp;

import com.google.gson.Gson;
import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Switch;
import edu.emory.mathcs.backport.java.util.Collections;
import fr.inria.diversify.dspot.DSpot;
import fr.inria.diversify.dspot.selector.ChangeDetectorSelector;
import fr.inria.diversify.utils.DSpotUtils;
import fr.inria.diversify.utils.sosiefier.InputConfiguration;
import fr.inria.stamp.git.Cloner;
import fr.inria.stamp.git.ParserPullRequest;
import fr.inria.stamp.git.ProjectJSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spoon.reflect.declaration.CtType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 16/01/18
 */
public class Main {

    public static boolean verbose = false;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static final JSAP options = initJSAP();

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) {
        JSAPResult jsapConfig = options.parse(args);
        Main.verbose = jsapConfig.getBoolean("verbose");
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
                Main.run(jsapConfig.getString("run"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            showUsage();
        }
    }

    private static void run(String pathToJsonFile) throws Exception {
        Gson gson = new Gson();
        final ProjectJSON projectJSON =
                gson.fromJson(new FileReader(pathToJsonFile), ProjectJSON.class);
        final String[] split = pathToJsonFile.split("/");
        String path = "";
        for (int i = 0 ; i < split.length - 1 ; i ++) {
            path += split[i] + "/";
        }
        final InputConfiguration inputConfiguration = new InputConfiguration(path + projectJSON.name + ".properties");
        inputConfiguration.getProperties().setProperty("configPath", path + projectJSON.name + ".properties");
        projectJSON.pullRequests.stream()
                .forEach(pullRequestJSON -> {
                    inputConfiguration.getProperties().setProperty("project",
                            inputConfiguration.getProperty("project") + "/" + pullRequestJSON.id + "/");
                    inputConfiguration.getProperties().setProperty("folderPath",
                            inputConfiguration.getProperty("folderPath") + "/" + pullRequestJSON.id + Cloner.SUFFIX_VERSION_2 + "/");
                    final Ex2Amplifier ex2Amplifier = new Ex2Amplifier(inputConfiguration);
                    final ChangeDetectorSelector changeDetectorSelector = new ChangeDetectorSelector();
                    try {
                        final DSpot dSpot = new DSpot(
                                inputConfiguration,
                                1,
                                Collections.singletonList(ex2Amplifier),
                                changeDetectorSelector
                        );
                        final List<CtType> ctTypes = dSpot.amplifyAllTests();
                        System.out.println(ctTypes);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
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
        try (BufferedReader buffer = new BufferedReader(new FileReader("dataset/projects"))) {
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

        try {
            jsap.registerParameter(help);
            jsap.registerParameter(verbose);
            jsap.registerParameter(get);
            jsap.registerParameter(clone);
            jsap.registerParameter(run);
            jsap.registerParameter(output);
        } catch (JSAPException e) {
            showUsage();
        }
        return jsap;
    }

}
