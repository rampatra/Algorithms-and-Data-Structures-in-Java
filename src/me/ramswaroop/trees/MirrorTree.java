package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;
import me.ramswaroop.common.BinaryTree;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/26/15
 * @time: 7:03 PM
 */
public class MirrorTree<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Converts a Tree to its Mirror Tree.
     * <p/>
     * MIRROR OF A BINARY TREE T is another Binary Tree M(T) with
     * left and right children of all non-leaf nodes interchanged.
     * <p/>
     * TIP: In-order traversal of mirror tree is exactly the
     * reverse of the in-order traversal of the original tree.
     */
    public void mirror() {
        mirror(root);
    }

    public void mirror(BinaryNode<E> node) {
        if (node == null) return;

        BinaryNode<E> tempNode;

        // mirror sub-trees
        mirror(node.left);
        mirror(node.right);

        // swap nodes
        tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
    }

    public static void main(String a[]) {
        MirrorTree<Integer> bt = new MirrorTree<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        System.out.println("Original Tree");
        bt.breadthFirstTraversal();
        System.out.println("\nMirror Tree");
        bt.mirror();
        bt.breadthFirstTraversal();
    }
}
