package deques;

/**
 * @see Deque
 */
public class LinkedDeque<T> implements Deque<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;

    public LinkedDeque() {
        size = 0;
        // TODO: Replace with your code
    }

    public void addFirst(T item) {
        size += 1;
        // TODO: Replace with your code
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void addLast(T item) {
        size += 1;
        // TODO: Replace with your code
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        // TODO: Replace with your code
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        // TODO: Replace with your code
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public T get(int index) {
        if ((index >= size) || (index < 0)) {
            return null;
        }
        // TODO: Replace with your code
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int size() {
        return size;
    }
}
