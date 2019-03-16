package com.rampatra.linkedlists;

import com.rampatra.base.DoubleLinkedList;
import com.rampatra.base.DoubleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/19/15
 * @time: 9:24 AM
 */
public class ReverseDoubleLinkedList {

    /**
     * Reverses the doubly linked list.
     *
     * @param list
     */
    public static <E extends Comparable<E>> void reverseList(DoubleLinkedList<E> list) {

        DoubleLinkedNode<E> curr = list.getNode(0);
        DoubleLinkedNode<E> temp = curr;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        // temp will be null if linked list has only one node
        if (temp != null) {
            list.head = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.printList();
        reverseList(linkedList);
        linkedList.printList();
    }
}
