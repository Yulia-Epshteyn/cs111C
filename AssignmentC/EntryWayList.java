package Assignments.AssignmentC;

import Assignments.AssignmentB.EntryWayListInterface;
import Midterm.AList;

public class EntryWayList<T extends Comparable> implements EntryWayListInterface<T> {
    private AList<T> aList;
    private static final int MAX_CAPACITY = 10000;

    public EntryWayList() {
      aList = new AList<>();

    } // end default constructor

    @Override
    public boolean insertHead(T newEntry) {

        aList.add(1, newEntry);
        return true;
    }

    @Override
    public boolean insertTail(T newEntry) {

        aList.add(newEntry);
        return true;
    }

    @Override
    public T deleteHead() {
        return aList.remove(1);
    }

    @Override
    public T deleteTail() {
        return aList.remove(aList.getLength());
    }

    @Override
    public void display() {

        T[] result = aList.toArray();
        for (T item : result) {
            System.out.print(item + ", ");
        }
    }

    @Override
    public int contains(T anEntry) {

        return aList.getPosition(anEntry);
    }

    @Override
    public boolean isEmpty() {
        return aList.isEmpty();
    }

    @Override
    public boolean isFull() {

        return aList.getLength() == MAX_CAPACITY;
    }
}
