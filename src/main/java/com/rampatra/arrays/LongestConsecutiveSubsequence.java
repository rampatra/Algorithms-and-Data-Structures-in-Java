package com.rampatra.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rampatra
 * @since 25/11/2018
 */
public class LongestConsecutiveSubsequence {

    /**
     * Given an array of distinct integers, find the length of the longest sub-sequence such that
     * elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
     * <p>
     * Examples:
     * Input: arr[] = {1, 9, 3, 10, 4, 20, 2};
     * Output: 4
     * The subsequence {1, 3, 4, 2} is the longest subsequence
     * of consecutive elements
     * <p>
     * Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
     * Output: 5
     * The subsequence {36, 35, 33, 34, 32} is the longest subsequence
     * of consecutive elements.
     * <p>
     * NOTE: You can also sort this array and check for consecutive elements. You can take this approach if interviewer
     * asks to solve with no additional space but do bear in mind that some sorting algorithms do require extra space.
     *
     * @param arr unsorted array of non-repeating integers
     * @return the length of the longest consecutive subsequence
     */
    private static int findLengthOfLongestConsecutiveSubsequence(int[] arr) {
        int longestSubseqCount = 0;
        int subseqCount;
        int currElem;
        // add all numbers to a set to have O(1) time complexity for searching elements
        Set<Integer> numSet = new HashSet<>();
        for (int n : arr) {
            numSet.add(n);
        }

        for (int n : arr) {
            subseqCount = 1;
            currElem = n;
            // check for the next consecutive elements
            while (numSet.contains(currElem + 1)) {
                numSet.remove(currElem);
                numSet.remove(currElem + 1);
                currElem++;
                subseqCount++;
            }
            // check for the previous consecutive elements
            while (numSet.contains(currElem - 1)) {
                numSet.remove(currElem);
                numSet.remove(currElem - 1);
                currElem--;
                subseqCount++;
            }
            // update longest counter if the length of the current subsequence is larger
            if (subseqCount > longestSubseqCount) {
                longestSubseqCount = subseqCount;
            }
        }
        return longestSubseqCount;
    }

    public static void main(String[] args) {

        System.out.println("{1, 9, 3, 10, 4, 20, 2}: " +
                findLengthOfLongestConsecutiveSubsequence(new int[]{1, 9, 3, 10, 4, 20, 2}));
        System.out.println("{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}: " +
                findLengthOfLongestConsecutiveSubsequence(new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}));
        System.out.println("{1,5,8,3}: " + findLengthOfLongestConsecutiveSubsequence(new int[]{1, 5, 8, 3}));

        // corner cases
        System.out.println("{1}: " + findLengthOfLongestConsecutiveSubsequence(new int[]{1}));
        System.out.println("{}: " + findLengthOfLongestConsecutiveSubsequence(new int[]{}));
    }
}
