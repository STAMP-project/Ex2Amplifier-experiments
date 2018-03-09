package fr.inria.stamp.diff;

import edu.emory.mathcs.backport.java.util.Collections;
import fr.inria.diversify.utils.AmplificationChecker;
import gumtree.spoon.AstComparator;
import gumtree.spoon.diff.Diff;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.visitor.filter.TypeFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 08/03/18
 */
public class DiffFinder {

    public static Set<CtType> findTestClassesAccordingToADiff(Factory factory,
                                                                 String baseSha,
                                                                 String pathToFirstVersion,
                                                                 String pathToSecondVersion) {
        //get the modified methods
        final Set<String> modifiedJavaFiles = pathToModifiedJavaFile(baseSha, pathToSecondVersion);

        // keep modified test in the PR: must be present in both versions of the program
        final Set<CtType> modifiedTestClasses =
                getModifiedTestClasses(factory, pathToFirstVersion, pathToSecondVersion, modifiedJavaFiles);
        if (!modifiedTestClasses.isEmpty()) {
            return modifiedTestClasses;
        }
        // find all modified methods
        final Set<CtMethod> modifiedMethods = modifiedJavaFiles.stream()
                .flatMap(s ->
                        getModifiedMethod(
                                pathToFirstVersion + s.substring(1),
                                pathToSecondVersion + s.substring(1)
                        ).stream()
                ).collect(Collectors.toSet());
        // TODO not sure this is good, if the changed method are used everywhere in the project...
        //find all test classes that execute those methods
        return factory.Package().getRootPackage()
                .getElements(new TypeFilter<CtExecutableReference>(CtExecutableReference.class) {
                    @Override
                    public boolean matches(CtExecutableReference element) {
                        return modifiedMethods.contains(element.getDeclaration());
                    }
                }).stream()
                .map(ctExecutableReference -> ctExecutableReference.getParent(CtType.class))
                .filter(ctType -> ctType.getMethods()
                        .stream()
                        .anyMatch(method -> {
                                    try {
                                        return AmplificationChecker.isTest((CtMethod<?>) method);
                                    } catch (Exception e) {
                                        return false;
                                    }
                                }
                        )
                ).collect(Collectors.toSet());
    }

    private static Set<CtType> getModifiedTestClasses(Factory factory,
                                                         String pathToFirstVersion,
                                                         String pathToSecondVersion,
                                                         Set<String> modifiedJavaFiles) {
        return modifiedJavaFiles.stream()
                .filter(pathToClass ->
                        new File(pathToFirstVersion + pathToClass.substring(1)).exists() &&
                        new File(pathToSecondVersion + pathToClass.substring(1)).exists() // it is present in both versions
                ).filter(pathToClass -> {
                    final String[] split = pathToClass.split("/");
                    return (split[split.length - 1].split("\\.")[0].endsWith("Test") || // the class in a test class
                            split[split.length - 1].split("\\.")[0].startsWith("Test"));
                })
                .map(pathToClass -> pathToClass.substring("a/src/main/java/".length()).split("\\.")[0].replace("/", "."))// TODO maybe be more flexible on the src/main/java (use the InputConfiguration
                .map(nameOfModifiedTestClass -> factory.Class().get(nameOfModifiedTestClass))
                .collect(Collectors.toSet());
    }

    public static Set<CtMethod> getModifiedMethod(String pathFile1, String pathFile2) {
        try {
            final File file1 = new File(pathFile1);
            final File file2 = new File(pathFile2);
            if (!file1.exists() || !file2.exists()) {
                return Collections.emptySet();
            }
            Diff result = (new AstComparator()).compare(file1, file2);
            return result.getRootOperations()
                    .stream()
                    .map(operation -> operation.getSrcNode().getParent(CtMethod.class))
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Set<String> pathToModifiedJavaFile(String baseSha, String pathToChangedVersion) {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(
                    "git diff " + baseSha,
                    new String[]{},
                    new File(pathToChangedVersion));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final Set<String> modifiedJavaFiles = new BufferedReader(new InputStreamReader(p.getInputStream()))
                .lines()
                .filter(line -> line.startsWith("diff") && line.endsWith(".java"))
                .map(line -> line.split(" ")[2])
                .collect(Collectors.toSet());
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return modifiedJavaFiles;
    }

}
