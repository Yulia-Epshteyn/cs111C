package Assignments.AssignmentA;

import java.util.Iterator;

public class Trio<T extends Comparable<? super T>> implements Comparable<Trio<T>> {
    private T item1;
    private T item2;
    private T item3;

    public Trio(T item1, T item2, T item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public T getItem2() {
        return item2;
    }

    public void setItem2(T item2) {
        this.item2 = item2;
    }

    public T getItem3() {
        return item3;
    }

    public void setItem3(T item3) {
        this.item3 = item3;
    }

    private class TrioIterator implements Iterator<T> {
        private int pointer = 0;

        @Override
        public boolean hasNext() {
            return pointer < 3;
        }

        public T next() {
            switch (pointer) {
                case 0:
                    pointer++;
                    return Trio.this.getItem1();
                case 1:
                    pointer++;
                    return Trio.this.getItem2();
                case 2:
                    pointer++;
                    return Trio.this.getItem3();
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public boolean contains(T element) {
        return item1.equals(element) || item2.equals(element) || item3.equals(element);
    }

    public String toString() {
        return "(" + item1.toString() + ", " + item2.toString() + ", " + item3.toString() + ")";
    }

    public boolean sameItems() {
        return item1.equals(item2) && item2.equals(item3);
    }

    @Override
    public boolean equals(Object other) {
        boolean[] sameItems = {false, false, false};
        if (other instanceof Trio<?>) {
            Trio<?> otherTrio = (Trio<?>) other;
            Iterator<T> it = new TrioIterator();
            while (it.hasNext()) {
                T element = it.next();
                if (element.equals(otherTrio.getItem1()) && !sameItems[0]) {
                    sameItems[0] = true;
                } else if (element.equals(otherTrio.getItem2()) && !sameItems[1]) {
                    sameItems[1] = true;
                } else if (element.equals(otherTrio.getItem3()) && !sameItems[2]) {
                    sameItems[2] = true;
                } else {
                    break;
                }
            }
        }
        return sameItems[0] && sameItems[1] && sameItems[2];
    }

    @Override
    public int compareTo(Trio<T> otherTrio) {
        return this.theSmallestItem().compareTo(otherTrio.theSmallestItem());
    }

    private T theSmallestItem() {
        T theSmallestItem = this.item1;
        Iterator<T> it = new TrioIterator();
        while (it.hasNext()) {
            T element = it.next();
            if ((element.compareTo(theSmallestItem)) < 0) {
                theSmallestItem = element;
            }
        }
        return theSmallestItem;
    }
}



