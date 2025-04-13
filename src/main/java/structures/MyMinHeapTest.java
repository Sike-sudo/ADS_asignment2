package structures;
public class MyMinHeapTest {
    public static void main(String[] args) {
        structures.MyMinHeap<Integer> heap = new structures.MyMinHeap<>();
        heap.insert(50);
        heap.insert(20);
        heap.insert(40);
        heap.insert(10);
        heap.insert(30);

        System.out.println("Min element: " + heap.peek());   // 10

        while (!heap.isEmpty()) {
            System.out.println("Extract Min: " + heap.extractMin());
        }
    }
}
