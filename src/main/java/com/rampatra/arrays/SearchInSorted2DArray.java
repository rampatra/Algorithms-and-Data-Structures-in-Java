package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/23/15
 * @time: 10:31 PM
 */
public class SearchInSorted2DArray {

    /**
     * Searches {@param value} in a SQUARE sized 2-D array {@param a} which is sorted
     * both row wise and column wise.
     * <p/>
     * Time complexity:
     * T(n) = T(n) + T(n-1) + T(n-2) + .... + T(1)
     * T(n) = n(n+1)/2
     * T(n) = O(n^2) where n is size of 2-D array.
     * <p/>
     * Explanation:
     * Linearly searches across rows and columns until the element is found or till the last element. If
     * the element is not found in the 1st row or 1st column then we search in 2nd row and 2nd column
     * and so on.
     *
     * @param a
     * @param i
     * @param j
     * @param value
     * @return an array consisting of co-ordinates if {@param value} is found otherwise {@code new int[]{-1, -1}}.
     */
    public static int[] linearSearchNaive(int[][] a, int i, int j, int value) {
        for (int x = i; x < a.length && (a[i][x] <= value || a[x][j] <= value); x++) {
            if (a[i][x] == value) {
                return new int[]{i, x};
            } else if (a[x][j] == value) {
                return new int[]{x, j};
            }
        }

        if (i < a.length - 1) {
            return linearSearchNaive(a, i + 1, j + 1, value);
        } else {
            return new int[]{-1, -1};
        }
    }

    /**
     * More efficient way to search in a 2-D array sorted both row wise and column wise.
     * <p/>
     * Explanation:
     * We start from top right corner (we can also start from bottom left corner) and move left if current
     * element is greater than the value to be searched and bottom if current element is
     * smaller than the value to be searched.
     * <p/>
     * Time complexity: O(m+n) where m = no. of rows, n = no. of columns
     *
     * @return
     * @link http://articles.leetcode.com/2010/10/searching-2d-sorted-matrix-part-ii.html
     */
    public static int[] linearSearch(int[][] a, int value) {
        int i = 0, j = a[0].length - 1; // start from top right corner

        while (i < a.length && j >= 0) {
            if (a[i][j] == value) {
                return new int[]{i, j};
            } else if (a[i][j] > value) {
                j--; // move left
            } else {
                i++; // move down
            }
        }

        return new int[]{-1, -1};

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
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 1)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 2)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 3)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 4)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 5)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 6)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 7)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 8)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 9)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 10)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 11)));
        System.out.println(Arrays.toString(linearSearchNaive(ar, 0, 0, 12)));
        System.out.println("============");
        System.out.println(Arrays.toString(linearSearch(ar, 1)));
        System.out.println(Arrays.toString(linearSearch(ar, 2)));
        System.out.println(Arrays.toString(linearSearch(ar, 3)));
        System.out.println(Arrays.toString(linearSearch(ar, 4)));
        System.out.println(Arrays.toString(linearSearch(ar, 5)));
        System.out.println(Arrays.toString(linearSearch(ar, 6)));
        System.out.println(Arrays.toString(linearSearch(ar, 7)));
        System.out.println(Arrays.toString(linearSearch(ar, 8)));
        System.out.println(Arrays.toString(linearSearch(ar, 9)));
        System.out.println(Arrays.toString(linearSearch(ar, 10)));
        System.out.println(Arrays.toString(linearSearch(ar, 11)));
        System.out.println(Arrays.toString(linearSearch(ar, 12)));
    }
}
