package org.example;

import org.example.exceptions.NullItemException;
import org.example.exceptions.StorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private StringListImpl stringList;

    @BeforeEach
    public void setUp() {
        stringList = new StringListImpl();
    }

    @Test
    public void testAdd() {
        String item = "Test";

        String result = stringList.add(item);

        assertEquals(item, result);
        assertEquals(1, stringList.size());
        assertTrue(stringList.contains(item));
    }

    @Test
    public void testAddWithNullItem() {
        String item = null;

        assertThrows(NullItemException.class, () -> {
            stringList.add(item);
        });
    }

    @Test
    public void testAddWithFullStorage() {
        StringListImpl stringList = new StringListImpl(1);
        stringList.add("Item1");

        assertThrows(StorageIsFullException.class, () -> {
            stringList.add("Item2");
        });
    }

    @Test
    public void testAddAtIndex() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        String item = "New";
        stringList.add(1, item);

        assertEquals(item, stringList.get(1));
        assertEquals(4, stringList.size());
    }

    @Test
    public void testSet() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        String item = "New";
        stringList.set(1, item);

        assertEquals(item, stringList.get(1));
    }

    @Test
    public void testRemoveByItem() {
        // Arrange
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        String removedItem = stringList.remove("Item2");

        assertFalse(stringList.contains(removedItem));
        assertEquals(2, stringList.size());
    }

    @Test
    public void testRemoveByIndex() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        String removedItem = stringList.remove(1);

        assertFalse(stringList.contains(removedItem));
        assertEquals(2, stringList.size());
    }

    @Test
    public void testContains() {
        stringList.add("Item1");
        stringList.add("Item2");

        assertTrue(stringList.contains("Item1"));
        assertTrue(stringList.contains("Item2"));
        assertFalse(stringList.contains("Item3"));
    }

    @Test
    public void testIndexOf() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item1");

        int index1 = stringList.indexOf("Item1");
        int index2 = stringList.indexOf("Item2");
        int index3 = stringList.indexOf("Item3");

        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(-1, index3);
    }

    @Test
    public void testLastIndexOf() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item1");

        int lastIndex1 = stringList.lastIndexOf("Item1");
        int lastIndex2 = stringList.lastIndexOf("Item2");
        int lastIndex3 = stringList.lastIndexOf("Item3");

        assertEquals(2, lastIndex1);
        assertEquals(1, lastIndex2);
        assertEquals(-1, lastIndex3);
    }

    @Test
    public void testGet() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        String item1 = stringList.get(0);
        String item2 = stringList.get(1);
        String item3 = stringList.get(2);

        assertEquals("Item1", item1);
        assertEquals("Item2", item2);
        assertEquals("Item3", item3);
    }

    @Test
    public void testEquals() {
        StringListImpl otherList = new StringListImpl();
        otherList.add("Item1");
        otherList.add("Item2");
        otherList.add("Item3");

        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        assertTrue(stringList.equals(otherList));
    }

    @Test
    public void testSize() {
        stringList.add("Item1");
        stringList.add("Item2");

        assertEquals(2, stringList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stringList.isEmpty());

        stringList.add("Item1");

        assertFalse(stringList.isEmpty());
    }

    @Test
    public void testClear() {
        stringList.add("Item1");
        stringList.add("Item2");

        stringList.clear();

        assertTrue(stringList.isEmpty());
    }

    @Test
    public void testToArray() {
        stringList.add("Item1");
        stringList.add("Item2");
        stringList.add("Item3");

        String[] array = stringList.toArray();

        assertArrayEquals(new String[]{"Item1", "Item2", "Item3"}, array);
    }
}