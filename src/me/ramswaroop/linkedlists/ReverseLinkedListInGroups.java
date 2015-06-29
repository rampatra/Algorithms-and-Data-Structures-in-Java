package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/29/15
 * @time: 2:32 PM
 */
public class ReverseLinkedListInGroups<E extends Comparable<E>> extends SingleLinkedList<E> {

    /**
     * Reverses the linked list in groups.
     *
     * Example:
     *
     * Inputs:  1->2->3->4->5->6->7->8 and k = 3
     * Output:  3->2->1->6->5->4->8->7.
     *
     * Inputs:   1->2->3->4->5->6->7->8 and k = 5
     * Output:  5->4->3->2->1->8->7->6.
     *
     * @param node
     * @param k
     * @return
     */
    public SingleLinkedNode<E> reverseLinkedListInGroups(SingleLinkedNode<E> node, int k) {

        SingleLinkedNode<E> curr = node, prev = null, next = null;
        int i = 0;

        // reverse the 'next' pointer of nodes
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

        // recursively call for the rest of the nodes in the linked list
        if (next != null) {
            node.next = reverseLinkedListInGroups(next, k);
        }

        return prev;
    }

    public static void main(String a[]) {
        ReverseLinkedListInGroups<Integer> linkedList = new ReverseLinkedListInGroups<>();
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
        linkedList.add(100);
        linkedList.printList();
        linkedList.reverseLinkedListInGroups(linkedList.head, 3);
        linkedList.printList();
    }
}
