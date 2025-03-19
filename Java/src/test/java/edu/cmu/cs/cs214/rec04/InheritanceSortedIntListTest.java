package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class InheritanceSortedIntListTest {

    private InheritanceSortedIntList list1;
    private InheritanceSortedIntList list2;

    @Before
    public void setUp() {
        list1 = new InheritanceSortedIntList();
        list2 = new InheritanceSortedIntList();
    }

    @Test
    public void testAdd() {
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        assertTrue(list1.getTotalAdded() == 5);
        printList(list1);
    }

    @Test
    public void testAddAll() {
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        assertTrue(list1.getTotalAdded() == 5);

        list2.add(3);
        list2.add(0);
        assertTrue(list2.getTotalAdded() == 2);

        list2.addAll(list1);
        assertTrue(list2.getTotalAdded() == 7);
        printList(list2);
    }

    @Test
    public void testRemoveAll() {
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        assertTrue(list1.getTotalAdded() == 5);

        list2.add(3);
        list2.add(0);
        assertTrue(list2.getTotalAdded() == 2);

        // Adding list1 to list2
        list2.addAll(list1);
        assertTrue(list2.getTotalAdded() == 7);

        // Remove all elements from list2
        list2.removeAll(list1);
        assertTrue(list2.getTotalAdded() == 2);
        printList(list2);
    }

    @Test
    public void testRemove() {
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        assertTrue(list1.getTotalAdded() == 5);

        // Removing an element from list1
        list1.remove(2);
        assertTrue(list1.getTotalAdded() == 4);
        printList(list1);

        // Removing an element not in the list
        list1.remove(10);
        assertTrue(list1.getTotalAdded() == 4); // should remain the same
        printList(list1);
    }

    private void printList(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }
}
