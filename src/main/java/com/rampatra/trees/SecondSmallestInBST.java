package com.rampatra.trees;

/**
 * Given a Binary Search Tree, find out the second smallest element in the tree.
 *
 * @author rampatra
 * @since 2019-04-02
 */
public class SecondSmallestInBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode getSecondSmallestNode(TreeNode root) {
        if (root == null) return null;

        TreeNode curr = root;

        if (curr.left == null) {
            if (curr.right == null) {
                return null;
            } else {
                return curr;
            }
        }

        while (curr.left.left != null) {
            curr = curr.left;
        }

        if (curr.left.right != null) {
            return curr.left.right;
        } else {
            return curr;
        }
    }

    public static void main(String[] args) {
        /*
            The BST looks like:
            
                      4
                   /    \
                  2      8
                /  \   /  \
               1   3  6   9
              /
             0
             
         */
        TreeNode treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(8);
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.right = new TreeNode(3);
        treeRoot.left.left.left = new TreeNode(0);
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.right = new TreeNode(9);

        System.out.println(getSecondSmallestNode(treeRoot).val);
        
         /*
            The BST looks like:
            
                      4
                   /    \
                  2      8
                /  \   /  \
               1   3  6   9
             
         */
        treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(8);
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.right = new TreeNode(3);
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.right = new TreeNode(9);

        System.out.println(getSecondSmallestNode(treeRoot).val);
        
        /*
            The BST looks like:
            
                      4
                   /    \
                  2      8
                   \   /  \
                   3  6   9
             
         */
        treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(8);
        treeRoot.left.right = new TreeNode(3);
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.right = new TreeNode(9);

        System.out.println(getSecondSmallestNode(treeRoot).val);
    }
}