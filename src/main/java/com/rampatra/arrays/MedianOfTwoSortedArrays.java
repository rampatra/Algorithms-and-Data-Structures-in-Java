package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/27/15
 * @time: 5:50 PM
 */
public class MedianOfTwoSortedArrays {

    /**
     * Returns the median of a sorted array {@param a}.
     *
     * @param a
     * @return
     */
    public static int median(int a[]) {
        int l = a.length;
        if (l % 2 == 0) {
            return (a[l / 2] + a[l / 2 - 1]) / 2;
        } else {
            return a[l / 2];
        }
    }

    /**
     * Returns the median of two sorted arrays {@param a1} and {@param a2} having same length.
     * In case of any error, it returns {@code -1}.
     * <p/>
     * Example:
     * <p/>
     * <p/>
     * ar1[] = {1, 12, 15, 26, 38}
     * ar2[] = {2, 13, 17, 30, 45}
     * For above two arrays m1 = 15 and m2 = 17
     * <p/>
     * For the above ar1[] and ar2[], m1 is smaller than m2. So median is present in one of
     * the following two sub-arrays:
     * <p/>
     * [15, 26, 38] and [2, 13, 17]
     * Let us repeat the process for above two sub-arrays:
     * <p/>
     * m1 = 26 m2 = 13.
     * m1 is greater than m2. So the sub-arrays become
     * <p/>
     * [15, 26] and [13, 17]
     * Now size is 2, so median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
     * = (max(15, 13) + min(26, 17))/2
     * = (15 + 17)/2
     * = 16
     *
     * @param a1
     * @param a2
     * @return
     */
    public static int median(int[] a1, int[] a2) {

        int l1 = a1.length, l2 = a2.length, m1, m2;

        if (l1 != l2 || l1 <= 0) {
            return -1;
        }

        if (l1 == 1) {
            return (a1[0] + a2[0]) / 2;
        }

        if (l1 == 2) {
            return (Math.max(a1[0], a2[0]) + Math.min(a1[1], a2[1])) / 2;
        }

        m1 = median(a1);
        m2 = median(a2);

        if (m1 == m2) {
            return m1;
        }

        if (m1 < m2) { // median exists in a1[m1....] and a2[....m2]
            if (l1 % 2 == 0) {
                return median(Arrays.copyOfRange(a1, l1 / 2 - 1, l1), Arrays.copyOfRange(a2, 0, l2 / 2 + 1));
            } else {
                return median(Arrays.copyOfRange(a1, l1 / 2, l1), Arrays.copyOfRange(a2, 0, l2 / 2 + 1));
            }
        } else {
            if (l1 % 2 == 0) { // median exists in a1[....m1] and a2 [m2....]
                return median(Arrays.copyOfRange(a1, 0, l1 / 2 + 1), Arrays.copyOfRange(a2, l2 / 2 - 1, l2));
            } else {
                return median(Arrays.copyOfRange(a1, 0, l1 / 2 + 1), Arrays.copyOfRange(a2, l2 / 2, l2));
            }
        }
    }

    public static void main(String[] args) {
        // test cases
        System.out.println(median(new int[]{1, 2, 3, 6}, new int[]{4, 6, 8, 9}));
        System.out.println(median(new int[]{4, 6, 8, 9}, new int[]{1, 2, 3, 6}));
        System.out.println(median(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(median(new int[]{2, 2}, new int[]{2, 2}));
    }
}
