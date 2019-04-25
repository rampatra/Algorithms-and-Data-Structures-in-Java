package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Problem Description:
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * <p>
 * Given nums = [1,1,2]
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * <p>
 * NOTE: It doesn't matter what you leave beyond the returned length.
 *
 * @author rampatra
 * @since 2019-04-24
 */
public class RemoveDuplicates {

    /**
     * This removes the duplicates from the array in-place.
     * <p>
     * Time complexity: O(n)
     * where,
     * n = no. of elements in the array
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/224719750/">1 ms</a>.
     *
     * @param nums
     * @return
     */
    public static int removeDuplicatesInSortedArray(int[] nums) {
        int insertIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++insertIndex] = nums[i];
            }
        }

        return insertIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        System.out.println(removeDuplicatesInSortedArray(arr));
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicatesInSortedArray(arr));
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1, 2, 3, 4, 5};
        System.out.println(removeDuplicatesInSortedArray(arr));
        System.out.println(Arrays.toString(arr));
    }
}