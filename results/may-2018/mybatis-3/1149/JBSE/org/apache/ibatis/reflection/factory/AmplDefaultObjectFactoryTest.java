package org.apache.ibatis.reflection.factory;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.apache.ibatis.reflection.ReflectionException;
import org.junit.Assert;
import org.junit.Test;


public class AmplDefaultObjectFactoryTest {
    @Test(timeout = 120000)
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

    @Test(timeout = 120000)
    public void instantiateClass_Ex2_JBSE9_failAssert0() throws Exception {
        try {
            DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
            TestClass testClass = defaultObjectFactory.instantiateClass(TestClass.class, Arrays.<Class<?>>asList(String.class, Integer.class), Arrays.<Object>asList(0, 0));
            org.junit.Assert.fail("instantiateClass_Ex2_JBSE9 should have thrown ReflectionException");
        } catch (ReflectionException expected) {
            Assert.assertEquals("Error instantiating class org.apache.ibatis.reflection.factory.TestClass with invalid types (String,Integer) or values (0,0). Cause: java.lang.IllegalArgumentException: argument type mismatch", expected.getMessage());
        }
    }
}

