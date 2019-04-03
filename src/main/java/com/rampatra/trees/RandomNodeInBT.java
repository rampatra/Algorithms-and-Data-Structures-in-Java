package com.rampatra.trees;

import java.util.Random;

/**
 * You are implementing a binary tree class from scratch, which has a method getRandomNode() which returns a
 * random node from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
 * for getRandomNode().
 *
 * @author rampatra
 * @since 2019-04-03
 */
public class RandomNodeInBT {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int size; // num of nodes in left subtree + 1 + num of nodes in right subtree

        TreeNode(int val, int size) {
            this.val = val;
            this.size = size;
        }

        TreeNode getRandomNode() {
            int randomNum = new Random().nextInt(this.size); // generates a random num from 0 to size - 1 (both inclusive)

            /*
                the below makes all nodes equally likely because the probability is distributed
                evenly (approximately) depending on the number of children
            */
            if (this.left != null && randomNum < this.left.size) {
                return left.getRandomNode();
            } else if (this.right != null && randomNum > this.right.size) {
                return right.getRandomNode();
            } else {
                return this;
            }
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
             
         */
        TreeNode treeRoot = new TreeNode(4, 7);
        treeRoot.left = new TreeNode(2, 3);
        treeRoot.right = new TreeNode(8, 3);
        treeRoot.left.left = new TreeNode(1, 1);
        treeRoot.left.right = new TreeNode(3, 1);
        treeRoot.right.left = new TreeNode(6, 1);
        treeRoot.right.right = new TreeNode(9, 1);

        System.out.println(treeRoot.getRandomNode().val);
        System.out.println(treeRoot.getRandomNode().val);
        System.out.println(treeRoot.getRandomNode().val);
        System.out.println(treeRoot.getRandomNode().val);
        System.out.println(treeRoot.getRandomNode().val);
        System.out.println(treeRoot.getRandomNode().val);
        System.out.println(treeRoot.getRandomNode().val);
        System.out.println(treeRoot.getRandomNode().val);

        System.out.println("-------");

        System.out.println(new Random().nextInt(8));
        System.out.println(new Random().nextInt(8));
        System.out.println(new Random().nextInt(8));
        System.out.println(new Random().nextInt(8));
        System.out.println(new Random().nextInt(8));
        System.out.println(new Random().nextInt(8));
        System.out.println(new Random().nextInt(8));
        System.out.println(new Random().nextInt(8));
    }
}