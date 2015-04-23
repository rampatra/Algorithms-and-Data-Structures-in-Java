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
public class RecursiveBST<E extends Comparable<E>> extends BinarySearchTree<E> {

    public static void main(String[] a) {
        RecursiveBST obj = new RecursiveBST();
        obj.put(6);
        obj.put(3);
        obj.put(5);
        obj.put(7);
        obj.put(8);
        obj.put(9);
        obj.preOrder();
        Utils.println("");
        obj.inOrder();
        Utils.println("");
        obj.postOrder();
        Utils.println("\n" + obj.size());
        Utils.println(BinaryTree.isIdentical(obj.root.right, obj.root.right));
        Utils.println(obj.isIdentical(obj.root));
        Utils.println(obj.height());
        /*obj.delete();
        Utils.println("After deletion: ");
        obj.postOrder();*/
        Utils.println("In Order: ");
        obj.inOrder();
        Utils.println("\nAfter mirroring: ");
        obj.mirror();
        obj.inOrder();
        Utils.println("\nRoot to leafs: ");
        obj.rootToLeafPaths();
    }

    /**
     * Inserts a node into the tree.
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
}
