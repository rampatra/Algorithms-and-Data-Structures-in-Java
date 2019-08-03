package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/find-leaves-of-binary-tree/
 * Problem Description:
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat
 * until the tree is empty.
 *
 * Example:
 * Input: [1,2,3,4,5]
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * Output: [[4,5,3],[2],[1]]
 *
 * Explanation:
 * 1. Removing the leaves [4,5,3] would result in this tree:
 *           1
 *          /
 *         2
 *
 * 2. Now removing the leaf [2] would result in this tree:
 *           1
 *
 * 3. Now removing the leaf [1] would result in the empty tree:
 *           []
 *
 * @author rampatra
 * @since 2019-08-01
 */
public class LeavesOfBinaryTree {

    /**
     * THe idea is to perform a DFS and backtrack. While backtracking, check the height of the node and insert
     * the node into the list indexed by their heights.
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/248573435/">1 ms</a>.
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> findLeavesOfBinaryTree(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        findLeavesOfBinaryTree(root, levels);
        return levels;
    }

    private static int findLeavesOfBinaryTree(TreeNode root, List<List<Integer>> levels) {
        if (root == null) return -1;

        int leftHeight = findLeavesOfBinaryTree(root.left, levels);
        int rightHeight = findLeavesOfBinaryTree(root.right, levels);
        int height = Math.max(leftHeight, rightHeight) + 1;

        if (height >= levels.size()) {
            levels.add(height, new ArrayList<>());
        }
        levels.get(height).add(root.val);

        return height;
    }

    public static void main(String[] args) {
        /*
            BST looks like:

                    4
                  /   \
                 1     7
                / \      \
               3   8      20
              / \
             2   6
         */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(6);
        root.right.right = new TreeNode(20);

        assertEquals("[[2, 6, 8, 20], [3, 7], [1], [4]]", findLeavesOfBinaryTree(root).toString());
    }
}