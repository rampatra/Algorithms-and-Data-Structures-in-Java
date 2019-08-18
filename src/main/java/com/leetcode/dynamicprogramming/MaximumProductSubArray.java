package com.leetcode.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/maximum-product-subarray/
 * Description:
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which
 * has the largest product.
 * <p>
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * <p>
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @author rampatra
 * @since 2019-08-18
 */
public class MaximumProductSubArray {

    /**
     * The approach is similar to {@link MaximumSubArray} where we update maxUntilIndex only if multiplying the current
     * number to the product of of all numbers until index produces a larger product and if not make maxUntilIndex the
     * current number. The only twist here is that we keep two such variables, one for max and one for min, and that's
     * because the product of two negatives gives us a positive number.
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/252751578/">1 ms</a>.
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int maxUntilIndex = nums[0];
        int minUntilIndex = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxUntilIndex = Math.max(nums[i], maxUntilIndex * nums[i]);
                minUntilIndex = Math.min(nums[i], minUntilIndex * nums[i]);
            } else {
                int prevMaxUntilIndex = maxUntilIndex;
                maxUntilIndex = Math.max(nums[i], minUntilIndex * nums[i]); // when current number is -ve then multiply with minUntilIndex to get the max as product of two negatives is a positive
                minUntilIndex = Math.min(nums[i], prevMaxUntilIndex * nums[i]);
            }

            maxProd = Math.max(maxProd, maxUntilIndex);
        }

        return maxProd;
    }

    public static void main(String[] args) {
        assertEquals(24, maxProduct(new int[]{-2, 3, -4}));
    }
}