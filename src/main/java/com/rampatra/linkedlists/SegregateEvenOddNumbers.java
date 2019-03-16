package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/30/15
 * @time: 10:32 PM
 */
public class SegregateEvenOddNumbers {

    /**
     * Modifies the linked list such that all even numbers appear
     * before all the odd numbers in the linked list.
     * <p/>
     * Algorithm:
     * ----------
     * 1) Make a pointer point the last node of the list.
     * <p/>
     * 2) Traverse the linked list from start and append all odd values
     * nodes to the end of the above pointer.
     * <p/>
     * 3) If the pointer in step 1 points to a odd valued node then move it
     * to the end so that the relative order of nodes remains unchanged.
     *
     * @param list
     * @param <E>
     */
    public static <E extends Comparable<E>> void segregateEvenOddNumbers(SingleLinkedList<E> list) {
        SingleLinkedNode<E> curr = list.head, prev = null, end = curr, separator;

        // a pointer to the last node
        while (end.next != null) {
            end = end.next;
        }
        separator = end;

        // move all odd valued nodes after the end node
        while (curr != separator) {
            if (Integer.parseInt(curr.item.toString()) % 2 != 0) {
                end.next = curr;
                curr = curr.next;
                end = end.next;
                end.next = null;
                if (curr == list.head) {
                    list.head = curr;
                } else {
                    prev.next = curr;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        // if separator is odd valued then move it to the end (if its not already in the end)
        if (Integer.parseInt(separator.item.toString()) % 2 != 0 && separator.next != null) {
            prev.next = curr.next;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = separator;
            separator.next = null;
        }

    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        linkedList.printList();
        segregateEvenOddNumbers(linkedList);
        linkedList.printList();
    }
}
