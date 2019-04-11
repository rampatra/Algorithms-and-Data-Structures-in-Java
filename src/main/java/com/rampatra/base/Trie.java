package com.rampatra.base;

import java.util.HashMap;

/**
 * Trie also called digital tree and sometimes radix tree or prefix tree (as they can be
 * searched by prefixes), is an ordered tree data structure that is used to store a dynamic
 * set or associative array where the keys are usually strings.
 * <p/>
 * You can think it as HashMap of HashMap of HashMap and so on. Each key in the HashMap is a
 * single digit/letter of the data you want to store and {@code data} is the final full word
 * you want to save in trie.
 * <p>
 * Some resources:
 * <a href="https://en.wikipedia.org/wiki/Trie">Trie Data Structure</a>
 * <a href="https://www.topcoder.com/community/data-science/data-science-tutorials/using-tries">More about Tries</a>
 * <a href="https://www.youtube.com/watch?v=zIjfhVPRZCg">Video explanation from Gayle McDowell</a>
 *
 * @author rampatra
 * @since 9/22/15
 */
public class Trie {

    private class TrieNode<T> {
        char ch;
        HashMap<T, TrieNode<T>> children = new HashMap<>();
        boolean isCompleteWord; // to mark a complete word in the tri data structure

        TrieNode(char ch) {
            this.ch = ch;
        }
    }

    private TrieNode<Character> root;

    Trie() {
        root = new TrieNode<>('0');
    }

    /**
     * Inserts {@code data} in trie.
     *
     * @param str
     */
    public void insert(String str) {
        char c;
        TrieNode<Character> curr = root;

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            curr.children.putIfAbsent(c, new TrieNode<>(c));
            curr = curr.children.get(c);
        }

        curr.isCompleteWord = true;
    }

    /**
     * Searches {@code data} in trie.
     *
     * @param str the value to search.
     * @return {@code true} if {@code str} is present, {@code false} otherwise.
     */
    public boolean search(String str) {

        TrieNode<Character> curr = root;

        for (int i = 0; i < str.length(); i++) {
            if (curr.children.get(str.charAt(i)) == null) {
                return false;
            }
            curr = curr.children.get(str.charAt(i));
        }

        return curr.isCompleteWord;
    }

    // unit testing
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ram");
        trie.insert("r");
        trie.insert("rama");
        trie.insert("rampatra");
        System.out.println(trie.search("ram"));
        System.out.println(trie.search("r"));
        System.out.println(trie.search("ra"));
        System.out.println(trie.search("raz"));
        System.out.println(trie.search("rampatra"));
    }
}