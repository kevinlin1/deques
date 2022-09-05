package deques.numbers;

import deques.ArrayDeque;
import deques.Deque;
import deques.LinkedDeque;

import java.io.PrintStream;
import java.util.Map;
import java.util.function.Supplier;

public class NumbersInputSizeExperiments {
    public static final int NUM_TRIALS = 1000;
    public static final int MAX_SIZE = 20000;
    public static final int STEP = 100;

    public static void main(String[] args) {
        Map<String, Supplier<Deque<Integer>>> implementations = Map.of(
                "ArrayDeque", ArrayDeque::new,
                // "ArrayListDeque", ArrayListDeque::new,
                "LinkedDeque", LinkedDeque::new
        );
        for (String name : implementations.keySet()) {
            PrintStream out = System.out;
            out.println(name);
            out.println("size,add,get");

            for (int size = STEP; size <= MAX_SIZE; size += STEP) {
                out.print(size);
                out.print(',');

                // Record the total runtimes accumulated across all trials
                double totalAddTime = 0.0;
                double totalGetTime = 0.0;

                for (int i = 0; i < NUM_TRIALS; i += 1) {
                    Deque<Integer> deque = implementations.get(name).get();

                    // Measure the time to add N integers
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
}
