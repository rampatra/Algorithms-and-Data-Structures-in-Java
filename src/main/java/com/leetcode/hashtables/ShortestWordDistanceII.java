package com.leetcode.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/shortest-word-distance-ii/
 * Problem Description:
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words
 * word1 and word2 and return the shortest distance between these two words in the list. Your method will be called
 * repeatedly many times with different parameters. For a simpler variant, see {@link com.leetcode.arrays.ShortestWordDistance}.
 * <p>
 * Examples:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input1: word1 = “coding”, word2 = “practice”
 * Output1: 3
 * <p>
 * Input2: word1 = "makes", word2 = "coding"
 * Output2: 1
 * <p>
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 * @author rampatra
 * @since 2019-07-31
 */
public class ShortestWordDistanceII {

    private String[] words;
    private Map<String, List<Integer>> wordsToIndexesMap;

    ShortestWordDistanceII(String[] words) {
        this.words = words;
        this.wordsToIndexesMap = getWordsToIndexesMap();
    }

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/248572352/">65 ms</a>.
     *
     * @param word1
     * @param word2
     * @return
     */
    public int findShortestDistance(String word1, String word2) {
        return findShortestDistance(wordsToIndexesMap.get(word1), wordsToIndexesMap.get(word2));
    }

    private int findShortestDistance(List<Integer> indexes1, List<Integer> indexes2) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < indexes1.size() && j < indexes2.size(); ) {
            if (indexes1.get(i) <= indexes2.get(j)) {
                minDistance = Math.min(minDistance, Math.abs(indexes1.get(i) - indexes2.get(j)));
                i++;
            } else if (indexes1.get(i) > indexes2.get(j)) {
                minDistance = Math.min(minDistance, Math.abs(indexes1.get(i) - indexes2.get(j)));
                j++;
            }
        }

        return minDistance;
    }

    private Map<String, List<Integer>> getWordsToIndexesMap() {
        Map<String, List<Integer>> wordsToIndexesMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            wordsToIndexesMap.putIfAbsent(words[i], new ArrayList<>());
            wordsToIndexesMap.get(words[i]).add(i);
        }
        return wordsToIndexesMap;
    }

    public static void main(String[] args) {
        ShortestWordDistanceII shortestWordDist = new ShortestWordDistanceII(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        assertEquals(1, shortestWordDist.findShortestDistance("coding", "makes"));
        assertEquals(1, shortestWordDist.findShortestDistance("perfect", "makes"));
        assertEquals(1, shortestWordDist.findShortestDistance("practice", "makes"));
        assertEquals(1, shortestWordDist.findShortestDistance("makes", "practice"));
        assertEquals(3, shortestWordDist.findShortestDistance("coding", "practice"));
        assertEquals(0, shortestWordDist.findShortestDistance("coding", "coding"));
        assertEquals(0, shortestWordDist.findShortestDistance("makes", "makes"));
    }
}