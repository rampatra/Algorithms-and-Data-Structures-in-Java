package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;
import me.ramswaroop.common.BinaryTree;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/26/15
 * @time: 6:02 PM
 */
public class DoubleTree<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Converts a given tree to its Double tree. To create a Double tree
     * of the given tree, create a new duplicate for each node, and insert
     * the duplicate as the left child of the original node.
     */
    public void doubleTree() {
        doubleTree(root);
    }

    public void doubleTree(BinaryNode<E> node) {
        if (node == null) return;

        BinaryNode<E> newNode = new BinaryNode<>(node.value, node.left, null);

        node.left = newNode;

        doubleTree(newNode.left);
        doubleTree(node.right);
    }

    public static void main(String a[]) {
        DoubleTree<Integer> bt = new DoubleTree<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        bt.breadthFirstTraversal();
        out.println();
        bt.doubleTree();
        out.println("BFS after Double tree: ");
        bt.breadthFirstTraversal();
    }
}
