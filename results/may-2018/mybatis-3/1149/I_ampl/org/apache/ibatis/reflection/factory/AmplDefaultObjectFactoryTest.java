package org.apache.ibatis.reflection.factory;


import java.util.Collections;
import org.apache.ibatis.reflection.ReflectionException;
import org.junit.Assert;
import org.junit.Test;


public class AmplDefaultObjectFactoryTest {
    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString9() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("x*zH_,y(q2"));
        } catch (Exception e) {
            boolean boolean_9 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString9__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString9__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString9__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString9__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString9__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString7() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("Should not have trailing commas in types list"));
        } catch (Exception e) {
            boolean boolean_7 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString7__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString7__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString7__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString7__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString7__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString8() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("fo"));
        } catch (Exception e) {
            boolean boolean_8 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString8__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString8__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString8__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString8__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString8__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString5() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("Should have thrown ReflectionException"));
        } catch (Exception e) {
            boolean boolean_5 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString5__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString5__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString5__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString5__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString5__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString6() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("(foo)"));
        } catch (Exception e) {
            boolean boolean_6 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString6__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString6__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString6__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString6__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString6__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString3() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("Coo"));
        } catch (Exception e) {
            boolean boolean_3 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString3__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString3__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString3__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString3__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString3__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString4() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_4 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString4__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString4__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString4__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString4__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString4__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString41() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_41 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString41__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString41__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString41__12 = e.getMessage().contains("\n");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString41__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString41__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString42() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_42 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString42__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString42__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString42__12 = e.getMessage().contains("(fo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString42__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString42__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString40() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_40 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString40__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString40__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString40__12 = e.getMessage().contains("Should not have trailing commas in types list");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString40__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString40__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString45() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_45 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString45__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString45__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString45__12 = e.getMessage().contains("(Ufoo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString45__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString45__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString46() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_46 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString46__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString46__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString46__12 = e.getMessage().contains("Should be ReflectionException");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString46__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString46__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString43() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_43 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString43__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString43__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString43__12 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString43__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString43__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString44() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_44 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString44__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString44__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString44__12 = e.getMessage().contains("lfoo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString44__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString44__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString1() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList(""));
        } catch (Exception e) {
            boolean boolean_1 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString1__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString1__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString1__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString1__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString1__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString49() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_49 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString49__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString49__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString49__12 = e.getMessage().contains("Should not have trailing commas in values list");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString49__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString49__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString2() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("\u0000"));
        } catch (Exception e) {
            boolean boolean_2 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString2__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString2__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString2__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString2__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString2__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString47() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_47 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString47__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString47__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString47__12 = e.getMessage().contains("IvC=TU&zgY");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString47__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString47__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString48() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_48 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString48__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString48__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString48__12 = e.getMessage().contains("myString didn\'t match expected");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString48__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString48__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString50() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_50 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString50__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString50__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString50__12 = e.getMessage().contains("myInteger didn\'t match expected");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString50__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString50__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString51() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_51 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString51__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString51__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString51__12 = e.getMessage().contains(":");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString51__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString51__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString12() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("Should be ReflectionException"));
        } catch (Exception e) {
            boolean boolean_12 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString12__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString12__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString12__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString12__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString12__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString13() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("f@oo"));
        } catch (Exception e) {
            boolean boolean_13 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString13__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString13__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString13__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString13__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString13__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString10() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("\n"));
        } catch (Exception e) {
            boolean boolean_10 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString10__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString10__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString10__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString10__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString10__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString11() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("(String)"));
        } catch (Exception e) {
            boolean boolean_11 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString11__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString11__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString11__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString11__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString11__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString16() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("myInteger didn\'t match expected"));
        } catch (Exception e) {
            boolean boolean_16 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString16__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString16__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString16__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString16__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString16__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString17() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList(":"));
        } catch (Exception e) {
            boolean boolean_17 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString17__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString17__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString17__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString17__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString17__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString14() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("myString didn\'t match expected"));
        } catch (Exception e) {
            boolean boolean_14 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString14__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString14__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString14__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString14__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString14__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString15() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("Should not have trailing commas in values list"));
        } catch (Exception e) {
            boolean boolean_15 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString15__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString15__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString15__12 = e.getMessage().contains("(foo)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString15__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString15__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString18() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_18 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString18__10 = e.getMessage().contains("");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString18__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString18__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString18__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString18__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString19() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_19 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString19__10 = e.getMessage().contains("\u0000");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString19__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString19__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString19__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString19__10);
        }
    }

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
    public void instantiateClassThrowsProperErrorMsglitString20() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_20 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString20__10 = e.getMessage().contains("(St5ring)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString20__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString20__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString20__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString20__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString23() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_23 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString23__10 = e.getMessage().contains("Should have thrown ReflectionException");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString23__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString23__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString23__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString23__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString24() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_24 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString24__10 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString24__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString24__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString24__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString24__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString21() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_21 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString21__10 = e.getMessage().contains("Wz2[|+mr6#");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString21__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString21__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString21__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString21__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString22() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_22 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString22__10 = e.getMessage().contains("foo");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString22__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString22__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString22__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString22__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString27() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_27 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString27__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString27__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString27__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString27__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString27__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString28() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_28 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString28__10 = e.getMessage().contains("Should be ReflectionException");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString28__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString28__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString28__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString28__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString25() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_25 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString25__10 = e.getMessage().contains("Should not have trailing commas in types list");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString25__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString25__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString25__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString25__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString26() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_26 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString26__10 = e.getMessage().contains("\n");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString26__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString26__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString26__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString26__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString29() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_29 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString29__10 = e.getMessage().contains("(Strig)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString29__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString29__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString29__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString29__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString30() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_30 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString30__10 = e.getMessage().contains("myString didn\'t match expected");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString30__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString30__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString30__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString30__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString31() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_31 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString31__10 = e.getMessage().contains("(SQring)");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString31__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString31__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString31__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString31__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString34() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_34 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString34__10 = e.getMessage().contains(":");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString34__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString34__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString34__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString34__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString35() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_35 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString35__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString35__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString35__12 = e.getMessage().contains("");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString35__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString35__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString32() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_32 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString32__10 = e.getMessage().contains("Should not have trailing commas in values list");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString32__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString32__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString32__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString32__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString33() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_33 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString33__10 = e.getMessage().contains("myInteger didn\'t match expected");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString33__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString33__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString33__12);
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString33__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString38() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_38 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString38__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString38__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString38__12 = e.getMessage().contains("(foo)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString38__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString38__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString39() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_39 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString39__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString39__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString39__12 = e.getMessage().contains("Should have thrown ReflectionException");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString39__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString39__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString36() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_36 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString36__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString36__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString36__12 = e.getMessage().contains("\u0000");
            Assert.assertFalse(o_instantiateClassThrowsProperErrorMsglitString36__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString36__10);
        }
    }

    @Test(timeout = 120000)
    public void instantiateClassThrowsProperErrorMsglitString37() throws Exception {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        try {
            defaultObjectFactory.instantiateClass(TestClass.class, Collections.<Class<?>>singletonList(String.class), Collections.<Object>singletonList("foo"));
        } catch (Exception e) {
            boolean boolean_37 = e instanceof ReflectionException;
            boolean o_instantiateClassThrowsProperErrorMsglitString37__10 = e.getMessage().contains("(String)");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString37__10);
            boolean o_instantiateClassThrowsProperErrorMsglitString37__12 = e.getMessage().contains("foo");
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString37__12);
            Assert.assertTrue(o_instantiateClassThrowsProperErrorMsglitString37__10);
        }
    }
}

