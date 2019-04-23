package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/rotate-array/
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