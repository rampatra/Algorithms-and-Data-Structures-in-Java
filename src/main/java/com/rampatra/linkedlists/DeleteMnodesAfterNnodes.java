package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/6/15
 * @time: 7:43 PM
 */
public class DeleteMnodesAfterNnodes {

    /**
     * Deletes {@param n} nodes after every {@param m} nodes in {@param list}
     * till it reaches the end of {@param list}.
     *
     * @param list
     * @param m
     * @param n
     * @param <E>
     */
    public static <E extends Comparable<E>> void deleteMnodesAfterNnodes(SingleLinkedList<E> list,
                                                                         int m, int n) {

        SingleLinkedNode<E> curr1 = list.head, curr2;

        while (curr1 != null) {

            // skip m nodes
            for (int i = 1; curr1.next != null && i < m; i++) {
                curr1 = curr1.next;
            }

            // delete n nodes
            curr2 = curr1;
            for (int i = 0; curr2 != null && i <= n; i++) {
                curr2 = curr2.next;
            }
            curr1.next = curr2;

            curr1 = curr1.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(7);
        linkedList.add(5);
        linkedList.add(9);
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(7);
        linkedList.add(5);
        linkedList.add(9);
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.printList();
        deleteMnodesAfterNnodes(linkedList, 3, 2);
        linkedList.printList();
    }
}
