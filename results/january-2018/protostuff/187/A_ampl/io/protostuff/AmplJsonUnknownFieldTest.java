package io.protostuff;


import io.protostuff.runtime.RuntimeSchema;
import org.junit.Assert;
import org.junit.Before;


public class AmplJsonUnknownFieldTest {
    static class TestMessage {
        public int field1;

        public String field2;
    }

    public static final String NORMAL_MESSAGE = "{" + (("\"field1\":42," + "\"field2\":\"testValue\"") + "}");

    public static final String UNKNOWN_SCALAR_FIELD = "{" + ((("\"field1\":42," + "\"unknownField\":42,") + "\"field2\":\"testValue\"") + "}");

    public static final String UNKNOWN_EMPTY_MESSAGE_FIELD = "{" + ((("\"field1\":42," + "\"unknownField\":{},") + "\"field2\":\"testValue\"") + "}");

    public static final String UNKNOWN_NESTED_MESSAGE_FIELD = "{" + (((((((((((((("\"field1\":42," + "\"unknownField\":{") + "\"a\":0,") + "\"field1\":43,") + "\"anotherNestedField\":{") + "\"b\":0,") + "\"c\":[1, 2, 3],") + "\"thirdNestedField\":{") + "\"e\":1,") + "\"f\":\"foobar\"") + "}") + "}") + "},") + "\"field2\":\"testValue\"") + "}");

    public static final Schema<AmplJsonUnknownFieldTest.TestMessage> SCHEMA = RuntimeSchema.getSchema(AmplJsonUnknownFieldTest.TestMessage.class);

    private AmplJsonUnknownFieldTest.TestMessage instance;

    @Before
    public void setUp() throws Exception {
        instance = AmplJsonUnknownFieldTest.SCHEMA.newMessage();
    }

    private void checkKnownFields(AmplJsonUnknownFieldTest.TestMessage instance) {
        Assert.assertEquals(instance.field1, 42);
        Assert.assertEquals(instance.field2, "testValue");
    }
}

