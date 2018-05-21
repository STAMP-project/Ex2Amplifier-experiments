package io.protostuff.runtime;


import io.protostuff.Schema;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;


public class AmplObjectSchemaTest {
    enum Order {
        ASCENDING, DESCENDING;}

    @SuppressWarnings("rawtypes")
    public static class Bean {
        public String name;

        public List firstList;

        public List secondList;

        public Object firstItem;

        public Object secondItem;

        public Map firstMap;

        public Map secondMap;

        public AmplObjectSchemaTest.HasName firstHasName;

        public AmplObjectSchemaTest.HasName secondHashname;

        public AmplObjectSchemaTest.Named firstNamed;

        public AmplObjectSchemaTest.Named secondNamed;

        public Object firstObject;

        public Object secondObject;

        Map<String, ?> firstStringMap;

        Map<String, ?> secondStringMap;

        Map<AmplObjectSchemaTest.HasName, ?> firstHasNameMap;

        Map<AmplObjectSchemaTest.HasName, ?> secondHasNameMap;

        Map<AmplObjectSchemaTest.Named, ?> firstNamedMap;

        Map<AmplObjectSchemaTest.Named, ?> secondNamedMap;

        int[] firstIntArray;

        int[] secondIntArray;

        Map<Set<String>, ?> firstSetMap;

        Map<Set<String>, ?> secondSetMap;

        Map<List<AmplObjectSchemaTest.Order>, ?> firstListMap;

        Map<List<AmplObjectSchemaTest.Order>, ?> secondListMap;

        Map<EnumSet<AmplObjectSchemaTest.Order>, ?> firstEnumSetMap;

        Map<EnumSet<AmplObjectSchemaTest.Order>, ?> secondEnumSetMap;

        List<Map<String, ?>> firstMapList;

        List<Map<String, ?>> secondMapList;

        List<EnumMap<AmplObjectSchemaTest.Order, AmplObjectSchemaTest.Item>> firstEnumMapList;

        List<EnumMap<AmplObjectSchemaTest.Order, AmplObjectSchemaTest.Item>> secondEnumMapList;

        AmplObjectSchemaTest.Item[] firstItemArray;

        AmplObjectSchemaTest.Item[] secondItemArray;

        Object itemArray;

        AmplObjectSchemaTest.Item[][] itemArray2d;

        Object[] itemArrayWrapper;

        public Set firstSet;

        public Set secondSet;

        public IdentityHashMap identityMap;

        public IdentityHashMap anotherIdentityMap;
    }

    public interface HasName {
        public abstract String getName();
    }

    public abstract static class Named {
        public abstract String getName();
    }

    public static class Item extends AmplObjectSchemaTest.Named implements AmplObjectSchemaTest.HasName {
        public String name;

        public Item() {
        }

