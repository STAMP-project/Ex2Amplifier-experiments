package com.squareup.javapoet;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Map;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class AmplAnnotatedTypeNameTest {
    public @interface NeverNull {}

    @Target(ElementType.TYPE_USE)
    public @interface TypeUseAnnotation {}

    private static final String NN = AmplAnnotatedTypeNameTest.NeverNull.class.getCanonicalName();

    private final AnnotationSpec NEVER_NULL = AnnotationSpec.builder(AmplAnnotatedTypeNameTest.NeverNull.class).build();

    private void annotatedEquivalence(TypeName type) {
        Assert.assertFalse(type.isAnnotated());
        Assert.assertEquals(type, type);
        Assert.assertEquals(type.annotated(NEVER_NULL), type.annotated(NEVER_NULL));
        Assert.assertNotEquals(type, type.annotated(NEVER_NULL));
        Assert.assertEquals(type.hashCode(), type.hashCode());
        Assert.assertEquals(type.annotated(NEVER_NULL).hashCode(), type.annotated(NEVER_NULL).hashCode());
        Assert.assertNotEquals(type.hashCode(), type.annotated(NEVER_NULL).hashCode());
    }

    @Ignore
    @Test
    public void annotatedNestedType() {
        String expected = ("java.util.Map.@" + (AmplAnnotatedTypeNameTest.TypeUseAnnotation.class.getCanonicalName())) + " Entry";
        AnnotationSpec typeUseAnnotation = AnnotationSpec.builder(AmplAnnotatedTypeNameTest.TypeUseAnnotation.class).build();
        TypeName type = TypeName.get(Map.Entry.class).annotated(typeUseAnnotation);
        String actual = type.toString();
        Assert.assertEquals(expected, actual);
    }

    @Ignore
    @Test
    public void annotatedNestedParameterizedType() {
        String expected = ("java.util.Map.@" + (AmplAnnotatedTypeNameTest.TypeUseAnnotation.class.getCanonicalName())) + " Entry<java.lang.Byte, java.lang.Byte>";
        AnnotationSpec typeUseAnnotation = AnnotationSpec.builder(AmplAnnotatedTypeNameTest.TypeUseAnnotation.class).build();
        TypeName type = ParameterizedTypeName.get(Map.Entry.class, Byte.class, Byte.class).annotated(typeUseAnnotation);
        String actual = type.toString();
        Assert.assertEquals(expected, actual);
    }
}

