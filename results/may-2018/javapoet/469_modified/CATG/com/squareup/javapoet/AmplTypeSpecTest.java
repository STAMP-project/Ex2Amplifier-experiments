package com.squareup.javapoet;


import com.google.testing.compile.CompilationRule;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
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

    @Test(timeout = 10000)
    public void annotationWithFields() throws Exception {
        FieldSpec field = FieldSpec.builder(int.class, "FOO").addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL).initializer("$L", 101).build();
        Assert.assertEquals("public static final int FOO = 101;\n", ((com.squareup.javapoet.FieldSpec)((com.squareup.javapoet.FieldSpec.Builder)((com.squareup.javapoet.FieldSpec)field).toBuilder()).build()).toString());
        Assert.assertEquals("public static final int FOO = 101;\n", ((com.squareup.javapoet.FieldSpec)field).toString());
        Assert.assertEquals(-449343922, ((int) (((com.squareup.javapoet.FieldSpec)field).hashCode())));
        Assert.assertEquals(-449343922, ((int) (((com.squareup.javapoet.FieldSpec)((com.squareup.javapoet.FieldSpec.Builder)((com.squareup.javapoet.FieldSpec)field).toBuilder()).build()).hashCode())));
        TypeSpec anno = TypeSpec.annotationBuilder("Anno").addField(field).build();
        Assert.assertEquals(1023254950, ((int) (((com.squareup.javapoet.TypeSpec)((com.squareup.javapoet.TypeSpec.Builder)((com.squareup.javapoet.TypeSpec)anno).toBuilder()).build()).hashCode())));
        Assert.assertEquals("@interface Anno {\n  int FOO = 101;\n}\n", ((com.squareup.javapoet.TypeSpec)anno).toString());
        Assert.assertEquals("@interface Anno {\n  int FOO = 101;\n}\n", ((com.squareup.javapoet.TypeSpec)((com.squareup.javapoet.TypeSpec.Builder)((com.squareup.javapoet.TypeSpec)anno).toBuilder()).build()).toString());
        Assert.assertEquals(1023254950, ((int) (((com.squareup.javapoet.TypeSpec)anno).hashCode())));
        String String_1 = "" + (((("package com.squareup.tacos;\n" + "\n") + "@interface Anno {\n") + "  int FOO = 101;\n") + "}\n");
        Assert.assertEquals("package com.squareup.tacos;\n\n@interface Anno {\n  int FOO = 101;\n}\n", String_1);
        Assert.assertEquals(1023254950, ((int) (((com.squareup.javapoet.TypeSpec)((com.squareup.javapoet.TypeSpec.Builder)((com.squareup.javapoet.TypeSpec)anno).toBuilder()).build()).hashCode())));
        Assert.assertEquals("@interface Anno {\n  int FOO = 101;\n}\n", ((com.squareup.javapoet.TypeSpec)anno).toString());
        Assert.assertEquals("@interface Anno {\n  int FOO = 101;\n}\n", ((com.squareup.javapoet.TypeSpec)((com.squareup.javapoet.TypeSpec.Builder)((com.squareup.javapoet.TypeSpec)anno).toBuilder()).build()).toString());
        Assert.assertEquals(1023254950, ((int) (((com.squareup.javapoet.TypeSpec)anno).hashCode())));
        Assert.assertEquals("public static final int FOO = 101;\n", ((com.squareup.javapoet.FieldSpec)((com.squareup.javapoet.FieldSpec.Builder)((com.squareup.javapoet.FieldSpec)field).toBuilder()).build()).toString());
        Assert.assertEquals("public static final int FOO = 101;\n", ((com.squareup.javapoet.FieldSpec)field).toString());
        Assert.assertEquals(-449343922, ((int) (((com.squareup.javapoet.FieldSpec)field).hashCode())));
        Assert.assertEquals(-449343922, ((int) (((com.squareup.javapoet.FieldSpec)((com.squareup.javapoet.FieldSpec.Builder)((com.squareup.javapoet.FieldSpec)field).toBuilder()).build()).hashCode())));
    }
}

