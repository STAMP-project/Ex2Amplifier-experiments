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

    private boolean isJava8() {
        return (Util.DEFAULT) != null;
    }

    private String toString(TypeSpec typeSpec) {
        return JavaFile.builder(tacosPackage, typeSpec).build().toString();
    }

    @Test(timeout = 10000)
    public void typeVariableWithBounds() throws Exception {
        AnnotationSpec a = AnnotationSpec.builder(ClassName.get("com.squareup.tacos", "A")).build();
        Assert.assertEquals("@com.squareup.tacos.A", ((com.squareup.javapoet.AnnotationSpec)((com.squareup.javapoet.AnnotationSpec.Builder)((com.squareup.javapoet.AnnotationSpec)a).toBuilder()).build()).toString());
        Assert.assertEquals(-1400393500, ((int) (((com.squareup.javapoet.AnnotationSpec)a).hashCode())));
        Assert.assertEquals(-1400393500, ((int) (((com.squareup.javapoet.AnnotationSpec)((com.squareup.javapoet.AnnotationSpec.Builder)((com.squareup.javapoet.AnnotationSpec)a).toBuilder()).build()).hashCode())));
        Assert.assertEquals("@com.squareup.tacos.A", ((com.squareup.javapoet.AnnotationSpec)a).toString());
        TypeVariableName p = TypeVariableName.get("P", Number.class);
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).isBoxedPrimitive());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).toString());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).hashCode())));
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)p).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).isPrimitive());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).hashCode())));
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)p).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).isPrimitive());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeVariableName)p).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)p).isPrimitive());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).hashCode())));
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).isBoxedPrimitive());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeVariableName)p).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).isBoxedPrimitive());
        TypeVariableName q = ((TypeVariableName) (TypeVariableName.get("Q", Number.class).annotated(a)));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).isAnnotated());
        Assert.assertEquals("@com.squareup.tacos.A Q", ((com.squareup.javapoet.TypeVariableName)q).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).isAnnotated());
        Assert.assertTrue(((com.squareup.javapoet.TypeVariableName)q).isAnnotated());
        Assert.assertEquals("Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).toString());
        Assert.assertEquals(81, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).isPrimitive());
        Assert.assertEquals(-1453388779, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).hashCode())));
        Assert.assertEquals(-1453388779, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(81, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).isBoxedPrimitive());
        Assert.assertEquals(81, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).isAnnotated());
        Assert.assertEquals(-1453388779, ((int) (((com.squareup.javapoet.TypeVariableName)q).hashCode())));
        Assert.assertEquals("Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("@com.squareup.tacos.A Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)q).isPrimitive());
        Assert.assertEquals("Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).isPrimitive());
        Assert.assertEquals("Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)q).isBoxedPrimitive());
        Assert.assertEquals("@com.squareup.tacos.A Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).toString());
        Assert.assertEquals(81, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).isAnnotated());
        TypeSpec typeSpec = TypeSpec.classBuilder("Location").addTypeVariable(p.withBounds(Comparable.class)).addTypeVariable(q.withBounds(Comparable.class)).addField(p, "x").addField(q, "y").build();
        Assert.assertEquals(-1817016266, ((int) (((com.squareup.javapoet.TypeSpec)((com.squareup.javapoet.TypeSpec.Builder)((com.squareup.javapoet.TypeSpec)typeSpec).toBuilder()).build()).hashCode())));
        Assert.assertEquals("class Location<P extends java.lang.Number & java.lang.Comparable, @com.squareup.tacos.A Q extends java.lang.Number & java.lang.Comparable> {\n  P x;\n\n  @com.squareup.tacos.A Q y;\n}\n", ((com.squareup.javapoet.TypeSpec)typeSpec).toString());
        Assert.assertEquals(-1817016266, ((int) (((com.squareup.javapoet.TypeSpec)typeSpec).hashCode())));
        Assert.assertEquals("class Location<P extends java.lang.Number & java.lang.Comparable, @com.squareup.tacos.A Q extends java.lang.Number & java.lang.Comparable> {\n  P x;\n\n  @com.squareup.tacos.A Q y;\n}\n", ((com.squareup.javapoet.TypeSpec)((com.squareup.javapoet.TypeSpec.Builder)((com.squareup.javapoet.TypeSpec)typeSpec).toBuilder()).build()).toString());
        String String_0 = "" + ((((((((("package com.squareup.tacos;\n" + "\n") + "import java.lang.Comparable;\n") + "import java.lang.Number;\n") + "\n") + "class Location<P extends Number & Comparable, @A Q extends Number & Comparable> {\n") + "  P x;\n") + "\n") + "  @A Q y;\n") + "}\n");
        Assert.assertEquals("package com.squareup.tacos;\n\nimport java.lang.Comparable;\nimport java.lang.Number;\n\nclass Location<P extends Number & Comparable, @A Q extends Number & Comparable> {\n  P x;\n\n  @A Q y;\n}\n", String_0);
        Assert.assertEquals(-1817016266, ((int) (((com.squareup.javapoet.TypeSpec)((com.squareup.javapoet.TypeSpec.Builder)((com.squareup.javapoet.TypeSpec)typeSpec).toBuilder()).build()).hashCode())));
        Assert.assertEquals("class Location<P extends java.lang.Number & java.lang.Comparable, @com.squareup.tacos.A Q extends java.lang.Number & java.lang.Comparable> {\n  P x;\n\n  @com.squareup.tacos.A Q y;\n}\n", ((com.squareup.javapoet.TypeSpec)typeSpec).toString());
        Assert.assertEquals(-1817016266, ((int) (((com.squareup.javapoet.TypeSpec)typeSpec).hashCode())));
        Assert.assertEquals("class Location<P extends java.lang.Number & java.lang.Comparable, @com.squareup.tacos.A Q extends java.lang.Number & java.lang.Comparable> {\n  P x;\n\n  @com.squareup.tacos.A Q y;\n}\n", ((com.squareup.javapoet.TypeSpec)((com.squareup.javapoet.TypeSpec.Builder)((com.squareup.javapoet.TypeSpec)typeSpec).toBuilder()).build()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).isAnnotated());
        Assert.assertEquals("@com.squareup.tacos.A Q", ((com.squareup.javapoet.TypeVariableName)q).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).isAnnotated());
        Assert.assertTrue(((com.squareup.javapoet.TypeVariableName)q).isAnnotated());
        Assert.assertEquals("Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).toString());
        Assert.assertEquals(81, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).isPrimitive());
        Assert.assertEquals(-1453388779, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).hashCode())));
        Assert.assertEquals(-1453388779, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(81, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).isBoxedPrimitive());
        Assert.assertEquals(81, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).isAnnotated());
        Assert.assertEquals(-1453388779, ((int) (((com.squareup.javapoet.TypeVariableName)q).hashCode())));
        Assert.assertEquals("Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("@com.squareup.tacos.A Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)q).isPrimitive());
        Assert.assertEquals("Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).isPrimitive());
        Assert.assertEquals("Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)q).isBoxedPrimitive());
        Assert.assertEquals("@com.squareup.tacos.A Q", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).box()).box()).toString());
        Assert.assertEquals(81, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)q).withoutAnnotations()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).isBoxedPrimitive());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).toString());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).hashCode())));
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)p).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).isPrimitive());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).hashCode())));
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)p).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).isPrimitive());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeVariableName)p).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeVariableName)p).isPrimitive());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).hashCode())));
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).isBoxedPrimitive());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeVariableName)p).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals(80, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("P", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeVariableName)p).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("@com.squareup.tacos.A", ((com.squareup.javapoet.AnnotationSpec)((com.squareup.javapoet.AnnotationSpec.Builder)((com.squareup.javapoet.AnnotationSpec)a).toBuilder()).build()).toString());
        Assert.assertEquals(-1400393500, ((int) (((com.squareup.javapoet.AnnotationSpec)a).hashCode())));
        Assert.assertEquals(-1400393500, ((int) (((com.squareup.javapoet.AnnotationSpec)((com.squareup.javapoet.AnnotationSpec.Builder)((com.squareup.javapoet.AnnotationSpec)a).toBuilder()).build()).hashCode())));
        Assert.assertEquals("@com.squareup.tacos.A", ((com.squareup.javapoet.AnnotationSpec)a).toString());
    }
}

