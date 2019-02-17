package com.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 *
 * @author rampatra
 * @since 2019-02-17
 */
public class ValidateBST {

    private static boolean isBST(TreeNode node) {
        return isBST(node, new ArrayList<>());
    }

    /**
     * This method exploits the fact that the inorder traversal of a binary search tree
     * results in the values being sorted in ascending order. Here, we have used a list
     * but if you see closely we use this list to only compare with the previous element.
     * Ergo, we can use an instance/class variable to store just the last element. This
     * will be a good optimization for space.
     * <p>
     * Time Complexity: O(n) as we touch all the nodes in the tree.
     * Space Complexity: O(n) as we use a list to store all the elements in the tree. If we
     * had used just a instance/class variable, the space complexity would have been O(log n)
     * as there can be up to O(log n) recursive calls as we may recurse up to the depth of
     * the tree. Note, the tree has to balanced though.
     *
     * @param node
     * @param values
     * @return
     */
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

    private static boolean isBSTApproach2(TreeNode node) {
        return isBSTApproach2(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * This approach exploits the condition that all left nodes must be less than or equal to
     * the current node, which must be less than all the right nodes.
     * <p>
     * Time Complexity: O(n) as we touch all the nodes in the tree.
     * Space Complexity: O(log n) as there are up to O(log n) recursive calls on the stack
     * as we may recurse up to the depth fo the tree. Note, the tree has to be balanced though.
     *
     * @param node
     * @param min
     * @param max
     * @return
     */
    private static boolean isBSTApproach2(TreeNode node, int min, int max) {
        if (node == null) return true;

        if (node.val < min || node.val > max) {
            return false;
        }

        return isBSTApproach2(node.left, min, node.val) && isBSTApproach2(node.right, node.val + 1, max);
    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);
        System.out.println("Is BST Approach 1: " + isBST(treeRoot));
        System.out.println("Is BST Approach 2: " + isBSTApproach2(treeRoot));

        treeRoot = new TreeNode(2);
        treeRoot.left = new TreeNode(1);
        treeRoot.right = new TreeNode(3);
        System.out.println("Is BST Approach 1: " + isBST(treeRoot));
        System.out.println("Is BST Approach 2: " + isBSTApproach2(treeRoot));

        treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(8);
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.right = new TreeNode(3);
        treeRoot.left.left.left = new TreeNode(0);
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.right = new TreeNode(9);
        treeRoot.right.left.right = new TreeNode(7);
        System.out.println("Is BST Approach 1: " + isBST(treeRoot));
        System.out.println("Is BST Approach 2: " + isBSTApproach2(treeRoot));
    }
}