package com.leetcode.trie;

import java.util.HashMap;
import java.util.Stack;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/longest-word-in-dictionary/
 *
 * @author rampatra
 * @since 2019-04-10
 */
public class LongestWord {

    private class TrieNode {
        char ch;
        HashMap<Character, TrieNode> children = new HashMap<>();
        String completeWord; // to mark a complete word in the trie data structure

        TrieNode(char ch) {
            this.ch = ch;
        }
    }

    private TrieNode root = new TrieNode('0');

    /**
     * Inserts {@code data} in trie.
     *
     * @param str
     */
    public void insert(String str) {
        char c;
        TrieNode curr = root;

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            curr.children.putIfAbsent(c, new TrieNode(c));
            curr = curr.children.get(c);
        }

        curr.completeWord = str;
    }

    public String longestWord(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        return longestWord();
    }

    private String longestWord() {
        String longestWord = "";
        TrieNode curr;
        Stack<TrieNode> stack = new Stack<>();
        stack.addAll(root.children.values());

        while (!stack.empty()) {
            curr = stack.pop();
            if (curr.completeWord != null) {
                if (curr.completeWord.length() > longestWord.length() ||
                        (curr.completeWord.length() == longestWord.length() &&
                                curr.completeWord.compareTo(longestWord) < 0)) {
                    longestWord = curr.completeWord;
                }
                stack.addAll(curr.children.values());
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
        LongestWord longestWord = new LongestWord();
        System.out.println(longestWord.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(longestWord.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}