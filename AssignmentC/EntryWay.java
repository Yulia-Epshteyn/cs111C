package Assignments.AssignmentC;

import Assignments.AssignmentB.EntryWayListInterface;

public class EntryWay<T> implements EntryWayListInterface<T> {

    private Node firstNode; // Reference to first node
    private int numberOfEntries;

    public EntryWay() {
        firstNode = null;
        numberOfEntries = 0;
    } // end default constructor

     @Override
    public boolean insertTail(T newEntry) {
        Node newNode = new Node(newEntry);
        if (numberOfEntries == 0) {
            firstNode = newNode;
        } else {
            Node tail = findTail();
            tail.next = newNode;
        }
        numberOfEntries++;
        return true;
    }


    private Node findTail() {
        Node currentNode = firstNode;
        while (currentNode.next != null) {
            currentNode = currentNode.next;

        }
        return currentNode;
    }


    @Override
    public boolean insertHead(T newEntry) {

        Node newNode = new Node(newEntry);
        if (numberOfEntries > 0) {
            newNode.next = firstNode;
        }
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }


    @Override
    public T deleteHead() {

        Node head = null;
        if (numberOfEntries == 0) {
            return null;

        } else if (numberOfEntries == 1) {
            head = firstNode;
            firstNode = null;

        } else {
            Node currentNode = firstNode;
            while (currentNode.next.next != null) {
                currentNode = currentNode.next;
            }
            Node beforeHead = currentNode;
            head = currentNode.next;
            beforeHead.next = null;
        }

        numberOfEntries--;
        return head.data;
    }

    @Override
    public T deleteTail() {
        if (numberOfEntries > 0) {
            Node currentNode = firstNode;
            firstNode = currentNode.next;
            numberOfEntries--;
            return currentNode.data;
        } else {
            return null;
        }
    }


    @Override
    public void display() {
        if (numberOfEntries == 0) {
            System.out.println("Your collection is empty");
        }
        Node currentNode = firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + ((currentNode.next == null) ? "" : " -> "));
            currentNode = currentNode.next;
        }
        System.out.println("");
    }

      @Override
    public int contains(Object anEntry) {
        int count = 0;
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.data.equals(anEntry)) {
                return count;
            } else {
                currentNode = currentNode.next;
                count++;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node
}
