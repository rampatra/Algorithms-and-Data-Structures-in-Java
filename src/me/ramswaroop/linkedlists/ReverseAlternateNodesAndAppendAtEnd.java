package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/14/15
 * @time: 12:16 PM
 */
public class ReverseAlternateNodesAndAppendAtEnd {

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

    public static void main(String a[]) {
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
