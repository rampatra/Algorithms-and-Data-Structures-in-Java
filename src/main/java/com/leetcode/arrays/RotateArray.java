package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Level: Easy
 * Link: https://leetcode.com/problems/rotate-array/
 * Description:
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * @author rampatra
 * @since 2019-04-20
 */
public class RotateArray {

    /**
     * Time complexity: O(n)
     * where,
     * n = no. of elements in the array
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/224425565/">0 ms</a>.
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {

        if (k > nums.length) {
            k = k % nums.length;
        }
        
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }

    private static void reverse(int[] nums, int start, int end) {
        int temp;
        for (int i = start, j = end - 1; i < j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        // normal case
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));

        // edge cases
        arr = new int[]{1, 2};
        System.out.println(Arrays.toString(arr));
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr)); // should be [1, 2]

        arr = new int[]{1, 2};
        System.out.println(Arrays.toString(arr));
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr)); // should be [2, 1]

        arr = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(arr));
        rotate(arr, 4);
        System.out.println(Arrays.toString(arr)); // should be [3, 1, 2]

        arr = new int[]{1};
        System.out.println(Arrays.toString(arr));
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}