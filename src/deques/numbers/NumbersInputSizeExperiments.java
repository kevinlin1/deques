package deques.numbers;

import deques.ArrayDeque;
import deques.Deque;
import deques.LinkedDeque;

import java.io.PrintStream;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Run timing experiments and output the results.
 */
public class NumbersInputSizeExperiments {
    /**
     * Number of trials per implementation run. Making this smaller means experiments run faster.
     */
    public static final int NUM_TRIALS = 1000;
    /**
     * Maximum number of elements to add.
     */
    public static final int MAX_SIZE = 20000;
    /**
     * Step size increment. Making this smaller means experiments run slower.
     */
    public static final int STEP = 100;

    public static void main(String[] args) {
        Map<String, Supplier<Deque<Integer>>> implementations = Map.of(
                "ArrayDeque", ArrayDeque::new,
                // "ArrayListDeque", ArrayListDeque::new,
                "LinkedDeque", LinkedDeque::new
        );
        for (String name : implementations.keySet()) {
            System.out.println(name);
            run(implementations.get(name), System.out);
        }
    }

    private static void run(Supplier<Deque<Integer>> implementation, PrintStream out) {
        out.println("size,add,get");
        for (int size = STEP; size <= MAX_SIZE; size += STEP) {
            out.print(size);
            out.print(',');

            // Record the total runtimes accumulated across all trials
            double totalAddTime = 0.0;
            double totalGetTime = 0.0;

            for (int i = 0; i < NUM_TRIALS; i += 1) {
                Deque<Integer> deque = implementation.get();

                // Measure the time to add integers
                long addStart = System.nanoTime();
                for (int j = 0; j < size; j += 1) {
                    deque.addLast(j);
                }
                long addTime = System.nanoTime() - addStart;
                // Convert from nanoseconds to seconds and add to total time
                totalAddTime += (double) addTime / 1_000_000_000;

                // Measure the time to get the item at the given index
                long getStart = System.nanoTime();
                deque.get(0);
                long getTime = System.nanoTime() - getStart;
                totalGetTime += (double) getTime / 1_000_000_000;
            }

            // Output the averages to 10 decimal places.
            out.printf("%.10f", totalAddTime / NUM_TRIALS);
            out.print(',');
            out.printf("%.10f", totalGetTime / NUM_TRIALS);
            out.println();
        }
    }
}
