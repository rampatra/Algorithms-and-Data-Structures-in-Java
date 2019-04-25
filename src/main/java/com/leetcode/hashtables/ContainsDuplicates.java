package com.leetcode.hashtables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/contains-duplicate/
 *
 * @author rampatra
 * @since 2019-04-24
 */
public class ContainsDuplicates {

    public static boolean containsDuplicates(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (!numSet.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/224724092/">5 ms</a>.
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicatesWithoutSet(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicates(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicates(new int[]{1, 2, 3, 4}));
        
        System.out.println(containsDuplicatesWithoutSet(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicatesWithoutSet(new int[]{1, 2, 3, 4}));
    }
}
