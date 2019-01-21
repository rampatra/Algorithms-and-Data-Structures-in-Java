package com.ctci.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row
 * and column are set to 0.
 *
 * @author rampatra
 * @since 2019-01-20
 */
public class ZeroMatrix {

    private static void zeroMatrix(int[][] matrix) {
        // keep count of which rows and columns have a number zero
        List<Integer> rowsToZero = new ArrayList<>();
        List<Integer> colsToZero = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsToZero.add(i);
                    colsToZero.add(j);
                }
            }
        }

        makeRowColumnZero(matrix, rowsToZero, colsToZero);
    }

    private static void makeRowColumnZero(int[][] matrix, List<Integer> rows, List<Integer> cols) {
        for (int row : rows) {
            // make entire row zero
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[row][c] = 0;
            }
        }
        for (int col : cols) {
            // make entire column zero
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][col] = 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if (j + 1 >= matrix[0].length) {
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        printMatrix(m);
        zeroMatrix(m);
        System.out.println("---");
        printMatrix(m);
        System.out.println("---");
        m = new int[][]{{1, 0, 2}, {3, 4, 5}, {6, 7, 8}};
        printMatrix(m);
        zeroMatrix(m);
        System.out.println("---");
        printMatrix(m);
        System.out.println("---");
        m = new int[][]{{1, 2, 0}, {3, 4, 5}, {6, 7, 8}};
        printMatrix(m);
        zeroMatrix(m);
        System.out.println("---");
        printMatrix(m);
        System.out.println("---");
    }
}
