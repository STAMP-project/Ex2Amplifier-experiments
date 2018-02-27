/**
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.javapoet;


import com.google.testing.compile.CompilationRule;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.Rule;


public final class AmplAnnotationSpecTest {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnotationA {}

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnotationB {}

    @Retention(RetentionPolicy.RUNTIME)
    public @interface AnnotationC {
        String value();
    }

    public enum Breakfast {
        WAFFLES, PANCAKES;
        public String toString() {
            return (name()) + " with cherries!";
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface HasDefaultsAnnotation {
        byte a() default 5;

        short b() default 6;

        int c() default 7;

        long d() default 8;

        float e() default 9.0F;

        double f() default 10.0;

        char[] g() default { 0, 51966, 'z', '€', 'ℕ', '"', '\'', '\t', '\n' };

        boolean h() default true;

        AmplAnnotationSpecTest.Breakfast i() default AmplAnnotationSpecTest.Breakfast.WAFFLES;

        AmplAnnotationSpecTest.AnnotationA j() default @AmplAnnotationSpecTest.AnnotationA;

        String k() default "maple";

        Class<? extends Annotation> l() default AmplAnnotationSpecTest.AnnotationB.class;

        int[] m() default { 1, 2, 3 };

        AmplAnnotationSpecTest.Breakfast[] n() default { AmplAnnotationSpecTest.Breakfast.WAFFLES, AmplAnnotationSpecTest.Breakfast.PANCAKES };

        AmplAnnotationSpecTest.Breakfast o();

        int p();

        AmplAnnotationSpecTest.AnnotationC q() default @AmplAnnotationSpecTest.AnnotationC("foo");

        Class<? extends Number>[] r() default { Byte.class, Short.class, Integer.class, Long.class };
    }

    // empty
    @AmplAnnotationSpecTest.HasDefaultsAnnotation(o = AmplAnnotationSpecTest.Breakfast.PANCAKES, p = 1701, f = 11.1, m = { 9, 8, 1 }, l = Override.class, j = @AmplAnnotationSpecTest.AnnotationA, q = @AmplAnnotationSpecTest.AnnotationC("bar"), r = { Float.class, Double.class })
    public class IsAnnotated {}

    @Rule
    public final CompilationRule compilation = new CompilationRule();

    private String toString(TypeSpec typeSpec) {
        return JavaFile.builder("com.squareup.tacos", typeSpec).build().toString();
    }
}

