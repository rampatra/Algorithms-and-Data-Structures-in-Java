package com.leetcode.design;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/lru-cache/
 * Description:
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Runtime: <a href="https://leetcode.com/submissions/detail/253383205/">54 ms</a>.
 *
 * @author rampatra
 * @since 2019-08-20
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer val = cache.get(key);
        return val == null ? -1 : val;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(1,1);
        cache.put(3,3);
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2));
        assertEquals(3, cache.get(3));
    }
}