package com.rampatra.linkedlists;

import com.rampatra.base.DoubleLinkedList;
import com.rampatra.base.DoubleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/7/15
 * @time: 4:34 PM
 */
public class MergeSortDoubleLinkedList {

    /**
     * Merge sort for linked list starting at {@param node}.
     *
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> DoubleLinkedNode<E> mergeSort(DoubleLinkedNode<E> node) {
        if (node == null || node.next == null) return node;

        DoubleLinkedNode<E> middleNode, head1, head2;

        middleNode = divideInTwoHalves(node);

        head1 = mergeSort(node);
        head2 = mergeSort(middleNode);

        return mergeTwoSortedLists(head1, head2);

    }


    /**
     * Divides a linked list starting from {@param node} into 2 halves
     * and returns the starting {@code node} of the second half.
     *
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> DoubleLinkedNode<E> divideInTwoHalves(DoubleLinkedNode<E> node) {
        DoubleLinkedNode<E> slow = node, fast = node, prev = slow;

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
     * into one and returns its starting node.
     * <p/>
     * This method is similar to {@link MergeTwoSortedLists#mergeTwoSortedLists}
     *
     * @param node1
     * @param node2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> DoubleLinkedNode<E> mergeTwoSortedLists(DoubleLinkedNode<E> node1,
                                                                                    DoubleLinkedNode<E> node2) {
        DoubleLinkedNode<E> curr1 = node1, curr2 = node2, head, curr;

        if (node1 == null && node2 == null) return null;

        head = curr = new DoubleLinkedNode<>(null); // dummy node

        while (curr1 != null || curr2 != null) {
            // handle cases where either of the list run out first
            if (curr1 == null) {
                curr.next = curr2;
                curr2.prev = curr;
                curr2 = curr2.next;
            } else if (curr2 == null) {
                curr.next = curr1;
                curr1.prev = curr;
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) < 0) {  // advance the current pointer of the
                // list having smaller {@code item}
                curr.next = curr1;
                curr1.prev = curr;
                curr1 = curr1.next;
            } else if (curr1.item.compareTo(curr2.item) > 0) {
                curr.next = curr2;
                curr2.prev = curr;
                curr2 = curr2.next;
            } else { // both nodes are equal so add both to the result
                curr.next = curr1;
                curr = curr.next;
                curr1 = curr1.next;
                curr1.prev = curr;
                curr.next = curr2;
                curr2.prev = curr;
                curr2 = curr2.next;
            }

            curr = curr.next;
        }

        // the dummy node should be unlinked
        head.next.prev = null;

        // return the node next to the dummy node
        return head.next;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(21);
        linkedList.add(33);
        linkedList.add(89);
        linkedList.add(21);
        linkedList.add(44);
        linkedList.add(67);
        linkedList.printList();
        linkedList.printList(mergeSort(linkedList.head));
    }
}
