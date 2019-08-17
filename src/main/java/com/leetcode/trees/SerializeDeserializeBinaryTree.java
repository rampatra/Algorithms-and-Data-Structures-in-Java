package com.leetcode.trees;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Level: Hard
 * Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Description:
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need
 * to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
 * should be stateless.
 *
 * @author rampatra
 * @since 2019-08-17
 */
public class SerializeDeserializeBinaryTree {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/252443769/">31 ms</a>.
     *
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (sb.length() > 1) {
                sb.append(", ");
            }
            if (node == null) {
                sb.append("null");
                continue;
            }

            sb.append(node.val);

            queue.add(node.left);
            queue.add(node.right);
        }

        sb.append("]");
        return removeExtraNulls(sb.toString());
    }

    private static String removeExtraNulls(String data) {
        int i = data.length() - 1;
        while (!(data.charAt(i) >= 48 && data.charAt(i) <= 57)) {
            i--;
        }
        return data.substring(0, i + 1) + "]";
    }

    /**
     *
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);

        if (data.length() == 0) {
            return null;
        }

        String[] values = data.split(", ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 0; i < values.length && !queue.isEmpty(); i += 2) {
            TreeNode currNode = queue.poll();

            if (i + 1 < values.length && !values[i + 1].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i + 1]));
                currNode.left = leftNode;
                queue.add(leftNode);
            }

            if (i + 2 < values.length && !values[i + 2].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i + 2]));
                currNode.right = rightNode;
                queue.add(rightNode);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        // TODO Convert the print statements to asserts

        System.out.println(serialize(new TreeNode(1)));

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

        System.out.println(serialize(tree));

        System.out.println(serialize(deserialize(serialize(tree))));

        System.out.println(serialize(deserialize(serialize(null))));

        TreeNode tree2 = new TreeNode(1);
        tree2.right = new TreeNode(2);
        tree2.right.right = new TreeNode(3);
        tree2.right.right.right = new TreeNode(4);
        tree2.right.right.right.right = new TreeNode(5);
        tree2.right.right.right.right.right = new TreeNode(6);
        tree2.right.right.right.right.right.right = new TreeNode(7);
        tree2.right.right.right.right.right.right.right = new TreeNode(8);

        System.out.println(serialize(tree2));
        System.out.println(serialize(deserialize(serialize(tree2))));

        System.out.println("---");

        System.out.println(serialize(deserialize("[1, 2]")));
        System.out.println(serialize(deserialize("[1, 2, 3]")));
        System.out.println(serialize(deserialize("[3, 2, 4, 1]")));
        System.out.println(serialize(deserialize("[3, 2, 4, 1, 5, 6]")));
        System.out.println(serialize(deserialize("[1, 2, 3, null, null, 4, 5]")));
        System.out.println(serialize(deserialize("[5, 2, 3, null, null, 2, 4, 3, 1]")));

        System.out.println(serialize(deserialize("[1, null, 2, null, 3, null, 4, null, 5]")));
        System.out.println(serialize(deserialize("[1, null, 2, null, 3, null, 4, null, 5, null, 6]")));
        System.out.println(serialize(deserialize("[1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7]")));
        System.out.println(serialize(deserialize("[1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8]")));
        System.out.println(serialize(deserialize("[1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9]")));
    }
}