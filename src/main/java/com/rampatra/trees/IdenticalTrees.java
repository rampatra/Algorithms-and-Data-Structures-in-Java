package com.rampatra.trees;

import com.rampatra.base.BinaryNode;
import com.rampatra.base.BinarySearchTree;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/26/15
 * @time: 5:36 PM
 */
public class IdenticalTrees {

    /**
     * Checks whether two trees having their roots at node1 and node2
     * are identical or not.
     *
     * @param node1
     * @param node2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isIdentical(BinaryNode<E> node1, BinaryNode<E> node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null && node2 != null || (node1 != null && node2 == null)) return false;

        if (node1.value == node2.value) {
            return true && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.put(6);
        bst.put(3);
        bst.put(5);
        bst.put(7);
        bst.put(8);
        bst.put(9);
        out.println(IdenticalTrees.isIdentical(bst.root.right, bst.root.right));
        out.println(IdenticalTrees.isIdentical(bst.root.right, bst.root));
    }
}
