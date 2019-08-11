package com.leetcode.trees;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Description:
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author rampatra
 * @since 2019-08-11
 */
public class BinaryTreeZigZagLevelOrderTraversal {

    /**
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/250830618/">1 ms</a>.
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        int levelNo = 0;
        LinkedList<Integer> currLevel = new LinkedList<>();
        List<List<Integer>> levelOrderTraversal = new LinkedList<>();

        if (root == null) {
            return levelOrderTraversal;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();

            if (treeNode == null) {
                levelOrderTraversal.add(currLevel);
                currLevel = new LinkedList<>();
                levelNo++;

                if (queue.size() > 0) {
                    queue.add(null);
                }
            } else {
                if (levelNo % 2 == 0) {
                    currLevel.add(treeNode.val);
                } else {
                    currLevel.add(0, treeNode.val);
                }
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
        }

        return levelOrderTraversal;
    }

    public static void main(String[] args) {
        /*
            Binary Tree

                1
               / \
              2   3
             / \
            4   5
         */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        assertEquals("[[1], [3, 2], [4, 5]]", zigzagLevelOrder(tree).toString());
        assertEquals("[]", zigzagLevelOrder(null).toString());
    }
}
