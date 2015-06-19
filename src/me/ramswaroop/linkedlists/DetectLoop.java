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
public class DetectLoop<E> extends SingleLinkedList<E> {

    /**
     * Uses Flyod's Cycle Finding algorithm.
     * <p/>
     * This is the fastest method. Traverse
     * linked list using two pointers. Move one
     * pointer by one and other pointer by two.
     * If these pointers meet at some node then
     * there is a loop. If pointers do not meet
     * then linked list does not have loop.
     *
     * @param node
     * @return
     */
    public boolean isLoopPresent(SingleLinkedNode<E> node) {
        SingleLinkedNode<E> prev = node, curr = node;
        while (curr != null && curr.next != null) {
            prev = prev.next;
            curr = curr.next.next;
            if (prev == curr) {
                return true;
            }
        }
        return false;
    }

    public static void main(String a[]) {
        DetectLoop<Integer> linkedList = new DetectLoop<>();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.getNode(4).next = linkedList.getNode(3);
        System.out.println(linkedList.isLoopPresent(linkedList.getNode(0)));
    }
}
