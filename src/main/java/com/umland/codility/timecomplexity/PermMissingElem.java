package com.umland.codility.timecomplexity;

import java.util.Arrays;

public class PermMissingElem {
    /**
     * N is an integer within the range [0..100,000];
     * the elements of A are all distinct;
     * @param A each element of array A is an integer within the range [1..(N + 1)].
     * @return Missing element in array A
     */
    public int solution(int[] A) {
        Arrays.sort(A);

        if (A.length == 0) {
            return 1;
        }

        for (int idx = 0; idx < A.length; ++idx) {
            if (A[idx] != idx + 1) {
                return idx + 1;
            }
        }

        return A.length + 1;
    }
}
