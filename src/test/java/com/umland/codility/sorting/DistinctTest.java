package com.umland.codility.sorting;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class DistinctTest {
    private Distinct distinct = new Distinct();

    /**
     * For example, given array A consisting of six elements such that:
     * <p>
     * A[0] = 2    A[1] = 1    A[2] = 1
     * A[3] = 2    A[4] = 3    A[5] = 1
     * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
     */
    @Test
    public void sampleProblemTest() {
        int[] A = new int[]{2, 1, 1, 2, 3, 1};
        assertEquals(3, distinct.solution(A));
    }

    /**
     * each element of array A is an integer within the range [−1,000,000..1,000,000].
     */
    @Test
    public void maxValuesTest() {
        int[] A = new int[]{-1000000, 1000000, 999999, 888888,
                -1000000, 1000000, 999999, 888888,
                -1000000, 1000000, 999999, 888888};
        assertEquals(4, distinct.solution(A));
    }

    /**
     * N is an integer within the range [0..100,000];
     */
    @Test
    public void maxElementsTest() {
        int[] A = IntStream.range(0, 100001).toArray();
        assertEquals(A.length, distinct.solution(A));
    }

    @Test
    public void emptyTest() {
        int[] A = new int[0];
        assertEquals(0, distinct.solution(A));
    }
}