        public Item(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        public String toString() {
            return "name:" + (name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if ((this) == obj)
                return true;

            if (obj == null)
                return false;

            if ((getClass()) != (obj.getClass()))
                return false;

            AmplObjectSchemaTest.Item other = ((AmplObjectSchemaTest.Item) (obj));
            if ((name) == null) {
                if ((other.name) != null)
                    return false;

            }else
                if (!(name.equals(other.name)))
                    return false;


            return true;
        }
    }

    static void print(Schema<?> schema) {
        int i = 1;
        for (String name = schema.getFieldName(i); name != null; name = schema.getFieldName((++i))) {
            System.err.println(name);
        }
    }

    static AmplObjectSchemaTest.Bean fill(AmplObjectSchemaTest.Bean bean) {
        bean.name = "test";
        AmplObjectSchemaTest.Item share = new AmplObjectSchemaTest.Item("share");
        List<AmplObjectSchemaTest.Item> firstList = AmplObjectSchemaTest.newList(share, new AmplObjectSchemaTest.Item("new_a"));
        bean.firstList = firstList;
        List<AmplObjectSchemaTest.Item> secondList = AmplObjectSchemaTest.newList(share, new AmplObjectSchemaTest.Item("new_a"));
        bean.secondList = secondList;
        AmplObjectSchemaTest.Item share2;
        bean.firstItem = bean.secondItem = share2 = new AmplObjectSchemaTest.Item("share2");
        AmplObjectSchemaTest.Item share3 = new AmplObjectSchemaTest.Item("share3");
        Map<String, AmplObjectSchemaTest.Item> firstMap = AmplObjectSchemaTest.newMap();
        firstMap.put("share", share);
        firstMap.put("share3", share3);
        bean.firstMap = firstMap;
        Map<String, AmplObjectSchemaTest.Item> secondMap = AmplObjectSchemaTest.newMap();
        secondMap.put("share", share);
        secondMap.put("share3", share3);
        bean.secondMap = secondMap;
        AmplObjectSchemaTest.Item share4;
        AmplObjectSchemaTest.Item share5;
        bean.firstHasName = bean.secondHashname = share4 = new AmplObjectSchemaTest.Item("share4");
        bean.firstNamed = bean.secondNamed = share5 = new AmplObjectSchemaTest.Item("share5");
        bean.firstObject = bean.secondObject = new Object();
        AmplObjectSchemaTest.Item share6 = new AmplObjectSchemaTest.Item("share6");
        Map<String, AmplObjectSchemaTest.Item> firstStringMap = AmplObjectSchemaTest.newMap();
        firstStringMap.put("share", share);
        firstStringMap.put("share6", share6);
        bean.firstStringMap = firstStringMap;
        Map<String, AmplObjectSchemaTest.Item> secondStringMap = AmplObjectSchemaTest.newMap();
        secondStringMap.put("share", share);
        secondStringMap.put("share6", share6);
        bean.secondStringMap = secondStringMap;
        AmplObjectSchemaTest.Item share7 = new AmplObjectSchemaTest.Item("share7");
        Map<AmplObjectSchemaTest.HasName, AmplObjectSchemaTest.Item> firstHasNameMap = AmplObjectSchemaTest.newMap();
        firstHasNameMap.put(share, share);
        firstHasNameMap.put(share7, share7);
        bean.firstHasNameMap = firstHasNameMap;
        Map<AmplObjectSchemaTest.HasName, AmplObjectSchemaTest.Item> secondHasNameMap = AmplObjectSchemaTest.newMap();
        secondHasNameMap.put(share, share);
        secondHasNameMap.put(share7, share7);
        bean.secondHasNameMap = secondHasNameMap;
        AmplObjectSchemaTest.Item share8 = new AmplObjectSchemaTest.Item("share8");
        Map<AmplObjectSchemaTest.Named, AmplObjectSchemaTest.Item> firstNamedMap = AmplObjectSchemaTest.newMap();
        firstNamedMap.put(share, share);
        firstNamedMap.put(share8, share8);
        bean.firstNamedMap = firstNamedMap;
        Map<AmplObjectSchemaTest.Named, AmplObjectSchemaTest.Item> secondNamedMap = AmplObjectSchemaTest.newMap();
        secondNamedMap.put(share, share);
        secondNamedMap.put(share8, share8);
        bean.secondNamedMap = secondNamedMap;
        bean.firstIntArray = bean.secondIntArray = new int[]{ 1, 2, 3 };
        AmplObjectSchemaTest.Item share9 = new AmplObjectSchemaTest.Item("share9");
        Set<String> set = AmplObjectSchemaTest.newSet("share9");
        Map<Set<String>, AmplObjectSchemaTest.Item> firstSetMap = AmplObjectSchemaTest.newMap();
        firstSetMap.put(set, share9);
        bean.firstSetMap = firstSetMap;
        Map<Set<String>, AmplObjectSchemaTest.Item> secondSetMap = AmplObjectSchemaTest.newMap();
        secondSetMap.put(set, share9);
        bean.secondSetMap = secondSetMap;
        AmplObjectSchemaTest.Item share10 = new AmplObjectSchemaTest.Item("share10");
        List<AmplObjectSchemaTest.Order> orderList = AmplObjectSchemaTest.newList(AmplObjectSchemaTest.Order.ASCENDING, AmplObjectSchemaTest.Order.DESCENDING, AmplObjectSchemaTest.Order.ASCENDING);
        Map<List<AmplObjectSchemaTest.Order>, AmplObjectSchemaTest.Item> firstListMap = AmplObjectSchemaTest.newMap();
        firstListMap.put(orderList, share10);
        bean.firstListMap = firstListMap;
        Map<List<AmplObjectSchemaTest.Order>, AmplObjectSchemaTest.Item> secondListMap = AmplObjectSchemaTest.newMap();
        secondListMap.put(orderList, share10);
        bean.secondListMap = secondListMap;
        AmplObjectSchemaTest.Item share11 = new AmplObjectSchemaTest.Item("share11");
        EnumSet<AmplObjectSchemaTest.Order> orderEnumSet = EnumSet.allOf(AmplObjectSchemaTest.Order.class);
        Map<EnumSet<AmplObjectSchemaTest.Order>, AmplObjectSchemaTest.Item> firstEnumSetMap = AmplObjectSchemaTest.newMap();
        firstEnumSetMap.put(orderEnumSet, share11);
        bean.firstEnumSetMap = firstEnumSetMap;
        Map<EnumSet<AmplObjectSchemaTest.Order>, AmplObjectSchemaTest.Item> secondEnumSetMap = AmplObjectSchemaTest.newMap();
        secondEnumSetMap.put(orderEnumSet, share11);
        bean.secondEnumSetMap = secondEnumSetMap;
        AmplObjectSchemaTest.Item share12 = new AmplObjectSchemaTest.Item("share12");
        Map<String, AmplObjectSchemaTest.Item> itemMap = AmplObjectSchemaTest.newMap();
        itemMap.put("share12", share12);
        itemMap.put("share", share);
        List<Map<String, ?>> firstMapList = AmplObjectSchemaTest.newList();
        firstMapList.add(itemMap);
        bean.firstMapList = firstMapList;
        List<Map<String, ?>> secondMapList = AmplObjectSchemaTest.newList();
        secondMapList.add(itemMap);
        bean.secondMapList = secondMapList;
        AmplObjectSchemaTest.Item share13 = new AmplObjectSchemaTest.Item("share13");
        EnumMap<AmplObjectSchemaTest.Order, AmplObjectSchemaTest.Item> orderMap = new EnumMap<>(AmplObjectSchemaTest.Order.class);
        orderMap.put(AmplObjectSchemaTest.Order.ASCENDING, share13);
        orderMap.put(AmplObjectSchemaTest.Order.DESCENDING, share);
        List<EnumMap<AmplObjectSchemaTest.Order, AmplObjectSchemaTest.Item>> firstEnumMapList = AmplObjectSchemaTest.newList();
        firstEnumMapList.add(orderMap);
        bean.firstEnumMapList = firstEnumMapList;
        List<EnumMap<AmplObjectSchemaTest.Order, AmplObjectSchemaTest.Item>> secondEnumMapList = AmplObjectSchemaTest.newList();
        secondEnumMapList.add(orderMap);
        bean.secondEnumMapList = secondEnumMapList;
        AmplObjectSchemaTest.Item share14 = new AmplObjectSchemaTest.Item("share14");
        bean.itemArray = bean.firstItemArray = bean.secondItemArray = new AmplObjectSchemaTest.Item[]{ share, share2, share3, share4, share5, share6, share7, share8, share9, share10, share11, share12, share13, share14 };
        bean.itemArray2d = new AmplObjectSchemaTest.Item[1][];
        bean.itemArray2d[0] = bean.firstItemArray;
        bean.itemArrayWrapper = new Object[]{ bean.itemArray, bean.itemArray2d, share };
        AmplObjectSchemaTest.Item share15 = new AmplObjectSchemaTest.Item("share15");
        Set<AmplObjectSchemaTest.Item> firstSet = AmplObjectSchemaTest.newSet(share15);
        bean.firstSet = firstSet;
        Set<AmplObjectSchemaTest.Item> secondSet = AmplObjectSchemaTest.newSet(share15);
        bean.secondSet = secondSet;
        IdentityHashMap<AmplObjectSchemaTest.Item, AmplObjectSchemaTest.Item> identityMap = new IdentityHashMap<>();
        identityMap.put(share, share);
        bean.identityMap = identityMap;
        AmplObjectSchemaTest.Item share16 = new AmplObjectSchemaTest.Item("share16");
        IdentityHashMap<AmplObjectSchemaTest.Order, AmplObjectSchemaTest.Item> anotherIdentityMap = new IdentityHashMap<>();
        anotherIdentityMap.put(AmplObjectSchemaTest.Order.ASCENDING, share16);
        anotherIdentityMap.put(AmplObjectSchemaTest.Order.DESCENDING, share);
        bean.anotherIdentityMap = anotherIdentityMap;
        return bean;
    }

    static void verify(AmplObjectSchemaTest.Bean bean) {
        Assert.assertEquals(bean.name, "test");
        Assert.assertNotNull(bean.firstList);
        Assert.assertTrue(((bean.firstList.size()) == 2));
        Assert.assertTrue(((bean.firstList.get(0)) == (bean.secondList.get(0))));
        Assert.assertNotNull(bean.secondItem);
        Assert.assertTrue(((bean.secondItem) == (bean.firstItem)));
        Assert.assertNotNull(bean.firstMap);
        Assert.assertTrue(((bean.firstMap.size()) == 2));
        Assert.assertTrue(((bean.firstMap.get("share")) == (bean.secondMap.get("share"))));
        Assert.assertTrue(((bean.firstMap.get("share3")) == (bean.secondMap.get("share3"))));
        Assert.assertNotNull(bean.firstHasName);
        Assert.assertTrue(((bean.firstHasName) == (bean.secondHashname)));
        Assert.assertNotNull(bean.firstNamed);
        Assert.assertTrue(((bean.firstNamed) == (bean.secondNamed)));
        Assert.assertNotNull(bean.firstObject);
        Assert.assertTrue(((bean.firstObject) == (bean.secondObject)));
        Assert.assertNotNull(bean.firstStringMap);
        Assert.assertTrue(((bean.firstStringMap.size()) == 2));
        Assert.assertTrue(((bean.firstStringMap.get("share")) == (bean.secondStringMap.get("share"))));
        Assert.assertTrue(((bean.firstStringMap.get("share6")) == (bean.secondStringMap.get("share6"))));
        Assert.assertNotNull(bean.firstHasNameMap);
        Assert.assertTrue(((bean.firstHasNameMap.size()) == 2));
        Assert.assertTrue(((bean.firstHasNameMap.get("share")) == (bean.secondHasNameMap.get("share"))));
        Assert.assertTrue(((bean.firstHasNameMap.get("share7")) == (bean.secondHasNameMap.get("share7"))));
        Assert.assertNotNull(bean.firstNamedMap);
        Assert.assertTrue(((bean.firstNamedMap.size()) == 2));
        Assert.assertTrue(((bean.firstNamedMap.get("share")) == (bean.secondNamedMap.get("share"))));
        Assert.assertTrue(((bean.firstNamedMap.get("share8")) == (bean.secondNamedMap.get("share8"))));
        Assert.assertNotNull(bean.firstIntArray);
        Assert.assertTrue(((bean.firstIntArray.length) == 3));
        Assert.assertTrue(((bean.firstIntArray) == (bean.secondIntArray)));
        Assert.assertNotNull(bean.firstSetMap);
        Assert.assertTrue(((bean.firstSetMap.size()) == 1));
        Assert.assertTrue(((bean.firstSetMap.values().iterator().next()) == (bean.secondSetMap.values().iterator().next())));
        Assert.assertTrue(((bean.firstSetMap.keySet().iterator().next()) == (bean.secondSetMap.keySet().iterator().next())));
        Assert.assertNotNull(bean.firstListMap);
        Assert.assertTrue(((bean.firstListMap.size()) == 1));
        List<AmplObjectSchemaTest.Order> orderList = bean.firstListMap.keySet().iterator().next();
        Assert.assertTrue(((orderList.size()) == 3));
        Assert.assertTrue(((orderList.get(0)) == (AmplObjectSchemaTest.Order.ASCENDING)));
        Assert.assertTrue(((orderList.get(1)) == (AmplObjectSchemaTest.Order.DESCENDING)));
        Assert.assertTrue(((orderList.get(2)) == (AmplObjectSchemaTest.Order.ASCENDING)));
        Assert.assertTrue((orderList == (bean.secondListMap.keySet().iterator().next())));
        Assert.assertTrue(((bean.firstListMap.values().iterator().next()) == (bean.secondListMap.values().iterator().next())));
        Assert.assertNotNull(bean.firstEnumSetMap);
        Assert.assertTrue(((bean.firstEnumSetMap.size()) == 1));
        Assert.assertTrue(((bean.firstEnumSetMap.values().iterator().next()) == (bean.secondEnumSetMap.values().iterator().next())));
        Assert.assertTrue(((bean.firstEnumSetMap.keySet().iterator().next()) == (bean.secondEnumSetMap.keySet().iterator().next())));
        Assert.assertNotNull(bean.firstMapList);
        Assert.assertTrue(((bean.firstMapList.size()) == 1));
        Assert.assertTrue(((bean.firstMapList.get(0)) == (bean.secondMapList.get(0))));
        Assert.assertNotNull(bean.firstEnumMapList);
        Assert.assertTrue(((bean.firstEnumMapList.size()) == 1));
        Assert.assertTrue(((bean.firstEnumMapList.get(0)) == (bean.secondEnumMapList.get(0))));
        Assert.assertNotNull(bean.firstItemArray);
        Assert.assertTrue(((bean.firstItemArray.length) == 14));
        Assert.assertTrue(((bean.firstItemArray) == (bean.secondItemArray)));
        Assert.assertTrue(((bean.firstItemArray) == (bean.itemArray)));
        Assert.assertEquals(bean.firstItemArray[0].name, "share");
        Assert.assertEquals(bean.firstItemArray[1].name, "share2");
        Assert.assertEquals(bean.firstItemArray[2].name, "share3");
        Assert.assertEquals(bean.firstItemArray[3].name, "share4");
        Assert.assertEquals(bean.firstItemArray[4].name, "share5");
        Assert.assertEquals(bean.firstItemArray[5].name, "share6");
        Assert.assertEquals(bean.firstItemArray[6].name, "share7");
        Assert.assertEquals(bean.firstItemArray[7].name, "share8");
        Assert.assertEquals(bean.firstItemArray[8].name, "share9");
        Assert.assertEquals(bean.firstItemArray[9].name, "share10");
        Assert.assertEquals(bean.firstItemArray[10].name, "share11");
        Assert.assertEquals(bean.firstItemArray[11].name, "share12");
        Assert.assertEquals(bean.firstItemArray[12].name, "share13");
        Assert.assertEquals(bean.firstItemArray[13].name, "share14");
        Assert.assertNotNull(bean.itemArray2d);
        Assert.assertTrue(((bean.itemArray2d.length) == 1));
        Assert.assertTrue(((bean.itemArray2d[0]) == (bean.firstItemArray)));
        Assert.assertNotNull(bean.itemArrayWrapper);
        Assert.assertTrue(((bean.itemArrayWrapper.length) == 3));
        Assert.assertTrue(((bean.itemArrayWrapper[0]) == (bean.itemArray)));
        Assert.assertTrue(((bean.itemArrayWrapper[1]) == (bean.itemArray2d)));
        Assert.assertTrue(((bean.itemArrayWrapper[2]) == (bean.firstItemArray[0])));
        Assert.assertNotNull(bean.firstSet);
        Assert.assertTrue(((bean.firstSet.size()) == 1));
        Assert.assertTrue(((bean.firstSet.iterator().next()) == (bean.secondSet.iterator().next())));
        Assert.assertNotNull(bean.identityMap);
        Assert.assertTrue(((bean.identityMap.size()) == 1));
        Assert.assertTrue(((bean.identityMap.keySet().iterator().next()) == (bean.identityMap.values().iterator().next())));
        AmplObjectSchemaTest.Item share = bean.firstItemArray[0];
        Assert.assertEquals(share.name, "share");
        Assert.assertTrue(bean.identityMap.containsKey(share));
        Assert.assertTrue(((bean.identityMap.get(share)) == share));
        Assert.assertNotNull(bean.anotherIdentityMap);
        Assert.assertTrue(((bean.anotherIdentityMap.size()) == 2));
        Assert.assertEquals(bean.anotherIdentityMap.get(AmplObjectSchemaTest.Order.ASCENDING), new AmplObjectSchemaTest.Item("share16"));
        Assert.assertTrue(((bean.anotherIdentityMap.get(AmplObjectSchemaTest.Order.DESCENDING)) == share));
    }

    static <T> Set<T> newSet(T... ts) {
        HashSet<T> set = new HashSet<>();
        for (T t : ts)
            set.add(t);

        return set;
    }

    static <K, V> Map<K, V> newMap() {
        return new HashMap<>();
    }

    static <T> Set<T> newSet() {
        return new HashSet<>();
    }

    static <T> List<T> newList() {
        return new ArrayList<>();
    }

    static <T> List<T> newList(T... ts) {
        ArrayList<T> list = new ArrayList<>();
        for (T t : ts)
            list.add(t);

        return list;
    }

    static <K, V> Map<K, V> newMap(K key, V value) {
        HashMap<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}

