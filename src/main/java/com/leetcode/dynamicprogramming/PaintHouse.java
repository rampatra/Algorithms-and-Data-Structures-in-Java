package com.leetcode.dynamicprogramming;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/paint-house/
 * Problem Description:
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost
 * of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent
 * houses have the same color. The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * <p>
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting
 * house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * <p>
 * Companies: LinkedIn.
 * Related: {@link PaintHouseII}.
 *
 * @author rampatra
 * @since 2019-07-23
 */
public class PaintHouse {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/248573066/">1 ms</a>.
     *
     * @param costs of coloring the houses with red, blue, and green respectively. 1st row represents house 1, 2nd row
     *              house 2 and so on
     * @return the minimum cost to paint all houses such that no two adjacent houses are of same color
     */
    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        int lastRow = costs.length - 1;
        return Math.min(Math.min(costs[lastRow][0], costs[lastRow][1]), costs[lastRow][2]);
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{
        }));

        System.out.println(minCost(new int[][]{
                {2, 3, 4},
                {5, 7, 6},
                {8, 7, 2}
        }));
    }
}