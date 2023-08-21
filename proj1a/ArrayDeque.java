public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;
    private final int initialLength = 8;
    // at list use 25%
    private final int scale = 4;
    public ArrayDeque() {
        items = (T[]) new Object[initialLength];
        size = 0;
        head = items.length / 2 - 1;
        tail = items.length / 2;
    }

    private int moveRight(int index) {
        index++;
        if (index >= items.length) {
            return 0;
        }
        return index;
    }

    private int moveLeft(int index) {
        index--;
        if (index < 0) {
            return items.length - 1;
        }
        return index;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = items.length / 2 - size / 2, j = head; i < items.length / 2 + size / 2 - 1; i++) {
            j = moveRight(j);
            a[i] = items[j];
        }
        head = items.length / 2 - size / 2 - 1;
        tail = items.length / 2 + size / 2;
        items = a;
    }

    public void addFirst(T item) {
        size++;
        if (size > items.length) {
            this.resize(items.length * 2);
        }
        items[head] = item;
        head = moveLeft(head);
    }

    public void addLast(T item) {
        size++;
        if (size > items.length) {
            this.resize(items.length * 2);
        }
        items[tail] = item;
        tail = moveRight(tail);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i = 0, j = head; i < size; i++) {
            System.out.print(items[head]);
            j = moveRight(j);
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        if (items.length > initialLength
                && size <= items.length / scale) {
            this.resize(items.length / 2);
        }
        head = moveRight(head);
        return items[head];
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        if (items.length > initialLength
                && size <= items.length / scale) {
            this.resize(items.length / 2);
        }
        tail = moveLeft(tail);
        return items[tail];
    }

    public T get(int index) {
        if (isEmpty() || index < 0 || index > size - 1) {
            return null;
        }
        int i = moveRight(head);
        for (int j = 0; j < index; j++) {
            i = moveRight(i);
        }
        return items[i];
    }
}
