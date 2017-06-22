package Assignments.AssignmentA;

/**
 * Created by tigrj on 1/26/2017.
 */
public class TestTrio {
    public static void main(String[] args) {

        Trio<Integer> theNumbers = new Trio<>(1,1,3);
        Trio<Integer> theNum3 = new Trio<>(1,3,3);

        System.out.println(theNum3.equals(theNumbers));
        System.out.println(theNumbers);

        System.out.println(theNumbers.contains(1));

        System.out.println(theNumbers.sameItems());

        theNumbers.setItem1(4);
        theNumbers.setItem3(4);
        theNumbers.setItem2(4);
        System.out.println(theNumbers);

        System.out.println(theNumbers.sameItems());

        Trio<Integer> theNum2 = new Trio<>(4,4,4);
        System.out.println(theNum2);

        System.out.println(theNum2.equals(theNumbers));


        Trio<String> words = new Trio<String>("apple", "banana", "banana");
        System.out.println(words.sameItems());

        System.out.println(theNumbers.equals(words));









    }


    }




