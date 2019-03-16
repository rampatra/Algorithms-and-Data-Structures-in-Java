package com.rampatra.linkedlists;

import com.rampatra.base.DoubleLinkedList;
import com.rampatra.base.DoubleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/24/15
 * @time: 3:16 PM
 */
public class SortedDLLToBBST {

    /**
     * Returns the number of nodes in the doubly linked list.
     *
     * @param node
     * @param <E>
     * @return
     */
    static <E extends Comparable<E>> int getLength(DoubleLinkedNode<E> node) {
        int l = 0;
        DoubleLinkedNode<E> curr = node;
        while (curr != null) {
            curr = curr.next;
            l++;
        }
        return l;
    }

    /**
     * @param node
     * @param <E>
     */
    static <E extends Comparable<E>> void inOrder(DoubleLinkedNode<E> node) {
        if (node == null) return;
        inOrder(node.prev);
        System.out.print(node.item.toString());
        inOrder(node.next);
    }

    /**
     * Converts a sorted doubly linked list to a balanced binary tree in-place.
     *
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> DoubleLinkedNode<E> sortedDLLToBBST(DoubleLinkedNode<E> node) {
        return sortedDLLToBBST(node, getLength(node));
    }

    public static <E extends Comparable<E>> DoubleLinkedNode<E> sortedDLLToBBST(DoubleLinkedNode<E> node, int n) {
        if (n <= 0) {
            return null;
        }

        DoubleLinkedNode<E> left = sortedDLLToBBST(node, n / 2);

        DoubleLinkedNode<E> root = node;
        root.prev = left;

        node = node.next;

        DoubleLinkedNode<E> right = sortedDLLToBBST(node, n - n / 2 - 1);
        root.next = right;

        return root;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        linkedList.printList();
        inOrder(sortedDLLToBBST(linkedList.head));
        System.out.println();
        linkedList.printList();
    }
}
