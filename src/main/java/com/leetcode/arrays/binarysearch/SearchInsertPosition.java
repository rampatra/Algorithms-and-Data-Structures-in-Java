package com.leetcode.arrays.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Easy
 * Link: https://leetcode.com/problems/search-insert-position/
 * Description:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 * <p>
 * Similar question: {@link SmallestLetterGreaterThanTarget}.
 *
 * @author rampatra
 * @since 2019-08-19
 */
public class SearchInsertPosition {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/253066747/">0 ms</a>.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        assertEquals(2, searchInsert(new int[]{1, 2}, 3));
        assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}