package com.umland.codility.schneiderelectrictest;

/**
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the
 * range [0..N-1]. Sets S[K] for 0 <= K < N are defined as follows:
 * <p>
 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
 * <p>
 * Sets S[K] are finite for each K.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the size of the largest set S[K] for this array. The
 * function should return 0 if the array is empty.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 5    A[1] = 4    A[2] = 0
 * A[3] = 3    A[4] = 1    A[5] = 6
 * A[6] = 2
 * <p>
 * the function should return 4, because set S[2] equals { 0, 5, 6, 2 } and has four elements. No other set S[K]
 * has more than four elements.
 * <p>
 * Assume that:
 * <ul>
 * <li>N is an integer within the range [0..1,000,000];</li>
 * <li>the elements of A are all distinct;</li>
 * <li>each element of array A is an integer within the range [0..N-1].</li>
 * </ul>
 * <p>
 * Complexity:
 * <ul>
 * <li>expected worst-case time complexity is O(N);</li>
 * <li>expected worst-case space complexity is O(N), beyond input storage (not counting the storage
 * required for input arguments.</li>
 * </ul>
 * <p>
 * Elements of input arrays can be modified.
 */
class SampleTest {
    private int[] problemArray;

    int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        problemArray = A;
        int max = Integer.MIN_VALUE;
        for (int idx = 0; idx < problemArray.length; ++idx) {
            int value = getSetCount(idx, idx);
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    // S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
    private int getSetCount(int idx, int firstIdx) {
        if (loopDetected(idx, firstIdx)) {
            return 1;
        }

        return 1 + getSetCount(problemArray[idx], firstIdx);
    }

    private boolean loopDetected(int index, int firstIndex) {
        return problemArray[index] == firstIndex;
    }
}
