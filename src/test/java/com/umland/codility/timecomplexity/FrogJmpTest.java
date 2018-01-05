package com.umland.codility.timecomplexity;

import com.umland.codility.timecomplexity.FrogJmp;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrogJmpTest {
    private FrogJmp fj = new FrogJmp();

    @Test
    public void exampleTest() {
        int X = 10;
        int Y = 85;
        int D = 30;

        assertEquals(3, fj.solution(X, Y, D));
    }

    @Test
    public void exactLandTest() {
        assertEquals(2, fj.solution(7, 21, 7));
    }

    @Test
    public void atDestinationTest() {
        assertEquals(0, fj.solution(10, 10, 10));
    }

    @Test
    public void extremeTest() {
        assertEquals(99999999, fj.solution(10, 1000000000, 10));
    }
}