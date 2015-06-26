package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;
import me.ramswaroop.common.BinaryTree;

import java.util.List;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/26/15
 * @time: 7:14 PM
 */
public class CheckForBST<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Checks whether the binary tree is a BST or not.
     * <p/>
     * Approach: Performs in-order traversal of the tree and if
     * the result isn't in ascending order then returns false.
     *
     * @return
     */
    public boolean isBST() {
        //List<BinaryNode<E>> list = new ArrayList<>();
        BinaryNode<E> prev = new BinaryNode<>(null);
        return isBST(root, prev);
    }

    /**
     * Traverse the tree in in-order fashion and insert all nodes
     * in a list and check for sort order of list.
     *
     * @param node
     * @param list
     * @return
     */
    public boolean isBST(BinaryNode<E> node, List<BinaryNode<E>> list) {
        if (node == null) return true;

        boolean left = isBST(node.left, list);

        // while adding node to list, compare it with previous node in list
        if (list.size() > 0 && list.get(list.size() - 1).value.compareTo(node.value) > 0) {
            return false;
        }
        list.add(node);

        boolean right = isBST(node.right, list);

        return left && right;
    }

    /**
     * Traverse the tree in in-order fashion and keep track of prev node.
     * <p/>
     *
     * @param node
     * @param prev
     * @return
     */
    public boolean isBST(BinaryNode<E> node, BinaryNode<E> prev) {
        if (node == null) return true;

        boolean left = isBST(node.left, prev);

        // compare current node with previous node
        if (prev.value != null && prev.value.compareTo(node.value) > 0) {
            return false;
        }
        prev.value = node.value;

        boolean right = isBST(node.right, prev);

        return left && right;
    }

    public static void main(String a[]) {
        CheckForBST<Integer> bt = new CheckForBST<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        out.println("Is BST: ");
        out.println(bt.isBST());
    }
}
