package com.leetcode.hashtables;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/two-sum-iii-data-structure-design/
 * Problem Description:
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p>
 * Example 1:
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * <p>
 * Example 2:
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 *
 * @author rampatra
 * @since 2019-08-03
 */
public class TwoSumIII {

    Map<Integer, Integer> numCount;

    /**
     * Initialize your data structure here.
     */
    public TwoSumIII() {
        this.numCount = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (numCount.containsKey(number)) {
            numCount.put(number, 2);
        } else {
            numCount.put(number, 1);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            int num1 = entry.getKey();
            int num2 = value - num1;
            if ((num2 == num1 && entry.getValue() == 2) || (num1 != num2 && numCount.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/248632458/">115 ms</a>.
     *
     * @param args
     */
    public static void main(String[] args) {
        TwoSumIII twoSumIII = new TwoSumIII();
        twoSumIII.add(0);
        twoSumIII.add(-1);
        twoSumIII.add(1);
        assertTrue(twoSumIII.find(0));
    }
}