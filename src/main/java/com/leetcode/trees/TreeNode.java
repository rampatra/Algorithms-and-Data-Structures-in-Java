package com.leetcode.trees;

/**
 * @author rampatra
 * @since 2019-07-25
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + "";
    }
}