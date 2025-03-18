package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.Collections;

/**
 * SortedIntList -- a list of integers that maintains elements in sorted order.
 *
 * This class extends AbstractIntList and ensures elements are always stored in
 * ascending order.
 *
 * @author Nora Shoemaker
 */
public class SortedIntList extends AbstractIntList {

    private final ArrayList<Integer> list;

    public SortedIntList() {
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(int num) {
        int index = Collections.binarySearch(list, num);
        if (index < 0) {
            index = -(index + 1); // Convert to insertion point
        }
        list.add(index, num);
        return true;
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            changed |= add(list.get(i));
        }
        return changed;
    }

    @Override
    public int get(int index) {
        return list.get(index);
    }

    @Override
    public boolean remove(int num) {
        return list.remove((Integer) num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            changed |= remove(list.get(i));
        }
        return changed;
    }

    @Override
    public int size() {
        return list.size();
    }
}
