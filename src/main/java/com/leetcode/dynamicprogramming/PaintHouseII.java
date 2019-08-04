package com.leetcode.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Hard
 * Problem Link: https://leetcode.com/problems/paint-house-ii/
 * Problem Description:
 * There are a row of n houses, each house can be painted with one of the m colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x m cost matrix.
 * <p>
 * For example, costs[0][0] is the cost of painting house 0 with color 0;
 * costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Find the minimum cost to paint all houses.
 * <p>
 * Note: All costs are positive integers.
 * <p>
 * Follow up: Could you solve it in O(n * m) runtime? // TODO
 *
 * Companies: LinkedIn.
 * Related: {@link PaintHouse}.
 *
 * @author rampatra
 * @since 2019-07-24
 */
public class PaintHouseII {

    /**
     * The approach is similar to {@link PaintHouse} but slightly complex as the number of colors are arbitrary
     * instead of the 3 fixed colors. So, we use two additional for loops to cycle through all the colors.
     * Time Complexity: O(n * m * m)
     * Space Complexity: O(1)
     *
     * @param costs the costs of coloring the house, each row represents the cost of coloring a particular
     *              house with different colors
     * @return the minimum cost to paint all houses such that no two adjacent houses are of same color
     */
    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                int min = Integer.MAX_VALUE;
                // loop through all colors for the previous house except the color of the current house
                for (int k = 0; k < costs[0].length; k++) {
                    if (k != j) {
                        min = Math.min(costs[i - 1][k], min);
                    }
                }
                costs[i][j] += min;
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            minCost = Math.min(costs[costs.length - 1][i], minCost);
        }

        return minCost;
    }

    public static void main(String[] args) {
        assertEquals(0, minCost(new int[][]{}));

        assertEquals(10, minCost(new int[][]{
                {2, 3, 4},
                {5, 7, 6},
                {8, 7, 2}
        }));

        assertEquals(10, minCost(new int[][]{{10, 30, 20}}));

        assertEquals(3, minCost(new int[][]{{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}}));

        assertEquals(5, minCost(new int[][]{{1, 2, 3},
                {3, 2, 1},
                {2, 2, 2},
                {3, 1, 2}}));

        assertEquals(10, minCost(new int[][]{{17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}}));

        assertEquals(5, minCost(new int[][]{{1, 5, 3},
                {2, 9, 4}}));

        assertEquals(8, minCost(new int[][]{{8}}));

        assertEquals(143, minCost(new int[][]{{12, 1, 19},
                {15, 1, 10},
                {3, 11, 10},
                {9, 3, 10},
                {4, 8, 7},
                {4, 18, 2},
                {16, 6, 6},
                {3, 3, 6},
                {10, 18, 16},
                {5, 4, 8},
                {5, 3, 16},
                {11, 8, 19},
                {18, 15, 18},
                {16, 4, 15},
                {10, 7, 13},
                {11, 10, 14},
                {3, 9, 8},
                {5, 2, 2},
                {3, 2, 5},
                {2, 19, 14},
                {17, 3, 6},
                {6, 4, 17},
                {5, 15, 19},
                {2, 14, 14},
                {19, 4, 16}}));
    }
}
