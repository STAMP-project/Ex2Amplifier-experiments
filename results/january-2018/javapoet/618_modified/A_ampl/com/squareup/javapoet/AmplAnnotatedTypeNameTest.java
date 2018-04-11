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
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals((-916118931), ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals((-916118931), ((int) (((com.squareup.javapoet.ArrayTypeName) (type)).hashCode())));
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals((-916118931), ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.ArrayTypeName) (type)).toString());
        Assert.assertEquals((-916118931), ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals((-916118931), ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals((-916118931), ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals((-916118931), ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.lang. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Object[]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
    }

    @Test(timeout = 10000)
    public void annotatedInnerMultidimensionalArrayType() throws Exception {
        TypeName type = ArrayTypeName.of(ArrayTypeName.of(ClassName.get(Object.class)).annotated(this.TYPE_USE_ANNOTATION));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.ArrayTypeName) (type)).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.ArrayTypeName) (type)).toString());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
    }

    @Test(timeout = 10000)
    public void annotatedOuterMultidimensionalArrayType() throws Exception {
        TypeName type = ArrayTypeName.of(ArrayTypeName.of(ClassName.get(Object.class))).annotated(this.TYPE_USE_ANNOTATION);
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.ArrayTypeName) (type)).hashCode())));
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.ArrayTypeName) (type)).toString());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
    }

    @Test(timeout = 10000)
    public void annotatedArrayTypeVarargsParameter() throws Exception {
        TypeName type = ArrayTypeName.of(ArrayTypeName.of(ClassName.get(Object.class))).annotated(TYPE_USE_ANNOTATION);
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.ArrayTypeName) (type)).hashCode())));
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.ArrayTypeName) (type)).toString());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        MethodSpec varargsMethod = MethodSpec.methodBuilder("m").addParameter(build()).varargs().build();
        Assert.assertEquals(453946397, ((int) (((com.squareup.javapoet.MethodSpec) (varargsMethod)).hashCode())));
        Assert.assertFalse(isConstructor());
        Assert.assertEquals("void m(java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []... p) {\n}\n", ((com.squareup.javapoet.MethodSpec) (varargsMethod)).toString());
        Assert.assertEquals("void m(java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []... p) {\n}\n", ((com.squareup.javapoet.MethodSpec) (build())).toString());
        Assert.assertFalse(isConstructor());
        Assert.assertEquals(453946397, ((int) (((com.squareup.javapoet.MethodSpec) (build())).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.ArrayTypeName) (type)).hashCode())));
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation [][]", ((com.squareup.javapoet.ArrayTypeName) (type)).toString());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1862817935, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(340213335, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.lang.Object[][]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
    }

    @Test(timeout = 10000)
    public void annotatedArrayTypeInVarargsParameter() throws Exception {
        TypeName type = ArrayTypeName.of(ArrayTypeName.of(ClassName.get(Object.class)).annotated(TYPE_USE_ANNOTATION));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.ArrayTypeName) (type)).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.ArrayTypeName) (type)).toString());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        MethodSpec varargsMethod = MethodSpec.methodBuilder("m").addParameter(build()).varargs().build();
        Assert.assertEquals(2145472029, ((int) (((com.squareup.javapoet.MethodSpec) (varargsMethod)).hashCode())));
        Assert.assertFalse(isConstructor());
        Assert.assertEquals("void m(java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation ... p) {\n}\n", ((com.squareup.javapoet.MethodSpec) (varargsMethod)).toString());
        Assert.assertEquals("void m(java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation ... p) {\n}\n", ((com.squareup.javapoet.MethodSpec) (build())).toString());
        Assert.assertFalse(isConstructor());
        Assert.assertEquals(2145472029, ((int) (((com.squareup.javapoet.MethodSpec) (build())).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.ArrayTypeName) (type)).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.ArrayTypeName) (type)).toString());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(1851225743, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.lang.Object[] @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
    }

    @Test(timeout = 10000)
    public void annotatedArrayType() throws Exception {
        TypeName type = ArrayTypeName.of(ClassName.get(Object.class)).annotated(this.TYPE_USE_ANNOTATION);
        Assert.assertEquals("java.lang.Object[]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(183594037, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(690205805, ((int) (((com.squareup.javapoet.ArrayTypeName) (type)).hashCode())));
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals(690205805, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.lang.Object[]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.lang.Object @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation []", ((com.squareup.javapoet.ArrayTypeName) (type)).toString());
        Assert.assertEquals(183594037, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.lang.Object[]", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(690205805, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(183594037, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(183594037, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.lang.Object[]", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
    }

    @Test(timeout = 10000)
    public void annotatedNestedParameterizedType() throws Exception {
        TypeName type = ParameterizedTypeName.get(Map.Entry.class, Byte.class, Byte.class).annotated(this.TYPE_USE_ANNOTATION);
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(1905940054, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals((-247473378), ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(1905940054, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.util.Map.Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.util.Map. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals("java.util.Map. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertEquals((-247473378), ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals("java.util.Map.Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertEquals("java.util.Map.Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals("java.util.Map. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.ParameterizedTypeName) (type)).toString());
        Assert.assertEquals(1905940054, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals((-247473378), ((int) (((com.squareup.javapoet.ParameterizedTypeName) (type)).hashCode())));
        Assert.assertEquals(1905940054, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.util.Map.Entry<java.lang.Byte, java.lang.Byte>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
    }

    @Test(timeout = 10000)
    public void annotatedParameterizedType() throws Exception {
        TypeName type = ParameterizedTypeName.get(List.class, String.class);
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.ParameterizedTypeName) (type)).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.ParameterizedTypeName) (type)).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
        TypeName actual = type.annotated(this.TYPE_USE_ANNOTATION);
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertEquals(473852115, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(473852115, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.util. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation List<java.lang.String>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals("java.util. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation List<java.lang.String>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertTrue(isAnnotated());
        Assert.assertTrue(isAnnotated());
        Assert.assertEquals(473852115, ((int) (((com.squareup.javapoet.ParameterizedTypeName) (actual)).hashCode())));
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertTrue(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals("java.util. @com.squareup.javapoet.AnnotatedTypeNameTest.TypeUseAnnotation List<java.lang.String>", ((com.squareup.javapoet.ParameterizedTypeName) (actual)).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertFalse(isAnnotated());
        Assert.assertFalse(isAnnotated());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertFalse(isPrimitive());
        Assert.assertFalse(isBoxedPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (box())).toString());
        Assert.assertFalse(isPrimitive());
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.ParameterizedTypeName) (type)).toString());
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (withoutAnnotations())).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.ParameterizedTypeName) (type)).hashCode())));
        Assert.assertEquals(2123584667, ((int) (((com.squareup.javapoet.TypeName) (box())).hashCode())));
        Assert.assertEquals("java.util.List<java.lang.String>", ((com.squareup.javapoet.TypeName) (withoutAnnotations())).toString());
        Assert.assertFalse(isAnnotated());
    }
}

