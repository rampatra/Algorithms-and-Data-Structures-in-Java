package com.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/find-the-celebrity/
 * Problem Description:
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do
 * is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the
 * celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a
 * function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's
 * label if there is a celebrity in the party. If there is no celebrity, return -1.
 *
 * Example 1:
 *
 * Input: graph = [
 *   [1,1,0],
 *   [0,1,0],
 *   [1,1,1]
 * ]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise
 * graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2
 * know him but 1 does not know anybody.
 *
 *
 * Example 2:
 *
 * Input: graph = [
 *   [1,0,1],
 *   [1,1,0],
 *   [0,1,1]
 * ]
 * Output: -1
 * Explanation: There is no celebrity.
 *
 *
 * Note: The directed graph is represented as an adjacency matrix, which is an n x n matrix where a[i][j] = 1 means
 * person i knows person j while a[i][j] = 0 means the contrary. Remember that you won't have direct access to the
 * adjacency matrix.
 *
 * @author rampatra
 * @since 2019-08-04
 */
public class FindTheCelebrity {

    private int[][] knowsMatrix;

    FindTheCelebrity(int[][] knowsMatrix) {
        this.knowsMatrix = knowsMatrix;
    }

    public boolean knows(int a, int b) {
        return knowsMatrix[a][b] == 1;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: <a href="https://leetcode.com/submissions/detail/249123409/">6 ms</a>.
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        int celebrityIndex = 0;

        for (int i = 1; i < n; i++) {
            // if a person doesn't know another person then he maybe a celebrity
            if (!knows(i, celebrityIndex)) {
                celebrityIndex = i;
            }
        }

        for (int i = 0; i < n; i++) {
            // verify whether the celebrity only knows himself and all other people know the celebrity
            if ((knows(celebrityIndex, i) && i != celebrityIndex) || !knows(i, celebrityIndex)) {
                return -1;
            }
        }

        return celebrityIndex;
    }

    public static void main(String[] args) {
        FindTheCelebrity findTheCelebrity = new FindTheCelebrity(new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1}});

        assertEquals(1, findTheCelebrity.findCelebrity(3));

        findTheCelebrity = new FindTheCelebrity(new int[][]{
                {1, 0},
                {0, 1}});

        assertEquals(-1, findTheCelebrity.findCelebrity(2));
    }
}
