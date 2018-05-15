package com.squareup.javapoet;


import com.google.testing.compile.CompilationRule;
import javax.lang.model.element.TypeElement;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public final class AmplTypeSpecTest {
    private final String tacosPackage = "com.squareup.tacos";

    private static final String donutsPackage = "com.squareup.donuts";

    @Rule
    public final CompilationRule compilation = new CompilationRule();

    private TypeElement getElement(Class<?> clazz) {
        return compilation.getElements().getTypeElement(clazz.getCanonicalName());
    }

    private boolean isJava8() {
        return (Util.DEFAULT) != null;
    }

    private String toString(TypeSpec typeSpec) {
        return JavaFile.builder(tacosPackage, typeSpec).build().toString();
    }
}

