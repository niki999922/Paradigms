package base;

/**
 * @author Niktia Kochetkov M3134
 */

public class ArrayQueueModule {
    private static int size, head;
    private static Object[] elements = new Object[10];

    //Post: last_peace - last index + 1
    private static int last_peace() {
        return (size + head) % elements.length;
    }

    private static Object[] newElements(int capacity) {
        Object[] newElements = new Object[capacity];
        if (head + size <= elements.length) {
            System.arraycopy(elements, head, newElements, 0, size);
        } else {
            System.arraycopy(elements, head, newElements, 0, size - last_peace());
            System.arraycopy(elements, 0, newElements, size - last_peace(), last_peace());
        }
        return newElements;
    }

    private static void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }
        elements = newElements(2 * capacity);
        head = 0;
    }

    // Pre: element != null
    // Post: size = size' + 1
    // && elements'[i] == elements[i] for i = 0..size'
    // && elements[size' + 1] = element
    public static void enqueue(Object element) {
        assert element != null : "element == null";
        ensureCapacity(size + 1);
        elements[last_peace()] = element;
        size++;
    }

    // Pre: size > 0
    // Post: size' == size
    // && elements'[i] == elements[i] for i = 0..size
    public static Object element() {
        assert elements.length > 0 : "length == 0";
        return elements[head];
    }

    // Pre: size > 0
    // Post: size' == size - 1
    // && elements'[i] == elements[i+1] for i = 0..size-1
    // && R = elements[0]
  /*  public static Object dequeue() {
        assert elements.length > 0 : "length == 0";
        Object tmp = elements[head];
        elements[head] = null; //memory leak
        head++;
        if (head == elements.length) head = 0;
        size--;
        return tmp;
    }*/

    // Pre: True
    // Post: R = size
    // && elements'[i] == elements[i] for i = 0..size-1
    public static int size() {
        return size;
    }

    // Pre: True
    // Post: size == size'
    // && elements'[i] == elements[i] for i = head..last_peace
    // && R = (size == 0)
    public static boolean isEmpty() {
        return size == 0;
    }

    // Pre: True
    // Post: size = 0
    public static void clear() {
        head = 0;
        size = 0;
        elements = new Object[10];
    }

    // Pre: True
    // Post: elements'[i] == elements[i] for i = 0..size-1
    // && R[i] == elements[i] for i = 0..size - 1
    public static Object[] toArray() {
        return newElements(size);
    }

}
