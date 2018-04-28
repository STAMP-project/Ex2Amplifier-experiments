package com.squareup.javapoet;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;


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
}

