package com.leetcode.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/closest-binary-search-tree-value/
 * Problem Description:
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * <p>
 * Note:
 * - Given target value is a floating point.
 * - You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 * @author rampatra
 * @since 2019-07-31
 */
public class ClosestBinarySearchTreeValue {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/248841443/">0 ms</a>.
     *
     * @param root
     * @param target
     * @return
     */
    public static int closestValue(TreeNode root, double target) {
        if (root == null) return -1;

        return closestValue(root, root, target);
    }

    private static int closestValue(TreeNode node, TreeNode closestNode, double val) {
        if (node == null) return closestNode.val;

        if (Math.abs(node.val - val) < Math.abs(closestNode.val - val)) {
            closestNode = node;
        }

        if (node.val > val) {
            return closestValue(node.left, closestNode, val);
        } else {
            return closestValue(node.right, closestNode, val);
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
        root.left.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(2);
        root.right.right = new TreeNode(20);

        assertEquals(13, closestValue(root, 15));
        assertEquals(13, closestValue(root, 13));
        assertEquals(9, closestValue(root, 9));
        assertEquals(2, closestValue(root, 2));
        assertEquals(2, closestValue(root, 1));
        assertEquals(6, closestValue(root, 6));
        assertEquals(13, closestValue(root, 11)); // tie b/w 9 and 13

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

        assertEquals(13, closestValue(root, 15));

        /*
            BST looks like:

                    1500000000
                        /
                       /
                      /
                 1400000000
         */
        root = new TreeNode(1500000000);
        root.left = new TreeNode(1400000000);

        assertEquals(1400000000, closestValue(root, -1500000000.0));
    }
}
