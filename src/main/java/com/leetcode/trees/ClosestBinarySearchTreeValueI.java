package com.leetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/closest-binary-search-tree-value/
 * Problem Description:
 *
 * @author rampatra
 * @since 2019-07-31
 */
public class ClosestBinarySearchTreeValueI {

    public static TreeNode findNodeWithClosestValue(TreeNode node, TreeNode parentNode, int val, int diff) {
        if (node == null) return parentNode;

        if (Math.abs(node.val - val) > diff) return parentNode;

        if (node.val > val) {
            return findNodeWithClosestValue(node.left, node, val, Math.abs(node.val - val));
        } else {
            return findNodeWithClosestValue(node.right, node, val, Math.abs(node.val - val));
        }
    }

    public static void main(String[] args) {

        /*
            BST looks like:

                    9
                  /   \
                 7     13
                / \      \
               5   8      20
              / \
             2   6
         */
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(7);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(6);
        root.right.right = new TreeNode(20);

        assertEquals(13, findNodeWithClosestValue(root, root, 15, Integer.MAX_VALUE).val);
        assertEquals(13, findNodeWithClosestValue(root, root, 13, Integer.MAX_VALUE).val);
        assertEquals(9, findNodeWithClosestValue(root, root, 9, Integer.MAX_VALUE).val);
        assertEquals(2, findNodeWithClosestValue(root, root, 2, Integer.MAX_VALUE).val);
        assertEquals(2, findNodeWithClosestValue(root, root, 1, Integer.MAX_VALUE).val);
        assertEquals(6, findNodeWithClosestValue(root, root, 6, Integer.MAX_VALUE).val);
        assertEquals(13, findNodeWithClosestValue(root, root, 11, Integer.MAX_VALUE).val); // tie b/w 9 and 13

        /*
            BST looks like:

                    9
                  /   \
                 7     13
                / \   /  \
               5   8 13  20
         */
        root = new TreeNode(9);
        root.left = new TreeNode(7);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(20);

        assertEquals(13, findNodeWithClosestValue(root, root, 15, Integer.MAX_VALUE).val);
    }
}
