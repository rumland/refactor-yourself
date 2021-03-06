package com.umland.codility.schneiderelectrictest;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class

SampleTestTest {
    private SampleTest sampleTest = new SampleTest();

    /**
     * Given array A such that:
     * A[0] = 5    A[1] = 4    A[2] = 0
     * A[3] = 3    A[4] = 1    A[5] = 6
     * A[6] = 2
     * the function should return 4, because set S[2] equals { 0, 5, 6, 2 } and has four elements. No other set S[K]
     * has more than four elements.
     */
    @Test
    public void problemExampleTest() {
        int[] A = new int[]{5, 4, 0, 3, 1, 6, 2};
        assertEquals(4, sampleTest.solution(A));
    }

    @Test
    public void emptyArrayTest() {
        int[] A = new int[0];
        assertEquals(0, sampleTest.solution(A));
    }

    @Test
    public void largestArrayTest() {
        int[] A = IntStream.range(0, 1000001).toArray();
        assertEquals(1, sampleTest.solution(A));
    }
}