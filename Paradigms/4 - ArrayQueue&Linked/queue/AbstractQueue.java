package queue;

/**
 * @author Nikita Kochetkov M3134
 */

public abstract class AbstractQueue implements Queue {
    protected int size;

    public void enqueue(Object element) {
        assert element != null : "element == null";
        enqueueFull(element);
        ++size;
    }

    public Object element() {
        assert size > 0 : "size == 0";
        return getElements();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object dequeue() {
        assert size > 0 : "size == 0";
        Object el = dequeueFull();
        --size;
        return el;
    }

    public void clear() {
        size = 0;
        clearFull();
    }

    public Object[] toArray() {
        return newElements(size);
    }

    protected abstract Object[] newElements(int capacity);

    protected abstract void clearFull();

    protected abstract Object dequeueFull();

    protected abstract Object getElements();

    protected abstract void enqueueFull(Object element);
}
