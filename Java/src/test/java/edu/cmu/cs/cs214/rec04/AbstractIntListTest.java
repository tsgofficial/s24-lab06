package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the AbstractIntList functionality via SortedIntList implementation.
 */
public class AbstractIntListTest {

    private AbstractIntList list1;
    private AbstractIntList list2;

    @Before
    public void setUp() {
        list1 = new SortedIntList();
        list2 = new SortedIntList();
    }

    @Test
    public void testAddAll() {
        list1.add(2);
        list1.add(4);
        list1.add(6);

        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);

        assertTrue(list1.addAll(list2));

        // Ensure merged list is sorted: [1, 2, 3, 4, 5, 6, 7]
        assertEquals(7, list1.size());
        assertEquals(1, list1.get(0));
        assertEquals(2, list1.get(1));
        assertEquals(3, list1.get(2));
        assertEquals(4, list1.get(3));
        assertEquals(5, list1.get(4));
        assertEquals(6, list1.get(5));
        assertEquals(7, list1.get(6));
    }
}
