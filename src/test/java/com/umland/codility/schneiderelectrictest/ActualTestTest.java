package com.umland.codility.schneiderelectrictest;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActualTestTest {
    private ActualTest at = new ActualTest();

    @Test
    public void sampleOneTest() {
        int[] A = new int[]{4, 10, 5, 4, 2, 10};
        assertEquals(5, at.solution(A));
    }

    @Test
    public void sampleTwoTest() {
        int[] A = new int[]{1, 4, 3, 3, 1, 2};
        assertEquals(4, at.solution(A));
    }

    @Test
    public void sampleThreeTest() {
        int[] A = new int[]{6, 4, 4, 6};
        assertEquals(-1, at.solution(A));
    }

    @Test
    public void singleValueTest() {
        int[] A = new int[]{4};
        assertEquals(4, at.solution(A));
    }

    @Test
    public void manyInstancesSameValueTest() {
        int[] A = new int[]{1, 2, 1, 2, 2, 2, 2, 2, 2, 4};
        assertEquals(4, at.solution(A));
    }
}