package com.rampatra.linkedlists;

import com.rampatra.common.SingleLinkedList;
import com.rampatra.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/19/15
 * @time: 9:24 AM
 */
public class ReverseSingleLinkedList {

    /**
     * Reverses the linked list using 3 references prev, curr and next.
     *
     * @param list
     */
    public static <E extends Comparable<E>> void reverseList(SingleLinkedList<E> list) {
        SingleLinkedNode<E> curr = list.getNode(0), prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
    }

    /**
     * Recursive method to reverse a linked list.
     *
     * @param node
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> recursiveReverseList(SingleLinkedNode<E> node) {
        if (node == null || node.next == null) return node;

        SingleLinkedNode<E> nextNode = node.next;

        node.next = null;

        SingleLinkedNode<E> newHead = recursiveReverseList(nextNode);

        nextNode.next = node;

        return newHead;
    }

    /**
     * Recursive method to PRINT the linked list in reverse.
     * <p/>
     * NOTE: It doesn't reverse the linked list but just PRINTS
     * them in reverse.
     *
     * @param node
     * @param <E>
     */
    public static <E extends Comparable<E>> void printListInReverse(SingleLinkedNode<E> node) {
        if (node == null) return;

        printListInReverse(node.next);

        System.out.print(node.item + ",");
    }

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.printList();
        reverseList(linkedList);
        linkedList.printList();
        printListInReverse(linkedList.head);
        System.out.println();
        SingleLinkedList.printList(recursiveReverseList(linkedList.head));
    }
}
