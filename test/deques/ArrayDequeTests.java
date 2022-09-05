package deques;

public class ArrayDequeTests extends DequeTests {
    @Override
    protected <T> Deque<T> createDeque() {
        return new ArrayDeque<>();
    }

    // You may write additional tests here if you only want them to run for ArrayDeque
}
