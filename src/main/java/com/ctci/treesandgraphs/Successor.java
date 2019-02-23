package com.ctci.treesandgraphs;

/**
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node
 * in a binary search tree. You may assume that each node has a link to its parent.
 *
 * @author rampatra
 * @since 2019-02-17
 */
public class Successor {

    /**
     * To get the inorder successor what this method does is that it checks if the right child of the input node
     * is null and if not, gets the leftmost child of the right child. And, if the right child of the input
     * node is null, it checks all the parents until it finds the next successor.
     *
     * @param node
     * @return
     */
    private static TreeNode getInOrderSuccessor(TreeNode node) {
        if (node == null) return null;

        if (node.right != null) {
            return getLeftmostNode(node.right);
        } else {
            TreeNode curr = node;

            while (curr != null) {
                if (curr.parent != null && curr.parent.left == curr) {
                    return curr.parent;
                }
                curr = curr.parent;
            }
        }
        return null;
    }

    private static TreeNode getLeftmostNode(TreeNode node) {
        TreeNode curr = node;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    private static class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        /* 
            The binary search tree looks like:
        
                     4
                   /   \
                  2     8
                 / \   / \
                1  3  6  9
               /       \
              0        7 
              
         */
        TreeNode treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(2);
        treeRoot.left.parent = treeRoot;
        treeRoot.right = new TreeNode(8);
        treeRoot.right.parent = treeRoot;
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.left.parent = treeRoot.left;
        treeRoot.left.right = new TreeNode(3);
        treeRoot.left.right.parent = treeRoot.left;
        treeRoot.left.left.left = new TreeNode(0);
        treeRoot.left.left.left.parent = treeRoot.left.left;
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.left.parent = treeRoot.right;
        treeRoot.right.right = new TreeNode(9);
        treeRoot.right.right.parent = treeRoot.right;
        treeRoot.right.left.right = new TreeNode(7);
        treeRoot.right.left.right.parent = treeRoot.right.left;

        System.out.println("InOrder successor of 0 is: " + getInOrderSuccessor(treeRoot.left.left.left).val);
        System.out.println("InOrder successor of 1 is: " + getInOrderSuccessor(treeRoot.left.left).val);
        System.out.println("InOrder successor of 2 is: " + getInOrderSuccessor(treeRoot.left).val);
        System.out.println("InOrder successor of 3 is: " + getInOrderSuccessor(treeRoot.left.right).val);
        System.out.println("InOrder successor of 4 is: " + getInOrderSuccessor(treeRoot).val);
        System.out.println("InOrder successor of 6 is: " + getInOrderSuccessor(treeRoot.right.left).val);
        System.out.println("InOrder successor of 7 is: " + getInOrderSuccessor(treeRoot.right.left.right).val);
        System.out.println("InOrder successor of 8 is: " + getInOrderSuccessor(treeRoot.right).val);
        System.out.println("InOrder successor of 9 is: " + getInOrderSuccessor(treeRoot.right.right));
    }
}