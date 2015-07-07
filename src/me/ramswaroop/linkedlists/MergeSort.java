package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/7/15
 * @time: 4:34 PM
 */
public class MergeSort {

    public static <E extends Comparable<E>> SingleLinkedNode<E> mergeSort(SingleLinkedNode<E> node) {
        if (node == null || node.next == null) return null;

        SingleLinkedNode<E> middleNode = divideInTwoHalves(node);

        mergeSort(node);
        mergeSort(middleNode);

        return mergeTwoSortedLists(node, middleNode);

    }


    public static <E extends Comparable<E>> SingleLinkedNode<E> divideInTwoHalves(SingleLinkedNode<E> node) {
        SingleLinkedNode<E> slow = node, fast = node, prev = slow;

        if (node == null || node.next == null) {
            return null;
        }

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    /**
     * Merges two sorted lists starting at {@param node1} and {@param node2}
     * into one and returns its {@code head} reference.
     *
     * @param node1
     * @param node2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> mergeTwoSortedLists(SingleLinkedNode<E> node1,
                                                                                    SingleLinkedNode<E> node2) {
        SingleLinkedNode<E> curr1 = node1, curr2 = node2, head, curr;

        if (node1 == null && node2 == null) return null;

        if (node1 == null) {
            head = node2;
            curr2 = curr2.next;
        } else if (node2 == null) {
            head = node1;
            curr1 = curr1.next;
        } else if (node1.item.compareTo(node2.item) < 0) {
            head = node1;
            curr1 = curr1.next;
        } else {
            head = node2;
            curr2 = curr2.next;
        }

        curr = head;
        while (curr1 != null || curr2 != null) {
            // handle cases where either of the list run out first
            if (curr1 == null) {
                curr.next = curr2;
                curr2 = curr2.next;
            } else if (curr2 == null) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) < 0) {  // advance the current pointer of the
                // list having smaller {@code item}
                curr.next = curr1;
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) > 0) {
                curr.next = curr2;
                curr2 = curr2.next;
            } else { // both nodes are equal so add both to the result
                curr.next = curr1;
                curr = curr.next;
                curr1 = curr1.next;
                curr.next = curr2;
                curr2 = curr2.next;
            }

            curr = curr.next;
        }

        return head;
    }

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(33);
        linkedList.add(21);
        linkedList.add(89);
        linkedList.add(55);
        linkedList.add(44);
        linkedList.add(67);
        linkedList.printList();
        linkedList.printList(mergeSort(linkedList.head));
    }
}
