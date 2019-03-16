package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/31/15
 * @time: 3:16 PM
 */
public class MaxMinWithMinComparisons {

    /**
     * Finds the minimum and maximum number in array {@param a}
     * with minimum no. of comparisons.
     * <p/>
     * If length of array is even:
     * No. of comparisons = 1+3*(n-2)/2
     * and if length is odd:
     * No. of comparisons = 3*(n-1)/2
     *
     * @param a
     * @return
     */
    public static int[] getMaxMinWithMinComparisons(int[] a) {
        int min, max, i;

        if (a.length % 2 == 0) { // this is not a comparison
            if (a[0] < a[1]) { // this is a comparison
                min = a[0];
                max = a[1];
            } else {
                min = a[1];
                max = a[0];
            }
            i = 2;
        } else {
            min = max = a[0];
            i = 1;
        }

        for (; i < a.length - 1; i += 2) {
            if (a[i] < a[i + 1]) { // 1st comparison
                if (a[i] < min) min = a[i]; // 2nd comparison
                if (a[i + 1] > max) max = a[i + 1]; // 3rd comparison
            } else {
                if (a[i] > max) max = a[i]; // 2nd comparison
                if (a[i + 1] < min) min = a[i + 1]; // 3rd comparison
            }
        }

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaxMinWithMinComparisons(new int[]{2, 5, 1, 6, 7, 9, 0, 8, 10})));
    }
}
