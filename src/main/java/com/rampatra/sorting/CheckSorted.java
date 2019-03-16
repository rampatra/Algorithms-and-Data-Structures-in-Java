package com.rampatra.sorting;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/23/15
 * @time: 8:30 AM
 */
public class CheckSorted {

    /**
     * Determines whether array {@param a} is sorted or not.
     * Sort order can be either ascending or descending.
     *
     * @param a
     * @return
     */
    public static boolean isSorted(int[] a) {

        if (a.length == 0) return true;

        int i;
        boolean isAscending;

        // go to index where you find a number different from  
        // previous number (req. to determine sort order)
        for (i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) break;
        }

        // all elements equal or only a single element
        if (i == a.length) {
            return true;
        }

        // determine sort order of array
        if (a[i] > a[i - 1]) {
            isAscending = true;
        } else {
            isAscending = false;
        }

        // check if appropriate sort property is hold for rest of array
        if (isAscending) {
            for (; i < a.length; i++) {
                if (a[i] < a[i - 1]) return false;
            }
        } else {
            for (; i < a.length; i++) {
                if (a[i] > a[i - 1]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1, 2, 3, 4, 5}));
        System.out.println(isSorted(new int[]{5, 4, 3, 2, 1}));
        System.out.println(isSorted(new int[]{}));
        System.out.println(isSorted(new int[]{0}));
        System.out.println(isSorted(new int[]{0, 0, 0, 0, 0, 0}));
        System.out.println(isSorted(new int[]{4, 7, 9, 1, 0}));
    }
}
