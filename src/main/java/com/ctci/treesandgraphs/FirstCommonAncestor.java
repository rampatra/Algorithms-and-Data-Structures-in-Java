package com.ctci.treesandgraphs;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary
 * tree. Avoid storing additional nodes in a data structure. Also, for this question, the tree node
 * does NOT have access to its parent node. NOTE: This is not necessarily a binary search tree.
 *
 * First Common Ancestor or the Least/Lowest Common Ancestor of two nodes is a node which is the
 * closest to both of the nodes.
 *
 * @author rampatra
 * @since 2019-02-24
 */
public class FirstCommonAncestor {

    /**
     * We recurse through the entire tree with a function called findFCA(TreeNode root, TreeNode TreeNode a, TreeNode b).
     * This function returns values as follows:
     * - Returns p, if root's subtree includes p (and not q).
     * - Returns q, if root's subtree includes q (and not p).
     * - Returns null, if neither p nor q are in root's subtree.
     * - Else, returns the common ancestor of p and q.
     * <p>
     * See {@link com.rampatra.trees.LeastCommonAncestorInBT} for a better answer.
     *
     * @param root
     * @param a
     * @param b
     * @return the least common ancestor node
     */
    private static TreeNode findFCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) { // validation
            return null;
        }
        if (root == a && root == b) { // optimization
            return root;
        }

        TreeNode left = findFCA(root.left, a, b);
        if (left != null && left != a && left != b) {
            return left;
        }

        TreeNode right = findFCA(root.right, a, b);
        if (right != null && right != a && right != b) {
            return right;
        }

        /* One node is found on the left subtree and other on the 
        right one. This means current node is the ancestor. */
        if (left != null && right != null) {
            return root;
        } else if (root == a || root == b) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        /* 
            The binary tree looks like:
        
                     4
                   /   \
                  5     8
                 / \   / \
                1  3  2  9
               /       \
              0        7 
              
         */
        TreeNode treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(5);
        treeRoot.right = new TreeNode(8);
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.right = new TreeNode(3);
        treeRoot.left.left.left = new TreeNode(0);
        treeRoot.right.left = new TreeNode(2);
        treeRoot.right.right = new TreeNode(9);
        treeRoot.right.left.right = new TreeNode(7);

        System.out.println("FCA of 0 and 7 is: " + findFCA(treeRoot, treeRoot.left.left.left, treeRoot.right.left.right).val);
        System.out.println("FCA of 0 and 9 is: " + findFCA(treeRoot, treeRoot.left.left.left, treeRoot.right.right).val);
        System.out.println("FCA of 0 and 1 is: " + findFCA(treeRoot, treeRoot.left.left.left, treeRoot.left.left).val);
        System.out.println("FCA of 1 and 2 is: " + findFCA(treeRoot, treeRoot.left.left, treeRoot.right.left).val);
        System.out.println("FCA of 1 and 7 is: " + findFCA(treeRoot, treeRoot.left.left, treeRoot.right.left.right).val);
        System.out.println("FCA of 4 and 7 is: " + findFCA(treeRoot, treeRoot, treeRoot.right.left.right).val);
        System.out.println("FCA of 5 and 2 is: " + findFCA(treeRoot, treeRoot.left, treeRoot.right.left).val);
        System.out.println("FCA of 7 and 9 is: " + findFCA(treeRoot, treeRoot.right.left.right, treeRoot.right.right).val);
        System.out.println("FCA of 7 and 10 is: " + findFCA(treeRoot, treeRoot.right.left.right, new TreeNode(10)).val); // this use case does not work with the above algorithm
    }
}