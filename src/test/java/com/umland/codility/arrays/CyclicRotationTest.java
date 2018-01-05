package com.umland.codility.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CyclicRotationTest {
    private CyclicRotation cr = new CyclicRotation();

    @Test
    public void solutionMirrorTest() {
        int[] A = new int[]{1, 2, 3, 4};
        assertArrayEquals(A, cr.solution(A, 4));
    }

    @Test
    public void solutionZeroTest() {
        int[] A = new int[]{1, 2, 3, 4};
        assertArrayEquals(A, cr.solution(A, 0));
    }

    @Test
    public void solutionShiftByOneTest() {
        int[] A = new int[]{3, 8, 9, 7, 6};
        assertArrayEquals(new int[]{6, 3, 8, 9, 7}, cr.solution(A, 1));
    }

    @Test
    public void solutionShiftByTwoTest() {
        int[] A = new int[]{3, 8, 9, 7, 6};
        assertArrayEquals(new int[]{7, 6, 3, 8, 9}, cr.solution(A, 2));
    }

    @Test
    public void solutionShiftByThreeTest() {
        int[] A = new int[]{3, 8, 9, 7, 6};
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, cr.solution(A, 3));
    }

    @Test
    public void solutionShiftByNMinusOneTest() {
        int[] A = new int[]{3, 8, 9, 7, 6};
        assertArrayEquals(new int[]{8, 9, 7, 6, 3}, cr.solution(A, 4));
    }

    @Test
    public void solutionEmptyArrayTest() {
        int[] A = new int[]{};
        assertArrayEquals(new int[]{}, cr.solution(A, 4));
    }
}