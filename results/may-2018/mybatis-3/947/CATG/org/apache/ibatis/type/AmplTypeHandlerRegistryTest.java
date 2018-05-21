package org.apache.ibatis.type;


import org.junit.Before;


public class AmplTypeHandlerRegistryTest {
    private TypeHandlerRegistry typeHandlerRegistry;

    @Before
    public void setup() {
        typeHandlerRegistry = new TypeHandlerRegistry();
    }
}

