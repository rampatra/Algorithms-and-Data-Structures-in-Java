package com.leetcode.arrays;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/nested-list-weight-sum-ii/ (premium)
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
     * @param nestedList
     * @return
     */
    public static long nestedSum(List<NestedInteger> nestedList) {
        long weightedSum = 0;
        long unweightedSum = 0;
        Queue<NestedInteger> queue = new LinkedList<>();

        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                unweightedSum += nestedInteger.getInteger();
            } else {
                queue.addAll(nestedInteger.getList());
                while (!queue.isEmpty()) {
                    NestedInteger ni = queue.poll();
                    if (ni.isInteger()) {
                        unweightedSum += ni.getInteger();
                    } else {
                        nestedList.addAll(ni.getList());
                    }
                }
                unweightedSum += unweightedSum;
                weightedSum = unweightedSum;
            }
        }

        return weightedSum;
    }

    public static void main(String[] args) {
        assertEquals(0, nestedSum(Collections.singletonList(new NestedInteger())));

        assertEquals(0, nestedSum(Collections.singletonList(new NestedInteger().add(new NestedInteger()))));

        NestedInteger ni = new NestedInteger(2);
        ni.add(new NestedInteger().add(new NestedInteger(1)).add(new NestedInteger(1)));
        ni.add(new NestedInteger().add(new NestedInteger(1)).add(new NestedInteger(1)));

        assertEquals(10, nestedSum(Collections.singletonList(ni)));

        ni = new NestedInteger(1);
        ni.add(new NestedInteger(4).add(new NestedInteger(6)));

        assertEquals(27, nestedSum(Collections.singletonList(ni)));

        /*assertEquals(10, nestedSum(new Object[]{new Object[]{1, 1}, 2, new Object[]{1, 1}}));
        assertEquals(27, nestedSum(new Object[]{1, new Object[]{4, new Object[]{6}}}));*/
    }
}

class NestedInteger {

    private Integer integer;
    private List<NestedInteger> list;

    public NestedInteger() {
        this.list = new ArrayList<>();
    }

    public NestedInteger(int integer) {
        this.integer = integer;
        this.list = new ArrayList<>();
    }

    public boolean isInteger() {
        return this.integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public NestedInteger add(NestedInteger nestedInteger) {
        this.list.add(nestedInteger);
        return this;
    }
}