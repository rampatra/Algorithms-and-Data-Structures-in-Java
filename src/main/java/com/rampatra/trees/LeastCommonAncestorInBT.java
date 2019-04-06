package com.rampatra.trees;

/**
 * Given a binary tree {@code root}, find the LCA of two given nodes {@code node1} and  {@code node2}. LCA is a node
 * which is closest to both of the nodes.
 * <p>
 * See this <a href="https://www.youtube.com/watch?v=O4zB91sMKhM">youtube video</a> for a visual understanding of the 
 * approach taken to solve this problem.
 *
 * @author rampatra
 * @since 2019-04-06
 */
public class LeastCommonAncestorInBT {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    private static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null;

        /* 
            optimal: check this first before checking the child nodes recursively because even if the other node
            is in one of the sub-trees the LCA would be root node
         */
        if (root == node1 || root == node2) {
            return root;
        }
        
        TreeNode left = findLCA(root.left, node1, node2);
        TreeNode right = findLCA(root.right, node1, node2);

        if (left != null && right != null) { // one node is in the left sub-tree and the other on the right sub-tree
            return root;
        } else if (left != null) { // we found one node in the left sub-tree
            return left;
        } else if (right != null) { // we found one node in the right sub-tree
            return right;
        } else {
            return null;
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

        System.out.println(findLCA(treeRoot, treeRoot, treeRoot).val); // findLCA(4, 4)
        System.out.println(findLCA(treeRoot, treeRoot.left, treeRoot.right).val); // findLCA(2, 8)
        System.out.println(findLCA(treeRoot, treeRoot.left, treeRoot.left.left).val); // findLCA(2, 1)
        System.out.println(findLCA(treeRoot, treeRoot.left.left, treeRoot.left).val); // findLCA(1, 2)
        System.out.println(findLCA(treeRoot, treeRoot.left.left.left, treeRoot.right.left).val); // findLCA(0, 6)
        System.out.println(findLCA(treeRoot, treeRoot.right, treeRoot.right.right).val); // findLCA(8, 9)
    }
}