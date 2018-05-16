package com.squareup.javapoet;


import com.google.testing.compile.CompilationRule;
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

    private String toString(TypeSpec typeSpec) {
        return build().toString();
    }

    @Test(timeout = 10000)
    public void annotationsAndJavaLangTypes() throws Exception {
        ClassName freeRange = ClassName.get("javax.annotation", "FreeRange");
        Assert.assertEquals(111796842, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(111796842, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("javax.annotation.FreeRange", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals(111796842, ((int) (((com.squareup.javapoet.ClassName) (freeRange)).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals("javax.annotation.FreeRange", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertEquals("FreeRange", simpleName());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("javax.annotation.FreeRange", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals("javax.annotation.FreeRange", ((com.squareup.javapoet.ClassName) (freeRange)).toString());
        Assert.assertEquals(111796842, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        TypeSpec taco = TypeSpec.classBuilder("EthicalTaco").addField(ClassName.get(String.class).annotated(build()), "meat").build();
        Assert.assertEquals("class EthicalTaco {\n  java.lang. @javax.annotation.FreeRange String meat;\n}\n", ((com.squareup.javapoet.TypeSpec) (build())).toString());
        Assert.assertEquals((-1700952972), ((int) (((com.squareup.javapoet.TypeSpec) (taco)).hashCode())));
        Assert.assertEquals("class EthicalTaco {\n  java.lang. @javax.annotation.FreeRange String meat;\n}\n", ((com.squareup.javapoet.TypeSpec) (taco)).toString());
        Assert.assertEquals((-1700952972), ((int) (((com.squareup.javapoet.TypeSpec) (build())).hashCode())));
        String String_0 = "" + ((((((("package com.squareup.tacos;\n" + "\n") + "import java.lang.String;\n") + "import javax.annotation.FreeRange;\n") + "\n") + "class EthicalTaco {\n") + "  @FreeRange String meat;\n") + "}\n");
        Assert.assertEquals("package com.squareup.tacos;\n\nimport java.lang.String;\nimport javax.annotation.FreeRange;\n\nclass EthicalTaco {\n  @FreeRange String meat;\n}\n", String_0);
        Assert.assertEquals(111796842, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(111796842, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("javax.annotation.FreeRange", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals(111796842, ((int) (((com.squareup.javapoet.ClassName) (freeRange)).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals("javax.annotation.FreeRange", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertEquals("FreeRange", simpleName());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("javax.annotation.FreeRange", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals("javax.annotation.FreeRange", ((com.squareup.javapoet.ClassName) (freeRange)).toString());
        Assert.assertEquals(111796842, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("class EthicalTaco {\n  java.lang. @javax.annotation.FreeRange String meat;\n}\n", ((com.squareup.javapoet.TypeSpec) (build())).toString());
        Assert.assertEquals((-1700952972), ((int) (((com.squareup.javapoet.TypeSpec) (taco)).hashCode())));
        Assert.assertEquals("class EthicalTaco {\n  java.lang. @javax.annotation.FreeRange String meat;\n}\n", ((com.squareup.javapoet.TypeSpec) (taco)).toString());
        Assert.assertEquals((-1700952972), ((int) (((com.squareup.javapoet.TypeSpec) (build())).hashCode())));
    }
}

