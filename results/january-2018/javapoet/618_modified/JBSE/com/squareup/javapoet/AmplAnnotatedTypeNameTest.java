package com.squareup.javapoet;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;


public class AmplAnnotatedTypeNameTest {
    @Target(ElementType.TYPE_USE)
    public @interface NeverNull {}

    @Target(ElementType.TYPE_USE)
    public @interface TypeUseAnnotation {}

    private static final String NN = AmplAnnotatedTypeNameTest.NeverNull.class.getCanonicalName();

    private final AnnotationSpec NEVER_NULL = AnnotationSpec.builder(AmplAnnotatedTypeNameTest.NeverNull.class).build();

    private static final String TUA = AmplAnnotatedTypeNameTest.TypeUseAnnotation.class.getCanonicalName();

    private final AnnotationSpec TYPE_USE_ANNOTATION = AnnotationSpec.builder(AmplAnnotatedTypeNameTest.TypeUseAnnotation.class).build();

    private void annotatedEquivalence(TypeName type) {
        Assert.assertFalse(type.isAnnotated());
        Assert.assertEquals(type, type);
        Assert.assertEquals(type.annotated(TYPE_USE_ANNOTATION), type.annotated(TYPE_USE_ANNOTATION));
        Assert.assertNotEquals(type, type.annotated(TYPE_USE_ANNOTATION));
        Assert.assertEquals(type.hashCode(), type.hashCode());
        Assert.assertEquals(type.annotated(TYPE_USE_ANNOTATION).hashCode(), type.annotated(TYPE_USE_ANNOTATION).hashCode());
        Assert.assertNotEquals(type.hashCode(), type.annotated(TYPE_USE_ANNOTATION).hashCode());
    }

