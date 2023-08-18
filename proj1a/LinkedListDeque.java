public class LinkedListDeque<Type> {
    private class ListNode {
        public Type item;
        ListNode prev;
        ListNode next;

        public ListNode() {
            prev = null;
            next = null;
        }

        public ListNode(ListNode p,Type i,ListNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private int size;
    private ListNode sentinel;

    public LinkedListDeque() {
        size = 0 ;
        sentinel = new ListNode();
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
    }

    public void addFirst(Type item) {
        size++;
        sentinel.next = new ListNode(sentinel,item,sentinel.next);
    }

    public void addLast(Type item) {
        size++;
        sentinel.prev = new ListNode(sentinel.prev,item,sentinel);
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode ptr = sentinel;
        for(int i = 0 ; i <size ; ++i) {
            ptr = ptr.next;
            System.out.print(ptr.item);
        }
    }

    public Type removeFirst() {
        if(size==0) {
            return null;
        }
        size--;
        ListNode ptr = sentinel.next;
        sentinel.next = sentinel.next.next;
        ptr.prev=null;
        ptr.next=null;
        return ptr.item;
    }

    public Type removeLast() {
        if(size==0) {
            return null;
        }
        size--;
        ListNode ptr = sentinel.prev;
        sentinel.prev=sentinel.prev.prev;
        ptr.prev=null;
        ptr.next=null;
        return ptr.item;
    }

    public Type get(int index) {
        if(isEmpty()||index<0||index>size-1) {
            return null;
        }
        ListNode ptr = sentinel;
        for (int i = 0 ; i < index ; ++i) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    public Type getRecursive(int index) {
        if(isEmpty()||index<0||index>size-1) {
            return null;
        }
        return getRecursiveHelp(sentinel,index);
    }

    public Type getRecursiveHelp(ListNode start,int index) {
        if(index==0) {
            return start.item;
        }
        return getRecursiveHelp(start.next,index-1);
    }
}
