package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/14/15
 * @time: 12:16 PM
 */
public class ReverseAlternateNodesAndAppendAtEnd {

    /**
     * Reverse alternate nodes and append them to end of the list.
     * <p>
     * Example,
     * <p>
     * Input List:  1->2->3->4->5->6
     * Output List: 1->3->5->6->4->2
     * <p>
     * Input List:  12->14->16->18->20
     * Output List: 12->16->20->18->14
     *
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> reverseAlternateNodesAndAppendAtEnd(SingleLinkedNode<E> node) {
        SingleLinkedNode<E> curr = node, end = node, currNext, endNext;

        while (end.next != null) {
            end = end.next;
        }

        while (curr != end && curr.next != end) {

            currNext = curr.next.next;
            endNext = end.next;

            end.next = curr.next;
            end.next.next = endNext;

            curr.next = currNext;
            curr = curr.next;
        }

        return node;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.printList();
        SingleLinkedList.printList(reverseAlternateNodesAndAppendAtEnd(linkedList.head));
    }
}
