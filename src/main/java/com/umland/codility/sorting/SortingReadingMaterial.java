package com.umland.codility.sorting;

import java.util.*;

/**
 * Problem: You are given a zero-indexed array A consisting of n > 0 integers; you must return
 * the number of unique values in array A.
 */
public class SortingReadingMaterial {
    private Set<Integer> uniqueValues = new HashSet<>();

    int sampleProblem(int[] A) {
        for (int a : A) {
            uniqueValues.add(a);
        }

        return uniqueValues.size();
    }

    /**
     * Basic idea of selection sort is to start with the first element of the array. Then, search the remainder of the
     * array for the lowest value. If a lower value is found, swap that value with the first element of the array. The
     * next iteration starts with the second value and searches from the third value on. Repeat this until you have
     * gone through the entire array.
     * <p>
     * The time complexity of this sort is <i>O(N<sup>2</sup>)</i>.
     * </p>
     *
     * @param A Array that will be sorted in place
     */
    public void selectionSort(int[] A) {
        for (int idx = 0; idx < A.length; ++idx) {
            System.out.println("A: " + Arrays.toString(A));
            int minimal = idx;
            for (int jdx = idx + 1; jdx < A.length; ++jdx) {
                if (A[jdx] < A[minimal]) {
                    minimal = jdx;
                }
            }
            int temp = A[minimal];
            A[minimal] = A[idx];
            A[idx] = temp;
        }
    }

    /**
     * Basic idea of counting sort is to count the elements of array in array of counters. Then, traverse the array of
     * counters in increasing order. We need to know the range of sorted values to create the array of counters.
     * <p>
     * The time complexity of this sorting algorithm is <i>O(n+k)</i>.
     * </p>
     *
     * @param A array to be sorted in place
     */
    public void countingSort(int[] A) {
        Map<Integer, Integer> arrayCounter = new TreeMap<>();
        for (int a : A) {
            arrayCounter.merge(a, 1, Integer::sum);
        }

        int aIdx = 0;
        for (Map.Entry<Integer, Integer> entry : arrayCounter.entrySet()) {
            Integer value = entry.getKey();
            Integer valueCount = entry.getValue();
            for (int vIdx = 0; vIdx < valueCount; ++vIdx) {
                A[aIdx + vIdx] = value;
            }
            aIdx += valueCount;
        }
    }

    /**
     * Basic idea is to split array into 2 halves. Continue this split until there is an array with size of 1. Then,
     * walk back up the tree merging each half along the way.
     * <p>
     * Time complexity is <i>O(n*log(n))</i>.
     * </p>
     *
     * @param A array to be sorted in-place
     * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">Wikipedia Merge Sort</a>
     */
    public int[] topDownMergeSort(int[] A) {
        return topDownSplitMerge(A, 0, A.length);
    }

    private int[] topDownSplitMerge(int[] A, int start, int end) {
        String msg = String.format("Split A [%s, %s): %s", start, end,
                Arrays.toString(Arrays.stream(A, start, end).toArray()));
        System.out.println(msg);

        if ((end - start) == 1) {
            return new int[]{A[start]};
        }

        int middle = (end + start) / 2;
        int[] left = topDownSplitMerge(A, start, middle);
        int[] right = topDownSplitMerge(A, middle, end);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        System.out.println("left: " + Arrays.toString(left));
        System.out.println("right: " + Arrays.toString(right));
        int[] merge = new int[left.length + right.length];

        int leftIdx = 0, rightIdx = 0;
        for (int idx = 0; idx < merge.length; ++idx) {
            int leftValue = leftIdx < left.length ? left[leftIdx] : Integer.MAX_VALUE;
            int rightValue = rightIdx < right.length ? right[rightIdx] : Integer.MAX_VALUE;
            if (leftValue < rightValue) {
                merge[idx] = leftValue;
                ++leftIdx;
            } else {
                merge[idx] = rightValue;
                ++rightIdx;
            }
        }

        System.out.println("merge result: " + Arrays.toString(merge));
        return merge;
    }
}
