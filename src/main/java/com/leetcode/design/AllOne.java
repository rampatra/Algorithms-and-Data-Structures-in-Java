package com.leetcode.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Hard
 * Link: https://leetcode.com/problems/all-oone-data-structure/
 * Description:
 * Implement a data structure supporting the following operations:
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty
 * string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If
 * the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * <p>
 * Challenge: Perform all these in O(1) time complexity.
 *
 * @author rampatra
 * @since 2019-08-11
 */
public class AllOne {



    Map<String, Integer> keyToValMap;
    Map<Integer, Set<String>> valToKeyMap;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        keyToValMap = new HashMap<>();
        valToKeyMap = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {

    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {

    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return null;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return null;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("r");
        allOne.inc("r");
        allOne.dec("r");
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        assertEquals("b", allOne.getMaxKey());
        assertEquals("a", allOne.getMinKey());

        allOne = new AllOne();
        allOne.dec("hello");
        assertEquals("", allOne.getMaxKey());

        allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("b");
        allOne.dec("b");
        assertEquals("b", allOne.getMaxKey());
        assertEquals("a", allOne.getMinKey());

        allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        assertEquals("hello", allOne.getMaxKey());
        assertEquals("hello", allOne.getMinKey());
        allOne.inc("leet");
        assertEquals("hello", allOne.getMaxKey());
        assertEquals("leet", allOne.getMinKey());

        allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        assertEquals("a", allOne.getMinKey());
        allOne.dec("a");
        assertEquals("c", allOne.getMaxKey());
        //assertEquals("c", allOne.getMinKey());

        allOne = new AllOne();
        allOne.inc("hello");
        allOne.dec("hello");
        assertEquals("", allOne.getMaxKey());
        assertEquals("", allOne.getMinKey());
    }
}