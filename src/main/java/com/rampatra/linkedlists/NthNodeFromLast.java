package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/18/15
 */
public class NthNodeFromLast {

    /**
     * @param list
     * @param n
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> SingleLinkedNode<E> getNthNodeFromLast(SingleLinkedList<E> list, int n) {
        SingleLinkedNode<E> slow = list.getNode(0);
        SingleLinkedNode<E> fast = list.getNode(0);
        // move the fast reference ahead of slow reference by 'n' nodes
        for (int i = 0; i < n; i++) {
            // assert length of linkedlist > n
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.printList();
        System.out.println("n=3: " + getNthNodeFromLast(linkedList, 3).item);

        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<>();
        linkedList2.add(0);
        linkedList2.add(1);
        linkedList2.add(2);
        linkedList2.add(3);
        linkedList2.add(4);
        linkedList2.add(5);
        linkedList2.add(6);
        linkedList2.add(7);
        linkedList2.add(8);
        linkedList2.printList();
        System.out.println("n=1: " + getNthNodeFromLast(linkedList2, 1).item);

        SingleLinkedList<Integer> linkedList3 = new SingleLinkedList<>();
        linkedList3.add(0);
        linkedList3.add(1);
        linkedList3.add(2);
        linkedList3.add(3);
        linkedList3.add(4);
        linkedList3.add(5);
        linkedList3.add(6);
        linkedList3.add(7);
        linkedList3.add(8);
        linkedList3.printList();
        System.out.println("n=9: " + getNthNodeFromLast(linkedList3, 9).item);
    }
}
