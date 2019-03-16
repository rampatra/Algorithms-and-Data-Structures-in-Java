package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/1/15
 * @time: 10:21 PM
 */
public class MaxIndexDiff {

    /**
     * Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
     *
     * @param a
     * @return
     */
    public static int maxDiff(int[] a) {
        int maxDiff = -1;
        int[] leftMin = new int[a.length], rightMax = new int[a.length];

        /**
         * leftMin[i] holds the smallest element on left side of arr[i] including arr[i].
         * In other words, leftMin[i] stores the minimum value from (arr[0], arr[1], ... arr[i]).
         */
        leftMin[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(a[i], leftMin[i - 1]);
        }

        /**
         * rightMax[i] holds the greatest element on right side of arr[i] including arr[i].
         * In other words, rightMax[i] stores the maximum value from (arr[i], arr[i+1], ..arr[n-1])
         */
        rightMax[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(a[i], rightMax[i + 1]);
        }

        // traverse both arrays from left to right to find maximum j - i
        for (int i = 0, j = 0; i < a.length && j < a.length; ) {
            if (rightMax[j] > leftMin[i]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}));
        System.out.println(maxDiff(new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0}));
        System.out.println(maxDiff(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(maxDiff(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println(maxDiff(new int[]{10, 11, 12, 13, 14, 6, 9, 7, 5, 3}));
    }
}
