package org.apache.ibatis.reflection.factory;


import java.util.Collections;
import org.apache.ibatis.reflection.ReflectionException;
import org.junit.Assert;
import org.junit.Test;


public class AmplDefaultObjectFactoryTest {
    @Test(timeout = 10000)
    public void instantiateClassThrowsProperErrorMsg() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_0 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsg__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsg__10);
            boolean o_instantiateClassThrowsProperErrorMsg__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsg__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsg__10);
        }
    }
}

