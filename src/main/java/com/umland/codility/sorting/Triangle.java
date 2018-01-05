package com.umland.codility.sorting;

/**
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * <p>
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for
 * this array and returns 0 otherwise.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 * <p>
 * A[0] = 10    A[1] = 50    A[2] = 5
 * A[3] = 1
 * the function should return 0.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input
 * arguments).
 */
public class Triangle {
    /**
     * 90% correct and 0% on performance
     * extreme_arith_overflow1: overflow test, 3 MAXINTs ✘WRONG ANSWER got 0 expected 1
     *
     * large2: 1 followed by an ascending sequence of ~50K elements from [0..100K], length=~50K ✘TIMEOUT ERROR
     *      1. 6.000 s TIMEOUT ERROR,  running time: >6.00 sec., time limit: 0.50 sec.
     * large_negative: chaotic sequence of negative values from [-1M..-1], length=100K ✘TIMEOUT ERROR
     *      1. 7.000 s TIMEOUT ERROR,  running time: >7.00 sec., time limit: 1.22 sec.
     * large_negative2: chaotic sequence of negative values from [-10..-1], length=100K ✘TIMEOUT ERROR
     *      1. 6.000 s TIMEOUT ERROR,  running time: >6.00 sec., time limit: 0.70 sec.
     * large_negative3: sequence of -1 value, length=100K ✘TIMEOUT ERROR
     *      1. 6.000 s TIMEOUT ERROR,  running time: >6.00 sec., time limit: 0.66 sec.
     *
     * @param A array possibly containing triplet
     * @return 1 if A contains triplet, 0 otherwise
     */
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        for (int p = 0; p < A.length; ++p) {
            for (int q = p + 1; q < A.length; ++q) {
                for (int r = p + 2; r < A.length; ++r) {
                    if (isTriplet(A, p, q, r)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private boolean isTriplet(int[] A, int P, int Q, int R) {
        boolean triplet = false;
        if (0 <= P && P < Q && Q < R && R < A.length) {
            if (A[P] + A[Q] > A[R] && A[Q] + A[R] > A[P] && A[R] + A[P] > A[Q]) {
                triplet = true;
            }
        }

        return triplet;
    }
}
