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

    private String checkInvariants() {
        if (front == null) {
            return "Unexpected reference: front should reference a sentinel node but was <null>";
        } else if (front.prev != null) {
            return "Unexpected reference: front.prev should be <null> but was <" + front.prev + ">";
        } else if (back == null) {
            return "Unexpected reference: back should reference a sentinel node but was <null>";
        } else if (back.next != null) {
            return "Unexpected reference: back.next should be <null> but was <" + back.next + ">";
        }
        String message = checkNode(front, -1);
        if (message != null) {
            return message;
        }
        int i = 0;
        for (Node<T> curr = front.next; curr != back; curr = curr.next) {
            message = checkNode(curr, i);
            if (message != null) {
                return message;
            }
            i += 1;
        }
        return null;
    }

    private String checkNode(Node<T> node, int i) {
        if (node.next == null) {
            return "Unexpected null reference in node at index " + i + ": <" + node + ">";
        } else if (node.next.prev == node) {
            return null;
        } else if (node.next.prev == null) {
            return "Unexpected null reference in node at index " + (i + 1) + ": <" + node.next + ">";
        } else {
            return "Mismatched references:\n"
                    + "node at index " + i + ": <" + node + ">\n"
                    + "node at index " + (i + 1) + ": <" + node.next + ">";
        }
    }

    private static class Node<T> {
        public final T value;
        public Node<T> prev;
        public Node<T> next;

        public Node(T value) {
            this(value, null, null);
        }

        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }
}
