package deques.numbers;

import deques.LinkedDeque;
import deques.Deque;

/**
 * Run timing experiments and output the results for {@link LinkedDeque}.
 *
 * @see LinkedDeque
 */
public class LinkedDequeExperiments extends Experiments {
    @Override
    protected <T> Deque<T> createDeque() {
        return new LinkedDeque<>();
    }

    public static void main(String[] args) {
        new LinkedDequeExperiments().run(System.out);
    }
}
