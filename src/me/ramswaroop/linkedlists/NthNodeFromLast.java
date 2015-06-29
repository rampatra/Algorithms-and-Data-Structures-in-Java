package me.ramswaroop.linkedlists;

import me.ramswaroop.common.SingleLinkedList;
import me.ramswaroop.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/18/15
 * @time: 6:49 PM
 */
public class NthNodeFromLast {

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

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        linkedList.add(88);
        System.out.println(getNthNodeFromLast(linkedList, 3).item);
    }
}
