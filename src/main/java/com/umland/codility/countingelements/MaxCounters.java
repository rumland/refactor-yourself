package com.umland.codility.countingelements;

public class MaxCounters {
    private int numberOfCounters;

    public int[] solution(int N, int[] A) {
        numberOfCounters = N;
        int[] buckets = new int[N];

        int currentMax = 0;
        int maxValueToApply = currentMax;
        for (int X : A) {
            if (shouldIncrease(X)) {
                if (buckets[X - 1] < maxValueToApply) {
                    buckets[X - 1] = maxValueToApply;
                }
                ++buckets[X - 1];
                if (buckets[X - 1] > currentMax) {
                    currentMax = buckets[X - 1];
                }
            } else {
                maxValueToApply = currentMax;
            }
        }

        for (int idx = 0; idx < buckets.length; ++idx) {
            if (buckets[idx] < maxValueToApply) {
                buckets[idx] = maxValueToApply;
            }
        }
        return buckets;
    }

    /**
     * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
     * if A[K] = N + 1 then operation K is max counter.
     */
    private boolean shouldIncrease(int X) {
        return 1 <= X  && X <= numberOfCounters;
    }
}
