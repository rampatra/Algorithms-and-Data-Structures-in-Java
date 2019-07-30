package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    /**
     * Time Complexity: O(n) Because we traverse the entire input tree once, the total run time is O(n), where n is the
     * total number of nodes in the tree.
     * Space Complexity: There is additional space required for the search queue. In the worst case, we have to
     * insert O(n) nodes in the queue. Therefore, space complexity is O(n).
     * Runtime: <a href="https://leetcode.com/submissions/detail/246708370/">1 ms</a>.
     *
     * @param root
     * @return
     */
    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        if (root.left == null || root.right == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            // enqueue left and then right child of t1 but do the opposite for t2
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;
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
        assertTrue(isSymmetricIterative(root));
    }
}
