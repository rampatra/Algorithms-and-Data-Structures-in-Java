package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/27/15
 * @time: 8:47 PM
 */
public class MergeTwoSortedLists {

    /**
     * Merges two sorted list {@param list1} and {@param list2} into
     * a list with values in ascending order.
     *
     * @param list1
     * @param list2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedList<E> mergeTwoSortedLists(SingleLinkedList<E> list1,
                                                                                    SingleLinkedList<E> list2) {
        SingleLinkedNode<E> curr1 = list1.head, curr2 = list2.head;
        SingleLinkedList<E> intersectedList = new SingleLinkedList<>();
        while (curr1 != null || curr2 != null) {
            // handle cases where either of the list run out first
            if (curr1 == null) {
                intersectedList.add(curr2.item);
                curr2 = curr2.next;
            } else if (curr2 == null) {
                intersectedList.add(curr1.item);
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) < 0) { // advance the current pointer of
                // the list having smaller {@code item}
                intersectedList.add(curr1.item);
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) > 0) {
                intersectedList.add(curr2.item);
                curr2 = curr2.next;
            } else { // both nodes are equal so add both to the result
                intersectedList.add(curr1.item);
                intersectedList.add(curr1.item);
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        return intersectedList;
    }

    /**
     * Recursive method to merge two sorted lists into one sorted list.
     * <p/>
     * NOTE: You can make {@param mergedList} as static and not pass as params
     * to this method.
     *
     * @param node1
     * @param node2
     * @param <E>
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> mergeTwoSortedLists(SingleLinkedList<E> mergedList,
                                                                                    SingleLinkedNode<E> node1,
                                                                                    SingleLinkedNode<E> node2) {

        if (node1 == null && node2 == null) return null;

        // if either of the list runs out first
        if (node1 == null) {
            mergeTwoSortedLists(mergedList, node1, node2.next);
            mergedList.addFirst(node2.item);
            return node2;
        }
        if (node2 == null) {
            mergeTwoSortedLists(mergedList, node1.next, node2);
            mergedList.addFirst(node1.item);
            return node1;
        }

        if (node1.item.compareTo(node2.item) < 0) { // node1 is smaller, so add it and advance the pointer
            mergeTwoSortedLists(mergedList, node1.next, node2);
            mergedList.addFirst(node1.item);
            return node1;
        } else if (node1.item.compareTo(node2.item) > 0) {
            mergeTwoSortedLists(mergedList, node1, node2.next);
            mergedList.addFirst(node2.item);
            return node2;
        } else { // both nodes are equal so add both
            mergeTwoSortedLists(mergedList, node1.next, node2.next);
            mergedList.addFirst(node1.item);
            mergedList.addFirst(node2.item);
            return node1;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList1 = new SingleLinkedList<>();
        linkedList1.add(00);
        linkedList1.add(11);
        linkedList1.add(22);
        linkedList1.add(33);
        linkedList1.add(44);
        linkedList1.add(55);
        linkedList1.printList();
        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(21);
        linkedList2.add(33);
        linkedList2.add(44);
        linkedList2.add(55);
        linkedList2.add(67);
        linkedList2.add(89);
        linkedList2.add(99);
        linkedList2.printList();
        mergeTwoSortedLists(linkedList1, linkedList2).printList();
        System.out.println("====================");
        linkedList1.printList();
        linkedList2.printList();
        SingleLinkedList<Integer> mergedList = new SingleLinkedList<>();
        mergeTwoSortedLists(mergedList, linkedList1.head, linkedList2.head);
        mergedList.printList();
    }
}
