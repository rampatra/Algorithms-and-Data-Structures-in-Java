package com.rampatra.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Level: Easy
 * Problem Description:
 * Given an array and a target sum, return the number of distinct pairs whose sum is equal to the target sum.
 * <p>
 * For Example, given an array [1, 2, 3, 6, 7, 8, 9, 1] and a target sum of 10,
 * the 7 pairs, i.e, (1, 9), (2, 8), (3, 7), (8, 2), (9, 1), (9, 1), and (1, 9) all sum to 10 but there are only
 * three distinct pairs, i.e, (1, 9), (2, 8), and (3, 7) so the answer would be 3.
 *
 * @author rampatra
 * @since 2019-06-03
 */
public class DistinctPairs {

    /**
     * Time complexity: O(n), n = size of the array
     * Space complexity: O(n)
     *
     * @param arr
     * @param targetSum
     * @return
     */
    private static int numberOfDistinctPairs(int[] arr, int targetSum) {
        Set<Integer> numSet = new HashSet<>();
        Set<Set<Integer>> pairSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (numSet.contains(targetSum - arr[i])) {
                Set<Integer> pair = new HashSet<>();
                pair.add(arr[i]);
                pair.add(targetSum - arr[i]);
                pairSet.add(pair);
            }
            numSet.add(arr[i]);
        }

        return pairSet.size();
    }

    public static void main(String[] args) {
        System.out.println(numberOfDistinctPairs(new int[]{1, 2, 3, 6, 7, 8, 9, 1}, 1));
        System.out.println(numberOfDistinctPairs(new int[]{1, 2, 3, 6, 7, 8, 9, 1}, 2));
        System.out.println(numberOfDistinctPairs(new int[]{1, 2, 3, 6, 7, 8, 9, 1}, 10));
    }
}