package Assignments.AssignmentE;

public class NoDupsDePrioritizeArrayQueue<T> extends ArrayQueue<T>
        implements NoDupsDePrioritizeQueueInterface<T> {


    public NoDupsDePrioritizeArrayQueue() {
        super();
    }

    public NoDupsDePrioritizeArrayQueue(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void enqueue(T newEntry) {
        if (isArrayFull())
            doubleArray();
        if (this.indexOf(newEntry) < 0) {
            backIndex = (backIndex + 1) % queue.length;
            queue[backIndex] = newEntry;
        }
    }

    private int indexOf(T entry) {
        int index = -1;
        if (isEmpty()) {
            return index;
        } else {
            int currentIndex = frontIndex;
            while (currentIndex != backIndex) {
                if (queue[currentIndex].equals(entry)) {
                    return currentIndex;
                }
                currentIndex = (currentIndex + 1) % queue.length;
            }
            if (queue[backIndex].equals(entry)) {
                return backIndex;
            }
        }
        return index;
    }

    public void moveToBack(T entry) {
        int index = indexOf(entry);
        if (index< 0){
            enqueue(entry);
        }
        else {
            int length = queue.length;
            T tmp = queue[index];
            while (index != backIndex) {
                queue[index] = queue[(index + 1) % length];
                index = (index + 1) % length;
            }
            queue[backIndex] = tmp;
        }
    }

    public void display() {
        for (int i = frontIndex; i != (backIndex + 1) % queue.length; i = (i + 1) % queue.length) {
            System.out.print(queue[i] + ", ");
        }
    }

}