package eu.stamp.project;

import eu.stamp.project.ex2amplifier.amplifier.Ex2Amplifier;
import eu.stamp.project.git.Cloner;
import eu.stamp.project.git.ProjectJSON;
import eu.stamp.project.git.PullRequestJSON;
import fr.inria.diversify.utils.sosiefier.InputConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 18/04/18
 */
public class InputConfigurationManager {


    @NotNull
    public static InputConfiguration setupConfiguration(int id,
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

        if (Main.reverse) {
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
                Main.reverse ? pullRequestJSON.headSha : pullRequestJSON.baseSha
        );

        if (Main.mavenHome != null) {
            inputConfiguration.getProperties().put("maven.home", Main.mavenHome);
        }

        final String module = getModule(pullRequestJSON.baseSha, inputConfiguration);
        if (!module.isEmpty()) {
            inputConfiguration.getProperties().setProperty("targetModule", module);
        }

        return inputConfiguration;
    }

    private static String getModule(String baseSha, InputConfiguration configuration) {
        Process p;
        try {
            p = Runtime.getRuntime().exec(
                    "git diff " + baseSha,
                    new String[0],
                    new File(configuration.getProperty("folderPath"))
            );
        } catch (IOException var6) {
            throw new RuntimeException(var6);
        }

        final Map<Object, Long> numberOfModifiedFilePerModule = new BufferedReader(new InputStreamReader(p.getInputStream()))
                .lines()
                .filter(line -> line.startsWith("diff"))
                .filter(line -> line.endsWith(".java"))
                .filter(line -> !(line.contains(configuration.getRelativeTestSourceCodeDir())))
                .collect(
                        Collectors.groupingBy(
                                line -> line.split(" ")[2].substring(2).split("/")[0],
                                Collectors.counting()
                        )
                );
        try {
            p.waitFor();
            final String key = (String) Collections.max(
                    numberOfModifiedFilePerModule.entrySet(),
                    Comparator.comparingLong(Map.Entry::getValue)
            ).getKey();
            return configuration.getRelativeSourceCodeDir().contains(key) ? "" : key;
        } catch (InterruptedException var5) {
            throw new RuntimeException(var5);
        }
    }

    static String getRightOutputSuffx(int id) {
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
}
