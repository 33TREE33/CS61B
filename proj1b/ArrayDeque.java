public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] items;
    private int size;
    private int head;
    private int tail;
    private final int initialLength = 8;
    // at list use 25%
    private final int scale = 4;
    public ArrayDeque() {
        items = (Item[]) new Object[initialLength];
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
        Item[] a = (Item[]) new Object[capacity];
        for (int i = items.length / 2 - size / 2,
             j = head; i < items.length / 2 + size / 2 - 1;
             i++) {
            j = moveRight(j);
            a[i] = items[j];
        }
        head = items.length / 2 - size / 2 - 1;
        tail = items.length / 2 + size / 2;
        items = a;
    }

    @Override
    public void addFirst(Item item) {
        size++;
        if (size > items.length) {
            this.resize(items.length * 2);
        }
        items[head] = item;
        head = moveLeft(head);
    }

    @Override
    public void addLast(Item item) {
        size++;
        if (size > items.length) {
            this.resize(items.length * 2);
        }
        items[tail] = item;
        tail = moveRight(tail);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (int i = 0, j = head; i < size; i++) {
            System.out.print(items[head]);
            j = moveRight(j);
        }
    }
    @Override
    public Item removeFirst() {
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

    @Override
    public Item removeLast() {
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

    @Override
    public Item get(int index) {
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
