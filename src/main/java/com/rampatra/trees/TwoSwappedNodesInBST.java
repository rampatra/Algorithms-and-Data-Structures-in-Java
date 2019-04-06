package com.rampatra.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Two nodes are swapped in a BST, write a function to find these two nodes.
 * <p>
 * Approach:
 * 1. We perform an in-order traversal of the tree and find the 2 discontinuities, i.e, the nodes which are larger than their next node.
 * 2. We take the left node of the first discontinuity and the right node of the second.
 * <p>
 * Note: There is one edge case where the two nodes swapped are parent and child nodes. This means that in the in-order
 * traversal these two nodes will be adjacent. Therefore, in this case, these two nodes will be our answer.
 * <p>
 * See this <a href="https://www.youtube.com/watch?v=O4zB91sMKhM">youtube video</a> for a visual understanding.
 *
 * @author rampatra
 * @since 2019-04-06
 */
public class TwoSwappedNodesInBST {

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

    private static List<TreeNode> findSwappedNodes(TreeNode root) {
        List<TreeNode> inOrderTraversal = new ArrayList<>();
        TreeNode firstSwappedNode = null;
        TreeNode secondSwappedNode = null;
        TreeNode plausibleSwappedNode = null;

        traverseInOrder(root, inOrderTraversal);

        for (int i = 0; i < inOrderTraversal.size() - 1; i++) {
            // find nodes not in ascending order
            if (inOrderTraversal.get(i).val > inOrderTraversal.get(i + 1).val) {
                if (firstSwappedNode == null) {
                    firstSwappedNode = inOrderTraversal.get(i); // take the left node from the first violation
                    plausibleSwappedNode = inOrderTraversal.get(i + 1);
                } else {
                    secondSwappedNode = inOrderTraversal.get(i + 1); // take the right node from the second violation
                }
            }
        }

        return Arrays.asList(firstSwappedNode, secondSwappedNode == null ? plausibleSwappedNode : secondSwappedNode);
    }

    private static void traverseInOrder(TreeNode node, List<TreeNode> inOrderTraversal) {
        if (node == null) return;

        traverseInOrder(node.left, inOrderTraversal);
        inOrderTraversal.add(node);
        traverseInOrder(node.right, inOrderTraversal);
    }

    public static void main(String[] args) {
        /*
        
        Test case 1: Node 8 and node 2 are swapped
        
            The current BST looks like:
            
                      4
                   /    \
                  8      2
                /  \   /  \
               1   3  6   9
              /
             0
             
            Instead, the correct BST should look like:
            
                      4
                   /    \
                  2      8
                /  \   /  \
               1   3  6   9
              /
             0
             
         */
        TreeNode treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(8);
        treeRoot.right = new TreeNode(2);
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.right = new TreeNode(3);
        treeRoot.left.left.left = new TreeNode(0);
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.right = new TreeNode(9);

        System.out.println(findSwappedNodes(treeRoot));
        
        /*
        
        Test case 2: Node 3 and node 2 are swapped (note: these are parent child nodes)
        
            The current BST looks like:
            
                      4
                   /    \
                  3      8
                /  \   /  \
               1   2  6   9
              /
             0
             
            Instead, the correct BST should look like:
            
                      4
                   /    \
                  2      8
                /  \   /  \
               1   3  6   9
              /
             0
             
         */
        treeRoot = new TreeNode(4);
        treeRoot.left = new TreeNode(3);
        treeRoot.right = new TreeNode(8);
        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.right = new TreeNode(2);
        treeRoot.left.left.left = new TreeNode(0);
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.right = new TreeNode(9);

        System.out.println(findSwappedNodes(treeRoot));
    }
}