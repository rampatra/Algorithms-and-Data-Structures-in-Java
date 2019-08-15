package com.leetcode.arrays;

import com.leetcode.hashtables.ShortestWordDistanceII;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/shortest-word-distance/
 * Problem Description:
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the
 * list of words.
 *
 * Example 1:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = "coding", word2 = "practice", return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 *
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 * Lastly, for a more complex variant, see {@link ShortestWordDistanceII}.
 *
 * @author rampatra
 * @since 2019-07-31
 */
public class ShortestWordDistance {

    /**
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/248572791/">1 ms</a>.
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public static int findShortestDistance(String[] words, String word1, String word2) {
        int indexWord1 = -1;
        int indexWord2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                indexWord1 = i;
            } else if (words[i].equals(word2)) {
                indexWord2 = i;
            }
            if (indexWord1 != -1 && indexWord2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(indexWord1 - indexWord2));
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        assertEquals(3, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "practice", "coding"));
        assertEquals(3, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding", "practice"));
        assertEquals(1, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "coding"));
        assertEquals(1, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "perfect"));
        assertEquals(0, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "perfect", "perfect"));
        assertEquals(0, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "makes"));
    }
}
