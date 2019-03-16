package com.rampatra.linkedlists;

import com.rampatra.base.CircularSingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/29/15
 * @time: 6:16 PM
 */
public class InsertInSortedCircularLinkedList<E extends Comparable<E>> extends CircularSingleLinkedList<E> {

    /**
     * Inserts an element in the sorted circular
     * linked list maintaining the sorted property.
     *
     * @param item
     */
    public void insert(E item) {
        SingleLinkedNode<E> node = head, curr = node;

        do {
            if (node.item.compareTo(item) > 0) { // new node is to be inserted before head
                // last node should now point to the new head
                while (curr.next != head) {
                    curr = curr.next;
                }
                head = new SingleLinkedNode<>(item, node);
                curr.next = head;
                return;
            } else if (node.next.item.compareTo(item) > 0) {
                node.next = new SingleLinkedNode<>(item, node.next);
                return;
            } else if (node.next == head) {
                node.next = new SingleLinkedNode<>(item, head);
                return;
            }
            node = node.next;
        } while (node != head);
    }

    public static void main(String[] args) {
        InsertInSortedCircularLinkedList<Integer> linkedList = new InsertInSortedCircularLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.printList();
        linkedList.insert(-2);
        linkedList.insert(9);
        linkedList.insert(44);
        linkedList.printList();
    }
}
