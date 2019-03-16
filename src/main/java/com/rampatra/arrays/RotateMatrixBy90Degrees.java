package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/22/15
 * @time: 4:03 PM
 */
public class RotateMatrixBy90Degrees {

    /**
     * Rotates a 2-D array by 90 degrees clockwise.
     * <p/>
     * The algorithm is simple:
     * 1st row = last column
     * 2nd row = 2nd last column
     * and so on...
     *
     * @param a
     * @return
     */
    public static int[][] rotateMatrixBy90DegreesRight(int[][] a) {
        int rows = a.length, columns = a[0].length;
        int[][] rotatedMatrix = new int[columns][rows];

        for (int i = 0; --rows >= 0 && i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                rotatedMatrix[j][rows] = a[i][j];
            }
        }

        return rotatedMatrix;
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
        int[][] ar = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print2DMatrix(ar);
        System.out.println("--------");
        print2DMatrix(rotateMatrixBy90DegreesRight(ar));

        System.out.println("========");

        ar = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 5, 7}};
        print2DMatrix(ar);
        System.out.println("--------");
        print2DMatrix(rotateMatrixBy90DegreesRight(ar));
    }
}
