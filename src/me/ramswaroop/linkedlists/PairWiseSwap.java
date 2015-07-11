package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/24/15
 * @time: 3:48 PM
 */
public class PairWiseSwap {

    /**
     * Recursively swaps adjacent nodes of a linked list.
     * The swapping is done in place.
     *
     * @param node
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> pairWiseSwap(SingleLinkedNode<E> node) {
        if (node == null || node.next == null) return node;

        SingleLinkedNode<E> nextNode = node.next, nextOfNextNode = nextNode.next;

        nextNode.next = node;
        node.next = pairWiseSwap(nextOfNextNode);

        return nextNode;
    }

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        linkedList.printList();
        linkedList.printList(pairWiseSwap(linkedList.head));
    }
}