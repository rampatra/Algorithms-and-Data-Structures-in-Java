package com.rampatra.arrays;

import com.rampatra.sorting.QuickSort;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/4/15
 * @time: 11:28 PM
 */
public class SubsetOfArray {

    /**
     * Determines if array {@param b} is a subset of array {@param a}.
     * <p/>
     * Explanation: The below method uses sorting + merge method of merge sort. Time
     * complexity is O(mlogm + nlogn) where m and n are lengths of array a and b resp.
     * You could also have used sorting + binary search but this fails when array
     * {@param b} has repeating elements for example, a={1,4,2} and b={1,4,4,2}. Time
     * complexity would be O(mlogm + nlogm).
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isSubsetOfArray(int[] a, int[] b) {

        QuickSort.quickSort(a);
        QuickSort.quickSort(b);

        int i, j;
        for (i = 0, j = 0; i < a.length && j < b.length; ) {
            if (a[i] > b[j]) {
                return false;
            } else if (a[i] == b[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (i < b.length) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isSubsetOfArray(new int[]{11, 1, 13, 21, 3, 7}, new int[]{11, 3, 7, 1}));
        System.out.println(isSubsetOfArray(new int[]{1, 2, 2, 3, 4, 5, 6}, new int[]{1, 2, 4}));
        System.out.println(isSubsetOfArray(new int[]{1, 2, 2, 3, 4, 5, 6}, new int[]{1, 2, 2, 4}));
        System.out.println(isSubsetOfArray(new int[]{1, 4, 2}, new int[]{1, 4, 4, 2}));
    }
}
