package com.umland.codility.countingelements;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrogRiverOneTest {
    private FrogRiverOne fro = new FrogRiverOne();

    @Test
    public void sampleProblemTest() {
        int[] A = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
        assertEquals(6, fro.solution(5, A));
    }

    @Test
    public void singleElementNoSuccessTest() {
        int [] A = new int[]{3};
        assertEquals(-1, fro.solution(4, A));
    }

    @Test
    public void singleElementSuccessTest() {
        int [] A = new int[]{1};
        assertEquals(0, fro.solution(1, A));
    }
}