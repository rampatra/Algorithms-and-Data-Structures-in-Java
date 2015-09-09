package me.ramswaroop.arrays;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/9/15
 * @time: 2:55 PM
 */
public class MatrixInSpiral {

    public static void printMatrixInSpiral(int[][] a) {
        int row = a.length, col = a[0].length;

        //for (int r = 0, c = col - 1; r < row && c >= 0; r++, c--) {
            for (int i = 0, j = 0; j < col; j++) {
                out.print(a[i][j]);
            }
            for (int i = 1, j = col - 1; i < row; i++) {
                out.print(a[i][j]);
            }
            for (int i = row - 1, j = col - 2; j >= 0; j--) {
                out.print(a[i][j]);
            }
            for (int i = row - 2, j = 0; i > 0; i--) {
                out.print(a[i][j]);
            }
        //}
    }

    public static void main(String a[]) {
        printMatrixInSpiral(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        out.println();
        printMatrixInSpiral(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }
}
