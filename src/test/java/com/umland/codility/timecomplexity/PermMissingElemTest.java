package com.umland.codility.timecomplexity;

import com.umland.codility.timecomplexity.PermMissingElem;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermMissingElemTest {
    private PermMissingElem pme = new PermMissingElem();

    @Test
    public void problemExample() {
        int[] A = new int[] {2, 3, 1, 5};
        assertEquals(4, pme.solution(A));
    }

    /**
     * N is an integer within the range [0..100,000];
     * the elements of A are all distinct;
     */
    @Test
    public void missingOneTest() {
        assertEquals(1, pme.solution(new int[]{2, 3, 4, 5}));
    }

    @Test
    public void emptyListTest() {
        assertEquals(1, pme.solution(new int[]{}));
    }

    @Test
    public void missingFirstElementTest() {
        assertEquals(1, pme.solution(new int[]{2, 3, 4}));
    }

    @Test
    public void missingLastElementTest() {
        assertEquals(4, pme.solution(new int[]{1, 2, 3}));
    }

    @Test
    public void singleElementTest() {
        assertEquals(2, pme.solution(new int[]{1}));
    }

    @Test
    public void singleElementTwoTest() {
        assertEquals(1, pme.solution(new int[]{2}));
    }
}