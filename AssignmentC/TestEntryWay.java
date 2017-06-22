package Assignments.AssignmentC;

public class TestEntryWay {
    public static void main(String[] args) {
        EntryWay list = new EntryWay();
        list.display();

        list.insertTail(3);
        list.insertTail(4);
        list.display();

        list.insertTail(5);
        list.insertHead(8);
        list.insertHead(1);
        list.display();

        list.deleteHead();
        list.display();

        list.deleteTail();
        list.display();

        System.out.println(list.contains(4));
        System.out.println(list.contains(10));

        list.deleteTail();
        list.deleteTail();
        list.deleteTail();

        list.deleteHead();

    }
}