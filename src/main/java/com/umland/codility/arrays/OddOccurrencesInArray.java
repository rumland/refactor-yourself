package com.umland.codility.arrays;

import java.util.*;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        Arrays.sort(A);

        for (int a = 0, b = 1; b < A.length; a += 2, b += 2) {
            if (A[a] != A[b]) {
                return A[a];
            }
        }

        return A[A.length - 1];
    }
}
