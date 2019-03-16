package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/29/15
 * @time: 2:32 PM
 */
public class ReverseLinkedListInGroups {

    /**
     * Reverses the linked list in groups.
     * <p>
     * Example:
     * <p>
     * Inputs:  1->2->3->4->5->6->7->8 and k = 3
     * Output:  3->2->1->6->5->4->8->7.
     * <p>
     * Inputs:   1->2->3->4->5->6->7->8 and k = 5
     * Output:  5->4->3->2->1->8->7->6.
     *
     * @param node
     * @param k
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> reverseLinkedListInGroups(SingleLinkedNode<E> node, int k) {

        SingleLinkedNode<E> curr = node, prev = null, next = null;
        int i = 0;

        // reverse the 'next' pointer of nodes with help of 3 pointers
        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // recursively call for the rest of the nodes in the linked list
        if (next != null) {
            node.next = reverseLinkedListInGroups(curr, k);
        }

        return prev;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);
        linkedList.printList();
        SingleLinkedList.printList(reverseLinkedListInGroups(linkedList.head, 3));
    }
}
