package org.example;

import org.example.exceptions.NullItemException;
import org.example.exceptions.StorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    private IntegerListImpl IntegerList;

    @BeforeEach
    public void setUp() {
        IntegerList = new IntegerListImpl();
    }

    @Test
    public void testAdd() {
        Integer item = 1;

        Integer result = IntegerList.add(item);

        assertEquals(item, result);
        assertEquals(1, IntegerList.size());
        assertTrue(IntegerList.contains(item));
    }

    @Test
    public void testAddWithNullItem() {
        Integer item = null;

        assertThrows(NullItemException.class, () -> {
            IntegerList.add(null);
        });
    }

    @Test
    public void testAddWithFullStorage() {
        IntegerListImpl IntegerList = new IntegerListImpl(1);
        IntegerList.add(1);

        assertThrows(StorageIsFullException.class, () -> {
            IntegerList.add(1);
        });
    }

    @Test
    public void testAddAtIndex() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        Integer item = 5;
        IntegerList.add(1, item);

        assertEquals(item, IntegerList.get(1));
        assertEquals(4, IntegerList.size());
    }

    @Test
    public void testSet() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        Integer item = 5;
        IntegerList.set(1, item);

        assertEquals(item, IntegerList.get(1));
    }

    @Test
    public void testRemoveByItem() {
        // Arrange
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        Integer removedItem = IntegerList.remove(2);

        assertFalse(IntegerList.contains(removedItem));
        assertEquals(2, IntegerList.size());
    }

    @Test
    public void testRemoveByIndex() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        Integer removedItem = IntegerList.remove(1);

        assertFalse(IntegerList.contains(removedItem));
        assertEquals(2, IntegerList.size());
    }

    @Test
    public void testContains() {
        IntegerList.add(1);
        IntegerList.add(2);

        assertTrue(IntegerList.contains(1));
        assertTrue(IntegerList.contains(2));
        assertFalse(IntegerList.contains(3));
    }

    @Test
    public void testIndexOf() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        int index1 = IntegerList.indexOf(1);
        int index2 = IntegerList.indexOf(2);
        int index3 = IntegerList.indexOf(3);

        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(-1, index3);
    }

    @Test
    public void testLastIndexOf() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        int lastIndex1 = IntegerList.lastIndexOf(1);
        int lastIndex2 = IntegerList.lastIndexOf(2);
        int lastIndex3 = IntegerList.lastIndexOf(3);

        assertEquals(2, lastIndex1);
        assertEquals(1, lastIndex2);
        assertEquals(-1, lastIndex3);
    }

    @Test
    public void testGet() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        Integer item1 = IntegerList.get(0);
        Integer item2 = IntegerList.get(1);
        Integer item3 = IntegerList.get(2);

        assertEquals(1, item1);
        assertEquals(2, item2);
        assertEquals(3, item3);
    }

    @Test
    public void testEquals() {
        IntegerListImpl otherList = new IntegerListImpl();
        otherList.add(1);
        otherList.add(2);
        otherList.add(3);

        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        assertTrue(IntegerList.equals(otherList));
    }

    @Test
    public void testSize() {
        IntegerList.add(1);
        IntegerList.add(2);

        assertEquals(2, IntegerList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(IntegerList.isEmpty());

        IntegerList.add(1);

        assertFalse(IntegerList.isEmpty());
    }

    @Test
    public void testClear() {
        IntegerList.add(1);
        IntegerList.add(2);

        IntegerList.clear();

        assertTrue(IntegerList.isEmpty());
    }

    @Test
    public void testToArray() {
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);

        Integer[] array = IntegerList.toArray();

        assertArrayEquals(new Integer[]{1, 2, 3}, array);
    }
}