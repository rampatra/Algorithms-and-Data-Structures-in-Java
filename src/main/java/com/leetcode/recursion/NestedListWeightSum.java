package com.leetcode.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/nested-list-weight-sum/
 * Problem Description:
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element
 * is either an integer, or a list – whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1’s at depth 2, one 2 at depth 1)
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 42 + 63 = 27)
 *
 * Note: For a more complex variant, see {@link NestedListWeightSumII}.
 *
 * @author rampatra
 * @since 2019-07-27
 */
public class NestedListWeightSum {

    /**
     * Time Complexity: The algorithm takes O(N) time, where N is the total number of nested elements in the input
     * list. For example, the list [ [[[[1]]]], 2 ] contains 4 nested lists and 2 nested integers (11 and 22), so N=6.
     * Space Complexity: In terms of space, at most O(D) recursive calls are placed on the stack, where D is the
     * maximum level of nesting in the input. For example, D=2 for the input [[1,1],2,[1,1]], and D=3 for the
     * input [1,[4,[6]]].
     *
     * @param nestedList
     * @return
     */
    public static long nestedSum(Object[] nestedList) {
        return nestedSum(nestedList, 1);
    }

    private static long nestedSum(Object[] nestedList, int depth) {
        long sum = 0;
        for (int i = 0; i < nestedList.length; i++) {
            if (nestedList[i] instanceof Integer) {
                sum += ((int) nestedList[i] * depth);
            } else {
                sum += nestedSum((Object[]) nestedList[i], depth + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        assertEquals(0, nestedSum(new Object[]{}));
        assertEquals(0, nestedSum(new Object[]{new Object[]{}}));
        assertEquals(10, nestedSum(new Object[]{new Object[]{1, 1}, 2, new Object[]{1, 1}}));
        assertEquals(27, nestedSum(new Object[]{1, new Object[]{4, new Object[]{6}}}));
    }
}