    @Test(timeout = 10000)
    public void annotatedArrayElementType() throws Exception {
        TypeName type = ArrayTypeName.of(ClassName.get(Object.class).annotated(this.TYPE_USE_ANNOTATION));
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(-916118931, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(-916118931, ((int) (((com.squareup.javapoet.ArrayTypeName)type).hashCode())));
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals(-916118931, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.ArrayTypeName)type).toString());
        Assert.assertEquals(-916118931, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isAnnotated());
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isPrimitive());
        Assert.assertEquals(-916118931, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isPrimitive());
        Assert.assertEquals(-916118931, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals(-916118931, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).toString());
    }

    @Test(timeout = 10000)
    public void annotatedInnerMultidimensionalArrayType() throws Exception {
        TypeName type = ArrayTypeName.of(ArrayTypeName.of(ClassName.get(Object.class)).annotated(this.TYPE_USE_ANNOTATION));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.ArrayTypeName)type).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.ArrayTypeName)type).toString());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).toString());
    }

    @Test(timeout = 10000)
    public void annotatedOuterMultidimensionalArrayType() throws Exception {
        TypeName type = ArrayTypeName.of(ArrayTypeName.of(ClassName.get(Object.class))).annotated(this.TYPE_USE_ANNOTATION);
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.ArrayTypeName)type).hashCode())));
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.ArrayTypeName)type).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.ArrayTypeName)type).toString());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).toString());
    }

    @Test(timeout = 10000)
    public void annotatedArrayTypeVarargsParameter() throws Exception {
        TypeName type = ArrayTypeName.of(ArrayTypeName.of(ClassName.get(Object.class))).annotated(TYPE_USE_ANNOTATION);
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.ArrayTypeName)type).hashCode())));
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.ArrayTypeName)type).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.ArrayTypeName)type).toString());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).toString());
        MethodSpec varargsMethod = MethodSpec.methodBuilder("m").addParameter(ParameterSpec.builder(type, "p").build()).varargs().build();
        Assert.assertEquals(453946397, ((int) (((com.squareup.javapoet.MethodSpec)varargsMethod).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)varargsMethod).toBuilder()).build()).isConstructor());
        Assert.assertEquals("void m(java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []... p) {\n}\n", ((com.squareup.javapoet.MethodSpec)varargsMethod).toString());
        Assert.assertEquals("void m(java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []... p) {\n}\n", ((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)varargsMethod).toBuilder()).build()).toString());
        Assert.assertFalse(((com.squareup.javapoet.MethodSpec)varargsMethod).isConstructor());
        Assert.assertEquals(453946397, ((int) (((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)varargsMethod).toBuilder()).build()).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.ArrayTypeName)type).hashCode())));
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.ArrayTypeName)type).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.ArrayTypeName)type).toString());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).toString());
    }

    @Test(timeout = 10000)
    public void annotatedArrayTypeInVarargsParameter() throws Exception {
        TypeName type = ArrayTypeName.of(ArrayTypeName.of(ClassName.get(Object.class)).annotated(TYPE_USE_ANNOTATION));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.ArrayTypeName)type).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.ArrayTypeName)type).toString());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).toString());
        MethodSpec varargsMethod = MethodSpec.methodBuilder("m").addParameter(ParameterSpec.builder(type, "p").build()).varargs().build();
        Assert.assertEquals(2145472029, ((int) (((com.squareup.javapoet.MethodSpec)varargsMethod).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)varargsMethod).toBuilder()).build()).isConstructor());
        Assert.assertEquals("void m(java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation ... p) {\n}\n", ((com.squareup.javapoet.MethodSpec)varargsMethod).toString());
        Assert.assertEquals("void m(java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation ... p) {\n}\n", ((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)varargsMethod).toBuilder()).build()).toString());
        Assert.assertFalse(((com.squareup.javapoet.MethodSpec)varargsMethod).isConstructor());
        Assert.assertEquals(2145472029, ((int) (((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)varargsMethod).toBuilder()).build()).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.ArrayTypeName)type).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.ArrayTypeName)type).toString());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).toString());
    }

    @Test(timeout = 10000)
    public void annotatedArrayType() throws Exception {
        TypeName type = ArrayTypeName.of(ClassName.get(Object.class)).annotated(this.TYPE_USE_ANNOTATION);
        Assert.assertEquals("java.lang.Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(183594037, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(690205805, ((int) (((com.squareup.javapoet.ArrayTypeName)type).hashCode())));
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.ArrayTypeName)type).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals(690205805, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals("java.lang.Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.ArrayTypeName)type).toString());
        Assert.assertEquals(183594037, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).isAnnotated());
        Assert.assertEquals("java.lang.Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isPrimitive());
        Assert.assertEquals(690205805, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ArrayTypeName)type).isPrimitive());
        Assert.assertEquals(183594037, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals(183594037, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.lang.Object[]", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ArrayTypeName)type).withoutAnnotations()).toString());
    }

    @Test(timeout = 10000)
    public void annotatedNestedParameterizedType() throws Exception {
        TypeName type = ParameterizedTypeName.get(Map.Entry.class, Byte.class, Byte.class).annotated(this.TYPE_USE_ANNOTATION);
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(1905940054, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)type).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertEquals(-247473378, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals(1905940054, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals("java.util.Map.Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.util.Map. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertTrue(((com.squareup.javapoet.ParameterizedTypeName)type).isAnnotated());
        Assert.assertEquals("java.util.Map. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).toString());
        Assert.assertEquals(-247473378, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)type).isBoxedPrimitive());
        Assert.assertEquals("java.util.Map.Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals("java.util.Map.Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).isPrimitive());
        Assert.assertEquals("java.util.Map. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.ParameterizedTypeName)type).toString());
        Assert.assertEquals(1905940054, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals(-247473378, ((int) (((com.squareup.javapoet.ParameterizedTypeName)type).hashCode())));
        Assert.assertEquals(1905940054, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals("java.util.Map.Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
    }

    @Test(timeout = 10000)
    public void annotatedParameterizedType() throws Exception {
        TypeName type = ParameterizedTypeName.get(List.class, String.class);
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)type).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)type).isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)type).isBoxedPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).isPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.ParameterizedTypeName)type).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.ParameterizedTypeName)type).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        TypeName actual = type.annotated(this.TYPE_USE_ANNOTATION);
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)actual).isBoxedPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).toString());
        Assert.assertEquals(473852115, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).box()).hashCode())));
        Assert.assertEquals(473852115, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).hashCode())));
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).withoutAnnotations()).isPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).withoutAnnotations()).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.util. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).box()).isBoxedPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertEquals("java.util. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).toString());
        Assert.assertTrue(((com.squareup.javapoet.ParameterizedTypeName)actual).isAnnotated());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).box()).isAnnotated());
        Assert.assertEquals(473852115, ((int) (((com.squareup.javapoet.ParameterizedTypeName)actual).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).withoutAnnotations()).isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).box()).isPrimitive());
        Assert.assertTrue(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)actual).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)actual).withoutAnnotations()).isPrimitive());
        Assert.assertEquals("java.util. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation List<java.lang.String>", ((com.squareup.javapoet.ParameterizedTypeName)actual).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).isPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)type).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).isBoxedPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)type).isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ParameterizedTypeName)type).isBoxedPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).isPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.ParameterizedTypeName)type).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.ParameterizedTypeName)type).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).box()).hashCode())));
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).box()).withoutAnnotations()).toString());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ParameterizedTypeName)type).withoutAnnotations()).withoutAnnotations()).isAnnotated());
    }
}

