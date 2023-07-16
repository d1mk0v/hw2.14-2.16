package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private StringListImpl stringList;

    @BeforeEach
    public void setup() {
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
}