package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/19/15
 */
public class DetectLoop {

    /**
     * Uses Flyod's Cycle Finding algorithm.
     * <p/>
     * This is the fastest method. Traverse
     * linked list using two pointers. Move one
     * pointer by one and other pointer by two.
     * If these pointers meet at some node then
     * there is a loop. If pointers do not meet
     * then linked list does not have loop.
     * <p/>
     * Level: Easy
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param list
     * @return
     */
    public static <E extends Comparable<E>> boolean isLoopPresent(SingleLinkedList<E> list) {
        SingleLinkedNode<E> slow = list.head, fast = list.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Uses HashMap to store visited nodes.
     * <p/>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param node
     * @return
     */
    public static <E extends Comparable<E>> boolean isLoopPresentUsingHashMap(SingleLinkedNode<E> node) {
        HashMap<SingleLinkedNode<E>, Boolean> map = new HashMap<>();
        SingleLinkedNode<E> curr = node;
        while (curr != null) {
            if (map.get(curr) != null && map.get(curr)) {
                return true;
            }
            map.put(curr, true);
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.getNode(4).next = linkedList.getNode(3);
        System.out.println(isLoopPresent(linkedList));
    }
}