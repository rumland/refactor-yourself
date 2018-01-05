package com.umland.codility.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input
 * arguments).
 */
public class MissingInteger {
    public int solution(int[] A) {
        int missingInteger = 1;
        Set<Integer> numbers = new HashSet<>();

        for (int value : A) {
            numbers.add(value);
        }

        while (numbers.contains(missingInteger)) {
            ++missingInteger;
        }

        return missingInteger;
    }
}
