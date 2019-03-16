package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/20/15
 * @time: 3:03 PM
 */
public class SortAlternativelySortedLinkedList {

    /**
     * Given a Linked List which is in alternating ascending and descending orders. In other words, nodes
     * at even indexes are in ascending order whereas the nodes at odd indexes are in descending order.
     * Sort the list efficiently in O(n) time complexity.
     * <p>
     * Example:
     * <p>
     * Input List:   10->40->53->30->67->12->89->NULL
     * Output List:  10->12->30->43->53->67->89->NULL
     *
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> sort(SingleLinkedNode<E> node) {
        SingleLinkedNode<E> secondList = node.next, curr = node, next;

        // separate even and odd nodes into two separate lists
        while (curr != null && curr.next != null) {
            next = curr.next;
            curr.next = next.next;
            next.next = (curr.next == null) ? null : curr.next.next;
            curr = curr.next;
        }

        // reverse the descending ordered list
        secondList = ReverseSingleLinkedList.recursiveReverseList(secondList);

        // now merge two sorted lists
        return MergeSort.mergeTwoSortedLists(node, secondList);
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(21);
        linkedList.add(67);
        linkedList.add(44);
        linkedList.add(33);
        linkedList.add(89);
        linkedList.printList();
        linkedList.printList(sort(linkedList.head));
    }
}
