package com.leetcode.arrays;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/sparse-matrix-multiplication/
 * Description:
 * Given two sparse matrices A and B, return the result of AB.
 *
 * You may assume that A's column number is equal to B's row number.
 *
 * Example:
 *
 * Input:
 *
 * A = [
 *   [ 1, 0, 0],
 *   [-1, 0, 3]
 * ]
 *
 * B = [
 *   [ 7, 0, 0 ],
 *   [ 0, 0, 0 ],
 *   [ 0, 0, 1 ]
 * ]
 *
 * Output:
 *
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 *
 * @author rampatra
 * @since 2019-08-09
 */
public class SparseMatrixMultiplication {

    /**
     * Time Complexity: O(Arow * Acol * Bcol)
     * Space Complexity: O(Arow * Bcol)
     *
     * @param A
     * @param B
     * @return
     */
    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] AB = new int[A.length][B[0].length];

        for (int Bcol = 0; Bcol < B[0].length; Bcol++) {
            for (int Arow = 0; Arow < A.length; Arow++) {
                int sum = 0;
                for (int Acol = 0; Acol < A[0].length; Acol++) {
                    sum += A[Arow][Acol] * B[Acol][Bcol];
                }
                AB[Arow][Bcol] = sum;
            }
        }

        return AB;
    }

    public static void main(String[] args) {
        assertEquals(Arrays.deepToString(new int[][]{
                {7, 0, 0},
                {-7, 0, 3}
        }), Arrays.deepToString(multiply(new int[][]{
                {1, 0, 0},
                {-1, 0, 3}
        }, new int[][]{
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        })));

        assertEquals(Arrays.deepToString(new int[][]{
                {0}
        }), Arrays.deepToString(multiply(new int[][]{
                {0, 1}
        }, new int[][]{
                {1},
                {0}
        })));
    }
}