package deques.numbers;

import deques.ArrayDeque;
import deques.Deque;

/**
 * Run timing experiments and output the results for {@link ArrayDeque}.
 *
 * @see ArrayDeque
 */
public class ArrayDequeExperiments extends Experiments {
    @Override
    public <T> Deque<T> createDeque() {
        return new ArrayDeque<>();
    }

    public static void main(String[] args) {
        new ArrayDequeExperiments().run(System.out);
    }
}
