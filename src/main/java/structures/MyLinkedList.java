package structures;
/*
 MyLinkedList implements a doubly linked list structure.
 */
public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;
        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;
    /*Initializes an empty linked list */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            MyNode current = head;
            for (int i = 0; i < index; i++) current = current.next;
            MyNode newNode = new MyNode(item);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IllegalStateException();
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IllegalStateException();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        MyNode toRemove = getNode(index);
        if (toRemove.prev != null) toRemove.prev.next = toRemove.next;
        else head = toRemove.next;
        if (toRemove.next != null) toRemove.next.prev = toRemove.prev;
        else tail = toRemove.prev;
        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new IllegalStateException();
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new IllegalStateException();
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
    }

    @Override
    public void sort() {
        if (size <= 1) return;
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                if (i.data.compareTo(j.data) > 0) {
                    T temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        int i = 0;
        for (MyNode cur = head; cur != null; cur = cur.next, i++) {
            if (cur.data.equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int i = size - 1;
        for (MyNode cur = tail; cur != null; cur = cur.prev, i--) {
            if (cur.data.equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (MyNode cur = head; cur != null; cur = cur.next, i++) {
            array[i] = cur.data;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            private MyNode current = head;
            public boolean hasNext() { return current != null; }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}