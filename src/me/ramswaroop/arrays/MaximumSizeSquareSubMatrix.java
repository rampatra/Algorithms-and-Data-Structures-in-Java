package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/4/15
 * @time: 11:48 PM
 */
public class MaximumSizeSquareSubMatrix {

    public static void printMaximumSizeSquareSubMatrix(int[][] a) {
        int size = a[0].length; // no. of rows/columns
        int maxI = 0, maxJ = 0, maxSubMatrixSize = 0;
        int[][] auxMatrix = new int[size][size];

        for (int i = 0, j = 0; j < size; j++) {
            auxMatrix[i][j] = a[i][j];
        }

        for (int i = 0, j = 0; i < size; i++) {
            auxMatrix[i][j] = a[i][j];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (a[i][j] == 1) {
                    auxMatrix[i][j] = Math.min(Math.min(auxMatrix[i - 1][j], auxMatrix[i][j - 1]), auxMatrix[i - 1][j - 1]) + 1;
                } else {
                    auxMatrix[i][j] = 0;
                }

                if (auxMatrix[i][j] > maxSubMatrixSize) {
                    maxSubMatrixSize = auxMatrix[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        for (int i = maxI; i > maxI - maxSubMatrixSize; i--) {
            for (int j = maxJ; j > maxJ - maxSubMatrixSize; j--) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String a[]) {
        int[][] ar = new int[][]{{0, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 0, 0, 1},
                {1, 0, 0, 1}};
        printMaximumSizeSquareSubMatrix(ar);
        int[][] ar1 = new int[][]{{0, 1, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0}};
        printMaximumSizeSquareSubMatrix(ar1);
    }
}
