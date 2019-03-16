package com.rampatra.trees;

import com.rampatra.base.BinaryNode;
import com.rampatra.base.BinarySearchTree;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/26/15
 * @time: 7:23 PM
 */
public class InOrderWithoutStackAndRecursion<E extends Comparable<E>> extends BinarySearchTree<E> {

    public void inOrder() {
        inOrderWithoutStackAndRecursion(root);
    }

    /**
     * Using Morris Traversal, we can traverse the tree without using stack and
     * recursion. The idea of Morris Traversal is based on Threaded Binary Tree.
     * In this traversal, we first create links to Inorder successor and print the
     * data using these links, and finally revert the changes to restore original tree.
     * <p/>
     * A binary tree is THREADED by making all right child pointers that would normally
     * be null point to the inorder successor of the node (if it exists), and all left
     * child pointers that would normally be null point to the inorder predecessor of
     * the node.
     * <p/>
     * PSEUDOCODE:
     * 1. Initialize current as root
     * 2. While current is not NULL
     * If current does not have left child
     * a) Print current’s data
     * b) Go to right child, i.e., current = current->right
     * Else
     * a) Make current as right child of the rightmost node in current's left subtree
     * b) Go to left child, i.e., current = current->left
     *
     * @param node
     */
    public void inOrderWithoutStackAndRecursion(BinaryNode<E> node) {
        if (node == null) return;

        BinaryNode<E> curr = node;

        while (curr != null) {
            // print the leftmost node
            if (curr.left == null) {
                printValue(curr);
                curr = curr.right;
            } else { // make current as right child of the rightmost node in current's left subtree
                BinaryNode<E> pre = curr.left;

                while (pre.right != curr && pre.right != null) {
                    pre = pre.right;
                }
                if (pre.right != curr) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    printValue(curr);
                    curr = curr.right;
                    pre.right = null; // revert to the original tree structure
                }
            }
        }
    }

    public static void main(String[] args) {
        InOrderWithoutStackAndRecursion<Integer> bst = new InOrderWithoutStackAndRecursion<>();
        bst.put(6);
        bst.put(3);
        bst.put(5);
        bst.put(7);
        bst.put(8);
        bst.put(9);
        bst.inOrder();
    }
}
