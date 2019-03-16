package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/21/15
 * @time: 11:43 PM
 */
public class QuickSort {

    public static <E extends Comparable<E>> SingleLinkedNode<E>[] partition(SingleLinkedNode<E> firstNode,
                                                                            SingleLinkedNode<E> lastNode) {

        SingleLinkedNode<E>[] partition = new SingleLinkedNode[4];
        SingleLinkedNode<E> pivot = lastNode, curr = new SingleLinkedNode<>(null, firstNode), currNext, pivotNext;

        while (curr.next != null && curr.next != lastNode) {
            if (curr.next.item.compareTo(pivot.item) > 0) {
                currNext = curr.next;
                curr.next = currNext.next;
                pivotNext = pivot.next;
                pivot.next = currNext;
                currNext.next = pivotNext;
                continue;
            }
            curr = curr.next;
        }

        partition[0] = curr;

        while (curr.next != pivot) {
            curr = curr.next;
        }
        partition[1] = curr;

        partition[2] = pivot.next;

        while (curr.next != null) {
            curr = curr.next;
        }
        partition[3] = curr;

        return partition;

    }

    public static <E extends Comparable<E>> SingleLinkedNode<E> quickSort(SingleLinkedNode<E> firstNode,
                                                                          SingleLinkedNode<E> lastNode) {

        SingleLinkedNode<E> head = firstNode;
        if (firstNode != lastNode) {
            SingleLinkedNode<E> partition[] = partition(firstNode, lastNode);
            head = quickSort(partition[0], partition[1]);
            quickSort(partition[2], partition[3]);
        }

        return head;
    }

    public static <E extends Comparable<E>> SingleLinkedNode<E> quickSort(SingleLinkedNode<E> node) {
        return quickSort(node, getLastNode(node));
    }

    public static <E extends Comparable<E>> SingleLinkedNode<E> getLastNode(SingleLinkedNode<E> node) {
        SingleLinkedNode<E> curr = node;

        while (curr != null && curr.next != null) {
            curr = curr.next;
        }

        return curr;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(23);
        linkedList.add(4);
        linkedList.add(45);
        linkedList.add(11);
        linkedList.add(7);
        linkedList.printList();
        linkedList.printList(quickSort(linkedList.head));
    }
}
