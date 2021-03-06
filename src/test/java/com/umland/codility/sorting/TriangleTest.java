package com.umland.codility.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    private Triangle triangle = new Triangle();

    /**
     * For example, given array A such that:
     * <p>
     * A[0] = 10    A[1] = 2    A[2] = 5
     * A[3] = 1     A[4] = 8    A[5] = 20
     * the function should return 1, as explained above. Given array A such that:
     */
    @Test
    public void sampleProblemOneTest() {
        int[] A = new int[]{10, 2, 5, 1, 8, 20};
        assertEquals(1, triangle.solution(A));
    }

    /**
     * A[0] = 10    A[1] = 50    A[2] = 5
     * A[3] = 1
     * the function should return 0.
     */
    @Test
    public void sampleProblemTwoTest() {
        int[] A = new int[]{10, 50, 5, 1};
        assertEquals(0, triangle.solution(A));
    }

    @Test
    public void maxIntTest() {
        int[] A = new int[]{Integer.MAX_VALUE - 90, Integer.MAX_VALUE - 98, Integer.MAX_VALUE - 95,
                Integer.MAX_VALUE - 99, Integer.MAX_VALUE - 92, Integer.MAX_VALUE - 80};
        assertEquals(1, triangle.solution(A));
    }
}