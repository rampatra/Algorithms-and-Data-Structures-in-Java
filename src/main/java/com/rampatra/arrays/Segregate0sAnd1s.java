package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/31/15
 * @time: 5:13 PM
 */
public class Segregate0sAnd1s {

    /**
     * Segregate 0s and 1s by traversing the array only once.
     *
     * @param a
     */
    public static void segregate0sAnd1s(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            if (a[i] > a[j]) {
                // swap if a[i] > a[j]
                a[i] = a[i] + a[j];
                a[j] = a[i] - a[j];
                a[i] = a[i] - a[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] ar = new int[]{0, 1, 1, 1, 0, 0, 1};
        segregate0sAnd1s(ar);
        System.out.println(Arrays.toString(ar));
    }
}
