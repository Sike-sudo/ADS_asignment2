package structures;
public class MyArrayListTest {
    public static void main(String[] args) {
        structures.MyArrayList<Integer> list = new structures.MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.addLast(40);
        list.set(2, 25);

        System.out.println("All values:");
        for (Integer val : list) {
            System.out.print(val + " ");
        }

        System.out.println("\nSize: " + list.size());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Index of 25: " + list.indexOf(25));
        System.out.println("Exists 100: " + list.exists(100));

        list.removeFirst();
        list.removeLast();
        list.sort();

        System.out.println("Sorted after removing first/last:");
        for (Integer val : list) {
            System.out.print(val + " ");
        }
    }
}
