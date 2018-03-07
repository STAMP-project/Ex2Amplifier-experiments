package io.protostuff.runtime;


import io.protostuff.AbstractTest;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.Tag;
import junit.framework.TestCase;


public class AmplFilterFieldsByGroupTest extends AbstractTest {
    static class Inner {
        @Tag(2)
        public boolean propAll = false;

        @Tag(value = 3, groupFilter = AmplFilterFieldsByGroupTest.GROUP1)
        public boolean prop1a = false;

        @Tag(value = 4, groupFilter = -((AmplFilterFieldsByGroupTest.GROUP2) | (AmplFilterFieldsByGroupTest.GROUP3)))
        public boolean prop1b = false;

        @Tag(value = 5, groupFilter = AmplFilterFieldsByGroupTest.GROUP2)
        public boolean prop2a = false;

        @Tag(value = 6, groupFilter = -((AmplFilterFieldsByGroupTest.GROUP1) | (AmplFilterFieldsByGroupTest.GROUP3)))
        public boolean prop2b = false;

        @Tag(value = 7, groupFilter = AmplFilterFieldsByGroupTest.GROUP3)
        public boolean prop3a = false;

        @Tag(value = 8, groupFilter = -((AmplFilterFieldsByGroupTest.GROUP1) | (AmplFilterFieldsByGroupTest.GROUP2)))
        public boolean prop3b = false;

        @Tag(value = 9, groupFilter = (AmplFilterFieldsByGroupTest.GROUP1) | (AmplFilterFieldsByGroupTest.GROUP2))
        public boolean prop1and2a = false;

        @Tag(value = 10, groupFilter = -(AmplFilterFieldsByGroupTest.GROUP3))
        public boolean prop1and2b = false;

        @Tag(value = 11, groupFilter = (AmplFilterFieldsByGroupTest.GROUP1) | (AmplFilterFieldsByGroupTest.GROUP3))
        public boolean prop1and3a = false;

        @Tag(value = 12, groupFilter = -(AmplFilterFieldsByGroupTest.GROUP2))
        public boolean prop1and3b = false;

        @Tag(value = 13, groupFilter = (AmplFilterFieldsByGroupTest.GROUP2) | (AmplFilterFieldsByGroupTest.GROUP3))
        public boolean prop2and3a = false;

        @Tag(value = 14, groupFilter = -(AmplFilterFieldsByGroupTest.GROUP1))
        public boolean prop2and3b = false;

        public AmplFilterFieldsByGroupTest.Inner fillAll(boolean value) {
            propAll = value;
            prop1a = value;
            prop1b = value;
            prop2a = value;
            prop2b = value;
            prop3a = value;
            prop3b = value;
            prop1and2a = value;
            prop1and2b = value;
            prop1and3a = value;
            prop1and3b = value;
            prop2and3a = value;
            prop2and3b = value;
            return this;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = (prime * result) + (prop1a ? 1231 : 1237);
            result = (prime * result) + (prop1and2a ? 1231 : 1237);
            result = (prime * result) + (prop1and2b ? 1231 : 1237);
            result = (prime * result) + (prop1and3a ? 1231 : 1237);
            result = (prime * result) + (prop1and3b ? 1231 : 1237);
            result = (prime * result) + (prop1b ? 1231 : 1237);
            result = (prime * result) + (prop2a ? 1231 : 1237);
            result = (prime * result) + (prop2and3a ? 1231 : 1237);
            result = (prime * result) + (prop2and3b ? 1231 : 1237);
            result = (prime * result) + (prop2b ? 1231 : 1237);
            result = (prime * result) + (prop3a ? 1231 : 1237);
            result = (prime * result) + (prop3b ? 1231 : 1237);
            result = (prime * result) + (propAll ? 1231 : 1237);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if ((this) == obj)
                return true;

            if (obj == null)
                return false;

            if ((getClass()) != (obj.getClass()))
                return false;

            AmplFilterFieldsByGroupTest.Inner other = ((AmplFilterFieldsByGroupTest.Inner) (obj));
            if ((prop1a) != (other.prop1a))
                return false;

            if ((prop1and2a) != (other.prop1and2a))
                return false;

            if ((prop1and2b) != (other.prop1and2b))
                return false;

            if ((prop1and3a) != (other.prop1and3a))
                return false;

            if ((prop1and3b) != (other.prop1and3b))
                return false;

            if ((prop1b) != (other.prop1b))
                return false;

            if ((prop2a) != (other.prop2a))
                return false;

            if ((prop2and3a) != (other.prop2and3a))
                return false;

            if ((prop2and3b) != (other.prop2and3b))
                return false;

            if ((prop2b) != (other.prop2b))
                return false;

            if ((prop3a) != (other.prop3a))
                return false;

            if ((prop3b) != (other.prop3b))
                return false;

            if ((propAll) != (other.propAll))
                return false;

            return true;
        }

