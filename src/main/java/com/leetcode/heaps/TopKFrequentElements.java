package com.leetcode.heaps;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 * Description:
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * Note:
 * - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * - Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author rampatra
 * @since 2019-08-19
 */
public class TopKFrequentElements {

    /**
     * TODO: A faster approach without using Pair.
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/253027938/">51 ms</a>.
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getValue));

        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            pq.add(new Pair<>(entry.getKey(), entry.getValue()));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.stream().map(Pair::getKey).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        assertEquals("[1, 2]", topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2).toString());
        assertEquals("[0]", topKFrequent(new int[]{3, 0, 1, 0}, 1).toString());
        assertEquals("[1]", topKFrequent(new int[]{1}, 1).toString());
        assertEquals("[1, 2]", topKFrequent(new int[]{1, 2}, 2).toString());
        assertEquals("[2, -1]", topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2).toString());
        assertEquals("[2, -1, 1]", topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 1}, 3).toString());
    }
}
