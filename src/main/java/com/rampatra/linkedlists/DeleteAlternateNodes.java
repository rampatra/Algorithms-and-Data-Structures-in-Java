package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Delete alternate nodes in a single linked list.
 *
 * @author rampatra
 * @since 6/27/15
 */
public class DeleteAlternateNodes {

    public static <E extends Comparable<E>> void deleteAlternateNodes(SingleLinkedList<E> list) {
        deleteAlternateNodes(list.head);
    }

    public static <E extends Comparable<E>> void deleteAlternateNodes(SingleLinkedNode<E> node) {
        if (node == null || node.next == null) return;

        node.next = node.next.next;

        deleteAlternateNodes(node.next);
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.printList();
        deleteAlternateNodes(linkedList);
        linkedList.printList();

    }
}
