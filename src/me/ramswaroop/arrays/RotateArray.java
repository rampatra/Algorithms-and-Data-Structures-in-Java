package me.ramswaroop.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/28/15
 * @time: 10:53 AM
 */
public class RotateArray {

    /**
     * Naive approach which stores the elements to be shifted in a temp array.
     * Time complexity: O(n)
     * Space complexity: O(k)
     *
     * @param a
     * @param k
     */
    public static void rotate(int[] a, int k) {
        int[] temp = new int[k];
        int i, j;
        // store elements to be shifted in temp array
        for (i = 0; i < k; i++) {
            temp[i] = a[i];
        }
        // shift elements to left
        for (j = 0; i < a.length; i++, j++) {
            a[j] = a[i];
        }
        // move elements to end
        for (i = 0; j < a.length; i++, j++) {
            a[j] = temp[i];
        }
    }

    public static void main(String a[]) {
        int[] ar = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(ar));
        rotate(ar, 2);
        System.out.println(Arrays.toString(ar));
    }
}
