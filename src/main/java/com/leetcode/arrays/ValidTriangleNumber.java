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
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 *
 * @author rampatra
 * @since 2019-08-07
 */
public class ValidTriangleNumber {

    public static int triangleNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int noOfTriangles = 0;

        Arrays.sort(nums);

        // todo

        return noOfTriangles;
    }

    public static void main(String[] args) {
        assertEquals(3, triangleNumber(new int[]{2, 2, 3, 4}));
    }
}
