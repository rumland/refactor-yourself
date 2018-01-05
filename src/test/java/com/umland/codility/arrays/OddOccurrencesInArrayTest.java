package com.umland.codility.arrays;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class OddOccurrencesInArrayTest {
    private OddOccurrencesInArray o = new OddOccurrencesInArray();

    @Test
    public void solutionSampleTest() {
        int[] A = new int[] {9, 3, 9, 3, 9, 7, 9};

        assertEquals(7, o.solution(A));
    }

    @Test
    public void solutionBeginningTest() {
        int[] A = new int[] {1, 5, 2, 2, 3, 4, 3, 4, 5, 6, 7, 6, 7 };

        assertEquals(1, o.solution(A));
    }

    @Test
    public void solutionEndTest() {
        int[] A = new int[] {1, 1, 2, 2, 3, 4, 3, 4, 5, 6, 7, 6, 5 };

        assertEquals(7, o.solution(A));
    }
}