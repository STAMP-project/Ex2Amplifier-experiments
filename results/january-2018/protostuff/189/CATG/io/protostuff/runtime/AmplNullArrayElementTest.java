package io.protostuff.runtime;


import io.protostuff.AbstractTest;
import io.protostuff.ByteString;
import io.protostuff.Pipe;
import io.protostuff.Schema;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;


public abstract class AmplNullArrayElementTest extends AbstractTest {
    public static final class SomePojo {
        String name;

        public SomePojo() {
        }

        public SomePojo(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = (prime * result) + ((name) == null ? 0 : name.hashCode());
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

            AmplNullArrayElementTest.SomePojo other = ((AmplNullArrayElementTest.SomePojo) (obj));
            if ((name) == null) {
                if ((other.name) != null)
                    return false;

            }else
                if (!(name.equals(other.name)))
                    return false;


            return true;
        }
    }

    public enum Size {
        SMALL, MEDIUM, LARGE;}

    public static final class PojoWithNonPrimitiveArrays {
        Boolean[] boolArray;

        Character[] charArray;

        Short[] shortArray;

        Integer[] intArray;

        Long[] longArray;

        Float[] floatArray;

        Double[] doubleArray;

        String[] stringArray;

        ByteString[] byteStringArray;

        byte[][] byteArrayArray;

        BigDecimal[] bigDecimalArray;

        BigInteger[] bigIntegerArray;

        Date[] dateArray;

        AmplNullArrayElementTest.Size[] sizeArray;

        AmplNullArrayElementTest.SomePojo[] somePojoArray;

        public PojoWithNonPrimitiveArrays() {
        }

        public PojoWithNonPrimitiveArrays(Boolean[] boolArray, Character[] charArray, Short[] shortArray, Integer[] intArray, Long[] longArray, Float[] floatArray, Double[] doubleArray, String[] stringArray, ByteString[] byteStringArray, byte[][] byteArrayArray, BigDecimal[] bigDecimalArray, BigInteger[] bigIntegerArray, Date[] dateArray, AmplNullArrayElementTest.Size[] sizeArray, AmplNullArrayElementTest.SomePojo[] somePojoArray) {
            this.boolArray = boolArray;
            this.charArray = charArray;
            this.shortArray = shortArray;
            this.intArray = intArray;
            this.longArray = longArray;
            this.floatArray = floatArray;
            this.doubleArray = doubleArray;
            this.stringArray = stringArray;
            this.byteStringArray = byteStringArray;
            this.byteArrayArray = byteArrayArray;
            this.bigDecimalArray = bigDecimalArray;
            this.bigIntegerArray = bigIntegerArray;
            this.dateArray = dateArray;
            this.sizeArray = sizeArray;
            this.somePojoArray = somePojoArray;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = (prime * result) + (Arrays.hashCode(bigDecimalArray));
            result = (prime * result) + (Arrays.hashCode(bigIntegerArray));
            result = (prime * result) + (Arrays.hashCode(boolArray));
            result = (prime * result) + (Arrays.hashCode(byteArrayArray));
            result = (prime * result) + (Arrays.hashCode(byteStringArray));
            result = (prime * result) + (Arrays.hashCode(charArray));
            result = (prime * result) + (Arrays.hashCode(dateArray));
            result = (prime * result) + (Arrays.hashCode(doubleArray));
            result = (prime * result) + (Arrays.hashCode(floatArray));
            result = (prime * result) + (Arrays.hashCode(intArray));
            result = (prime * result) + (Arrays.hashCode(longArray));
            result = (prime * result) + (Arrays.hashCode(shortArray));
            result = (prime * result) + (Arrays.hashCode(sizeArray));
            result = (prime * result) + (Arrays.hashCode(somePojoArray));
            result = (prime * result) + (Arrays.hashCode(stringArray));
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

            AmplNullArrayElementTest.PojoWithNonPrimitiveArrays other = ((AmplNullArrayElementTest.PojoWithNonPrimitiveArrays) (obj));
            if (!(Arrays.equals(bigDecimalArray, other.bigDecimalArray)))
                return false;

            if (!(Arrays.equals(bigIntegerArray, other.bigIntegerArray)))
                return false;

            if (!(Arrays.equals(boolArray, other.boolArray)))
                return false;

            if (!(Arrays.deepEquals(byteArrayArray, other.byteArrayArray)))
                return false;

            if (!(Arrays.equals(byteStringArray, other.byteStringArray)))
                return false;

            if (!(Arrays.equals(charArray, other.charArray)))
                return false;

            if (!(Arrays.equals(dateArray, other.dateArray)))
                return false;

            if (!(Arrays.equals(doubleArray, other.doubleArray)))
                return false;

            if (!(Arrays.equals(floatArray, other.floatArray)))
                return false;

            if (!(Arrays.equals(intArray, other.intArray)))
                return false;

            if (!(Arrays.equals(longArray, other.longArray)))
                return false;

            if (!(Arrays.equals(shortArray, other.shortArray)))
                return false;

            if (!(Arrays.equals(sizeArray, other.sizeArray)))
                return false;

            if (!(Arrays.equals(somePojoArray, other.somePojoArray)))
                return false;

            if (!(Arrays.equals(stringArray, other.stringArray)))
                return false;

            return true;
        }
    }

    protected abstract <T> byte[] toByteArray(T message, Schema<T> schema);

    protected abstract <T> void writeTo(OutputStream out, T message, Schema<T> schema) throws IOException;

    protected abstract <T> void mergeFrom(byte[] data, int offset, int length, T message, Schema<T> schema) throws IOException;

    protected abstract <T> void mergeFrom(InputStream in, T message, Schema<T> schema) throws IOException;

    protected abstract <T> void roundTrip(T message, Schema<T> schema, Pipe.Schema<T> pipeSchema) throws IOException;
}

