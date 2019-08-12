package com.leetcode.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Hard
 * Problem Link: https://leetcode.com/problems/closest-binary-search-tree-value-ii/
 * Problem Description:
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Note:
 * - Given target value is a floating point.
 * - You may assume k is always valid, that is: k ≤ total nodes.
 * - You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 * Example:
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: [4,3]
 *
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 *
 * @author rampatra
 * @since 2019-07-31
 */
public class ClosestBinarySearchTreeValueII {


    /**
     * The idea is simple. We do the inorder traversal and keep the values less than or equal to target in a stack and
     * the values greater than target in a queue. And finally, we compare values from both stack and queue and take
     * whichever is the closest to target value each time.
     *
     * Note: We can optimize it even further in terms of space. We can get rid of the stack and queue and just fill up
     * the result list in the recursive inOrder call. Once the result list is of size k, we can compare and remove the
     * farthest value and insert the closer value. See {@link ClosestBinarySearchTreeValueII#closestKValuesOptimized(TreeNode, double, int)}.
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
        int count = 0;
        List<Integer> closestKValues = new LinkedList<>();

        Stack<Integer> predecessors = new Stack<>();
        Queue<Integer> successors = new LinkedList<>();
        inOrder(root, predecessors, successors, target, k);

        while (count < k) {
            if (predecessors.empty()) {
                closestKValues.add(successors.poll());
            } else if (successors.isEmpty()) {
                closestKValues.add(predecessors.pop());
            } else if (Math.abs(target - predecessors.peek()) < Math.abs(target - successors.peek())) {
                closestKValues.add(predecessors.pop());
            } else {
                closestKValues.add(successors.poll());
            }
            count++;
        }

        return closestKValues;
    }

    private static void inOrder(TreeNode root, Stack<Integer> predecessors, Queue<Integer> successors, double target, int k) {
        if (root == null || successors.size() == k) return;
        inOrder(root.left, predecessors, successors, target, k);
        if (root.val <= target) {
            predecessors.add(root.val);
        } else {
            successors.add(root.val);
        }
        inOrder(root.right, predecessors, successors, target, k);
    }


    /**
     * This approach is similar to the above one but it doesn't use stack or queue.
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public static List<Integer> closestKValuesOptimized(TreeNode root, double target, int k) {
        LinkedList<Integer> closestKValues = new LinkedList<>();
        inOrder(root, target, k, closestKValues);
        return closestKValues;
    }

    private static void inOrder(TreeNode root, double target, int k, LinkedList<Integer> closestKValues) {
        if (root == null) return;

        inOrder(root.left, target, k, closestKValues);
        if (closestKValues.size() == k) {
            //if size k, add current and remove head if it's closer to target, otherwise return
            if (Math.abs(target - root.val) < Math.abs(target - closestKValues.peekFirst()))
                closestKValues.removeFirst();
            else {
                return;
            }
        }
        closestKValues.add(root.val);
        inOrder(root.right, target, k, closestKValues);
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

        assertEquals("[9, 8, 7, 6, 5]", closestKValues(root, 8.5, 5).toString());
        assertEquals("[5, 6, 7, 8, 9]", closestKValuesOptimized(root, 8.5, 5).toString());

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
        root.right.left = new TreeNode(13);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(20);

        assertEquals("[13, 13, 9, 20, 8]", closestKValues(root, 14, 5).toString());
        assertEquals("[8, 9, 13, 13, 20]", closestKValuesOptimized(root, 14, 5).toString());
    }
}
