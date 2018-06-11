package io.protostuff.parser;


import java.io.File;
import java.io.IOException;
import java.net.URL;


public class AmplProtoParserTest {
    static URL getResource(String path) throws IOException {
        return Thread.currentThread().getContextClassLoader().getResource(path);
    }

    static File getFile(String path) {
        return new File(new File("src/test/resources"), path);
    }
}

