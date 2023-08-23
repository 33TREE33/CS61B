public class LinkedListDeque<Item> implements Deque<Item> {
    private class ListNode {
        private Item item;
        ListNode prev;
        ListNode next;

        public ListNode() {
            prev = null;
            next = null;
        }

        public ListNode(ListNode p, Item i, ListNode n) {
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

    @Override
    public void addFirst(Item item) {
        size++;
        ListNode temp = new ListNode(sentinel, item, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
    }

    @Override
    public void addLast(Item item) {
        size++;
        ListNode temp = new ListNode(sentinel.prev, item, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
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
        ListNode ptr = sentinel;
        for (int i = 0; i < size; ++i) {
            ptr = ptr.next;
            System.out.print(ptr.item);
        }
    }

    @Override
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        ListNode ptr = sentinel.next;
        Item res = ptr.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        ptr = null;
        return res;
    }

    @Override
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        ListNode ptr = sentinel.prev;
        Item res = ptr.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        ptr = null;
        return res;
    }

    @Override
    public Item get(int index) {
        if (isEmpty() || index < 0 || index > size - 1) {
            return null;
        }
        ListNode ptr = sentinel.next;
        for (int i = 0; i < index; ++i) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public Item getRecursive(int index) {
        if (isEmpty() || index < 0 || index > size - 1) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }

    private Item getRecursiveHelp(ListNode start, int index) {
        if (index == 0) {
            return start.item;
        }
        return getRecursiveHelp(start.next, index - 1);
    }

}

