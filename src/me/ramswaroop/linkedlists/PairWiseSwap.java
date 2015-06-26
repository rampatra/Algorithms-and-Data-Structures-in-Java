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
public class PairWiseSwap<E extends Comparable<E>> extends SingleLinkedList<E> {

    /**
     * Recursively swaps adjacent nodes of a linked list.
     * The swapping is done in place.
     *
     * @param node
     */
    public void pairWiseSwap(SingleLinkedNode<E> node) {
        if (node == null || node.next == null) return;

        // the trick is to swap the next two nodes of {@param node}
        // but if {@param node} is head then swap itself with the next node
        SingleLinkedNode<E> firstNode = (node == head) ? node : node.next,
                secondNode = (node == head) ? node.next : node.next.next;

        if (firstNode == null || secondNode == null) return;

        firstNode.next = secondNode.next;
        secondNode.next = firstNode;

        if (node == head) {
            head = secondNode;
        } else {
            node.next = secondNode;
        }

        // pass firstNode as the next two nodes are swapped
        pairWiseSwap(firstNode);
    }

    public void pairWiseSwap() {
        pairWiseSwap(head);
    }

    public static void main(String a[]) {
        PairWiseSwap<Integer> linkedList = new PairWiseSwap<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        linkedList.printList();
        linkedList.pairWiseSwap();
        linkedList.printList();
    }
}