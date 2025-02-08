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
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
       
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{10, 9, 9, 9, 10}));
        System.out.println(majorityElement(new int[]{2, 3, 2, 2, 3, 2}));
        System.out.println(majorityElement(new int[]{2, 3, 2, 2, 2, 3}));
    }
}
