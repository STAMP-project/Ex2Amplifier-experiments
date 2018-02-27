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


import com.google.common.truth.Truth;
import java.util.concurrent.TimeUnit;
import javax.lang.model.element.Modifier;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public final class AmplJavaFileTest {
    @Ignore("addStaticImport doesn't support members with $L")
    @Test
    public void importStaticDynamic() {
        JavaFile source = JavaFile.builder("com.squareup.tacos", TypeSpec.classBuilder("Taco").addMethod(MethodSpec.methodBuilder("main").addStatement("$T.$L.println($S)", System.class, "out", "hello").build()).build()).addStaticImport(System.class, "out").build();
        Truth.assertThat(source.toString()).isEqualTo(("" + (((((((("package com.squareup.tacos;\n" + "\n") + "import static java.lang.System.out;\n") + "\n") + "class Taco {\n") + "  void main() {\n") + "    out.println(\"hello\");\n") + "  }\n") + "}\n")));
    }

    private TypeSpec importStaticTypeSpec(String name) {
        MethodSpec method = MethodSpec.methodBuilder("minutesToSeconds").addModifiers(Modifier.PUBLIC, Modifier.STATIC).returns(long.class).addParameter(long.class, "minutes").addStatement("$T.gc()", System.class).addStatement("return $1T.SECONDS.convert(minutes, $1T.MINUTES)", TimeUnit.class).build();
        return TypeSpec.classBuilder(name).addMethod(method).build();
    }
}

