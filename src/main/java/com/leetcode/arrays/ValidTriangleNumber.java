package com.leetcode.arrays;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/valid-triangle-number/
 * Problem Description:
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array
 * that can make triangles if we take them as side lengths of a triangle.
 * <p>
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * <p>
 * Note:
 * - The length of the given array won't exceed 1000.
 * - The integers in the given array are in the range of [0, 1000].
 * - Triangle Property: Sum of any 2 sides must be greater than the 3rd side.
 *
 * @author rampatra
 * @since 2019-08-07
 */
public class ValidTriangleNumber {

    /**
     * Time complexity : O(n^2 log n). In worst case, the inner loop will take n log n (binary search applied n times).
     * Space complexity : O(log n). Sorting takes O(log n) space.
     * Runtime: <a href="https://leetcode.com/submissions/detail/250225175/">13 ms</a>.
     *
     * @param nums
     * @return
     */
    public static int triangleNumberUsingBinarySearch(int[] nums) {
        int noOfTriangles = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                if (k - j - 1 > 0) {
                    noOfTriangles += k - j - 1;
                }
            }
        }

        return noOfTriangles;
    }

    private static int binarySearch(int[] nums, int low, int high, int num) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    /**
     * The concept is simple. For each pair (i,j), find the value of k such that nums[i] + nums[j] > nums[k] (as per
     * triangle property). Once we find k then we can form k- j - 1 triangles.
     *
     * Time Complexity: O(n^2) Loop of k and j will be executed O(n^2) times in total, because, we do
     * not reinitialize the value of k for a new value of j chosen(for the same i). Thus, the complexity
     * will be O(n^2 + n^2) = O(n^2).
     * Space Complexity: O(log n). Sorting takes O(log n) space.
     * Runtime: <a href="https://leetcode.com/submissions/detail/250239099/">5 ms</a>.
     *
     * @param nums
     * @return
     */
    public static int triangleNumber(int[] nums) {
        int noOfTriangles = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                if (k - j - 1 > 0) {
                    noOfTriangles += k - j - 1;
                }
            }
        }

        return noOfTriangles;
    }

    public static void main(String[] args) {
        assertEquals(0, triangleNumberUsingBinarySearch(new int[]{}));
        assertEquals(0, triangleNumberUsingBinarySearch(new int[]{1}));
        assertEquals(3, triangleNumberUsingBinarySearch(new int[]{2, 2, 3, 4}));
        assertEquals(0, triangleNumberUsingBinarySearch(new int[]{0, 1, 0, 1}));
        assertEquals(7, triangleNumberUsingBinarySearch(new int[]{1, 2, 3, 4, 5, 6}));

        assertEquals(0, triangleNumber(new int[]{}));
        assertEquals(0, triangleNumber(new int[]{1}));
        assertEquals(3, triangleNumber(new int[]{2, 2, 3, 4}));
        assertEquals(0, triangleNumber(new int[]{0, 1, 0, 1}));
        assertEquals(7, triangleNumber(new int[]{1, 2, 3, 4, 5, 6}));
    }
}