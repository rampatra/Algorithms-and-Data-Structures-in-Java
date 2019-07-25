package com.leetcode.trees;

import static org.junit.Assert.assertTrue;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/symmetric-tree/
 * Problem Description:
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * @author rampatra
 * @since 2019-07-25
 */
public class SymmetricTree {

    /**
     * Time Complexity: O(n) Because we traverse the entire input tree once, the total run time is O(n), where n is
     * the total number of nodes in the tree.
     * Space Complexity: O(n) The number of recursive calls is bound by the height of the tree. In the worst case, the
     * tree is linear and the height is in O(n). Therefore, space complexity due to recursive calls on the stack is
     * O(n) in the worst case.
     * Runtime: <a href="https://leetcode.com/submissions/detail/246324484/">0 ms</a>.
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        } else if (leftRoot == null || rightRoot == null) {
            return false;
        }

        return isSymmetric(leftRoot.left, rightRoot.right) && isSymmetric(leftRoot.right, rightRoot.left) && leftRoot.val == rightRoot.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        assertTrue(isSymmetric(root));
    }
}
