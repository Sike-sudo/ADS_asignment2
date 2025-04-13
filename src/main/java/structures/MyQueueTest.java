package structures;

public class MyQueueTest {
    public static void main(String[] args) {
        structures.MyQueue<String> queue = new structures.MyQueue<>();
        queue.enqueue("apple");
        queue.enqueue("banana");
        queue.enqueue("cherry");

        System.out.println("First in queue: " + queue.peek());   // apple
        System.out.println("Dequeued: " + queue.dequeue());      // apple
        System.out.println("Next in queue: " + queue.peek());    // banana
        System.out.println("Queue size: " + queue.size());       // 2

        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }
    }
}
