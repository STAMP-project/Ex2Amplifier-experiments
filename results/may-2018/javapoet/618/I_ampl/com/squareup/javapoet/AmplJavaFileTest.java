package com.squareup.javapoet;


import com.google.common.truth.Truth;
import java.util.List;
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

    @Test(timeout = 300000)
    public void annotatedTypeParamlitString13161litString13362() throws Exception {
        String source = JavaFile.builder("    return SECONDS.convert(minutes, MINUTES);\n", TypeSpec.classBuilder("Taco").addField(ParameterizedTypeName.get(ClassName.get(List.class), ClassName.get("com.squareup.meat", "com.squareup.tacos").annotated(AnnotationSpec.builder(ClassName.get("com.squareup.tacos", "Spicy")).build())), "chorizo").build()).build().toString();
        Assert.assertEquals("package     return SECONDS.convert(minutes, MINUTES);\n;\n\nimport com.squareup.meat.com.squareup.tacos;\nimport com.squareup.tacos.Spicy;\nimport java.util.List;\n\nclass Taco {\n  List<@Spicy com.squareup.tacos> chorizo;\n}\n", source);
    }
}

