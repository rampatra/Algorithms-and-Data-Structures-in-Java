package com.ctci.treesandgraphs;

/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary
 * tree. Avoid storing additional nodes in a data structure. Also, for this question, the tree node
 * has access to its parent node. NOTE: This is not necessarily a binary search tree.
 *
 * @author rampatra
 * @since 2019-02-23
 */
public class FirstCommonAncestorWithParentAccess {

    /**
     * This is a simple approach where we start with two references, one pointing to {@code node a} and another
     * pointing to {@code node b}. We move the reference pointing to the deeper node upwards, if required, so that
     * both the references are at the same depth from root. After both the references are at same depth, we simply 
     * move both the references upwards until they merge. The node at which they merge is our LCA.
     *
     * @param a
     * @param b
     * @return the least common ancestor node
     */
    private static TreeNode findLCA(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return null;
        }

        int depthA = depth(a);
        int depthB = depth(b);
        /* be little careful when both nodes are at same depth, have the checks such that
         shallow and deeper references point to different nodes */
        TreeNode shallowNode = depthA < depthB ? a : b;
        TreeNode deeperNode = depthB > depthA ? b : a;

        // move deeper node reference upwards so that both the references are at same depth
        deeperNode = goUpBy(deeperNode, Math.abs(depthA - depthB));

        while (shallowNode != deeperNode && shallowNode != null && deeperNode != null) {
            shallowNode = shallowNode.parent;
            deeperNode = deeperNode.parent;
        }

        return shallowNode;
    }

    private static int depth(TreeNode node) {
        int d = 0;
        while (node != null && node.parent != null) {
            d++;
            node = node.parent;
        }
        return d;
    }

    private static TreeNode goUpBy(TreeNode node, int levelsUp) {
        int c = 0;
        while (node != null && c < levelsUp) {
            node = node.parent;
            c++;
        }
        return node;
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
        treeRoot.left.parent = treeRoot;
        treeRoot.right = new TreeNode(8);
        treeRoot.right.parent = treeRoot;
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.left.parent = treeRoot.left;
        treeRoot.left.right = new TreeNode(3);
        treeRoot.left.right.parent = treeRoot.left;
        treeRoot.left.left.left = new TreeNode(0);
        treeRoot.left.left.left.parent = treeRoot.left.left;
        treeRoot.right.left = new TreeNode(2);
        treeRoot.right.left.parent = treeRoot.right;
        treeRoot.right.right = new TreeNode(9);
        treeRoot.right.right.parent = treeRoot.right;
        treeRoot.right.left.right = new TreeNode(7);
        treeRoot.right.left.right.parent = treeRoot.right.left;

        System.out.println("FCA of 0 and 7 is: " + findLCA(treeRoot.left.left.left, treeRoot.right.left.right).val);
        System.out.println("FCA of 0 and 9 is: " + findLCA(treeRoot.left.left.left, treeRoot.right.right).val);
        System.out.println("FCA of 0 and 1 is: " + findLCA(treeRoot.left.left.left, treeRoot.left.left).val);
        System.out.println("FCA of 1 and 2 is: " + findLCA(treeRoot.left.left, treeRoot.right.left).val);
        System.out.println("FCA of 1 and 7 is: " + findLCA(treeRoot.left.left, treeRoot.right.left.right).val);
        System.out.println("FCA of 4 and 7 is: " + findLCA(treeRoot, treeRoot.right.left.right).val);
        System.out.println("FCA of 5 and 2 is: " + findLCA(treeRoot.left, treeRoot.right.left).val);
        System.out.println("FCA of 7 and 9 is: " + findLCA(treeRoot.right.left.right, treeRoot.right.right).val);
    }
}