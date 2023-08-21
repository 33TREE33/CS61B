public class ArrayDeque<T> {
    private T[] items;
    private int head;
    private int tail;
    private int size;
    //at least use 25% of the array
    private final int scale = 4;
    //initial length should be set to 8
    private final int initialLength = 8;

    public ArrayDeque() {
        items = (T[]) new Object[initialLength];
        head = initialLength / 2 - 1;
        tail = initialLength / 2;
        size = 0;
    }

    private int moveRight(int index) {
        index++;
        if (index == items.length) {
            index = 0;
        }
        return index;
    }

    private int moveLeft(int index) {
        index--;
        if (index < 0) {
            index = items.length - 1;
        }
        return index;
    }

    private void resize(int newLength) {
        int index = head;
        int begin = newLength / 2 - size / 2;
        T[] newArr = (T[]) new Object[newLength];
        for (int i = 0; i < size; i++) {
            index = moveRight(index);
            newArr[begin] = items[index];
            begin++;
        }
        items = newArr;
        head = newLength / 2 - size / 2 - 1;
        tail = newLength / 2 + size / 2;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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

    public T removeFirst() {
        if (isEmpty()) {
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
        if (isEmpty()) {
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

    public void printDeque() {
        int index = head;
        for (int i = 0; i < size; i++) {
            index = moveRight(index);
            System.out.print(items[index]);
        }
    }

    public T get(int index) {
        if (isEmpty() || index < 0 || index > size - 1) {
            return null;
        }
        int begin = moveRight(head);
        for (int i = 0; i < index; i++) {
            begin = moveRight(head);
        }
        return items[begin];
    }
}
