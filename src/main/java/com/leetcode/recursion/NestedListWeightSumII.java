package com.leetcode.recursion;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/nested-list-weight-sum-ii/
 * Problem Description:
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element
 * is either an integer, or a list – whose elements may also be integers or other lists.
 * <p>
 * Different from {@link NestedListWeightSum} where weight is increasing from root to leaf, now the weight is defined
 * from bottom up, i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8. (four 1’s at depth 1, one 2 at depth 2)
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 13 + 42 + 6*1 = 17)
 * <p>
 * Note: For a simpler variant, see {@link NestedListWeightSum}.
 *
 * @author rampatra
 * @since 2019-07-27
 */
public class NestedListWeightSumII {

    /**
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/248595263/">1 ms</a>.
     *
     * @param nestedList
     * @return
     */
    public static int nestedSum(List<NestedInteger> nestedList) {
        int weightedSum = 0;
        int unweightedSum = 0;

        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();

            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    unweightedSum += ni.getInteger();
                } else {
                    nextLevel.addAll(ni.getList());
                }
            }

            unweightedSum += unweightedSum; // multiplication by repetitive addition
            weightedSum = unweightedSum;
            nestedList = nextLevel;
        }

        return weightedSum;
    }

    public static void main(String[] args) {
        assertEquals(0, nestedSum(Collections.singletonList(new NestedInteger())));

        assertEquals(0, nestedSum(Collections.singletonList(new NestedInteger().add(new NestedInteger()))));

        // TODO: fix the test cases
        // {2, {1,1}, {1,1}}
        NestedInteger ni = new NestedInteger(2);
        ni.add(new NestedInteger().add(new NestedInteger(1)).add(new NestedInteger(1)));
        ni.add(new NestedInteger().add(new NestedInteger(1)).add(new NestedInteger(1)));

        assertEquals(6, nestedSum(Collections.singletonList(ni)));

        // {1, {4, {6}}}
        ni = new NestedInteger(1);
        ni.add(new NestedInteger(4).add(new NestedInteger(6)));

        assertEquals(17, nestedSum(Collections.singletonList(ni)));
    }
}