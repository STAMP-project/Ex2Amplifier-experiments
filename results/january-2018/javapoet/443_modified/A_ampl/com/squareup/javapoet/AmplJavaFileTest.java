package com.squareup.javapoet;


import java.util.concurrent.TimeUnit;
import javax.lang.model.element.Modifier;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public final class AmplJavaFileTest {
    private TypeSpec importStaticTypeSpec(String name) {
        MethodSpec method = MethodSpec.methodBuilder("minutesToSeconds").addModifiers(Modifier.PUBLIC, Modifier.STATIC).returns(long.class).addParameter(long.class, "minutes").addStatement("$T.gc()", System.class).addStatement("return $1T.SECONDS.convert(minutes, $1T.MINUTES)", TimeUnit.class).build();
        return TypeSpec.classBuilder(name).addMethod(method).build();
    }
}

