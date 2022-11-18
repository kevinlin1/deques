package deques;

import java.util.ArrayList;

/**
 * An {@link ArrayList} implementation of the {@link Deque} interface.
 *
 * @see Deque
 */
public class ArrayListDeque<T> implements Deque<T> {
    /**
     * The underlying list of elements stored in this deque.
     */
    private final ArrayList<T> list;

    /**
     * Constructs an empty deque.
     */
    public ArrayListDeque() {
        list = new ArrayList<>();
    }

    @Override
    public void addFirst(T item) {
        list.add(0, item);
    }

    @Override
    public void addLast(T item) {
        list.add(item);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T removeFirst() {
        return list.remove(0);
    }

    @Override
    public T removeLast() {
        return list.remove(size() - 1);
    }
}
