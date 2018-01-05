package com.umland.codility.prefixsums;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int A, int B, int K); }
 * <p>
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible
 * by 2 within the range [6..11], namely 6, 8 and 10.
 * <p>
 * Assume that:
 * <p>
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(1);
 * expected worst-case space complexity is O(1).
 */
public class CountDiv {
    public int solution(int A, int B, int K) {
        if (A == 0 && B == 0) {
            return 1;
        } else if (A == 0) {
            return B / K + 1;
        }

        return (B / K - (A - 1) / K);
    }

    public int standard(int A, int B, int K) {
        int divCnt = 0;
        for (int idx = A; idx <= B; ++idx) {
            if (idx % K == 0) {
                ++divCnt;
            }
        }

        return divCnt;
    }
}
