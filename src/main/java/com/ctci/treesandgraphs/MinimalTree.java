package com.ctci.treesandgraphs;

/**
 * Given a sorted (increasing order) array with unique integer elements, write
 * an algorithm to create a binary search tree with minimal height.
 *
 * @author rampatra
 * @since 2019-02-15
 */
public class MinimalTree {

    private static TreeNode constructBSTWithMinimalHeight(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = constructBSTWithMinimalHeight(arr, start, mid - 1);
        root.right = constructBSTWithMinimalHeight(arr, mid + 1, end);
        return root;
    }

    private static void inOrderTraversal(TreeNode node) {
        if (node == null) return;

        inOrderTraversal(node.left);
        System.out.print("->" + node.val);
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = constructBSTWithMinimalHeight(new int[]{1, 2, 3, 4, 5, 6, 7}, 0, 6);
        inOrderTraversal(root);
        System.out.println();
        root = constructBSTWithMinimalHeight(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0, 7);
        inOrderTraversal(root);
        System.out.println();
        root = constructBSTWithMinimalHeight(new int[]{1, 2}, 0, 1);
        inOrderTraversal(root);
        System.out.println();
        root = constructBSTWithMinimalHeight(new int[]{1}, 0, 0);
        inOrderTraversal(root);
    }
}