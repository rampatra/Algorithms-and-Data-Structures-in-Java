package com.rampatra.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return lists of nodes at each level. The number of lists in the output will be equal to 
 * the number of levels in the tree.
 *
 * @author rampatra
 * @since 2019-04-02
 */
public class ConnectNodesAtSameLevel {

    private static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    private static List<List<TreeNode>> connectNodes(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<TreeNode>> allNodes = new ArrayList<>();
        List<TreeNode> connectedNodesAtLevel = new ArrayList<>();

        queue.add(root);
        queue.add(new TreeNode(null)); // we use a node with null value as a marker for each level

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val != null) {
                connectedNodesAtLevel.add(node);
            } else { // when we encounter a null in the queue, we know that a level is completed
                allNodes.add(connectedNodesAtLevel);
                connectedNodesAtLevel = new ArrayList<>();
                if (queue.peek() != null) queue.add(new TreeNode(null));
                continue;
            }

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return allNodes;
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

        connectNodes(treeRoot).forEach(System.out::println);
        System.out.println("--------------");
        
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

        connectNodes(treeRoot).forEach(System.out::println);
        System.out.println("--------------");

        
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

        connectNodes(treeRoot).forEach(System.out::println);
    }
}
