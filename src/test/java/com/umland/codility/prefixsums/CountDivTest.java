package com.umland.codility.prefixsums;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountDivTest {
    private CountDiv cd = new CountDiv();

    @Test
    public void sampleTest() {
        /*
         For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible
         by 2 within the range [6..11], namely 6, 8 and 10.
         */
        assertEquals(cd.standard(6, 11, 2), cd.solution(6, 11, 2));
    }

    @Test
    public void oddTest() {
        assertEquals(cd.standard(6, 11, 3), cd.solution(6, 11, 3));
    }

    @Test
    public void scaleTest() {
        /*
         A and B are integers within the range [0..2,000,000,000];
         K is an integer within the range [1..2,000,000,000];
         */
//        assertEquals(500000000, cd.solution(1, 2000000000, 4));
    }
}