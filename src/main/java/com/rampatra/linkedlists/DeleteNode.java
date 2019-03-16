package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/18/15
 * @time: 2:35 PM
 */
public class DeleteNode {

    /**
     * Given a pointer to a node, delete it.
     *
     * @param node
     * @param <E>
     */
    public static <E extends Comparable<E>> void deleteNode(SingleLinkedNode<E> node) {
        // assert node isn't the last node in the linked list
        node.item = node.next.item;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.printList();
        deleteNode(linkedList.getNode(1));
        linkedList.printList();
    }
}
