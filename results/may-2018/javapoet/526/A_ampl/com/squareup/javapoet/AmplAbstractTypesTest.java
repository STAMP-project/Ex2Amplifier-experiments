package com.squareup.javapoet;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import org.junit.Assert;
import org.junit.Test;


public abstract class AmplAbstractTypesTest {
    static class Parameterized<Simple, ExtendsClass extends Number, ExtendsInterface extends Runnable, ExtendsTypeVariable extends Simple, Intersection extends Number & Runnable, IntersectionOfInterfaces extends Runnable & Serializable> {}

    static class Recursive<T extends Map<List<T>, Set<T[]>>> {}

    private static class DeclaredTypeAsErrorType implements ErrorType {
        private final DeclaredType declaredType;

        public DeclaredTypeAsErrorType(DeclaredType declaredType) {
            this.declaredType = declaredType;
        }

        @Override
        public Element asElement() {
            return declaredType.asElement();
        }

        @Override
        public TypeMirror getEnclosingType() {
            return declaredType.getEnclosingType();
        }

        @Override
        public List<? extends TypeMirror> getTypeArguments() {
            return declaredType.getTypeArguments();
        }

        @Override
        public TypeKind getKind() {
            return declaredType.getKind();
        }

        @Override
        public <R, P> R accept(TypeVisitor<R, P> typeVisitor, P p) {
            return typeVisitor.visitError(this, p);
        }

        public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationType) {
            throw new UnsupportedOperationException();
        }

        public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
            throw new UnsupportedOperationException();
        }

        public List<? extends AnnotationMirror> getAnnotationMirrors() {
            throw new UnsupportedOperationException();
        }
    }

    protected abstract Elements getElements();

    protected abstract Types getTypes();

    private TypeElement getElement(Class<?> clazz) {
        return getElements().getTypeElement(clazz.getCanonicalName());
    }

    private TypeMirror getMirror(Class<?> clazz) {
        return getElement(clazz).asType();
    }

    @Test(timeout = 1200000)
    public void getTypeVariableTypeMirror() throws Exception {
        List<? extends TypeParameterElement> typeVariables = getElement(AmplAbstractTypesTest.Parameterized.class).getTypeParameters();
        Assert.assertFalse(typeVariables.isEmpty());
        ClassName number = ClassName.get(Number.class);
        Assert.assertEquals("Number", ((com.squareup.javapoet.ClassName)number).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)number).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)number).enclosingClassName());
        Assert.assertEquals("Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)number).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)number).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)number).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)number).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)number).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.ClassName)number).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)number).isPrimitive());
        ClassName runnable = ClassName.get(Runnable.class);
        Assert.assertEquals("Runnable", ((com.squareup.javapoet.ClassName)runnable).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)runnable).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)runnable).enclosingClassName());
        Assert.assertEquals("Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)runnable).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)runnable).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)runnable).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)runnable).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)runnable).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.ClassName)runnable).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)runnable).isPrimitive());
        ClassName serializable = ClassName.get(Serializable.class);
        Assert.assertEquals("Serializable", ((com.squareup.javapoet.ClassName)serializable).simpleName());
        Assert.assertEquals("java.io", ((com.squareup.javapoet.ClassName)serializable).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)serializable).enclosingClassName());
        Assert.assertEquals("Serializable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).simpleName());
        Assert.assertEquals("java.io", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("Serializable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).simpleName());
        Assert.assertEquals("java.io", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).withoutAnnotations()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).box()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)serializable).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.ClassName)serializable).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)serializable).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).box()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).box()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).withoutAnnotations()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)serializable).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)serializable).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)serializable).isBoxedPrimitive());
        Assert.assertEquals("java.io.Serializable", ((com.squareup.javapoet.ClassName)serializable).toString());
        Assert.assertEquals(1832181019, ((int) (((com.squareup.javapoet.ClassName)serializable).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)serializable).isPrimitive());
        Assert.assertFalse(typeVariables.isEmpty());
        Assert.assertEquals("Number", ((com.squareup.javapoet.ClassName)number).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)number).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)number).enclosingClassName());
        Assert.assertEquals("Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)number).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)number).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)number).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)number).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)number).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)number).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Number", ((com.squareup.javapoet.ClassName)number).toString());
        Assert.assertEquals(1052881309, ((int) (((com.squareup.javapoet.ClassName)number).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)number).isPrimitive());
        Assert.assertEquals("Runnable", ((com.squareup.javapoet.ClassName)runnable).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)runnable).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)runnable).enclosingClassName());
        Assert.assertEquals("Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).simpleName());
        Assert.assertEquals("java.lang", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).packageName());
        Assert.assertNull(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).enclosingClassName());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)((com.squareup.javapoet.ClassName)runnable).topLevelClassName()).isPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)runnable).reflectionName());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)runnable).simpleNames().isEmpty());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).withoutAnnotations()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.TypeName)((com.squareup.javapoet.ClassName)runnable).box()).isPrimitive());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)runnable).isAnnotated());
        Assert.assertFalse(((com.squareup.javapoet.ClassName)runnable).isBoxedPrimitive());
        Assert.assertEquals("java.lang.Runnable", ((com.squareup.javapoet.ClassName)runnable).toString());
        Assert.assertEquals(922510449, ((int) (((com.squareup.javapoet.ClassName)runnable).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.ClassName)runnable).isPrimitive());
    }
}

