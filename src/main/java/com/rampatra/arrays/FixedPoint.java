package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/8/15
 * @time: 11:34 PM
 */
public class FixedPoint {

    /**
     * Finds the FIXED POINT in an array {@param a} of n distinct integers sorted
     * in ascending order. If there is no fixed point it returns -1.
     * FIXED POINT in an array is an index i such that arr[i] is equal to i. Note that
     * integers in array can be negative.
     *
     * @param a
     * @return
     */
    public static int findFixedPoint(int[] a) {
        int low = 0, high = a.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == mid) {
                return mid;
            } else if (a[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findFixedPoint(new int[]{-10, -5, 0, 3, 7}));
        System.out.println(findFixedPoint(new int[]{0, 2, 5, 8, 17}));
        System.out.println(findFixedPoint(new int[]{-10, -5, 3, 4, 7, 9}));
    }
}
