package com.rampatra.base;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * Trie also called digital tree and sometimes radix tree or prefix tree (as they can be
 * searched by prefixes), is an ordered tree data structure that is used to store a dynamic
 * set or associative array where the keys are usually strings.
 * <p/>
 * You can think it as HashMap of HashMap of HashMap and so on. Each key in the HashMap is a
 * single digit/letter of the data you want to store and {@code data} is the final full word
 * you want to save in trie.
 *
 * @author rampatra
 * @since 9/22/15
 * @time: 8:19 PM
 * @see: https://en.wikipedia.org/wiki/Trie
 * @see: https://www.topcoder.com/community/data-science/data-science-tutorials/using-tries
 */
public class Trie<E> {

    TrieNode<E> root;

    Trie() {
        root = new TrieNode<>(null, new HashMap<String, TrieNode<E>>());
    }

    /**
     * Inserts {@param data} in trie.
     *
     * @param data
     */
    public void insert(E data) {

        int i = 0;
        String str = data.toString();
        TrieNode<E> curr = root;

        while (i < str.length()) {
            if (curr.children.get(str.substring(i, i + 1)) != null) {
                curr = curr.children.get(str.substring(i, i + 1));
                i++;
            } else {
                break;
            }
        }

        while (i < str.length()) {
            curr.children.put(str.substring(i, i + 1), new TrieNode<>(null, new HashMap<String, TrieNode<E>>()));
            curr = curr.children.get(str.substring(i, i + 1));
            i++;
        }

        curr.data = data;
    }

    /**
     * Searches {@param data} in trie.
     *
     * @param data
     * @return {@code true} if {@param data} is present, {@code false} otherwise.
     */
    public boolean search(E data) {

        int i = 0;
        String str = data.toString();
        TrieNode<E> curr = root;

        while (i < str.length()) {
            if (curr.children.get(str.substring(i, i + 1)) == null) {
                return false;
            }
            curr = curr.children.get(str.substring(i, i + 1));
            i++;
        }

        return curr.data != null && curr.data.equals(data);
    }

    private class TrieNode<E> {
        E data; // stores the complete string (required to determine whether the string is in the trie)
        HashMap<String, TrieNode<E>> children;

        TrieNode(E data, HashMap<String, TrieNode<E>> children) {
            this.data = data;
            this.children = children;
        }
    }

    // unit testing
    public static void main(String[] args) {
        Trie<String> trie = new Trie<>();
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
