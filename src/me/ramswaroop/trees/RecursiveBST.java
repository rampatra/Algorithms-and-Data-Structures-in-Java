package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;
import me.ramswaroop.utils.Utils;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 3/24/15
 * Time: 3:02 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class RecursiveBST<E extends Comparable<E>> extends Tree {

    BinaryNode root;

    public static void main(String[] a) {
        RecursiveBST obj = new RecursiveBST();
        obj.put(6);
        obj.put(3);
        obj.put(5);
        obj.put(7);
        obj.preOrder();
        obj.print("\n");
        obj.inOrder();
        obj.print("\n");
        obj.postOrder();
        Utils.println("\n" + obj.size());
    }

    /**
     * Inserts a node to the tree.
     *
     * @param value
     */
    public void put(E value) {
        put(root, value);
    }

    public BinaryNode<E> put(BinaryNode<E> node, E value) {
        if (node == null) {
            return root = new BinaryNode<>(value, null, null);
        } else {
            if (value.compareTo(node.value) < 0) {
                if (node.left == null) {
                    return node.left = new BinaryNode<>(value, null, null);
                } else {
                    return put(node.left, value);
                }
            } else {
                if (node.right == null) {
                    return node.right = new BinaryNode<>(value, null, null);
                } else {
                    return put(node.right, value);
                }
            }
        }
    }

    /**
     * Deletes a particular node from the tree.
     *
     * @param value
     */
    public void delete(E value) {

    }

    /**
     * Prints the pre-order traversal of the tree.
     */
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Prints the in-order traversal of the tree.
     */
    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        print(node.value);
        inOrder(node.right);
    }

    /**
     * Prints the post-order traversal of the tree.
     */
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        print(node.value);
    }

    /**
     * Returns the number of nodes currently in the tree.
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    public int size(BinaryNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.left) + 1 + size(node.right);
        }
    }

    /**
     * Tests if this tree is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Utility methods
     *
     * @param value
     */
    private void print(E value) {
        System.out.print(value);
    }

}
