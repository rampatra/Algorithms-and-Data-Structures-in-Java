package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 5/28/15
 * @time: 12:44 PM
 */
public class LargestSumContiguousSubArray {

    /**
     * Based on Kadane's Algorithm. Doesn't work when all
     * elements in array {@param a} are negative.
     *
     * @param a
     * @return
     */
    public static int getLargestSumOfContiguousSubArray(int[] a) {
        int maxSum = 0, maxSumTillIndex = 0;

        for (int i = 0; i < a.length; i++) {
            maxSumTillIndex += a[i]; // keep on adding elements
            if (maxSumTillIndex < 0) {
                maxSumTillIndex = 0; // once the sum is less than 0 restart adding elements from next index
            } else if (maxSumTillIndex > maxSum) {
                maxSum = maxSumTillIndex;
            }
        }
        return maxSum;
    }

    /**
     * Below algorithm works even when all elements in array {@param a} are negative.
     *
     * @param a
     * @return
     */
    public static int getLargestSumOfContiguousSubArrayWhenAllNosNegative(int[] a) {
        int maxSum = a[0], maxSumTillIndex = a[0];

        for (int i = 1; i < a.length; i++) {
            maxSumTillIndex = Math.max(a[i], maxSumTillIndex + a[i]);
            maxSum = Math.max(maxSum, maxSumTillIndex);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(getLargestSumOfContiguousSubArray(new int[]{-2, 1, -3, 4, 5, -1, 4}));
        System.out.println(getLargestSumOfContiguousSubArray(new int[]{2, -1, -3, 4, -5, 1, 4}));
        // kadane's algorithm doesn't work if all no.s are -ve
        System.out.println(getLargestSumOfContiguousSubArray(new int[]{-2, -1, -3, -4, -5, -1, -4}));

        System.out.println(getLargestSumOfContiguousSubArrayWhenAllNosNegative(new int[]{-2, 1, -3, 4, 5, -1, 4}));
        System.out.println(getLargestSumOfContiguousSubArrayWhenAllNosNegative(new int[]{2, -1, -3, 4, -5, 1, 4}));
        System.out.println(getLargestSumOfContiguousSubArrayWhenAllNosNegative(new int[]{-2, -1, -3, -4, -5, -1, -4}));
    }
}
