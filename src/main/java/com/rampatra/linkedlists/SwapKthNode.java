package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/13/15
 * @time: 12:25 PM
 */
public class SwapKthNode {

    public static <E extends Comparable<E>> SingleLinkedNode<E> swapKthNodeFromStartWithKthNodeFromEnd(SingleLinkedNode<E> node,
                                                                                                       int k) {


        int i = 1;

        // dummy node needed to swap the very first node
        SingleLinkedNode<E> head = new SingleLinkedNode<>(null),
                curr = head,
                slow = head,
                fast = head,
                temp;

        head.next = node;

        // find kth node from start
        while (i < k && curr.next != null) {
            curr = curr.next;
            fast = fast.next;
            i++;
        }

        // move the fast pointer k steps ahead of slow
        fast = fast.next;

        // find kth node from end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // if either of the node isn't present in the list then do nothing
        if (curr.next == null || slow.next == null) return head.next;

        // swap nodes
        temp = curr.next;
        curr.next = slow.next;
        slow.next = temp;

        // update their next nodes
        temp = curr.next.next;
        curr.next.next = slow.next.next;
        slow.next.next = temp;

        return head.next;

    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        linkedList.printList();
        linkedList.printList(swapKthNodeFromStartWithKthNodeFromEnd(linkedList.head, 2));
    }
}
