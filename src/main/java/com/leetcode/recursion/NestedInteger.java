package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Class needed for various problems like {@link NestedListWeightSumII}, {@link FlattenNestListIterator}, etc.
 *
 * @author rampatra
 * @since 2019-08-12
 */
public class NestedInteger {

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
