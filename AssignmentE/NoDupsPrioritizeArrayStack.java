package Assignments.AssignmentE;

public class NoDupsPrioritizeArrayStack<T> extends ArrayStack<T> implements NoDupsPrioritizeStackInterface<T> {

//	private ArrayStack<T> noDupsStack;

    public NoDupsPrioritizeArrayStack() {
        super();
    }

    public NoDupsPrioritizeArrayStack(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void push(T newEntry) {

        if (topIndex + 1 >= stack.length) // if array is full,
            doubleArray(); // expand array

        if (indexOf(newEntry) < 0) {
            topIndex++;
            stack[topIndex] = newEntry;
        }
    }

    private int indexOf(T entry) {
        int position = -1;

        for (int i = 0; i <= topIndex; i++) {
            if (stack[i].equals(entry)) {
                position = i;
                break;
            }
        }
        return position;
    }

    public void moveToTop(T entry) {
        int foundPosition = indexOf(entry);
        System.out.println("index is " + foundPosition);
        if (foundPosition < 0) {
            this.push(entry);
        } else {
            T tmp = this.stack[foundPosition];
            System.out.println(tmp);
            for (int i = foundPosition; i< topIndex; i++){
                stack[i]=stack[i+1];
            }
           stack[topIndex] = tmp;
        }
    }

    public void display() {
        for (int i = topIndex; i >= 0; i--) {
            System.out.print(this.stack[i] + ", ");
        }
    }
}