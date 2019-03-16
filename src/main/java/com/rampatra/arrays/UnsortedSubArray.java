package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/20/15
 * @time: 10:31 AM
 */
public class UnsortedSubArray {

    /**
     * Finds the unsorted sub array in array {@param a} such that
     * sorting this sub array makes the entire array sorted.
     * <p/>
     * EXPLANATION:
     * 1) Find the candidate unsorted subarray
     * ...a) Scan from left to right and find the first element which is greater than the next element. Let s be the
     * index of such an element. In the above example 1, s is 3 (index of 30).
     * ...b) Scan from right to left and find the first element (first in right to left order) which is smaller than
     * the next element (next in right to left order). Let e be the index of such an element. In the above example 1,
     * e is 7 (index of 31).
     * 2) Check whether sorting the candidate unsorted subarray makes the complete array sorted or not. If not, then
     * include more elements in the subarray.
     * ...a) Find the minimum and maximum values in arr[s..e]. Let minimum and maximum values be min and max. min and
     * max for [30, 25, 40, 32, 31] are 25 and 40 respectively.
     * ...b) Find the first element (if there is any) in arr[0..s-1] which is greater than min, change s to index of
     * this element. There is no such element in above example 1.
     * ...c) Find the last element (if there is any) in arr[e+1..n-1] which is smaller than max, change e to index of
     * this element. In the above example 1, e is changed to 8 (index of 35)
     * 3) Print s and e.
     *
     * @param a
     * @return
     */
    public static int[] getUnsortedSubArray(int[] a) {
        int start = 0, end = a.length - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] unsortedArray;

        // 1(a)
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                start = i;
                break;
            }
        }

        // 1(b)
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] < a[i - 1]) {
                end = i;
                break;
            }
        }

        // 2(a) - find min and max
        for (int i = start; i <= end; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 2(b)
        for (int i = 0; i < start; i++) {
            if (a[i] > min) {
                start = i;
                break;
            }
        }

        // 2(c)
        for (int i = end + 1; i < a.length; i++) {
            if (a[i] < max) {
                end = i;
                break;
            }
        }

        unsortedArray = new int[end - start + 1];
        for (int i = start, j = 0; i <= end; i++, j++) {
            unsortedArray[j] = a[i];
        }

        return unsortedArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getUnsortedSubArray(new int[]{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60})));
        System.out.println(Arrays.toString(getUnsortedSubArray(new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50})));
        System.out.println(Arrays.toString(getUnsortedSubArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}))); // fully sorted already
    }
}
