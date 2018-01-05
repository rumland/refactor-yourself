package com.umland.codility.prefixsums;

public class ReadingMaterial {
    /**
     * Problem is described <a href="https://codility.com/media/train/3-PrefixSums.pdf">here</a>.
     * This idea came from the referenced blog post.
     * @see <a href="http://thisthread.blogspot.com/2014/11/codility-mushroom-picker.html">post</a>
     * @param k starting position in array A
     * @param m number of moves allowed in array A
     * @param A number of mushrooms found at each location
     * @return maximum number of mushrooms that can be picked
     */
    public int[] solution(int k, int m, int[] A) {
        int maxSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int[] prefixSums = prefixSums(A);

        int maxLeftShift = Math.min(k, m);
        for (int curLeftShift = 0; curLeftShift <= maxLeftShift; ++curLeftShift) {
            int first = k - curLeftShift;
            int rightShift = Math.min(k + (m - curLeftShift * 2), A.length - 1);
            int last = Math.max(k, rightShift);

            int tentative = getPrefixSum(prefixSums, first, last);
            if (tentative > maxSum) {
                maxSum = tentative;
                startIndex = first;
                endIndex = last;
            }
        }

        return new int[]{maxSum, startIndex, endIndex};
    }

    private int[] prefixSums(int[] A) {
        int[] prefixes = new int[A.length + 1];
        prefixes[0] = 0;
        for (int k = 1; k < A.length + 1; ++k) {
            prefixes[k] = prefixes[k - 1] + A[k - 1];
        }

        return prefixes;
    }

    private int getPrefixSum(int[] prefixSums, int x, int y) {
        return prefixSums[y + 1] - prefixSums[x];
    }
}
