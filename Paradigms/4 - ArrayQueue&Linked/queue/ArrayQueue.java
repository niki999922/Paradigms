package queue;

/**
 * @author Niktia Kochetkov M3134
 */

public class ArrayQueue extends AbstractQueue {
    private int head;
    private Object[] elements = new Object[10];

    // Pre : True
    // Post : last_peace - last index + 1
    private int last_peace() {
        return (size + head) % elements.length;
    }

    protected Object[] newElements(int capacity) {
        Object[] newElements = new Object[capacity];
        if (head + size <= elements.length) {
            System.arraycopy(elements, head, newElements, 0, size);
        } else {
            System.arraycopy(elements, head, newElements, 0, size - last_peace());
            System.arraycopy(elements, 0, newElements, size - last_peace(), last_peace());
        }
        return newElements;
    }

    private void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }
        elements = newElements(2 * capacity);
        head = 0;
    }

    // Pre: element != null && Queue != null
    // Post: size = size' + 1
    // && elements'[i] == elements[i] for i = 0..size'
    // && elements[size' + 1] = element
    public void enqueueFull(Object element) {
        ensureCapacity(size + 1);
        elements[last_peace()] = element;
    }

    // Pre: size > 0
    // Post: size' == size
    // && elements'[i] == elements[i] for i = 0..size
    public Object getElements() {
        return elements[head];
    }

    // Pre: size > 0
    // Post: size' == size - 1
    // && elements'[i] == elements[i+1] for i = 0..size-1
    // && R = elements[head]
    // && if (size > 1) ? head != null : head = null
    public Object dequeueFull() {
        Object tmp = elements[head];
        elements[head] = null;
        ++head;
        if (head == elements.length) head = 0;
        return tmp;
    }

    // Post: size = 0
    // && if (head instance of LinkedQueue)? head = tail = null : head = 0
    protected void clearFull() {
        size = 0;
        elements = new Object[10];
    }
}
