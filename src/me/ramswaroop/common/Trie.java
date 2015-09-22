package me.ramswaroop.common;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/22/15
 * @time: 8:19 PM
 */
public class Trie<E> {

    TrieNode<E> root;

    Trie() {
        root = new TrieNode<>(null, new HashMap<String, TrieNode<E>>());
    }

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
        
        return curr.data == data;
    }

    private class TrieNode<E> {
        E data;
        HashMap<String, TrieNode<E>> children;

        TrieNode(E data, HashMap<String, TrieNode<E>> children) {
            this.data = data;
            this.children = children;
        }
    }
    
    public static void main(String[] a) {
        Trie<String> trie = new Trie<>();
        trie.insert("ram");
        trie.insert("rama");
        trie.insert("ramswaroop");
        System.out.println(trie.search("ram"));
        System.out.println(trie.search("ra"));
        System.out.println(trie.search("raz"));
        System.out.println(trie.search("ramswaroop"));
    }
}
