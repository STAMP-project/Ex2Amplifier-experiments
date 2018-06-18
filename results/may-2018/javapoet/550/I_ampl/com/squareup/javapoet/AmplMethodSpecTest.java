package com.squareup.javapoet;


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

    interface ExtendsOthers extends Comparable<Long> , Callable<Integer> {}

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
    public void nullExceptionsAdditionlitString2_failAssert0() throws Exception {
        try {
            try {
                MethodSpec.methodBuilder(null).addExceptions(null);
            } catch (IllegalArgumentException expected) {
            }
            Assert.fail("nullExceptionsAdditionlitString2 should have thrown NullPointerException");
        } catch (NullPointerException expected_1) {
            Assert.assertEquals(null, expected_1.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void nullExceptionsAdditionlitString4_failAssert0() throws Exception {
        try {
            try {
                MethodSpec.methodBuilder(null).addExceptions(null);
            } catch (IllegalArgumentException expected) {
            }
            org.junit.Assert.fail("nullExceptionsAdditionlitString4 should have thrown NullPointerException");
        } catch (NullPointerException expected_1) {
            Assert.assertEquals(null, expected_1.getMessage());
        }
    }
}

