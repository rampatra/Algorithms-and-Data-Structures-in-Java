package com.leetcode.design;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
 * Description:
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of
 * being returned.
 *
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 *
 * Runtime: <a href="https://leetcode.com/submissions/detail/250682053/>52 ms</a>.
 *
 * @author rampatra
 * @since 2019-08-11
 */
public class InsertDeleteGetRandom {
    // store the val and its index (from the array list to make the remove O(1))
    Map<Integer, Integer> valuesToIndexMap;
    List<Integer> values;
    Random random;

    InsertDeleteGetRandom() {
        valuesToIndexMap = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    boolean insert(int val) {
        if (valuesToIndexMap.containsKey(val)) {
            return false;
        }

        valuesToIndexMap.put(val, values.size());
        values.add(val);
        return true;
    }

    boolean remove(int val) {
        Integer index = valuesToIndexMap.get(val);

        if (index == null) {
            return false;
        }

        if (index != values.size() - 1) {
            int lastValue = values.get(values.size() - 1);
            values.set(index, lastValue); // replace the value with the last value
            valuesToIndexMap.put(lastValue, index); // update index in the map
        }
        values.remove(values.size() - 1);
        return valuesToIndexMap.remove(val, index);
    }

    int getRandom() {
        return values.get(random.nextInt(values.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom randomizedSet = new InsertDeleteGetRandom();
        assertTrue(randomizedSet.insert(2));
        assertTrue(randomizedSet.insert(-1));
        assertFalse(randomizedSet.remove(-10));
        assertTrue(randomizedSet.remove(-1));
        assertEquals(2, randomizedSet.getRandom());
        assertTrue(randomizedSet.remove(2));
        assertFalse(randomizedSet.remove(-2));
        assertFalse(randomizedSet.remove(-20));
        assertFalse(randomizedSet.remove(-30));
        assertFalse(randomizedSet.remove(2));
        assertFalse(randomizedSet.remove(1));
        assertFalse(randomizedSet.remove(0));
    }
}