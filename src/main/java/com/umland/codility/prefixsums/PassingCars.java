package com.umland.codility.prefixsums;

public class PassingCars {
    public int solution(int[] A) {
        int passes = 0;

        int eastCarCount = 0;
        for (int aA : A) {
            if (aA == 0) {
                ++eastCarCount;
            } else {
                passes += eastCarCount;
                if (passes > 1000000000) {
                    return -1;
                }
            }
        }

        return passes;
    }
}
