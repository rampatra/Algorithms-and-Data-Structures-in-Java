package com.leetcode.trees;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/binary-tree-upside-down/
 * Problem Description:
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the
 * same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into
 * left leaf nodes. Return the new root.
 *
 * Example:
 * Input: [1,2,3,4,5]
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 *
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 *
 * Clarification:
 * Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ. The serialization of
 * a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 *
 * Here's an example:
 *
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 *
 * The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
 *
 * @author rampatra
 * @since 2019-08-04
 */
public class BinaryTreeUpsideDown {

    /**
     * The solution is simple, every node (except the root) on the left of the tree would have its parent's right child
     * as it's left child and parent as its right child. That's all you have to do to flip the tree upside down.
     *
     * Time Complexity: O(h)
     * Space Complexity: O(h)
     * where,
     * h = height of the tree
     *
     * Runtime: <a href="https://leetcode.com/submissions/detail/248816514/">1 ms</a>.
     *
     * @param root
     * @return
     */
    public static TreeNode upsideDownBinaryTreeUsingStack(TreeNode root) {
        if (root == null) return null;

        TreeNode curr = root;
        TreeNode currParent;
        TreeNode newRoot = null;

        // using stack to keep track of the parent node
        Stack<TreeNode> stack = new Stack<>();

        while (curr != null) {
            stack.add(curr);
            curr = curr.left;
        }

        while (!stack.empty()) {
            curr = stack.pop();
            currParent = stack.empty() ? null : stack.peek();

            if (newRoot == null) newRoot = curr;

            if (currParent != null) {
                curr.left = currParent.right;
                curr.right = currParent;
            } else {
                curr.left = null;
                curr.right = null;
            }
        }

        return newRoot;
    }

    /**
     * The solution is simple, every node (except the root) on the left of the tree would have its parent's right child
     * as it's left child and parent as its right child. That's all you have to do to flip the tree upside down.
     *
     * Time Complexity: O(h)
     * Space Complexity: O(h)
     * where,
     * h = height of the tree
     *
     * Runtime: <a href="https://leetcode.com/submissions/detail/248821826/">0 ms</a>.
     *
     * @param node
     * @return
     */
    public static TreeNode upsideDownBinaryTree(TreeNode node) {
        if (node == null || node.left == null) return node;

        // go to the last node on the extreme left branch
        TreeNode newRoot = upsideDownBinaryTree(node.left);

        // do the node changes as you backtrack
        node.left.left = node.right;
        node.left.right = node;

        // clean up
        node.left = null;
        node.right = null;

        return newRoot;
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

        /*
            Upside Down Binary Tree

               4
              / \
             5   2
                / \
               3   1
         */
        TreeNode upsideDownTree = upsideDownBinaryTreeUsingStack(tree);
        assertEquals(4, upsideDownTree.val);
        assertEquals(5, upsideDownTree.left.val);
        assertEquals(2, upsideDownTree.right.val);
        assertEquals(1, upsideDownTree.right.right.val);
        assertEquals(3, upsideDownTree.right.left.val);
        assertNull(upsideDownTree.right.right.left);
        assertNull(upsideDownTree.right.right.right);



        /******************************
         *
         * Test for the recursive method
         *
         ******************************/

        /*
            Binary Tree

                1
               / \
              2   3
             / \
            4   5
         */
        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        /*
            Upside Down Binary Tree

               4
              / \
             5   2
                / \
               3   1
         */
        upsideDownTree = upsideDownBinaryTree(tree);
        assertEquals(4, upsideDownTree.val);
        assertEquals(5, upsideDownTree.left.val);
        assertEquals(2, upsideDownTree.right.val);
        assertEquals(1, upsideDownTree.right.right.val);
        assertEquals(3, upsideDownTree.right.left.val);
        assertNull(upsideDownTree.right.right.right);
        assertNull(upsideDownTree.right.right.left);
    }
}