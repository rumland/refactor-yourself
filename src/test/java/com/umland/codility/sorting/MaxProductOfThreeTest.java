package com.umland.codility.sorting;

import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MaxProductOfThreeTest {
    private MaxProductOfThree maxProductOfThree = new MaxProductOfThree();

    /**
     * For example, array A such that:
     * <p>
     * A[0] = -3
     * A[1] = 1
     * A[2] = 2
     * A[3] = -2
     * A[4] = 5
     * A[5] = 6
     * contains the following example triplets:
     * <p>
     * (0, 1, 2), product is −3 * 1 * 2 = −6
     * (1, 2, 4), product is 1 * 2 * 5 = 10
     * (2, 4, 5), product is 2 * 5 * 6 = 60
     * Your goal is to find the maximal product of any triplet.
     */
    @Test
    public void sampleProblemTest() {
        int[] A = new int[]{-3, 1, 2, -2, 5, 6};
        assertEquals(60, maxProductOfThree.solution(A));
    }

    /**
     * N is an integer within the range [3..100,000];
     * each element of array A is an integer within the range [−1,000..1,000].
     */
    @Test
    public void sameThreeValuesTest() {
        int[] A = new int[]{10, 10, 10};
        assertEquals(10 * 10 * 10, maxProductOfThree.solution(A));
    }

    @Test
    public void maxProductTest() {
        int[] A = new int[]{1000, 1000, 1000};
        assertEquals(1000000000, maxProductOfThree.solution(A));
    }

    @Test
    public void oneLessThanMaxProductTest() {
        int[] A = new int[]{1000, 1000, 999};
        assertEquals(999000000, maxProductOfThree.solution(A));
    }

    @Test
    public void reverseValuesTest() {
        int[] A = new int[]{3, 2, 1};
        assertEquals(3 * 2, maxProductOfThree.solution(A));
    }

    @Test
    public void twoNegativesTest() {
        int[] A = new int[]{-1000, -999, 999, 1000};
        assertEquals(999000000, maxProductOfThree.solution(A));
    }

    @Test
    @Ignore
    public void mediumRangeTest() {
        int[] A = IntStream.range(-1000, 1001).toArray();
        assertEquals(999000000, maxProductOfThree.solution(A));
    }
}