package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/19/15
 * @time: 9:24 AM
 */
public class ReverseSingleLinkedList<E extends Comparable<E>> extends SingleLinkedList<E> {

    /**
     * Reverses the linked list using 3 references prev, curr and next.
     *
     * @param list
     */
    public static <E extends Comparable<E>> void reverseList(SingleLinkedList<E> list) {
        SingleLinkedNode<E> prev = list.getNode(0);
        SingleLinkedNode<E> curr = prev.next;
        prev.next = null; // this will be the last node after reversal, so make next of node = null
        while (curr != null) {
            SingleLinkedNode<E> next = curr.next;
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
    public SingleLinkedNode<E> recursiveReverseList(SingleLinkedNode<E> node) {
        if (node == null) return null;

        SingleLinkedNode<E> nextNode = recursiveReverseList(node.next);

        if (nextNode == null) {
            head.next = null; // head will be the last node so head.next = null;
            head = node;
        } else {
            nextNode.next = node;
        }

        return node;
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
        ReverseSingleLinkedList<Integer> linkedList = new ReverseSingleLinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.printList();
        reverseList(linkedList);
        linkedList.printList();
        linkedList.recursiveReverseList(linkedList.getNode(0));
        linkedList.printList();
        printListInReverse(linkedList.getNode(0));
    }
}
