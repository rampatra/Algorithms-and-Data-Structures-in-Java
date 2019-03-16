package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/27/15
 * @time: 8:40 PM
 */
public class ReverseArray {

    /**
     * Iterative method to reverse the entire array.
     *
     * @param a
     */
    public static void reverse(int[] a) {
        int temp;
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            // swap elements
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /**
     * Recursive method to reverse the array elements from
     * {@param i} index to {@param j} index (both inclusive).
     *
     * @param a
     * @param i
     * @param j
     */
    public static void reverseRecursive(int[] a, int i, int j) {
        if (i > j) return;

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        reverseRecursive(a, ++i, --j);
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(ar));
        reverse(ar);
        System.out.println(Arrays.toString(ar));
        reverseRecursive(ar, 0, ar.length - 1);
        System.out.println(Arrays.toString(ar));
    }
}
