package queue;

/**
 * @author Nikita Kochetkov M3134
 */

// inv: size >= 0
// && el[i] != null for i = 0..size-1
public interface Queue {
    //immutable = { elements[i] == elements'[i] for i = head .. tail && head == head' && tail == tail' && size == size'}
    //immutable(l, r) = { elements[i] == elements[i] for i = l .. r}

    // Pre: element != null
    // Post: size = size' + 1
    // && elements'[i] == elements[i] for i = 0..size'
    // && elements[size' + 1] = element
    void enqueue(Object element);

    // Pre: size > 0
    // Post: R = elements[head]
    // && immutable
    Object element();

    // Pre: size > 0
    // Post: size' == size - 1
    // && elements'[i] == elements[i+1] for i = 0..size-1
    // && R = elements[head]
    // && if (size > 1) ? head != null : head = null
    Object dequeue();

    // Pre: True
    // Post: R = size
    // && elements'[i] == elements[i] for i = 0..size-1
    int size();

    // Pre: True
    // Post: immutable
    // && R = (size == 0)
    boolean isEmpty();

    // Pre: True
    // Post: size = 0
    // && if (head instance of LinkedQueue)? head = tail = null : head = 0
    void clear();

    // Pre: True
    // Post: elements'[i] == elements[i] for i = 0..size-1
    // && immutable
    // && R[i] == elements[i] for i = 0..size - 1
    // && R[i] != elements
    Object[] toArray();
}
