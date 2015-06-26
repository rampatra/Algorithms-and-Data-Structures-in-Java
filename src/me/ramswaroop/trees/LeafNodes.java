package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;
import me.ramswaroop.common.BinaryTree;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/26/15
 * @time: 6:08 PM
 */
public class LeafNodes<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Returns the number of leaf nodes in a binary tree.
     *
     * @return
     */
    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    public int countLeafNodes(BinaryNode<E> node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeafNodes(node.left) + countLeafNodes(node.right);
        }
    }

    public static void main(String a[]) {
        LeafNodes<Integer> bt = new LeafNodes<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        System.out.println(bt.countLeafNodes());
    }
}
