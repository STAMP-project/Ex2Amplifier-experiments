package io.protostuff.runtime;


import io.protostuff.Exclude;
import io.protostuff.Pipe.io.protostuff.Schema;
import io.protostuff.Tag;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class AmplExcludeFieldTest {
    public static class Entity {
        int id;

        String name;

        @Exclude
        String alias;

        long timestamp;
    }

    public static class MuchExcludedEntity {
        @Exclude
        int id;

        @Exclude
        String name;

        String alias;

        @Exclude
        long timestamp;
    }

    public static class TaggedAndExcludedEntity {
        @Exclude
        int id;

        @Tag(4)
        String name;

        @Tag(2)
        String alias;

        @Exclude
        long timestamp;
    }

    static final class Empty {}

    @Test(timeout = 10000)
    public void testMuchExcludedEntity() throws Exception {
        RuntimeSchema<AmplExcludeFieldTest.MuchExcludedEntity> schema = ((RuntimeSchema<AmplExcludeFieldTest.MuchExcludedEntity>) (RuntimeSchema.getSchema(AmplExcludeFieldTest.MuchExcludedEntity.class)));
        Assert.assertEquals("MuchExcludedEntity", messageName());
        Assert.assertEquals(1, ((int) (getFieldCount())));
        Assert.assertEquals("io.protostuff.runtime.ExcludeFieldTest$MuchExcludedEntity", messageFullName());
        Assert.assertEquals(981875886, ((int) (((List) (getFields())).hashCode())));
        Assert.assertEquals("io.protostuff.runtime.ExcludeFieldTest$MuchExcludedEntity", messageFullName());
        Assert.assertEquals("MuchExcludedEntity", messageName());
        Assert.assertEquals(1, ((int) (((List) (getFields())).size())));
        Assert.assertFalse(((List) (getFields())).isEmpty());
        boolean boolean_0 = (schema.getFieldCount()) == 1;
        boolean boolean_1 = (schema.getFieldNumber("id")) == 0;
        schema.getFieldByName("id");
        boolean boolean_2 = (schema.getFieldNumber("name")) == 0;
        schema.getFieldByName("name");
        boolean boolean_3 = (schema.getFieldNumber("timestamp")) == 0;
        schema.getFieldByName("timestamp");
    }

    @Test(timeout = 10000)
    public void testIt() throws Exception {
        RuntimeSchema<AmplExcludeFieldTest.Entity> schema = ((RuntimeSchema<AmplExcludeFieldTest.Entity>) (RuntimeSchema.getSchema(AmplExcludeFieldTest.Entity.class)));
        Assert.assertEquals("Entity", messageName());
        Assert.assertEquals(3, ((int) (getFieldCount())));
        Assert.assertEquals("io.protostuff.runtime.ExcludeFieldTest$Entity", messageFullName());
        Assert.assertEquals(1941802271, ((int) (((List) (getFields())).hashCode())));
        Assert.assertEquals("io.protostuff.runtime.ExcludeFieldTest$Entity", messageFullName());
        Assert.assertEquals("Entity", messageName());
        Assert.assertEquals(3, ((int) (((List) (getFields())).size())));
        Assert.assertFalse(((List) (getFields())).isEmpty());
        boolean boolean_4 = (schema.getFieldCount()) == 3;
        boolean boolean_5 = (schema.getFieldNumber("alias")) == 0;
        schema.getFieldByName("alias");
    }

    @Test(timeout = 10000)
    public void testEmptyMessage() throws Exception {
        io.protostuff.Schema<AmplExcludeFieldTest.Empty> o_testEmptyMessage__1 = RuntimeSchema.getSchema(AmplExcludeFieldTest.Empty.class);
        Assert.assertEquals("Empty", messageName());
        Assert.assertEquals("io.protostuff.runtime.ExcludeFieldTest$Empty", messageFullName());
        Assert.assertTrue(getFields().isEmpty());
        Assert.assertEquals(0, ((int) (getFieldCount())));
        Assert.assertEquals("Empty", messageName());
        Assert.assertEquals("io.protostuff.runtime.ExcludeFieldTest$Empty", messageFullName());
    }

    @Test(timeout = 10000)
    public void testTaggedAndExcludedEntity() throws Exception {
        RuntimeSchema<AmplExcludeFieldTest.TaggedAndExcludedEntity> schema = ((RuntimeSchema<AmplExcludeFieldTest.TaggedAndExcludedEntity>) (RuntimeSchema.getSchema(AmplExcludeFieldTest.TaggedAndExcludedEntity.class)));
        Assert.assertEquals("TaggedAndExcludedEntity", messageName());
        Assert.assertEquals(2, ((int) (getFieldCount())));
        Assert.assertEquals("io.protostuff.runtime.ExcludeFieldTest$TaggedAndExcludedEntity", messageFullName());
        Assert.assertEquals(2068767747, ((int) (((List) (getFields())).hashCode())));
        Assert.assertEquals("io.protostuff.runtime.ExcludeFieldTest$TaggedAndExcludedEntity", messageFullName());
        Assert.assertEquals("TaggedAndExcludedEntity", messageName());
        Assert.assertEquals(2, ((int) (((List) (getFields())).size())));
        Assert.assertFalse(((List) (getFields())).isEmpty());
        schema.getFieldCount();
        int o_testTaggedAndExcludedEntity__4 = schema.getFieldNumber("id");
        Assert.assertEquals(0, ((int) (o_testTaggedAndExcludedEntity__4)));
        schema.getFieldByName("id");
        boolean boolean_6 = (schema.getFieldNumber("timestamp")) == 0;
        schema.getFieldByName("timestamp");
    }
}

