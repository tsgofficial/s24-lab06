package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SortedIntList. Ensures all methods function correctly and
 * maintains sorted order.
 *
 * @author
 */
public class SortedIntListTest {

    private SortedIntList list1;
    private SortedIntList list2;

    @Before
    public void setUp() {
        list1 = new SortedIntList();
        list2 = new SortedIntList();
    }

    @Test
    public void testAdd() {
        list1.add(3);
        list1.add(1);
        list1.add(5);
        list1.add(2);
        list1.add(4);

        // Ensure list is sorted: [1, 2, 3, 4, 5]
        assertEquals(5, list1.size());
        assertEquals(1, list1.get(0));
        assertEquals(2, list1.get(1));
        assertEquals(3, list1.get(2));
        assertEquals(4, list1.get(3));
        assertEquals(5, list1.get(4));
    }

    @Test
    public void testAddDuplicates() {
        list1.add(2);
        list1.add(2);
        list1.add(2);
        assertEquals(3, list1.size());
        assertEquals(2, list1.get(0));
        assertEquals(2, list1.get(1));
        assertEquals(2, list1.get(2));
    }

    @Test
    public void testAddAll() {
        list1.add(1);
        list1.add(3);
        list1.add(5);

        list2.add(2);
        list2.add(4);
        list2.add(6);

        assertTrue(list1.addAll(list2));

        // Ensure merged list is sorted: [1, 2, 3, 4, 5, 6]
        assertEquals(6, list1.size());
        assertEquals(1, list1.get(0));
        assertEquals(2, list1.get(1));
        assertEquals(3, list1.get(2));
        assertEquals(4, list1.get(3));
        assertEquals(5, list1.get(4));
        assertEquals(6, list1.get(5));
    }

    @Test
    public void testGet() {
        list1.add(10);
        list1.add(5);
        list1.add(15);

        // Ensure elements are sorted
        assertEquals(5, list1.get(0));
        assertEquals(10, list1.get(1));
        assertEquals(15, list1.get(2));
    }

    @Test
    public void testRemove() {
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        assertTrue(list1.remove(3));
        assertEquals(4, list1.size());

        // Ensure remaining list is [1, 2, 4, 5]
        assertEquals(1, list1.get(0));
        assertEquals(2, list1.get(1));
        assertEquals(4, list1.get(2));
        assertEquals(5, list1.get(3));

        // Try removing an element that does not exist
        assertFalse(list1.remove(10));
        assertEquals(4, list1.size());
    }

    @Test
    public void testRemoveAll() {
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2.add(2);
        list2.add(4);

        assertTrue(list1.removeAll(list2));

        // Ensure remaining list is [1, 3, 5]
        assertEquals(3, list1.size());
        assertEquals(1, list1.get(0));
        assertEquals(3, list1.get(1));
        assertEquals(5, list1.get(2));

        // Try removing elements that do not exist
        list2.add(10);
        list2.add(20);
        assertFalse(list1.removeAll(list2));
        assertEquals(3, list1.size()); // No changes
    }
}
