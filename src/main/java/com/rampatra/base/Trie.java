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
 *
 * @author rampatra
 * @since 9/22/15
 */
public class Trie<E> {

    TrieNode<E> root;

    Trie() {
        root = new TrieNode<>(null, new HashMap<>());
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
            curr.children.put((E) str.substring(i, i + 1), new TrieNode<>(null, new HashMap<>()));
            curr = curr.children.get(str.substring(i, i + 1));
            i++;
        }

        curr.data = data;
    }

    /**
     * Searches {@code data} in trie.
     *
     * @param data the value to search.
     * @return {@code true} if {@code data} is present, {@code false} otherwise.
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

    private class TrieNode<T> {
        T data; // stores the complete string (required to determine whether the string is in the trie)
        HashMap<T, TrieNode<T>> children;

        TrieNode(T data, HashMap<T, TrieNode<T>> children) {
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
