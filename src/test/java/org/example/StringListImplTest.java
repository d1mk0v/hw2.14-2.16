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
        // Arrange
        String item = "Test";

        // Act
        String result = stringList.add(item);

        // Assert
        assertEquals(item, result);
        assertEquals(1, stringList.size());
        assertTrue(stringList.contains(item));
    }

    @Test
    public void testAddWithNullItem() {
        // Arrange
        String item = null;

        // Assert
        assertThrows(NullItemException.class, () -> {
            // Act
            stringList.add(item);
        });
    }

    @Test
    public void testAddWithFullStorage() {
        // Arrange
        StringListImpl stringList = new StringListImpl(1);
        stringList.add("Item1");

        // Assert
        assertThrows(StorageIsFullException.class, () -> {
            // Act
            stringList.add("Item2");
        });
    }
}