        @Override
        public String toString() {
            return ((((((((((((((((((((((((("Inner [propAll=" + (propAll)) + ", prop1a=") + (prop1a)) + ", prop1b=") + (prop1b)) + ", prop2a=") + (prop2a)) + ", prop2b=") + (prop2b)) + ", prop3a=") + (prop3a)) + ", prop3b=") + (prop3b)) + ", prop1and2a=") + (prop1and2a)) + ", prop1and2b=") + (prop1and2b)) + ", prop1and3a=") + (prop1and3a)) + ", prop1and3b=") + (prop1and3b)) + ", prop2and3a=") + (prop2and3a)) + ", prop2and3b=") + (prop2and3b)) + "]";
        }
    }

    static final int GROUP1 = 1;

    static final int GROUP2 = 2;

    static final int GROUP3 = 4;

    static void verifyPrimary(IdStrategy strategy) throws Exception {
        Schema<AmplFilterFieldsByGroupTest.Inner> schema = RuntimeSchema.getSchema(AmplFilterFieldsByGroupTest.Inner.class, strategy);
        AmplFilterFieldsByGroupTest.Inner message = new AmplFilterFieldsByGroupTest.Inner().fillAll(true);
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, AbstractTest.buf());
        AmplFilterFieldsByGroupTest.Inner parsed = new AmplFilterFieldsByGroupTest.Inner();
        ProtostuffIOUtil.mergeFrom(data, parsed, schema);
        TestCase.assertTrue(message.equals(parsed));
    }

    static void verifyGroup1(IdStrategy strategy) throws Exception {
        Schema<AmplFilterFieldsByGroupTest.Inner> schema = RuntimeSchema.getSchema(AmplFilterFieldsByGroupTest.Inner.class, strategy);
        AmplFilterFieldsByGroupTest.Inner message = new AmplFilterFieldsByGroupTest.Inner().fillAll(true);
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, AbstractTest.buf());
        AmplFilterFieldsByGroupTest.Inner parsed = new AmplFilterFieldsByGroupTest.Inner();
        ProtostuffIOUtil.mergeFrom(data, parsed, schema);
        TestCase.assertTrue((!(message.equals(parsed))));
        TestCase.assertTrue(((message.propAll) == (parsed.propAll)));
        TestCase.assertTrue(((message.prop1a) == (parsed.prop1a)));
        TestCase.assertTrue(((message.prop1b) == (parsed.prop1b)));
        TestCase.assertTrue(((message.prop2a) != (parsed.prop2a)));
        TestCase.assertTrue(((message.prop2b) != (parsed.prop2b)));
        TestCase.assertTrue(((message.prop3a) != (parsed.prop3a)));
        TestCase.assertTrue(((message.prop3b) != (parsed.prop3b)));
        TestCase.assertTrue(((message.prop1and2a) == (parsed.prop1and2a)));
        TestCase.assertTrue(((message.prop1and2b) == (parsed.prop1and2b)));
        TestCase.assertTrue(((message.prop1and3a) == (parsed.prop1and3a)));
        TestCase.assertTrue(((message.prop1and3b) == (parsed.prop1and3b)));
        TestCase.assertTrue(((message.prop2and3a) != (parsed.prop2and3a)));
        TestCase.assertTrue(((message.prop2and3b) != (parsed.prop2and3b)));
    }

    static void verifyGroup2(IdStrategy strategy) throws Exception {
        Schema<AmplFilterFieldsByGroupTest.Inner> schema = RuntimeSchema.getSchema(AmplFilterFieldsByGroupTest.Inner.class, strategy);
        AmplFilterFieldsByGroupTest.Inner message = new AmplFilterFieldsByGroupTest.Inner().fillAll(true);
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, AbstractTest.buf());
        AmplFilterFieldsByGroupTest.Inner parsed = new AmplFilterFieldsByGroupTest.Inner();
        ProtostuffIOUtil.mergeFrom(data, parsed, schema);
        TestCase.assertTrue((!(message.equals(parsed))));
        TestCase.assertTrue(((message.propAll) == (parsed.propAll)));
        TestCase.assertTrue(((message.prop1a) != (parsed.prop1a)));
        TestCase.assertTrue(((message.prop1b) != (parsed.prop1b)));
        TestCase.assertTrue(((message.prop2a) == (parsed.prop2a)));
        TestCase.assertTrue(((message.prop2b) == (parsed.prop2b)));
        TestCase.assertTrue(((message.prop3a) != (parsed.prop3a)));
        TestCase.assertTrue(((message.prop3b) != (parsed.prop3b)));
        TestCase.assertTrue(((message.prop1and2a) == (parsed.prop1and2a)));
        TestCase.assertTrue(((message.prop1and2b) == (parsed.prop1and2b)));
        TestCase.assertTrue(((message.prop1and3a) != (parsed.prop1and3a)));
        TestCase.assertTrue(((message.prop1and3b) != (parsed.prop1and3b)));
        TestCase.assertTrue(((message.prop2and3a) == (parsed.prop2and3a)));
        TestCase.assertTrue(((message.prop2and3b) == (parsed.prop2and3b)));
    }

    static void verifyGroup3(IdStrategy strategy) throws Exception {
        Schema<AmplFilterFieldsByGroupTest.Inner> schema = RuntimeSchema.getSchema(AmplFilterFieldsByGroupTest.Inner.class, strategy);
        AmplFilterFieldsByGroupTest.Inner message = new AmplFilterFieldsByGroupTest.Inner().fillAll(true);
        byte[] data = ProtostuffIOUtil.toByteArray(message, schema, AbstractTest.buf());
        AmplFilterFieldsByGroupTest.Inner parsed = new AmplFilterFieldsByGroupTest.Inner();
        ProtostuffIOUtil.mergeFrom(data, parsed, schema);
        TestCase.assertTrue((!(message.equals(parsed))));
        TestCase.assertTrue(((message.propAll) == (parsed.propAll)));
        TestCase.assertTrue(((message.prop1a) != (parsed.prop1a)));
        TestCase.assertTrue(((message.prop1b) != (parsed.prop1b)));
        TestCase.assertTrue(((message.prop2a) != (parsed.prop2a)));
        TestCase.assertTrue(((message.prop2b) != (parsed.prop2b)));
        TestCase.assertTrue(((message.prop3a) == (parsed.prop3a)));
        TestCase.assertTrue(((message.prop3b) == (parsed.prop3b)));
        TestCase.assertTrue(((message.prop1and2a) != (parsed.prop1and2a)));
        TestCase.assertTrue(((message.prop1and2b) != (parsed.prop1and2b)));
        TestCase.assertTrue(((message.prop1and3a) == (parsed.prop1and3a)));
        TestCase.assertTrue(((message.prop1and3b) == (parsed.prop1and3b)));
        TestCase.assertTrue(((message.prop2and3a) == (parsed.prop2and3a)));
        TestCase.assertTrue(((message.prop2and3b) == (parsed.prop2and3b)));
    }
}

