package com.rampatra.linkedlists;

import com.rampatra.common.SingleLinkedList;
import com.rampatra.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/27/15
 * @time: 5:27 PM
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

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.printList();
        deleteAlternateNodes(linkedList);
        linkedList.printList();

    }
}
