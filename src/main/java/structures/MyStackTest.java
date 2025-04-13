package structures;
public class MyStackTest {
    public static void main(String[] args) {
        structures.MyStack<Integer> stack = new structures.MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top of stack: " + stack.peek()); // 30
        System.out.println("Popped: " + stack.pop());        // 30
        System.out.println("New top: " + stack.peek());      // 20
        System.out.println("Stack size: " + stack.size());   // 2

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }
    }
}
