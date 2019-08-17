package com.leetcode.graphs;


import javafx.util.Pair;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/word-ladder/
 * Description:
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time. Each transformed word must exist in the word list. Note that beginWord
 * is not a transformed word.
 * <p>
 * Note:
 * - Return 0 if there is no such transformation sequence.
 * - All words have the same length.
 * - All words contain only lowercase alphabetic characters.
 * - You may assume no duplicates in the word list.
 * - You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @author rampatra
 * @since 2019-08-15
 */
public class WordLadder {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/251960230/">79 ms</a>.
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        Map<String, Set<String>> transformedToOriginalWordMap = new HashMap<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();

        wordList.forEach(word -> {
                    String transformedWord;
                    for (int i = 0; i < L; i++) {
                        transformedWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                        transformedToOriginalWordMap.putIfAbsent(transformedWord, new HashSet<>());
                        transformedToOriginalWordMap.get(transformedWord).add(word);
                    }
                }
        );

        Set<String> visited = new HashSet<>();
        queue.add(new Pair<>(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> currPair = queue.poll();
            String word = currPair.getKey();
            Integer level = currPair.getValue();

            if (word.equals(endWord)) {
                return level;
            }

            String transformedWord;
            for (int i = 0; i < L; i++) {
                transformedWord = word.substring(0, i) + "*" + word.substring(i + 1, L);

                for (String originalWord : transformedToOriginalWordMap.getOrDefault(transformedWord, Collections.emptySet())) {
                    if (!visited.contains(originalWord)) {
                        queue.add(new Pair<>(originalWord, level + 1));
                        visited.add(originalWord);
                    }
                }
            }
        }

        return 0;
    }

    /**
     * TODO: Optimized both end BFS solution
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLengthOptimized(String beginWord, String endWord, List<String> wordList) {
        return -1;
    }

    public static void main(String[] args) {
        assertEquals(5, ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }
}