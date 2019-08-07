package com.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/number-of-islands/
 * Description:
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
 * are all surrounded by water.
 * <p>
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 * <p>
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 *
 * @author rampatra
 * @since 2019-08-07
 */
public class NumberOfIslands {

    /**
     * The idea is simple and straightforward. Once we encounter land ('1' in grid) we drown the island or change the
     * neighboring '1's to '0's. Therefore, the number of '1's we encounter, we can say that we have that many islands.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: <a href="https://leetcode.com/submissions/detail/249754904/">1 ms</a>.
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    drownTheIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void drownTheIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        drownTheIsland(grid, i, j + 1);
        drownTheIsland(grid, i, j - 1);
        drownTheIsland(grid, i + 1, j);
        drownTheIsland(grid, i - 1, j);
    }

    public static void main(String[] args) {
        assertEquals(1, numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));

        assertEquals(2, numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'}
        }));

        assertEquals(1, numIslands(new char[][]{
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        }));

        assertEquals(1, numIslands(new char[][]{
                {'1'}
        }));

        assertEquals(0, numIslands(new char[][]{
                {'0'}
        }));

        assertEquals(0, numIslands(new char[][]{
                {}
        }));
    }
}