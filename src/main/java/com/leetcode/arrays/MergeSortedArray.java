package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Level: Easy
 * Link: https://leetcode.com/problems/merge-sorted-array/
 * Description:
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 * additional elements from nums2.
 *
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 *
 * @author rampatra
 * @since 2019-04-26
 */
public class MergeSortedArray {

    /**
     * Time complexity: O(m*n)
     * Runtime: <a href="https://leetcode.com/submissions/detail/225075693/">1 ms</a>.
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeSimple(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;

        for (int j = 0; j < n; j++) {
            // find the index where the element from nums2 need to be inserted
            while (i < m + j && nums1[i] < nums2[j]) {
                i++;
            }
            // copy elements from i+1th position to one position right
            for (int k = m + j; k > i; k--) { // note: replacing this with System.arraycopy() gives a 0 ms runtime
                nums1[k] = nums1[k - 1];
            }
            nums1[i] = nums2[j];
        }
    }

    /**
     * Time complexity: O(m+n)
     * Runtime: <a href="https://leetcode.com/submissions/detail/225078165/">0 ms</a>.
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= 0; i--) {
            if (m == 0) {
                nums1[i] = nums2[--n];
            } else if (n == 0) { // we ran out of nums2 elements so there is nothing left to merge
                return;
            } else if (nums1[m - 1] > nums2[n - 1]) { 
                nums1[i] = nums1[--m];
            } else {
                nums1[i] = nums2[--n];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{4, 5, 6, 0, 0, 0};
        nums2 = new int[]{1, 2, 3};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}