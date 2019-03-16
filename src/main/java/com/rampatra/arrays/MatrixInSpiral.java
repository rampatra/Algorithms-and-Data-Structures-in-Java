package com.rampatra.arrays;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/9/15
 * @time: 2:55 PM
 */
public class MatrixInSpiral {

    /**
     * Prints a 2D array {@param a} in spiral form (clockwise).
     *
     * @param a
     */
    public static void printMatrixInSpiral(int[][] a) {
        int row = a.length, col = a[0].length;

        // this loop iterates for the entire matrix
        for (int r = row, c = col, x = 0; r >= 0 && c >= 0; r--, c--, x++) {
            /**
             * Below 4 {@code for} loops print the perimeter of a matrix
             */
            // prints the top row
            for (int i = x, j = x; i < r && j < c; j++) {
                out.print(a[i][j] + " ");
            }
            // prints the right most column
            for (int i = x + 1, j = c - 1; i < r; i++) {
                out.print(a[i][j] + " ");
            }
            // prints the bottom row
            for (int i = r - 1, j = c - 2; i > x && j >= x; j--) {
                out.print(a[i][j] + " ");
            }
            // prints the left most column
            for (int i = r - 2, j = x; i > x; i--) {
                out.print(a[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        printMatrixInSpiral(new int[][]{{1}, {2}});
        out.println();
        printMatrixInSpiral(new int[][]{{1, 2}, {3, 4}});
        out.println();
        printMatrixInSpiral(new int[][]{{1, 2, 3}, {4, 5, 6}});
        out.println();
        printMatrixInSpiral(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        out.println();
        printMatrixInSpiral(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        out.println();
        printMatrixInSpiral(new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}});
        out.println();
        printMatrixInSpiral(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8}, {9, 10, 11, 12, 13, 14, 15, 16}});
    }
}
