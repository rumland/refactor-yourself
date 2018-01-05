package com.umland.codility.prefixsums;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReadingMaterialTest {
    private ReadingMaterial rm = new ReadingMaterial();

    @Test
    public void mushroomPickerPdfTest() {
        int k = 4;
        int m = 6;
        int[] A = new int[]{2, 3, 7, 5, 1, 3, 9};
        assertArrayEquals(new int[]{25, 2, 6}, rm.solution(k, m, A));
    }

    @Test
    public void beginningTest() {
        int[] A = new int[]{2, 3, 7, 5, 1, 3, 9};
        assertArrayEquals(new int[]{17, 0, 3}, rm.solution(0, 3, A));
    }
}