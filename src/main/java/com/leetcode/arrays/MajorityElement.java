package com.leetcode.arrays;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/majority-element/
 * Problem Description:
 * Given an array of size n, find the majority element. The majority element is the element
 * that appears more than ⌊ n/2 ⌋ times. You may assume that the array is non-empty and the
 * majority element always exist in the array.
 *
 * @author rampatra
 * @since 2019-04-27
 */
public class MajorityElement {

    /**
     * Time complexity: O(n)
     * Runtime: <a href="https://leetcode.com/submissions/detail/225285480/">1 ms</a>.
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count = 1;
        int majElem = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count <= 0) {
                majElem = nums[i];
                count = 0;
            }
            if (majElem == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return majElem;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{10, 9, 9, 9, 10}));
        System.out.println(majorityElement(new int[]{2, 3, 2, 2, 3, 2}));
        System.out.println(majorityElement(new int[]{2, 3, 2, 2, 2, 3}));
    }
}
