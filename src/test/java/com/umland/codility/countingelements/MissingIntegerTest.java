package com.umland.codility.countingelements;

import org.junit.Test;

import static org.junit.Assert.*;

public class MissingIntegerTest {
    private MissingInteger mi = new MissingInteger();

    /**
     *
     For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

     Given A = [1, 2, 3], the function should return 4.

     Given A = [−1, −3], the function should return 1.

     N is an integer within the range [1..100,000];
     each element of array A is an integer within the range [−1,000,000..1,000,000].
     */
    @Test
    public void sampleOneTest() {
        int[] A = new int[]{1, 3, 6, 4, 1, 2};
        assertEquals(5, mi.solution(A));
    }

    @Test
    public void missingTwoValuesTest() {
        int[] A = new int[]{1, 3, 6, 7, 1, 2};
        assertEquals(4, mi.solution(A));
    }

    @Test
    public void sampleTwoTest() {
        int[] A = new int[]{1, 2, 3};
        assertEquals(4, mi.solution(A));
    }

    @Test
    public void sampleThreeTest() {
        int[] A = new int[]{-1, -3};
        assertEquals(1, mi.solution(A));
    }

    @Test
    public void singleNegativeTest() {
        int[] A = new int[]{-1};
        assertEquals(1, mi.solution(A));
    }

    @Test
    public void singlePositiveTest() {
        int[] A = new int[]{1};
        assertEquals(2, mi.solution(A));
    }

    @Test
    public void singlePositiveGreaterThanOneTest() {
        int[] A = new int[]{2};
        assertEquals(1, mi.solution(A));
    }
}