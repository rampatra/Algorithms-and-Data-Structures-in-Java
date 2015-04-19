package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/19/15
 * Time: 6:35 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinaryTree<E> extends Tree<E> {
    BinaryNode<E> root;

    public static <E> boolean isIdentical(BinaryNode<E> node1, BinaryNode<E> node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null && node2 != null || (node1 != null && node2 == null)) return false;

        if (node1.value == node2.value) {
            return true && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
        } else {
            return false;
        }
    }

    public int height() {
        return height(root);
    }

    public int height(BinaryNode<E> node) {
        return 0;
    }

    public boolean isIdentical(BinaryNode<E> node) {
        return isIdentical(this.root, node);
    }
}
