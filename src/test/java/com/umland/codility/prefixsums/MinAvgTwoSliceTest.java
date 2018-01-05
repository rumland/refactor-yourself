package com.umland.codility.prefixsums;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinAvgTwoSliceTest {
    private MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

    @Test
    public void problemSampleTest() {
        int[] A = new int[]{4, 2, 2, 5, 1, 5, 8};
        assertEquals(1, minAvgTwoSlice.solution(A));
    }

    @Test
    public void multipleSlicesReturnLowerIndexTest() {
        int[] A = new int[]{4, 5, 2, 2, 1, 5, 8, 4, 2, 2, 5, 1, 5, 8};
        assertEquals(3, minAvgTwoSlice.solution(A));
    }

    @Test
    public void negativeValuesTest() {
        int[] A = new int[]{-3, -9, -1};
        assertEquals(0, minAvgTwoSlice.solution(A));
    }

    @Test
    public void negativeAndPositiveValuesTest() {
        int[] A = new int[]{-3, 9, -4, 3};
        assertEquals(2, minAvgTwoSlice.solution(A));
    }
}