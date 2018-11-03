package com.rampatra.linkedlists;

import com.rampatra.common.SingleLinkedList;
import com.rampatra.common.SingleLinkedNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/1/15
 * @time: 12:39 PM
 */
public class DetectAndRemoveLoop {

    /**
     * Detects loop if any in {@param list} and removes it.
     * <p>
     * Algorithm:
     * <p>
     * 1) Use Floyd's cycle detection algorithm to detect loop.
     * 2) Acc. to FCD, once the fast pointer meets the slow pointer we conclude that there is a loop.
     * 3) Now compute the length 'l' of the loop.
     * 4) Move the fast pointer length 'l' from head.
     * 5) Now move both slow and fast pointer at same pace and where they meet is the starting point of the loop.
     * 6) Lastly, to remove the loop make the next of the node (before the starting point of loop) to null.
     *
     * @param list
     * @param <E>
     * @return {@code true} if loop exists {@code false} otherwise.
     */
    public static <E extends Comparable<E>> boolean detectAndRemoveLoop(SingleLinkedList<E> list) {
        int i = 0, length = 0;
        boolean isLoopPresent = false;
        SingleLinkedNode<E> slow = list.head, fast = slow.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                isLoopPresent = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (isLoopPresent == false) return false;

        // compute length of loop
        while (fast.next != slow) {
            fast = fast.next;
            length++;
        }

        // move fast pointer from head by the length of loop
        slow = fast = list.head;
        while (i <= length) {
            fast = fast.next;
            i++;
        }

        // move both pointers at same pace to determine the starting node of loop
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (slow.next == fast.next) {
                fast.next = null;
                break;
            }
        }

        return isLoopPresent;
    }

    public static void main(String a[]) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(00);
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.getNode(1).next = linkedList.getNode(0);
        System.out.println(detectAndRemoveLoop(linkedList));
        linkedList.printList();
    }
}
