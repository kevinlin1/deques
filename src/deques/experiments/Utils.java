package deques.experiments;

import deques.Deque;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Utils {
    public static Deque<Long> createDequeOfSize(long size, Supplier<Deque<Long>> dequeConstructor) {
        Deque<Long> deque = dequeConstructor.get();
        for (long i = 0; i < size; i++) {
            deque.addLast(i);
        }
        return deque;
    }

    /**
     * Constructs a stream of longs starting from `startInclusive`, going to `endInclusive`,
     * in `step` increments.
     * (`endInclusive` is not actually included if it doesn't line up with `step`, e.g.
     * `range(0, 10, 3)` would produce a stream of [0, 3, 6, 9].)
     */
    public static List<Long> range(long startInclusive, long endInclusive, long step) {
        long length = (endInclusive - startInclusive) / step;
        return LongStream.rangeClosed(0, length).map(x -> x * step + startInclusive)
                .boxed().collect(Collectors.toList());
    }
}
