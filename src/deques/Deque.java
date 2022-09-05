package deques;

/**
 * A double-ended queue that allows addition, removal, and access to elements at either the front or
 * the back of the collection. The front of the deque contains the first element (aka "head") while
 * the back of the deque contains the last element (aka "tail"). Does not allow null elements, but
 * doesn't check for null elements.
 */
public interface Deque<T> {
    /**
     * Adds the given item to the front of this deque.
     */
    void addFirst(T x);

    /**
     * Adds the given item to the back of this deque.
     */
    void addLast(T x);

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    T get(int index);

    /**
     * Returns true if deque is empty, false otherwise.
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    int size();

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     */
    T removeFirst();

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
    T removeLast();
}
