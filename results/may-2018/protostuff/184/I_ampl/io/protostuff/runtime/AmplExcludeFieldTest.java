package io.protostuff.runtime;


import io.protostuff.Exclude;
import io.protostuff.Tag;


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
}

