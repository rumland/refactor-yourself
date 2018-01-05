package com.umland.codility.countingelements;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */
public class PermCheckTest {
    private final PermCheck pc = new PermCheck();

    @Test
    public void problemSamplePermutationTest() {
        int[] A = new int[]{4, 1, 3, 2};
        assertEquals(1, pc.solution(A));
    }

    @Test
    public void smallSequenceNonOneStartTest() {
        int[] A = new int[]{5, 6, 7};
        assertEquals(0, pc.solution(A));
    }

    @Test
    public void problemSampleNotPermutationTest() {
        int[] A = new int[]{4, 1, 3};
        assertEquals(0, pc.solution(A));
    }

    @Test
    public void largestValueNotPermutationTest() {
        int[] A = new int[]{1, 1000000000};
        assertEquals(0, pc.solution(A));
    }

    @Test
    public void twoValuesNotPermutationTest() {
        int[] A = new int[]{7, 5};
        assertEquals(0, pc.solution(A));
    }

    @Test
    public void twoValuesPermutationTest() {
        int[] A = new int[]{1, 2};
        assertEquals(1, pc.solution(A));
    }

    @Test
    public void largestValuePermutationTest() {
        int[] A = IntStream.range(999999999, 1000000001).toArray();
        assertEquals(0, pc.solution(A));
    }

    @Test
    public void largestSizePermutationTest() {
        int[] A = IntStream.range(1, 100000).toArray();
        assertEquals(1, pc.solution(A));
    }

    @Test
    public void largestSizeAndValuePermutationTest() {
        int[] A = IntStream.range(1000000000-1000, 1000000001).toArray();
        assertEquals(0, pc.solution(A));
    }

    @Test
    public void singleValueTest() {
        int[] A = new int[]{2};
        assertEquals(0, pc.solution(A));
    }

    @Test
    public void singleValuePermutationTest() {
        int[] A = new int[]{1};
        assertEquals(1, pc.solution(A));
    }
}