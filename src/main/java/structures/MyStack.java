package structures;
/*
 MyStack implements a simple stack (LIFO) using MyArrayList.
 */
public class MyStack<T extends Comparable<T>> {
    private final structures.MyArrayList<T> list = new structures.MyArrayList<>();

    /*
     Pushes an item onto the stack.
     */
    public void push(T item) {
        list.addLast(item);
    }

    /*
     Pops the top item off the stack.
     */
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    /*
     Peeks at the top of the stack.
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    /*
     Checks if the stack is empty.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }
    /*
     Returns the number of elements in the stack.
     */
    public int size() {
        return list.size();
    }
}
