package com.squareup.javapoet;


import com.google.common.truth.Truth;
import java.util.concurrent.TimeUnit;
import javax.lang.model.element.Modifier;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public final class AmplJavaFileTest {
    @Ignore("addStaticImport doesn't support members with $L")
    @Test
    public void importStaticDynamic() {
        JavaFile source = JavaFile.builder("com.squareup.tacos", TypeSpec.classBuilder("Taco").addMethod(MethodSpec.methodBuilder("main").addStatement("$T.$L.println($S)", System.class, "out", "hello").build()).build()).addStaticImport(System.class, "out").build();
        Truth.assertThat(source.toString()).isEqualTo(("" + (((((((("package com.squareup.tacos;\n" + "\n") + "import static java.lang.System.out;\n") + "\n") + "class Taco {\n") + "  void main() {\n") + "    out.println(\"hello\");\n") + "  }\n") + "}\n")));
    }

    private TypeSpec importStaticTypeSpec(String name) {
        MethodSpec method = MethodSpec.methodBuilder("minutesToSeconds").addModifiers(Modifier.PUBLIC, Modifier.STATIC).returns(long.class).addParameter(long.class, "minutes").addStatement("$T.gc()", System.class).addStatement("return $1T.SECONDS.convert(minutes, $1T.MINUTES)", TimeUnit.class).build();
        return TypeSpec.classBuilder(name).addMethod(method).build();
    }

    @Test(timeout = 10000)
    public void importStaticForCrazyFormatsWorks() {
        MethodSpec method = MethodSpec.methodBuilder("method").build();
        Assert.assertFalse(isConstructor());
        String o_importStaticForCrazyFormatsWorks__4 = JavaFile.builder("com.squareup.tacos", TypeSpec.classBuilder("Taco").addStaticBlock(CodeBlock.builder().addStatement("$T", Runtime.class).addStatement("$T.a()", Runtime.class).addStatement("$T.X", Runtime.class).addStatement("$T$T", Runtime.class, Runtime.class).addStatement("$T.$T", Runtime.class, Runtime.class).addStatement("$1T$1T", Runtime.class).addStatement("$1T$2L$1T", Runtime.class, "?").addStatement("$1T$2L$2S$1T", Runtime.class, "?").addStatement("$1T$2L$2S$1T$3N$1T", Runtime.class, "?", method).addStatement("$T$L", Runtime.class, "?").addStatement("$T$S", Runtime.class, "?").addStatement("$T$N", Runtime.class, method).build()).build()).addStaticImport(Runtime.class, "*").build().toString();
        Assert.assertEquals("package com.squareup.tacos;\n\nimport static java.lang.Runtime.*;\n\nimport java.lang.Runtime;\n\nclass Taco {\n  static {\n    Runtime;\n    a();\n    X;\n    RuntimeRuntime;\n    Runtime.Runtime;\n    RuntimeRuntime;\n    Runtime?Runtime;\n    Runtime?\"?\"Runtime;\n    Runtime?\"?\"RuntimemethodRuntime;\n    Runtime?;\n    Runtime\"?\";\n    Runtimemethod;\n  }\n}\n", o_importStaticForCrazyFormatsWorks__4);
        Assert.assertFalse(isConstructor());
    }
}

