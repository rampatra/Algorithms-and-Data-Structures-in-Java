package com.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/shortest-word-distance-iii/
 * Problem Description:
 * This is a follow-up problem of {@link ShortestWordDistance}. The only difference is that now word1 could be the
 * same as word2.
 * <p>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 * <p>
 * Note: You may assume word1 and word2 are both in the list. If they are same then it's guaranteed that there are
 * two occurrences of the same.
 *
 * @author rampatra
 * @since 2019-07-31
 */
public class ShortestWordDistanceIII {

    /**
     * Time Complexity:
     * Space Complexity:
     * TODO
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
                // if both words are same and the first index is already set then do nothing
                if (word1.equals(word2) && indexWord1 != -1) {

                } else {
                    indexWord1 = i;
                }
            }
            if (words[i].equals(word2)) {
                // if both words are same and i is same as first index then it implies its the
                // first occurrence, skip and continue look for the second occurrence
                if (word1.equals(word2) && i == indexWord1) {
                    continue;
                }
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
                "makes", "makes"));
        assertEquals(3, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding", "practice"));
        assertEquals(3, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "practice", "coding"));
        assertEquals(1, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "coding"));
        assertEquals(1, findShortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "perfect"));
    }
}
