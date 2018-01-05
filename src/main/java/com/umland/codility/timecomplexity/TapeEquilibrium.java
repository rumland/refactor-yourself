package com.umland.codility.timecomplexity;

public class TapeEquilibrium {
    /*
    correctness: 100%; performance: 100%; score: 100%
    medium_random1: 0.020 s TIMEOUT ERROR,  running time: 0.10 sec., time limit: 0.10 sec.
    medium_random2: 0.024 s TIMEOUT ERROR,  running time: 0.11 sec., time limit: 0.10 sec.
     */
    public int solution(int[] A) {
        int sumLeft = A[0];
        int sumRight = 0;

        for (int idx = 1; idx < A.length; ++idx) {
            sumRight += A[idx];
        }

//        Arrays.stream has "large" impact on performance.
//        correctness: 100%; performance: 83%; score: 91%
//        medium_random1: 0.104 s TIMEOUT ERROR,  running time: 0.10 sec., time limit: 0.10 sec.
//        medium_random2: 0.108 s TIMEOUT ERROR,  running time: 0.11 sec., time limit: 0.10 sec.
//        sumRight = Arrays.stream(A).sum() - A[0];

        int ans = Math.abs(sumLeft - sumRight);

        for (int P = 1; P < A.length - 1; ++P) {
            sumLeft += A[P];
            sumRight -= A[P];
            int nextAns = Math.abs(sumLeft - sumRight);
            if (nextAns < ans) {
                ans = nextAns;
            }
        }

        return ans;
    }
    /*
    100% correct but not fast enough...
    medium_random1: 0.112 s TIMEOUT ERROR,  running time: 0.11 sec., time limit: 0.10 sec.
    medium_random2: 0.116 s TIMEOUT ERROR,  running time: 0.12 sec., time limit: 0.11 sec.
     */
//    public int solutionSlightlyToSlow(int[] A) {
//        List<Integer> sums = new ArrayList<>();
//        int[] forwardSums = new int[A.length - 1];
//        int[] backwardSums = new int[A.length - 1];
//
//        int forwardSum = 0;
//        int backwardSum = 0;
//        for (int forwardIdx = 0, backwardIdx = A.length - 1; forwardIdx < A.length - 1; ++forwardIdx, --backwardIdx) {
//            forwardSums[forwardIdx] = forwardSum + A[forwardIdx];
//            forwardSum += A[forwardIdx];
//
//            backwardSums[backwardIdx - 1] = backwardSum + A[backwardIdx];
//            backwardSum += A[backwardIdx];
//        }
//
//        for (int idx = 0; idx < forwardSums.length; ++idx) {
//            sums.add(Math.abs(forwardSums[idx] - backwardSums[idx]));
//        }
//
//        return sums.stream().min(Comparator.naturalOrder()).orElse(0);
//    }
}
