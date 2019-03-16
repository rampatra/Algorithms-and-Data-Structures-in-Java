package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/11/15
 * @time: 3:28 PM
 * @see: http://www.geeksforgeeks.org/a-boolean-matrix-question/
 */
public class BooleanMatrix {

    /**
     * Given a boolean matrix mat[M][N] of size M X N, modify it such that
     * if a matrix cell mat[i][j] is 1 (or true) then make all the cells of
     * ith row and jth column as 1.
     *
     * @param a
     */
    public static void modifyBooleanMatrix(int[][] a) {
        int rowFlag = 0, colFlag = 0;

        // if a[i][j] is 1 then we make a[0][j] 1 and a[i][0] 1
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (a[i][0] == 1) {
                        rowFlag = 1;
                    }
                    if (a[0][j] == 1) {
                        colFlag = 1;
                    }
                } else if (a[i][j] == 1) {
                    a[0][j] = 1;
                    a[i][0] = 1;
                }
            }
        }

        // if a[0][j] is 1 or a[i][0] is 1 then a[i][j] is 1
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if (a[0][j] == 1 || a[i][0] == 1) {
                    a[i][j] = 1;
                }
            }
        }

        if (rowFlag == 1) {
            for (int j = 0; j < a[0].length; j++) {
                a[0][j] = 1;
            }
        }
        if (colFlag == 1) {
            for (int i = 0; i < a.length; i++) {
                a[i][0] = 1;
            }
        }
    }

    private static void print2DMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] ar = new int[][]{{1, 0, 0, 1}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        print2DMatrix(ar);
        modifyBooleanMatrix(ar);
        print2DMatrix(ar);
        System.out.println("-------");
        ar = new int[][]{{1, 0}, {0, 0}};
        print2DMatrix(ar);
        modifyBooleanMatrix(ar);
        print2DMatrix(ar);
    }
}
