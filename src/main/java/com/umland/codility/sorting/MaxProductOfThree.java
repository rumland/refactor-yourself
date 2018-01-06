package com.umland.codility.sorting;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The product of triplet (P, Q, R) equates to
 * A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * contains the following example triplets:
 * <p>
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty zero-indexed array A, returns the value of the maximal product of any triplet.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = -3
 * A[1] = 1
 * A[2] = 2
 * A[3] = -2
 * A[4] = 5
 * A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input
 * arguments).
 */
public class MaxProductOfThree {
    /**
     * TODO: 100% correct but slow. Need to improve performance.
     *
     * @param A input problem
     * @return solution as described above
     */
    public int solution(int[] A) {
        int maxProduct = Integer.MIN_VALUE;

        for (int pIdx = 0; pIdx < A.length; ++pIdx) {
            for (int qIdx = pIdx + 1; qIdx < A.length; ++qIdx) {
                for (int rIdx = qIdx + 1; rIdx < A.length; ++rIdx) {
                    int newProduct = A[pIdx] * A[qIdx] * A[rIdx];
                    if (maxProduct < newProduct) {
                        maxProduct = newProduct;
                    }
                }
            }
        }

        return maxProduct;
    }
}
