package io.protostuff;


import org.junit.Assert;
import org.junit.Test;


public class AmplMyTestClass {
    @Test(timeout = 120000)
    public void test() throws Exception {
        final ByteString wrap = ByteString.wrap("toto".getBytes());
        Assert.assertEquals("toto", ((io.protostuff.ByteString)wrap).toString());
        Assert.assertFalse(((io.protostuff.ByteString)wrap).isEmpty());
    }
}

