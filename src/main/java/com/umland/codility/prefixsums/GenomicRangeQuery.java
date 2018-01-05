package com.umland.codility.prefixsums;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types
 * of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides
 * of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries
 * of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA
 * sequence?
 * <p>
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M
 * queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M)
 * requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K]
 * and Q[K] (inclusive).
 * <p>
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 * <p>
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2
 * respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose
 * impact factor is 1, so the answer is 1.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 * <p>
 * that, given a non-empty zero-indexed string S consisting of N characters and two non-empty zero-indexed arrays P
 * and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all
 * queries.
 * <p>
 * The sequence should be returned as:
 * <p>
 * a Results structure (in C), or
 * a vector of integers (in C++), or
 * a Results record (in Pascal), or
 * an array of integers (in any other programming language).
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 * <p>
 * P[0] = 2    Q[0] = 4
 * P[1] = 5    Q[1] = 5
 * P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N+M);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
//TODO: Come back to this. This solution is 100% correct but fails every performance test.
    /*
    almost_all_same_letters:
    1. 8.000 s TIMEOUT ERROR,  running time: >8.00 sec., time limit: 2.85 sec.
    2. 0.164 s OK

    large_random:
    1. 8.000 s TIMEOUT ERROR,  running time: >8.00 sec., time limit: 2.82 sec.

    extreme_large
    1. 9.000 s TIMEOUT ERROR,  running time: >9.00 sec., time limit: 3.26 sec.
     */
public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int[] smallestNucleotideWeights = new int[P.length];
        int[] nucleotideWeights = getNucleotideWeights(S);

        for (int boundIdx = 0; boundIdx < P.length; ++boundIdx) {
            int smallestWeight = 5;
            for (int weightIdx = P[boundIdx]; weightIdx <= Q[boundIdx]; ++weightIdx) {
                int nucleotideWeight = nucleotideWeights[weightIdx];
                if (nucleotideWeight < smallestWeight) {
                    smallestWeight = nucleotideWeight;
                }
            }
            smallestNucleotideWeights[boundIdx] = smallestWeight;
        }

        return smallestNucleotideWeights;
    }

    private int[] getNucleotideWeights(String nucleotides) {
        int[] nucleotideWeights = new int[nucleotides.length()];
        for (int idx = 0; idx < nucleotides.length(); ++idx) {
            String nucleotide = nucleotides.substring(idx, idx + 1);
            nucleotideWeights[idx] = getNucleotideWeight(nucleotide);
        }

        return nucleotideWeights;
    }

    private int getNucleotideWeight(String nucleotide) {
        int weight;
        switch (nucleotide) {
            case "A":
                weight = 1;
                break;
            case "C":
                weight = 2;
                break;
            case "G":
                weight = 3;
                break;
            case "T":
                weight = 4;
                break;
            default:
                throw new RuntimeException("Unexpected nucleotide: " + nucleotide);
        }
        return weight;
    }
}
