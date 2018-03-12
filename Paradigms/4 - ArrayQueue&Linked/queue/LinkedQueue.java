package queue;

/**
 * @author Nikita Kochetkov M3134
 */

public class LinkedQueue extends AbstractQueue {
    private Node head, tail;

    public LinkedQueue() {
        size = 0;
        head = tail = null;
    }

    //inv: value != null
    public class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            assert value != null : "value == null";
            this.value = value;
            this.next = null;
        }
    }

    // Pre: element != null && Queue != null
    // Post: size = size' + 1
    // && elements'[i] == elements[i] for i = 0..size'
    // && elements[size' + 1] = element
    public void enqueueFull(Object element) {
        if (tail == null) {
            head = tail = new Node(element);
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
    }

    // Pre: size > 0
    // Post: size' == size
    // && elements'[i] == elements[i] for i = 0..size
    public Object getElements() {
        return head.value;
    }

    // Pre: size > 0
    // Post: size' == size - 1
    // && elements'[i] == elements[i+1] for i = 0..size-1
    // && R = elements[head]
    // && if (size > 1) ? head != null : head = null
    public Object dequeueFull() {
        Object tmp = head.value;
        head = head.next;
        if (size - 1 == 0) tail = null;
        return tmp;
    }

    // Post: size = 0
    // && if (head instance of LinkedQueue)? head = tail = null : head = 0
    protected void clearFull() {
        head = tail = null;
    }

    protected Object[] newElements(int capacity) {
        Node pos = head;
        Object[] mas = new Object[capacity];
        int i = 0;
        while (pos != null) {
            mas[i++] = pos.value;
            pos = pos.next;
        }
        return mas;
    }
}
