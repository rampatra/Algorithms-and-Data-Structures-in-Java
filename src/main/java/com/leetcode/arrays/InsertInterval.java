package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Level: Hard
 * Problem Link: https://leetcode.com/problems/insert-interval/
 * Problem Description:
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * <p>
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Companies: LinkedIn.
 * Related: {@link MergeIntervals}.
 *
 * @author rampatra
 * @since 2019-07-23
 */
public class InsertInterval {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: <a href="https://leetcode.com/submissions/detail/245767085/">2 ms</a>.
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 && newInterval.length == 0) {
            return new int[][]{};
        } else if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int[][] mergedIntervals = new int[intervals.length + 1][2];
        int j = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval == null || newInterval[0] > intervals[i][1]) { // newInterval is after the ith interval
                mergedIntervals[j++] = intervals[i];
            } else if (newInterval[1] < intervals[i][0]) { // newInterval is before the ith interval
                mergedIntervals[j++] = newInterval;
                mergedIntervals[j++] = intervals[i];
                newInterval = null;
            } else { // if overlapping
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        if (newInterval != null) {
            mergedIntervals[j++] = newInterval;
        }

        return Arrays.copyOfRange(mergedIntervals, 0, j);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{}, new int[]{})));
        System.out.println(Arrays.deepToString(insert(new int[][]{}, new int[]{5, 7})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{0, 0})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{2, 3})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{2, 5}, {6, 7}, {8, 9}}, new int[]{0, 1})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }
}