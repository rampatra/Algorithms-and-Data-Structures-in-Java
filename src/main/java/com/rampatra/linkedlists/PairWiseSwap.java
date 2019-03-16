package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/24/15
 * @time: 3:48 PM
 */
public class PairWiseSwap {

    /**
     * Recursively swaps adjacent nodes of a linked list.
     * <p/>
     * Example:
     * Input:   11->22->33->44->55
     * Output:  22->11->44->33->55
     *
     * @param node
     * @return new starting node after swapping adjacent nodes.
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> pairWiseSwap(SingleLinkedNode<E> node) {
        if (node == null || node.next == null) return node;

        SingleLinkedNode<E> nextNode = node.next, nextOfNextNode = nextNode.next;

        nextNode.next = node;
        node.next = pairWiseSwap(nextOfNextNode);

        return nextNode;
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
        linkedList.printList(pairWiseSwap(linkedList.head));
    }
}