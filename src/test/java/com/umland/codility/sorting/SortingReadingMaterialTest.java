package com.umland.codility.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortingReadingMaterialTest {
    private SortingReadingMaterial sortingReadingMaterial = new SortingReadingMaterial();

    @Test
    public void sampleProblemTest() {
        int[] A = new int[]{2, 2, 2, 3, 3, 1, 4, 1};
        assertEquals(4, sortingReadingMaterial.sampleProblem(A));
    }

    @Test
    public void selectionSortTest() {
        int[] A = new int[]{16, 14, 5, 8, 2, 1};
        int[] expected = new int[]{1, 2, 5, 8, 14, 16};
        sortingReadingMaterial.selectionSort(A);
        assertArrayEquals(expected, A);
    }

    @Test
    public void selectionSortSingleValueTest() {
        int[] A = new int[]{16};
        int[] expected = new int[]{16};
        sortingReadingMaterial.selectionSort(A);
        assertArrayEquals(expected, A);
    }

    @Test
    public void countingSortTest() {
        int[] A = new int[]{16, 14, 5, 8, 2, 1};
        int[] expected = new int[]{1, 2, 5, 8, 14, 16};
        sortingReadingMaterial.countingSort(A);
        assertArrayEquals(expected, A);
    }

    @Test
    public void countingSortDuplicatedValueTest() {
        int[] A = new int[]{16, 14, 5, 8, 8, 2, 1};
        int[] expected = new int[]{1, 2, 5, 8, 8, 14, 16};
        sortingReadingMaterial.countingSort(A);
        assertArrayEquals(expected, A);
    }

    @Test
    public void countingSortSingleValueTest() {
        int[] A = new int[]{16};
        int[] expected = new int[]{16};
        sortingReadingMaterial.countingSort(A);
        assertArrayEquals(expected, A);
    }

    @Test
    public void mergeSortDuplicatedValueTest() {
        int[] A = new int[]{16, 14, 5, 8, 8, 2, 1};
        int[] expected = new int[]{1, 2, 5, 8, 8, 14, 16};
        assertArrayEquals(expected, sortingReadingMaterial.topDownMergeSort(A));
    }

    @Test
    public void integerDivisionTest() {
        int a = 7 / 2;
        System.out.println("a: " + a);
    }
}