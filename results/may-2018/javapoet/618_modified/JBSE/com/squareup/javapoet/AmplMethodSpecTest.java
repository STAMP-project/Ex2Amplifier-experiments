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
import org.junit.Before;
import org.junit.Rule;


public final class AmplMethodSpecTest {
    @Target(ElementType.PARAMETER)
    @interface Nullable {}

    abstract static class Everything {
        @Deprecated
        protected abstract <T extends Runnable & Closeable> Runnable everything(@AmplMethodSpecTest.Nullable
        String thing, List<? extends T> things) throws IOException, SecurityException;
    }

    abstract static class HasAnnotation {
        @Override
        public abstract String toString();
    }

    interface Throws<R extends RuntimeException> {
        public abstract void fail() throws R;
    }

    interface ExtendsOthers extends AmplMethodSpecTest.Throws<IllegalStateException> , Comparable<AmplMethodSpecTest.ExtendsOthers> , Callable<Integer> {}

    interface ExtendsIterableWithDefaultMethods extends Iterable<Object> {}

    final class FinalClass {
        void method() {
        }
    }

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
}

