package com.umland.codility.prefixsums;

import java.util.ArrayList;
import java.util.List;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that
 * 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of
 * a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the
 * average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * contains the following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the starting position of the slice
 * with the minimal average. If there is more than one slice with a minimal average, you should return the smallest
 * starting position of such a slice.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * the function should return 1, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input
 * arguments).
 */
public class MinAvgTwoSlice {
    /**
     * 100% correct but fails _every_ performance tests.
     * To increase performance, maybe use binary indexed tree?
     * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/#introduction
     * TODO: come back and make faster after going through all other codility problems
     * @param A as described above
     * @return solution as described above
     */
    public int solution(int[] A) {
        List<Integer> prefixSums = getPrefixSums(A);

        double lowestSliceAverage = Double.MAX_VALUE;
        int lowestSliceIndex = 0;
        System.out.println("prefixSum: " + prefixSums);
        for (int a = 0; a < A.length; ++a) {
            for (int b = a + 1; b < A.length; ++b) {
                double rangeSum = (prefixSums.get(b + 1) - prefixSums.get(a));
                double rangeAverage = rangeSum / ((b - a) + 1);
                System.out.println("(" + a + ", " + b + ")[" + rangeSum + "]: => " + rangeAverage);
                if (rangeAverage < lowestSliceAverage) {
                    System.out.println("New lowest average: " + rangeAverage);
                    lowestSliceIndex = a;
                    lowestSliceAverage = rangeAverage;
                }
            }
        }

        return lowestSliceIndex;
    }

    private List<Integer> getPrefixSums(int[] a) {
        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        for (int idx = 1; idx < a.length + 1; ++idx) {
            sums.add(sums.get(idx - 1) + a[idx - 1]);
        }

        return sums;
    }
}
