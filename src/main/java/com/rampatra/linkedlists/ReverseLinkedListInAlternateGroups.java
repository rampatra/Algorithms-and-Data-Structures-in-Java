package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/30/15
 * @time: 9:33 AM
 */
public class ReverseLinkedListInAlternateGroups<E extends Comparable<E>> extends SingleLinkedList<E> {

    /**
     * Reverses the linked list in groups alternatively.
     * <p/>
     * It is similar to {@link ReverseLinkedListInGroups} but
     * does alternatively.
     * <p/>
     * Example:
     * Inputs:   1->2->3->4->5->6->7->8->9 and k = 3
     * Output:   3->2->1->4->5->6->9->8->7
     *
     * @param node
     * @param k
     * @return
     */
    public SingleLinkedNode<E> reverseLinkedListInAltGroups(SingleLinkedNode<E> node, int k) {
        int i = 0;
        SingleLinkedNode<E> curr = node, prev = null, next = null;

        // reverse the 'next' pointer of nodes with help of 3 pointers
        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // update the head
        if (node == head) {
            head = prev;
        }

        if (node != null) node.next = next;

        // move the pointer k steps ahead
        i = 1;
        while (curr != null && i < k) {
            curr = curr.next;
            i++;
        }

        // recursively call on the next set of nodes
        if (curr != null) {
            curr.next = reverseLinkedListInAltGroups(curr.next, k);
        }

        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedListInAlternateGroups<Integer> linkedList = new ReverseLinkedListInAlternateGroups<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        linkedList.add(88);
        linkedList.add(99);
        linkedList.printList();
        linkedList.reverseLinkedListInAltGroups(linkedList.head, 2);
        linkedList.printList();
    }
}
