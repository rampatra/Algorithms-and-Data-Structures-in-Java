package com.rampatra.trees;

import com.rampatra.base.BinaryNode;
import com.rampatra.base.BinaryTree;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/26/15
 * @time: 7:03 PM
 */
public class MirrorTree {

    /**
     * Converts a Tree to its Mirror Tree.
     * <p/>
     * MIRROR OF A BINARY TREE T is another Binary Tree M(T) with
     * left and right children of all non-leaf nodes interchanged.
     * <p/>
     * TIP: In-order traversal of mirror tree is exactly the
     * reverse of the in-order traversal of the original tree.
     */
    public static <E extends Comparable<E>> void mirror(BinaryNode<E> node) {
        if (node == null) return;

        // mirror sub-trees
        mirror(node.left);
        mirror(node.right);

        // swap nodes
        BinaryNode<E> tempNode;
        tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        System.out.println("Original Tree");
        bt.breadthFirstTraversal();
        System.out.println("\nMirror Tree");
        mirror(bt.root);
        bt.breadthFirstTraversal();
    }
}
