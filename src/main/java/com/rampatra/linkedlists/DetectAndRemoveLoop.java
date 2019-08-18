package com.rampatra.linkedlists;

import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;

/**
 * See this <a href="https://stackoverflow.com/a/32190575/1385441">Stackoverflow post</a> to understand
 * how to find the starting node of the loop.
 * <p>
 * Proof for Flyod's Loop Detection Algorithm:
 * <p>
 * Suppose fastRunner had just skipped over slowRunner. fastRunner would only be 1 node ahead of slowRunner, since their
 * speeds differ by only 1. So we would have something like this:
 * <p>
 * [ ] -> [s] -> [f]
 * <p>
 * What would the step right before this "skipping step" look like? fastRunner would be 2 nodes back, and slowRunner
 * would be 1 node back. But wait, that means they would be at the same node! So fastRunner didn't skip over slowRunner!
 * (This is a proof by contradiction.)
 *
 * @author rampatra
 * @since 7/1/15
 */
public class DetectAndRemoveLoop {

    /**
     * Detects loop, if any, in {@code list} and removes it.
     * <p>
     * Approach:
     * 1) Use Floyd's cycle detection algorithm to detect loop.
     * 2) Acc. to FCD, once the fast pointer meets the slow pointer we conclude that there is a loop.
     * 4) Now that we have concluded there is a loop, let's detect the starting node and remove the loop:
     *    i. Move the slow pointer to head.
     *   ii. Now, move both slow and fast pointer at same pace and where they meet is the starting point of the loop.
     *  iii. Lastly, to remove the loop make the next of the node (before the starting point of loop) to null.
     *
     * Proof for Floyd's Cycle Detection: Consider a cyclic list and imagine the slow and fast pointers are two runners
     * racing around a circle track. The fast runner will eventually meet the slow runner. Why? Consider this case -
     * The fast runner is just one step behind the slow runner. In the next iteration, they both increment one and two
     * steps respectively and meet each other.
     *
     * @param list
     * @param <E>
     * @return {@code true} if loop exists {@code false} otherwise.
     */
    public static <E extends Comparable<E>> boolean detectAndRemoveLoop(SingleLinkedList<E> list) {
        boolean isLoopPresent = false;
        SingleLinkedNode<E> slow = list.head, fast = list.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isLoopPresent = true;
                break;
            }
        }

        if (!isLoopPresent) return false;

        slow = list.head;
        // move both pointers at same pace to determine the starting node of loop
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                fast.next = null;
                break;
            }
        }

        return isLoopPresent;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.getNode(4).next = linkedList.getNode(2);
        System.out.println(detectAndRemoveLoop(linkedList));
        linkedList.printList();

        linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.getNode(1).next = linkedList.getNode(0);
        System.out.println(detectAndRemoveLoop(linkedList));
        linkedList.printList();

        linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        System.out.println(detectAndRemoveLoop(linkedList));
        linkedList.printList();

        linkedList = new SingleLinkedList<>();
        linkedList.add(0);
        linkedList.getNode(0).next = linkedList.getNode(0);
        System.out.println(detectAndRemoveLoop(linkedList));
        linkedList.printList();
    }
}