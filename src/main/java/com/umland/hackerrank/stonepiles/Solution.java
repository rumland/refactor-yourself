package com.umland.hackerrank.stonepiles;

/**
 * <a href="https://www.hackerrank.com/challenges/stone-piles/problem">Hacker Rank problem</a>
 * There are  piles of stones where the ith pile has  stones in it. Alice and Bob play the following game:
 * <p>
 * Alice starts, and they alternate turns.
 * <p>
 * In a turn, a player can choose any one of the piles of stones and divide the stones in it into any number of unequal
 * piles such that no two of the newly created piles have the same number of stones. For example, if there 8 stones in a
 * pile, it can be divided into one of these set of piles:  or .
 * <p>
 * The player who cannot make a move (because all the remaining piles are indivisible) loses the game.
 * <p>
 * Given the starting set of piles, who wins the game assuming both players play optimally (that means they will not
 * make a move that causes them to lose the game if some better, winning move exists)?
 * <p>
 * Input Format
 * <p>
 * The first line contains the number of test cases .  test cases follow. The first line for each test case contains,
 * the number of piles initially. The next line contains  space delimited numbers, the number of stones in each of the
 * piles.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Output  lines, one corresponding to each test case containing ALICE if Alice wins the game and BOB otherwise.
 * <p>
 * Sample Input
 * <p>
 * 4
 * 1
 * 4
 * 2
 * 1 2
 * 3
 * 1 3 4
 * 1
 * 8
 * Sample Output
 * <p>
 * BOB
 * BOB
 * ALICE
 * BOB
 * Explanation
 * <p>
 * For the first case, the only possible move for Alice is (4) -> (1,3). Now Bob breaks up the pile with 3 stones into (1,2). At this point Alice cannot make any move and has lost.
 */
public class Solution {
}
