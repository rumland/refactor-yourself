package com.umland.codility.timecomplexity;

public class FrogJmp {
    /**
     * Return number of jumps frog must jump to get from X to Y jumping D distance each hop.
     * @param X Starting location
     * @param Y Minimum location
     * @param D Distance traveled with each hop
     * @return number of jumps frog must take
     */
    public int solution(int X, int Y, int D) {

        return (int) Math.ceil(((double) Y - (double) X) / (double) D);
    }
}
