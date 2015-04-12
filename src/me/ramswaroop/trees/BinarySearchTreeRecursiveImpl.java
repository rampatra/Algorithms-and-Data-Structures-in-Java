package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;
import me.ramswaroop.common.BinarySearchTree;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 3/24/15
 * Time: 3:02 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinarySearchTreeRecursiveImpl<E extends Integer> implements BinarySearchTree<E> {

    BinaryNode root;

    BinarySearchTreeRecursiveImpl() {
        root = null;
    }

    public static void main(String[] a) {
        BinarySearchTreeRecursiveImpl obj = new BinarySearchTreeRecursiveImpl();
        obj.insert(2, null);
        obj.insert(3, obj.root);
        obj.insert(5, obj.root);
        obj.insert(6, obj.root);
        obj.preOrder(obj.root);

    }

    /**
     * Inserts a node to the tree.
     *
     * @param data
     */
    @Override
    public void insert(E data, BinaryNode<E> node) {
        if (node == null) {
            node = new BinaryNode<>(data, null, null);
        } else {
            if (data.intValue() < node.getData().intValue()) {
                insert(data, node.getLeft());
            } else {
                insert(data, node.getRight());
            }
        }
    }

    /**
     * Deletes a particular node from the tree.
     *
     * @param data
     */
    @Override
    public void delete(E data) {

    }

    /**
     * Prints the pre-order traversal of the tree.
     */
    @Override
    public void preOrder(BinaryNode<E> node) {
        if (node == null) {
            throw new NoSuchElementException();
        }
        print(node.getData());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * Prints the in-order traversal of the tree.
     */
    @Override
    public void inOrder() {

    }

    /**
     * Prints the post-order traversal of the tree.
     */
    @Override
    public void postOrder() {

    }

    /**
     * Returns the number of nodes currently in the tree.
     *
     * @return
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Tests if this tree is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    private void print(E value) {
        System.out.print(value);
    }

}
