package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/18/15
 * @time: 2:35 PM
 */
public class RemoveDuplicates {

    /**
     * Removes duplicates from a sorted linked list
     * by traversing it once.
     *
     * @param list
     * @param <E>
     */
    public static <E extends Comparable<E>> void removeDuplicates(SingleLinkedList<E> list) {
        SingleLinkedNode<E> curr = list.getNode(0);
        while (curr != null) {
            // inner while loop for removing multiple duplicates
            while (curr.next != null && curr.item == curr.next.item) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
    }

    /**
     * Removes duplicates from an unsorted linked list.
     * <p/>
     * This method uses {@link HashSet}, another
     * way is that you can sort it using merge sort and then
     * call {@link #removeDuplicates}.
     *
     * @param list
     * @param <E>
     */
    public static <E extends Comparable<E>> void removeDuplicatesFromUnsortedList(SingleLinkedList<E> list) {
        SingleLinkedNode<E> curr = list.getNode(0);
        SingleLinkedNode<E> prev = curr;
        Set<E> itemsInList = new HashSet<>();
        while (curr != null) {
            if (itemsInList.contains(curr.item)) {
                itemsInList.add(curr.item);
            } else { // delete duplicate element
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        linkedList.add(0);
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.printList();
        removeDuplicates(linkedList);
        linkedList.printList();

        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(0);
        linkedList2.add(0);
        linkedList2.add(2);
        linkedList2.add(1);
        linkedList2.add(4);
        linkedList2.add(2);
        linkedList2.add(6);
        linkedList2.add(7);
        linkedList2.add(6);
        linkedList2.printList();
        removeDuplicatesFromUnsortedList(linkedList2);
        linkedList2.printList();
    }
}
