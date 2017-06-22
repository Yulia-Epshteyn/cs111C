package Assignments.AssignmentF;

/**
 * Created by tigrj on 5/8/2017.
 */
public class SearchTester {
    public static void main(String[] args) {

        BinarySearchTreeWithDups<Integer> intTree = new BinarySearchTreeWithDups<Integer>();
        intTree.add(5);
        intTree.add(7);
        intTree.add(4);
        intTree.add(5);


        intTree.getAllEntriesIterative(7);



    }
}
