package structures;
@SuppressWarnings("unchecked")
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = item;
        size++;
    }

    public void addFirst(T item) {
        add(0, item);
    }

    public void addLast(T item) {
        add(item);
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        data[index] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (((T) data[j]).compareTo((T) data[j + 1]) > 0) {
                    Object tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            private int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                return (T) data[index++];
            }
        };
    }
}
