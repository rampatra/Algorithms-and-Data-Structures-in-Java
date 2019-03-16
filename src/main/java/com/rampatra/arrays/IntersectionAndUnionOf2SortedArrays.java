package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/13/15
 * @time: 3:56 PM
 */
public class IntersectionAndUnionOf2SortedArrays {

    /**
     * Returns a 2-D array consisting of intersection and union of
     * two sorted arrays {@param a} and {@param b} respectively.
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] getIntersectionAndUnionOf2SortedArrays(int[] a, int[] b) {
        int length = a.length + b.length, x = 0, y = 0;
        int[] intersection = new int[length], union = new int[length];

        for (int i = 0, j = 0; i < a.length || j < b.length; ) {

            // if either of the arrays runs out first
            if (i == a.length) {
                union[y++] = b[j++];
                continue;
            }
            if (j == b.length) {
                union[y++] = a[i++];
                continue;
            }

            if (a[i] < b[j]) {
                union[y++] = a[i++];
            } else if (a[i] > b[j]) {
                union[y++] = b[j++];
            } else {
                intersection[x++] = a[i];
                union[y++] = a[i];
                i++;
                j++;
            }
        }

        return new int[][]{intersection, union};
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{2, 3, 4, 5, 6, 7, 8};
        int[] a2 = new int[]{6, 7, 8, 10, 12, 14, 16};
        int[][] result = getIntersectionAndUnionOf2SortedArrays(a1, a2);
        // intersection
        System.out.println(Arrays.toString(result[0]));
        // union
        System.out.println(Arrays.toString(result[1]));
    }
}
