package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/flatten-nested-list-iterator/
 * Description:
 * Given a nested list of integers, implement an iterator to flatten it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,1,2,1,1].
 *
 * Example 2:
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be: [1,4,6].
 *
 * Runtime: <a href="https://leetcode.com/submissions/detail/250996020/">2 ms</a>.
 *
 * @author rampatra
 * @since 2019-08-12
 */
public class FlattenNestListIterator implements Iterator<Integer> {

    private int index;
    private List<Integer> flattenedList;

    public FlattenNestListIterator(List<NestedInteger> nestedList) {
        index = 0;
        flattenedList = getFlattenedList(nestedList);
    }

    private List<Integer> getFlattenedList(List<NestedInteger> nestedList) {
        List<Integer> flattenedList = new ArrayList<>();

        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                flattenedList.add(nestedInteger.getInteger());
            } else {
                flattenedList.addAll(getFlattenedList(nestedInteger.getList()));
            }
        }

        return flattenedList;
    }

    @Override
    public Integer next() {
        return flattenedList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flattenedList.size();
    }

    public static void main(String[] args) {
        // TODO add some test cases
    }
}