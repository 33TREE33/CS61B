public class LinkedListDeque<T> {
    private class ListNode {
        private T item;
        ListNode prev;
        ListNode next;

        public ListNode() {
            prev = null;
            next = null;
        }

        public ListNode(ListNode p, T i, ListNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private int size;
    private ListNode sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ListNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        size++;
        sentinel.next = new ListNode(sentinel, item, sentinel.next);
    }

    public void addLast(T item) {
        size++;
        sentinel.prev = new ListNode(sentinel.prev, item, sentinel);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode ptr = sentinel;
        for (int i = 0; i < size; ++i) {
            ptr = ptr.next;
            System.out.print(ptr.item);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        ListNode ptr = sentinel.next;
        sentinel.next = sentinel.next.next;
        return ptr.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        ListNode ptr = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        return ptr.item;
    }

    public T get(int index) {
        if (isEmpty() || index < 0 || index > size - 1) {
            return null;
        }
        ListNode ptr = sentinel;
        for (int i = 0; i < index; ++i) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public T getRecursive(int index) {
        if (isEmpty() || index < 0 || index > size - 1) {
            return null;
        }
        return getRecursiveHelp(sentinel, index);
    }

    public T getRecursiveHelp(ListNode start, int index) {
        if (index == 0) {
            return start.item;
        }
        return getRecursiveHelp(start.next, index - 1);
    }
}
