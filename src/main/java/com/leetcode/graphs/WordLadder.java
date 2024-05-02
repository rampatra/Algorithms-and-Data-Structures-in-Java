package com.leetcode.graphs;

import javafx.util.Pair;
import java.util.*;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/word-ladder/
 * Description:
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time. Each transformed word must exist in the word list. Note that beginWord
 * is not a transformed word.
 *
 * Note:
 * - Return 0 if there is no such transformation sequence.
 * - All words have the same length.
 * - All words contain only lowercase alphabetic characters.
 * - You may assume no duplicates in the word list.
 * - You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {

    private static final char WILDCARD_CHAR = '*';

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> allComboDict = preprocessWords(wordList);
        return performBFS(beginWord, endWord, allComboDict);
    }

    private static Map<String, Set<String>> preprocessWords(List<String> wordList) {
        Map<String, Set<String>> allComboDict = new HashMap<>();
        int L = wordList.get(0).length();
        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + WILDCARD_CHAR + word.substring(i + 1, L);
                allComboDict.computeIfAbsent(newWord, k -> new HashSet<>()).add(word);
            }
        });
        return allComboDict;
    }

    private static int performBFS(String beginWord, String endWord, Map<String, Set<String>> allComboDict) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + WILDCARD_CHAR + word.substring(i + 1);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new HashSet<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        queue.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        assertEquals(5, ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }
}