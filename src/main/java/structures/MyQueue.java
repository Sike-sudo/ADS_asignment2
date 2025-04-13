package structures;
/*
 MyQueue implements a simple FIFO queue using MyLinkedList.
 */
public class MyQueue<T extends Comparable<T>> {
    private final structures.MyLinkedList<T> list = new structures.MyLinkedList<>();
    /*
     Enqueues an item at the rear.
     */
    public void enqueue(T item) {
        list.addLast(item);
    }

    /*
     Dequeues the front item.
     */
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
    /*
     Returns the front element without removing it.
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }
    /*
     Checks if the queue is empty.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }
    /*
     Returns the number of elements in the queue.
     */
    public int size() {
        return list.size();
    }
}