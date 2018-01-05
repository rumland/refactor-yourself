package com.umland.codility.prefixsums;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

public class GenomicRangeQueryTest {
    private GenomicRangeQuery grq = new GenomicRangeQuery();

    @Rule
    public Timeout globalTimeout = new Timeout(3260, TimeUnit.MILLISECONDS);

    /**
     * For example, given the string S = CAGCCTA and arrays P, Q such that:
     * <p>
     * P[0] = 2    Q[0] = 4
     * P[1] = 5    Q[1] = 5
     * P[2] = 0    Q[2] = 6
     * the function should return the values [2, 4, 1], as explained above.
     */
    @Test
    public void solution() {
        String S = "CAGCCTA";
        int[] P = new int[]{2, 5, 0};
        int[] Q = new int[]{4, 5, 6};
        int[] expected = new int[]{2, 4, 1};
        assertArrayEquals(expected, grq.solution(S, P, Q));
    }

    /**
     * Assume that:
     * <p>
     * N is an integer within the range [1..100,000];
     * M is an integer within the range [1..50,000];
     * each element of arrays P, Q is an integer within the range [0..N − 1];
     * P[K] ≤ Q[K], where 0 ≤ K < M;
     * string S consists only of upper-case English letters A, C, G, T.
     * Complexity:
     * <p>
     * expected worst-case time complexity is O(N+M);
     * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     */
    //TODO: enable this test once performance has been improved.
    @Test
    @Ignore
    public void performanceTest() {
        String S = Stream.generate(new NucleotideSupplier()).limit(100000).collect(Collectors.joining());
        BoundSupplier boundSupplier = new BoundSupplier(S.length());
        int[] boundValues = IntStream.generate(boundSupplier).limit(2 * 50000).toArray();
        int [] P = new int[50000];
        int [] Q = new int[50000];
        int pIdx = 0;
        for (int idx = 0; idx < boundValues.length; ++idx) {
            int a = boundValues[idx];
            int b = boundValues[++idx];
            if (a <= b) {
                P[pIdx] = a;
                Q[pIdx] = b;
            } else {
                P[pIdx] = b;
                Q[pIdx] = a;
            }
            ++pIdx;
        }

        long start = System.currentTimeMillis();
        grq.solution(S, P, Q);
        long stop = System.currentTimeMillis();
        System.out.println("Solution took: " + Duration.ofMillis(stop - start).toString());
    }

    class NucleotideSupplier implements Supplier<String> {
        String[] nucleotides = new String[]{"A", "C", "G", "T"};
        Random r = new Random();

        @Override
        public String get() {
            return nucleotides[r.nextInt(nucleotides.length)];
        }
    }

    class BoundSupplier implements IntSupplier {
        private final Integer upperBoundExclusive;
        Random r = new Random();

        BoundSupplier(Integer upperBoundExclusive) {
            this.upperBoundExclusive = upperBoundExclusive;
        }

        @Override
        public int getAsInt() {
            return r.nextInt(upperBoundExclusive);
        }
    }
}