package com.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Hard
 * Link: https://leetcode.com/problems/best-meeting-point/
 * Description:
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid
 * of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using
 * Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * Example:
 *
 * Input:
 *
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * Output: 6
 *
 * Explanation: Given three people living at (0,0), (0,4), and (2,2):
 *              The point (0,2) is an ideal meeting point, as the total travel distance
 *              of 2+2+2=6 is minimal. So, return 6.
 *
 * @author rampatra
 * @since 2019-08-07
 */
public class BestMeetingPoint {

    /**
     * Time Complexity: O(k * i * j)
     * Space Complexity: O(1)
     * where,
     * k = no of homes
     * i = rows in grid
     * j = columns in grid
     *
     * So, if i = j = k then you can see that it has a O(n^3) time complexity.
     *
     * @param grid
     * @return
     */
    public static int minTotalDistanceBrutForce(int[][] grid) {
        int minDistance = Integer.MAX_VALUE;
        List<List<Integer>> homeCoordinates = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    homeCoordinates.add(Arrays.asList(i, j));
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int distance = 0;
                for (int k = 0; k < homeCoordinates.size(); k++) {
                    distance += Math.abs(homeCoordinates.get(k).get(0) - i) + Math.abs(homeCoordinates.get(k).get(1) - j);
                }
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance;
    }

    public static int minTotalDistance(int[][] grid) {
        return -1; // todo
    }

    public static void main(String[] args) {
        assertEquals(6, minTotalDistanceBrutForce(new int[][]{
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        }));

        assertEquals(4, minTotalDistanceBrutForce(new int[][]{
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,0,0,0}
        }));

        assertEquals(1, minTotalDistanceBrutForce(new int[][]{
                {1,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        }));

        assertEquals(0, minTotalDistanceBrutForce(new int[][]{
                {1,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        }));

        assertEquals(0, minTotalDistanceBrutForce(new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        }));

        assertEquals(6, minTotalDistance(new int[][]{
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        }));

        assertEquals(4, minTotalDistance(new int[][]{
                {1,0,0,0,1},
                {0,0,0,0,0},
                {0,0,0,0,0}
        }));

        assertEquals(1, minTotalDistance(new int[][]{
                {1,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        }));

        assertEquals(0, minTotalDistance(new int[][]{
                {1,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        }));

        assertEquals(0, minTotalDistance(new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        }));
    }
}