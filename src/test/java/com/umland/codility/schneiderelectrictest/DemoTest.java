package com.umland.codility.schneiderelectrictest;

import org.junit.Test;

import static org.junit.Assert.*;

public class DemoTest {
    private Demo d = new Demo();
    /*
    Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     */
    @Test
    public void problemExample1Test() {
        int[] A = new int[]{1, 3, 6, 4, 1, 2};
        assertEquals(5, d.solution(A));
    }

    @Test
    public void problemExample2Test() {
        int[] A = new int[]{1, 2, 3};
        assertEquals(4, d.solution(A));
    }

    @Test
    public void problemExample3Test() {
        int[] A = new int[]{-1, -3};
        assertEquals(1, d.solution(A));
    }

    @Test
    public void maxRangeTest() {
        int[] A = new int[]{0, 22, 88, 1983, -1000000, 1000000};
        assertEquals(1, d.solution(A));
    }

    @Test
    public void singleElementOfZeroTest() {
        int[] A = new int[]{0};
        assertEquals(1, d.solution(A));
    }

    @Test
    public void singleElementOf1Test() {
        int[] A = new int[]{1};
        assertEquals(2, d.solution(A));
    }

    @Test
    public void singleElementOfNegativeTwoTest() {
        int[] A = new int[]{-2};
        assertEquals(1, d.solution(A));
    }
}