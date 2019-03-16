package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/12/15
 * @time: 1:23 PM
 */
public class SwapNodes {

    /**
     * Swap nodes with value {@param item1} with {@param item2} in linked list
     * starting at {@param node}.
     *
     * @param node
     * @param item1
     * @param item2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> swap(SingleLinkedNode<E> node,
                                                                     E item1,
                                                                     E item2) {

        // dummy node needed to swap the very first node
        SingleLinkedNode<E> head = new SingleLinkedNode<>(null),
                curr1 = head,
                curr2 = head,
                temp;

        head.next = node;

        while (curr1.next != null && curr1.next.item != item1) {
            curr1 = curr1.next;
        }

        while (curr2.next != null && curr2.next.item != item2) {
            curr2 = curr2.next;
        }

        // if either of the node isn't present in the list then do nothing
        if (curr1.next == null || curr2.next == null) return head.next;

        // swap nodes
        temp = curr1.next;
        curr1.next = curr2.next;
        curr2.next = temp;

        // update their next nodes
        temp = curr1.next.next;
        curr1.next.next = curr2.next.next;
        curr2.next.next = temp;

        return head.next;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        linkedList.printList();
        linkedList.printList(swap(linkedList.head, 111, 77));
    }
}
