package com.squareup.javapoet;


import com.google.common.collect.Iterables;
import com.google.testing.compile.CompilationRule;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public final class AmplMethodSpecTest {
    @Target(ElementType.PARAMETER)
    @interface Nullable {}

    static abstract class Everything {
        @Deprecated
        protected abstract <T extends Runnable & Closeable> Runnable everything(@AmplMethodSpecTest.Nullable
        String thing, List<? extends T> things) throws IOException, SecurityException;
    }

    static abstract class HasAnnotation {
        @Override
        public abstract String toString();
    }

    interface ExtendsOthers extends Comparable<AmplMethodSpecTest.ExtendsOthers> , Callable<Integer> {}

    interface ExtendsIterableWithDefaultMethods extends Iterable<Object> {}

    @Rule
    public final CompilationRule compilation = new CompilationRule();

    private Elements elements;

    private Types types;

    @Before
    public void setUp() {
        elements = compilation.getElements();
        types = compilation.getTypes();
    }

    private TypeElement getElement(Class<?> clazz) {
        return elements.getTypeElement(clazz.getCanonicalName());
    }

    private ExecutableElement findFirst(Collection<ExecutableElement> elements, String name) {
        for (ExecutableElement executableElement : elements) {
            if (executableElement.getSimpleName().toString().equals(name)) {
                return executableElement;
            }
        }
        throw new IllegalArgumentException(((name + " not found in ") + elements));
    }

    @Test(timeout = 120000)
    public void overrideEverything() throws Exception {
        TypeElement classElement = getElement(AmplMethodSpecTest.Everything.class);
        ExecutableElement methodElement = Iterables.getOnlyElement(ElementFilter.methodsIn(classElement.getEnclosedElements()));
        MethodSpec method = MethodSpec.overriding(methodElement).build();
        Assert.assertEquals("@java.lang.Override\nprotected <T extends java.lang.Runnable & java.io.Closeable> java.lang.Runnable everything(java.lang.String arg0,\n    java.util.List<? extends T> arg1) throws java.io.IOException, java.lang.SecurityException {\n}\n", ((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)method).toBuilder()).build()).toString());
        Assert.assertEquals(1642434492, ((int) (((com.squareup.javapoet.MethodSpec)method).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.MethodSpec)method).isConstructor());
        Assert.assertFalse(((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)method).toBuilder()).build()).isConstructor());
        Assert.assertEquals(1642434492, ((int) (((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)method).toBuilder()).build()).hashCode())));
        Assert.assertEquals("@java.lang.Override\nprotected <T extends java.lang.Runnable & java.io.Closeable> java.lang.Runnable everything(java.lang.String arg0,\n    java.util.List<? extends T> arg1) throws java.io.IOException, java.lang.SecurityException {\n}\n", ((com.squareup.javapoet.MethodSpec)method).toString());
        String String_0 = "" + ((((("@java.lang.Override\n" + "protected <T extends java.lang.Runnable & java.io.Closeable> java.lang.Runnable ") + "everything(java.lang.String arg0,\n") + "    java.util.List<? extends T> arg1) throws java.io.IOException, ") + "java.lang.SecurityException {\n") + "}\n");
        Assert.assertEquals("@java.lang.Override\nprotected <T extends java.lang.Runnable & java.io.Closeable> java.lang.Runnable everything(java.lang.String arg0,\n    java.util.List<? extends T> arg1) throws java.io.IOException, java.lang.SecurityException {\n}\n", String_0);
        Assert.assertEquals("@java.lang.Override\nprotected <T extends java.lang.Runnable & java.io.Closeable> java.lang.Runnable everything(java.lang.String arg0,\n    java.util.List<? extends T> arg1) throws java.io.IOException, java.lang.SecurityException {\n}\n", ((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)method).toBuilder()).build()).toString());
        Assert.assertEquals(1642434492, ((int) (((com.squareup.javapoet.MethodSpec)method).hashCode())));
        Assert.assertFalse(((com.squareup.javapoet.MethodSpec)method).isConstructor());
        Assert.assertFalse(((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)method).toBuilder()).build()).isConstructor());
        Assert.assertEquals(1642434492, ((int) (((com.squareup.javapoet.MethodSpec)((com.squareup.javapoet.MethodSpec.Builder)((com.squareup.javapoet.MethodSpec)method).toBuilder()).build()).hashCode())));
        Assert.assertEquals("@java.lang.Override\nprotected <T extends java.lang.Runnable & java.io.Closeable> java.lang.Runnable everything(java.lang.String arg0,\n    java.util.List<? extends T> arg1) throws java.io.IOException, java.lang.SecurityException {\n}\n", ((com.squareup.javapoet.MethodSpec)method).toString());
    }
}

