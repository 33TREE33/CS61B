public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;
    final int length = 8;
    final int scale = 4;
    public ArrayDeque() {
        items = (T[]) new Object[length];
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
        for (int i = capacity / scale, j = head; i < capacity / scale + size; i++) {
            a[i] = items[j];
            j = moveRight(j);
        }
        head = capacity / scale - 1;
        tail = capacity / scale + size;
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
        if (items.length > length && size > items.length / 2 && size < items.length / scale) {
            this.resize(items.length / 2);
        }
        head = moveRight(head);
        T res = items[head];
        return res;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        if (items.length > length && size > items.length / 2 && size < items.length / scale) {
            this.resize(items.length / 2);
        }
        tail = moveLeft(tail);
        T res = items[tail];
        return res;
    }

    public T get(int index) {
        if (isEmpty() || index < 0 || index > size - 1) {
            return null;
        }
        int i = head + 1;
        for ( ; i < head + index; i++) {
            i = moveRight(i);
        }
        return items[i];
    }
}
