package com.umland.codility.arrays;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        if (K == 0) {
            return A;
        }

        if (A.length == 0) {
            return A;
        }

        int [] B = shiftArrayElements(A);
        for (int idx = 1; idx < K; ++idx) {
            B = shiftArrayElements(B);
        }

        return B;
    }

    private int[] shiftArrayElements(int[] A) {
        int[] B = new int[A.length];
        B[0] = A[A.length - 1];
        System.arraycopy(A, 0, B, 1, A.length - 1);
        return B;
    }
}
