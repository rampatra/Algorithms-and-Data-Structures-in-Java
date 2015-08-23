package me.ramswaroop.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/23/15
 * @time: 10:31 PM
 */
public class SearchInSorted2DArray {

    public static int[] search(int[][] a, int i, int j, int value) {

        if (i == a.length && j == a[0].length && i == j && a[i][j] != value) {
            return new int[]{-1, -1};
        }

        if (a[i][j] == value) {
            return new int[]{i, j};
        } else if (a[i][j] < value && j < a[0].length - 1 && a[i][j + 1] <= value) {
            return search(a, i, j + 1, value);
        } else if (a[i][j] < value && i < a.length - 1 && a[i + 1][j] <= value) {
            return search(a, i + 1, j, value);
        } else if (a[i][j] > value && i > 0) {
            return search(a, i - 1, j, value);
        } else {
            return new int[]{-1, -1};
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

    public static void main(String a[]) {
        int[][] ar = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print2DMatrix(ar);
        System.out.println(Arrays.toString(search(ar, 0, 0, 4)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 6)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 1)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 8)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 9)));
    }
}
