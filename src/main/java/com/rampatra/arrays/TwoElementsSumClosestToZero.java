package com.rampatra.arrays;

import com.rampatra.sorting.QuickSort;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/30/15
 * @time: 5:44 PM
 */
public class TwoElementsSumClosestToZero {

    /**
     * An array of integers is given containing both +ve and -ve numbers. You
     * need to find two elements such that their sum is closest to zero.
     *
     * @param a
     * @return
     */
    public static int[] getTwoElementsWhoseSumIsClosestToZero(int[] a) {
        QuickSort.quickSort(a);

        int minDiff = Math.abs(0 - (a[0] + a[a.length - 1])), n1 = a[0], n2 = a[a.length - 1];

        for (int i = 1, j = a.length - 2; i < j; ) {
            if (Math.abs(0 - (a[i] + a[j])) < minDiff) {
                minDiff = Math.abs(0 - (a[i] + a[j]));
                n1 = a[i];
                n2 = a[j];
                i++;
            } else {
                j--;
            }
        }

        return new int[]{n1, n2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTwoElementsWhoseSumIsClosestToZero(new int[]{1, 60, -10, -80, 85, 70})));
        System.out.println(Arrays.toString(getTwoElementsWhoseSumIsClosestToZero(new int[]{-3, -100, -10, -80, 85, 70})));
    }
}
