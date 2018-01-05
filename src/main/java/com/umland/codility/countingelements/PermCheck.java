package com.umland.codility.countingelements;

import java.util.Arrays;

public class PermCheck {
    public int solution(int[] A) {
        Arrays.sort(A);
        Integer currentValue = 1;

        for (int aA : A) {
            if (aA != currentValue) {
                return 0;
            }
            ++currentValue;
        }

        return 1;
    }

//    public int solutionInfiniteSeriesWrong(int[] A) {
//        Arrays.sort(A);
//
//        int N = A.length;
//        int firstValue = A[0];
//        int lastValue = A[N - 1];
//
//        Integer countSum = getCountSum(lastValue) - getCountSum(firstValue - 1);
//        Integer aSum = Arrays.stream(A).reduce(0, Integer::sum);
//        if (!countSum.equals(aSum)) {
//            return 0;
//        }
//
//        Integer currentValue = A[0];
//        for (int idx = 1; idx < N; ++idx) {
//            if (currentValue + 1 != A[idx]) {
//                return 0;
//            }
//            currentValue = A[idx];
//        }
//
//        return 1;
//    }

//    private int getCountSum(long value) {
//        return (int) ((value * (value + 1)) / 2);
//    }

//    public int solutionSortAndWrong(int[] A) {
//        int N = A.length;
//        if (N == 1) {
//            return 0;
//        }
//
//        Arrays.sort(A);
//        int currentValue = A[0];
//        for (int idx = 1; idx < N; ++idx) {
//            if (A[idx] != currentValue + 1) {
//                return 0;
//            }
//            currentValue = A[idx];
//        }
//
//        return 1;
//    }
}
