package io.protostuff.runtime;


import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 * @author Kostiantyn Shchepanovskyi
 */
public class AmplAlwaysUseSunReflectionFactoryOptionTest {
    static final class MyClass {
        private List<String> list;

        public MyClass() {
            list = new ArrayList<>();
            list.add("hello");
        }

        public List<String> getList() {
            return list;
        }
    }
}

