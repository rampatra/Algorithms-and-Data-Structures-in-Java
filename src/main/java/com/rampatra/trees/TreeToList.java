package com.rampatra.trees;

import com.rampatra.base.BinaryNode;
import com.rampatra.base.BinarySearchTree;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/26/15
 * @time: 4:38 PM
 */
public class TreeToList<E extends Comparable<E>> extends BinarySearchTree<E> {

    /**
     * A recursive function that takes an ordered binary tree
     * and rearranges the internal pointers to make a circular
     * doubly linked list out of the tree nodes. The list should
     * be arranged so that the nodes are in increasing order.
     */
    public void treeToList() {
        // print the list
        printList(treeToList(root));
    }

    public static <E extends Comparable<E>> BinaryNode<E> treeToList(BinaryNode<E> node) {
        if (node == null) return null;

        BinaryNode<E> aList = treeToList(node.left);
        BinaryNode<E> bList = treeToList(node.right);

        node.left = node;
        node.right = node;

        // attach left child then root followed by right child (so that final list is in ascending order)
        aList = addToList(aList, node);
        aList = addToList(aList, bList);

        return aList;
    }

    private static <E extends Comparable<E>> BinaryNode<E> addToList(BinaryNode<E> aList, BinaryNode<E> bList) {

        if (aList == null) return bList;
        if (bList == null) return aList;

        // find the last node in each list
        BinaryNode<E> aListLast = aList.left;
        BinaryNode<E> bListLast = bList.left;

        // join end of one list to beginning of another
        aListLast.right = bList;
        bList.left = aListLast;

        // make circular
        aListLast.left = bListLast;
        bListLast.right = aList;

        return aList;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.put(6);
        bst.put(3);
        bst.put(5);
        bst.put(7);
        bst.put(8);
        bst.put(9);
        bst.inOrder();
        // TODO incorrect results
        bst.printList(treeToList(bst.root));
    }
}
