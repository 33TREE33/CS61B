public class ArrayDeque<Type> {
    private Type[] items;
    private int size;
    private int head;
    private int tail;

    public ArrayDeque() {
        items = (Type[]) new Object[8];
        size = 0;
        head = items.length/2-1;
        tail = items.length/2;
    }

    private int moveRight(int index) {
        index++;
        if(index>=items.length){
            return 0;
        }
        return index;
    }

    private int moveLeft(int index) {
        index--;
        if(index<0) {
            return items.length-1;
        }
        return index;
    }

    private void resize(int capacity) {
        Type[] a = (Type[]) new Object[capacity];
        for(int i = capacity/4 , j = head; i < capacity/4+size ; i++) {
            a[i] = items[j];
            j = moveRight(j);
        }
        head = capacity/4 -1;
        tail = capacity/4 + size;
        items = a;
    }

    public void addFirst(Type item) {
        size++;
        if(size> items.length) {
            this.resize(items.length * 2);
        }
        items[head] = item;
        head=moveLeft(head);
    }

    public void addLast(Type item) {
        size++;
        if(size> items.length) {
            this.resize(items.length * 2);
        }
        items[tail]=item;
        tail=moveRight(tail);
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }
    public void printDeque() {
        for(int i = 0 , j = head; i < size ; i++) {
            System.out.print(items[head]);
            j = moveRight(j);
        }
    }
    public Type removeFirst() {
        if(size == 0) {
            return null;
        }
        size--;
        if(items.length > 8 && size > items.length/2 && size < items.length / 4) {
            this.resize(items.length/2);
        }
        head = moveRight(head);
        Type res = items[head];
        return res;
    }

    public Type removeLast() {
        if(size == 0) {
            return null;
        }
        size--;
        if(items.length > 8 && size > items.length/2 && size < items.length / 4) {
            this.resize(items.length/2);
        }
        tail = moveLeft(tail);
        Type res = items[tail];
        return res;
    }

    public Type get(int index) {
        if(isEmpty()||index<0||index>size-1){
            return null;
        }
        int i = head+1;
        for( ; i < head+index ; i++ ) {
            i = moveRight(i);
        }
        return items[i];
    }
}
