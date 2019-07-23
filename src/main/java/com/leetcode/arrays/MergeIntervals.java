package com.leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/merge-intervals/
 * Problem Description:
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * Companies: LinkedIn
 * Related: {@link InsertInterval}.
 *
 * @author rampatra
 * @since 2019-07-22
 */
public class MergeIntervals {

    /**
     * Time complexity: O(n log n)
     * Space complexity: O(n)
     * Runtime: <a href="https://leetcode.com/submissions/detail/245385574/">6 ms</a>
     *
     * @param intervals a list of intervals, may not be sorted
     * @return a list of intervals, with overlapping intervals merged
     */
    public static int[][] merge(int[][] intervals) {
        // some validations
        if (intervals.length == 0) return new int[0][2];

        // we first sort the intervals based on their start times
        Arrays.sort(intervals, new IntervalComparator());

        int[][] mergedIntervals = new int[intervals.length][2];
        int lastMergedIndex = 0;
        mergedIntervals[lastMergedIndex] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (isOverlap(mergedIntervals[lastMergedIndex], intervals[i])) {
                // if two intervals overlap, then merge the two
                mergedIntervals[lastMergedIndex] = new int[]{Math.min(mergedIntervals[lastMergedIndex][0], intervals[i][0]),
                        Math.max(mergedIntervals[lastMergedIndex][1], intervals[i][1])};
            } else {
                mergedIntervals[++lastMergedIndex] = intervals[i];
            }
        }

        return Arrays.copyOfRange(mergedIntervals, 0, lastMergedIndex + 1);
    }

    private static boolean isOverlap(int[] interval1, int[] interval2) {
        return interval1[0] <= interval2[0] && interval1[1] >= interval2[0];
    }

    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] interval1, int[] interval2) {
            return interval1[0] - interval2[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
    }
}