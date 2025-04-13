package structures;
/*
 MyMinHeap implements a minimum heap using MyArrayList.
 */
public class MyMinHeap<T extends Comparable<T>> {
    private final structures.MyArrayList<T> heap = new structures.MyArrayList<>();
    /*
     Inserts a value into the heap.
     */
    public void insert(T item) {
        heap.addLast(item);
        heapifyUp(heap.size() - 1);
    }
    /*
     Extracts and returns the minimum value.
     */
    public T extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.removeLast();
        heapifyDown(0);
        return min;
    }
    /*
     Returns the minimum value without removing it.
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }
    /*
     Checks if the heap is empty.
     */
    public boolean isEmpty() {
        return heap.size() == 0;
    }
    /*
     Returns the number of elements in the heap.
     */
    public int size() {
        return heap.size();
    }
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                T temp = heap.get(index);
                heap.set(index, heap.get(parent));
                heap.set(parent, temp);
                index = parent;
            } else break;
        }
    }
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                T temp = heap.get(index);
                heap.set(index, heap.get(smallest));
                heap.set(smallest, temp);
                index = smallest;
            } else break;
        }
    }
}