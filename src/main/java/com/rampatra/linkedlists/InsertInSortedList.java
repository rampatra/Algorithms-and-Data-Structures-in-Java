package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/21/15
 * @time: 10:20 PM
 */
public class InsertInSortedList<E extends Comparable<E>> extends SingleLinkedList<E> {

    /**
     * Inserts an element in the sorted linked
     * list maintaining the sorted property.
     *
     * @param item
     */
    public void insert(E item) {
        SingleLinkedNode<E> node = head;

        while (node != null) {
            if (node.item.compareTo(item) > 0) { // new node is to be inserted before head
                head = new SingleLinkedNode<>(item, node);
                return;
            } else if (node.next == null || node.next.item.compareTo(item) > 0) { // new node to be inserted anywhere else
                node.next = new SingleLinkedNode<>(item, node.next);
                return;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        InsertInSortedList<Integer> linkedList = new InsertInSortedList<>();
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