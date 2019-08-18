package com.leetcode.dynamicprogramming;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/maximum-subarray
 *
 * @author rampatra
 * @since 2019-04-26
 */
public class MaximumSubArray {

    /**
     * Time complexity: O(n)
     * Runtime: <a href="https://leetcode.com/submissions/detail/225130466/">0 ms</a>.
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int consecutiveSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            consecutiveSum += nums[i];

            /* if the current number is larger than the summation of all the 
                previous numbers then start from current number */
            if (nums[i] > consecutiveSum) {
                consecutiveSum = nums[i];
            }

            if (consecutiveSum > maxSum) {
                maxSum = consecutiveSum;
            }
        }

        return maxSum;
    }


    /**
     * Divide and Conquer approach.
     * Time complexity: O(n log n). See Master's Theorem to understand how.
     * Runtime: <a href="https://leetcode.com/submissions/detail/225140123/">1 ms</a>.
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayDivideAndConquer(int[] nums) {
        return maxSubArrayDivideAndConquer(nums, 0, nums.length - 1);
    }

    public static int maxSubArrayDivideAndConquer(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = start + (end - start) / 2;
        int leftSASum = maxSubArrayDivideAndConquer(nums, start, mid);
        int rightSASum = maxSubArrayDivideAndConquer(nums, mid + 1, end);

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        // compute consecutive sum from mid towards start
        int sum = 0;
        for (int i = mid; i >= start; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        // compute consecutive sum from mid towards end
        sum = 0;
        for (int i = mid + 1; i <= end; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        // return the max of left sub-array, right sub-array, and the consecutive sum between start and end via mid
        return Math.max(Math.max(leftSASum, rightSASum), leftSum + rightSum);
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{3}));
        System.out.println(maxSubArray(new int[]{-3}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{4, -5, 1, 2, -1, 4, -3, 1, -2}));

        System.out.println("----");

        System.out.println(maxSubArrayDivideAndConquer(new int[]{3}));
        System.out.println(maxSubArrayDivideAndConquer(new int[]{-3}));
        System.out.println(maxSubArrayDivideAndConquer(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArrayDivideAndConquer(new int[]{4, -5, 1, 2, -1, 4, -3, 1, -2}));
    }
}