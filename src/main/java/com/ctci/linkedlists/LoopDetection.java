package com.ctci.linkedlists;

/**
 * @author rampatra
 * @since 2019-02-03
 */
public class LoopDetection {

    /**
     * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
     * DEFINITION
     * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
     * as to make a loop in the linked list.
     * EXAMPLE
     * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
     * Output: C
     * <p>
     * See {@link com.rampatra.linkedlists.DetectAndRemoveLoop} for a slightly more complex problem.
     *
     * @param head the starting node of the linked list
     * @return the {@code Node} where the loop starts, {@code null} otherwise.
     */
    private static Node findLoopStartNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        /* Error check - no meeting point, and therefore no loop */
        if (fast == null || fast.next == null) {
            return null;
        }

        /* Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
         * Loop Start. If they move at the same pace, they must meet at Loop Start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /* You can return either as now both point to the start of the loop */
        return fast;
    }

    public static void main(String[] args) {
        /*
         *   1 -> 2 -> 3 -> 4 -> 5 -> 6
         *                  ^         |
         *                  |_________|
         */
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(6);
        l1.next.next.next.next.next.next = l1.next.next.next;
        System.out.println(findLoopStartNode(l1).val);
    }
}