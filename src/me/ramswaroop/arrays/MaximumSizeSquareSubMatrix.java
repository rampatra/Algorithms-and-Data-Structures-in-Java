package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/4/15
 * @time: 11:48 PM
 */
public class MaximumSizeSquareSubMatrix {

    public static int[][] getMaximumSizeSquareSubMatrix(int[][] a) {
        int size = a[0].length; // no. of rows/columns
        int k;
        int[][] subMatrix;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (a[i][j] == a[j][i] && a[i][j] == 1) {
                }
            }
        }

        return subMatrix;
    }

    public static void main(String a[]) {

    }
}
