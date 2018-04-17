package org.apache.ibatis.cache;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Assert;


public class AmplCacheKeyTest {
    private void canSerialize(final CacheKey object) throws IOException, ClassNotFoundException {
        FileOutputStream fout = new FileOutputStream("target/address.ser");
        ObjectOutputStream output = new ObjectOutputStream(fout);
        output.writeObject(object);
        output.close();
        FileInputStream fin = new FileInputStream("target/address.ser");
        ObjectInputStream input = new ObjectInputStream(fin);
        CacheKey cacheKey = ((CacheKey) (input.readObject()));
        input.close();
        Assert.assertEquals(1, cacheKey.getUpdateCount());
    }
}

