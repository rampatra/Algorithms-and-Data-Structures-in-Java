package com.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 * @author rampatra
 * @since 2019-02-16
 */
public class ListOfDepths {

    /**
     * This approach visits the root node, adds all its children to a list, then iterates
     * that list, and repeats the same process until all nodes are visited.
     *
     * @param root the root node of the tree
     * @return list of nodes at each depth, where depth starts from 0
     */
    private static List<List<TreeNode>> listOfDepths(TreeNode root) {
        List<List<TreeNode>> listOfDepths = new ArrayList<>();
        List<TreeNode> listOfNodesAtCurrentDepth = new ArrayList<>();

        if (root != null) {
            listOfNodesAtCurrentDepth.add(root);
        }

        while (listOfNodesAtCurrentDepth.size() > 0) {
            listOfDepths.add(listOfNodesAtCurrentDepth); // add current depth
            List<TreeNode> listOfNodesAtPreviousDepth = listOfNodesAtCurrentDepth; // make current depth as previous
            /* make current depth as the new depth to be processed considering 
            the nodes from the previous depth as parents */
            listOfNodesAtCurrentDepth = new ArrayList<>();

            for (TreeNode node : listOfNodesAtPreviousDepth) {
                if (node.left != null) {
                    listOfNodesAtCurrentDepth.add(node.left);
                }
                if (node.right != null) {
                    listOfNodesAtCurrentDepth.add(node.right);
                }
            }
        }

        return listOfDepths;
    }

    /**
     * This is a recursive approach where we pass the depth of each node in the call. We use a
     * list {@code listOfDepths} to keep track of all the depths.
     *
     * @param node
     * @param depth
     * @param listOfDepths
     * @return list of nodes at each depth, where depth starts from 0
     */
    private static List<List<TreeNode>> listOfDepths(TreeNode node, int depth, List<List<TreeNode>> listOfDepths) {
        if (node == null) return null;

        List<TreeNode> listOfNodesAtDepth;
        if (depth == listOfDepths.size()) {
            listOfNodesAtDepth = new ArrayList<>();
            listOfDepths.add(listOfNodesAtDepth);
        } else {
            listOfNodesAtDepth = listOfDepths.get(depth);
        }

        listOfNodesAtDepth.add(node);

        listOfDepths(node.left, depth + 1, listOfDepths);
        listOfDepths(node.right, depth + 1, listOfDepths);

        return listOfDepths;
    }

    private static void printAllDepths(List<List<TreeNode>> listOfDepths) {
        for (int i = 0; i < listOfDepths.size(); i++) {
            System.out.print("Depth " + i + ": ");
            listOfDepths.get(i).forEach(node -> System.out.print("->" + node.val));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1);
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);
        treeRoot.left.left = new TreeNode(4);
        treeRoot.left.right = new TreeNode(5);
        treeRoot.right.left = new TreeNode(6);
        treeRoot.right.right = new TreeNode(7);

        printAllDepths(listOfDepths(treeRoot));
        System.out.println("-----");
        printAllDepths(listOfDepths(treeRoot, 0, new ArrayList<>()));
    }
}
