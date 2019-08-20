package com.leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Hard
 * Link: https://leetcode.com/problems/lfu-cache/
 * Description:
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it
 * should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when
 * there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Note:
 * - When setting a key which is already present, reset its frequency/count to 1.
 *
 * @author rampatra
 * @since 2019-08-20
 */
public class LFUCache {

    private int minCount = 0;
    private int capacity;
    private Map<Integer, Integer> keyValueMap;
    private Map<Integer, Integer> keyCountMap;
    private Map<Integer, LinkedHashSet<Integer>> countKeysMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
        keyCountMap = new HashMap<>();
        countKeysMap = new HashMap<>();
    }


    public int get(int key) {
        Integer val = keyValueMap.get(key);
        if (val == null) {
            return -1;
        }

        int prevCount = keyCountMap.get(key);
        countKeysMap.getOrDefault(prevCount, new LinkedHashSet<>()).remove(key);
        countKeysMap.putIfAbsent(prevCount + 1, new LinkedHashSet<>());
        countKeysMap.get(prevCount + 1).add(key);

        if (prevCount == minCount && countKeysMap.get(prevCount).size() == 0) {
            minCount++;
        }

        return val;
    }


    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (!keyValueMap.containsKey(key) && keyCountMap.size() == capacity) {
            int keyToEvict = countKeysMap.get(minCount).iterator().next();
            countKeysMap.get(minCount).remove(keyToEvict);
            keyValueMap.remove(keyToEvict);
            keyCountMap.remove(keyToEvict);
        }

        keyValueMap.put(key, value);
        int prevCount = keyCountMap.getOrDefault(key, 0);
        keyCountMap.put(key, 1);

        countKeysMap.getOrDefault(prevCount, new LinkedHashSet<>()).remove(key);
        countKeysMap.putIfAbsent(1, new LinkedHashSet<>());
        countKeysMap.get(1).add(key);

        minCount = 1;
    }


    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);
        lfuCache.put(4, 4);
        assertEquals(-1, lfuCache.get(2));
        assertEquals(3, lfuCache.get(3));
        lfuCache.put(5, 5);
        assertEquals(-1, lfuCache.get(4));

        lfuCache = new LFUCache(2);
        lfuCache.put(3, 1);
        lfuCache.put(2, 1);
        lfuCache.put(2, 2);
        lfuCache.put(4, 4);
        assertEquals(-1, lfuCache.get(3));
        assertEquals(2, lfuCache.get(2));

        lfuCache = new LFUCache(2);
        lfuCache.put(2, 1);
        lfuCache.put(2, 2);
        assertEquals(2, lfuCache.get(2));
        lfuCache.put(1, 1);
        lfuCache.put(4, 4);
        assertEquals(2, lfuCache.get(2));

        lfuCache = new LFUCache(2);
        assertEquals(-1, lfuCache.get(2));
        lfuCache.put(2, 6);
        assertEquals(-1, lfuCache.get(1));
        lfuCache.put(1, 1);
        lfuCache.put(1, 2);
        assertEquals(2, lfuCache.get(1));
        assertEquals(6, lfuCache.get(2));

        // todo fix some test cases https://leetcode.com/submissions/detail/253376947/
    }
}