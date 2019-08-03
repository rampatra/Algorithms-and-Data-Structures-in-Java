package com.leetcode.trees;

import java.util.Stack;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * Problem Description:
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this
 * tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value
 * among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in
 * the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 *
 * Example 2:
 * Input:
 *     2
 *    / \
 *   2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 * @author rampatra
 * @since 2019-08-03
 */
public class SecondMinNodeInBinaryTree {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: <a href="https://leetcode.com/submissions/detail/248556303/">1 ms</a>.
     * @param root
     * @return
     */
    public static int findSecondMinimumValueIterative(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return -1;

        int min = root.val;
        long secondMin = Long.MAX_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;

            if (node.val > min && node.val < secondMin) {
                secondMin = node.val;
            }
            stack.push(node.left);
            stack.push(node.right);
        }

        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }


    /**
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/248558543/">0 ms</a>.
     *
     * @param root
     * @return
     */
    public static int findSecondMinimumValue(TreeNode root) {
        // passing a long as secondMin because TreeNode can have Integer.MAX_VALUE as its value
        long ans = findSecondMinimumValue(root, root.val, Long.MAX_VALUE);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    private static long findSecondMinimumValue(TreeNode root, int min, long secondMin) {
        if (root == null) return Long.MAX_VALUE;

        if (root.val > min && root.val < secondMin) {
            return root.val;
        } else {
            return Math.min(findSecondMinimumValue(root.left, min, secondMin),
            findSecondMinimumValue(root.right, min, secondMin));
        }
    }

    public static void main(String[] args) {
        System.out.println((int) 2147483647L);
        System.out.println(Integer.MAX_VALUE);
        // TODO: A function called buildTree which would take an array like [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
        //  and return a Binary Tree
        //assertEquals(2, findSecondMinimumValue(buildTree(new int[]{1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1})));
        //assertEquals(2147483647, findSecondMinimumValue(buildTree(new int[]{2,2,2147483647})));
    }
}
