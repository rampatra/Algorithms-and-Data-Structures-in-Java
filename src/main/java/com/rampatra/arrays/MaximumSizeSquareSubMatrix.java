package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/4/15
 * @time: 11:48 PM
 */
public class MaximumSizeSquareSubMatrix {

    /**
     * Prints the maximum size square sub-matrix in {@param a} with all 1s.
     * <p/>
     * Algorithm:
     * 1) Construct a sum matrix/auxiliary matrix aux[R][C] for the given a[R][C].
     * ...a) Copy first row and first columns as it is from a[][] to aux[][]
     * ...b) For other entries, use following expressions to construct aux[][]
     * ........If a[i][j] is 1 then
     * ........aux[i][j] = min(aux[i][j-1], aux[i-1][j], aux[i-1][j-1]) + 1
     * ........Else
     * ........aux[i][j] = 0
     * 2) Find the maximum entry in aux[R][C]
     * 3) Using the value and coordinates of maximum entry in aux[i], print sub-matrix of a[][]
     *
     * @param a
     */
    public static void printMaximumSizeSquareSubMatrix(int[][] a) {
        int size = a[0].length; // no. of rows/columns
        int maxI = 0, maxJ = 0, maxSubMatrixSize = 0;
        int[][] auxMatrix = new int[size][size];

        // construct auxiliary matrix
        for (int i = 0, j = 0; j < size; j++) { // copy 1st row
            auxMatrix[i][j] = a[i][j];
        }

        for (int i = 0, j = 0; i < size; i++) { // copy 1st column
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

        // print max size sub-matrix in array 'a' from the co-ordinates in auxiliary matrix
        for (int i = maxI; i > maxI - maxSubMatrixSize; i--) {
            for (int j = maxJ; j > maxJ - maxSubMatrixSize; j--) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
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
