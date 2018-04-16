package eu.stamp.project;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.Switch;
import fr.inria.diversify.utils.AmplificationHelper;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 08/03/18
 */
public class JSAPOptions {

    public static final JSAP options = JSAPOptions.initJSAP();

    public static void showUsage() {
        System.err.println();
        System.err.println("Usage: java -jar target/Ex2Amplifier-experiments-0.0.1-SNAPSHOT-jar-with-dependencies.jar");
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
                        + AmplificationHelper.LINE_SEPARATOR + "Each project should be on" +
                        " one line, and in this format: <owner>/<repository-name>/."
                        + AmplificationHelper.LINE_SEPARATOR + "the output is a json file contained in result/.";
        get.setHelp(helpForGet);

        Switch JBSEMode = new Switch("JBSE");
        JBSEMode.setLongFlag("jbse");
        JBSEMode.setShortFlag('j');
        JBSEMode.setHelp("enable de JBSE mode of the Ex2Amplifier");

        FlaggedOption mavenHome = new FlaggedOption("maven-home");
        mavenHome.setStringParser(JSAP.STRING_PARSER);
        mavenHome.setAllowMultipleDeclarations(false);
        mavenHome.setLongFlag("maven-home");
        mavenHome.setHelp("[Optional] specify a custom path for maven.");

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
        run.setHelp("[TASK] run the Ex2Amplifier, using the ChangeDetectorSelector." + AmplificationHelper.LINE_SEPARATOR
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

        Switch onlyAampl = new Switch("aampl");
        onlyAampl.setHelp("[optional] will use only A-amplification.");
        onlyAampl.setDefault("false");
        onlyAampl.setLongFlag("aampl");

        FlaggedOption depth = new FlaggedOption("depth");
        depth.setStringParser(JSAP.INTEGER_PARSER);
        depth.setAllowMultipleDeclarations(false);
        depth.setLongFlag("depth");
        depth.setDefault("8");

        FlaggedOption count = new FlaggedOption("count");
        count.setStringParser(JSAP.INTEGER_PARSER);
        count.setAllowMultipleDeclarations(false);
        count.setLongFlag("count");
        count.setDefault("1500");

        Switch amplifiers = new Switch("amplifiers");
        amplifiers.setHelp("[optional] will use \"classical\" amplifiers, i.e. StatementAdd and Literal amplifiers");
        amplifiers.setShortFlag('a');
        amplifiers.setLongFlag("amplifiers");
        amplifiers.setDefault("false");

        Switch reverse = new Switch("reverse");
        reverse.setHelp("[optional] will amplify modified version, and see if amplified tests fail on the base");
        reverse.setLongFlag("reverse");
        reverse.setDefault("false");

        try {
            jsap.registerParameter(help);
            jsap.registerParameter(verbose);
            jsap.registerParameter(get);
            jsap.registerParameter(clone);
            jsap.registerParameter(run);
            jsap.registerParameter(output);
            jsap.registerParameter(idPr);
            jsap.registerParameter(JBSEMode);
            jsap.registerParameter(onlyAampl);
            jsap.registerParameter(amplifiers);
            jsap.registerParameter(reverse);
            jsap.registerParameter(depth);
            jsap.registerParameter(count);
            jsap.registerParameter(mavenHome);
        } catch (JSAPException e) {
            throw new RuntimeException(e);
        }
        return jsap;
    }

}
