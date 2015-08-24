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

    /**
     * Searches {@param value} in a square sized 2-D array {@param a} which is sorted
     * both row wise and column wise.
     * <p/>
     * Time complexity: O(n) where n is size of 2-D array.
     *
     * @param a
     * @param i
     * @param j
     * @param value
     * @return
     */
    public static int[] search(int[][] a, int i, int j, int value) {
        for (int x = 0; x < a.length; x++) {
            if (a[i][x] == value) {
                return new int[]{i, x};
            } else if (a[x][j] == value) {
                return new int[]{x, j};
            }
        }

        if (i < a.length - 1) {
            return search(a, i + 1, j + 1, value);
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
        System.out.println(Arrays.toString(search(ar, 0, 0, 1)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 2)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 3)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 4)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 5)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 6)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 7)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 8)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 9)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 10)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 11)));
        System.out.println(Arrays.toString(search(ar, 0, 0, 12)));
    }
}
