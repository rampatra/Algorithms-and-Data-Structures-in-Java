package com.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rampatra
 * @since 2019-02-17
 */
public class ValidateBST {

    private static boolean isBST(TreeNode node) {
        return isBST(node, new ArrayList<>());
    }

    private static boolean isBST(TreeNode node, List<Integer> values) {
        if (node == null) return true;

        isBST(node.left, values);
        if (values.isEmpty() || node.val > values.get(values.size() - 1)) {
            values.add(node.val);
        } else {
            return false;
        }
        isBST(node.right, values);

        return true;
    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);
        System.out.println("Is BST: " + isBST(treeRoot));

        treeRoot = new TreeNode(2);
        treeRoot.left = new TreeNode(1);
        treeRoot.right = new TreeNode(3);
        System.out.println("Is BST: " + isBST(treeRoot));

        treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(8);
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.right = new TreeNode(3);
        treeRoot.left.left.left = new TreeNode(0);
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.right = new TreeNode(9);
        treeRoot.right.left.right = new TreeNode(7);
        System.out.println("Is BST: " + isBST(treeRoot));
    }
}
