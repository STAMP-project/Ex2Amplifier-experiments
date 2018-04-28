package com.squareup.javapoet;


import com.google.testing.compile.CompilationRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public final class AmplClassNameTest {
    static class OuterClass {
        static class InnerClass {}
    }

    @Rule
    public CompilationRule compilationRule = new CompilationRule();

    private void assertBestGuessThrows(String s) {
        try {
            ClassName.bestGuess(s);
            Assert.fail();
        } catch (IllegalArgumentException expected) {
        }
    }
}

