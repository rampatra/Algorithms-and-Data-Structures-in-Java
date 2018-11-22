package com.ctci.linkedlists;

import static com.ctci.linkedlists.Node.printList;

/**
 * @author rampatra
 * @since 21/11/2018
 */
public class KthToLastElement {

    /**
     * Finds the kth node from the end in a linked list.
     *
     * @param head is the reference to the head of the linked list
     * @param k    is the position of element from the end
     * @return the Kth node from the end
     */
    private static Node getKthToLastElement(Node head, int k) {
        Node slow = head;
        Node fast = head;
        int i = 0;

        // forward the fast reference k times
        while (i < k) {
            if (fast == null) return null; // k is out of bounds
            fast = fast.next;
            i++;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(6);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(7);
        printList(l1);
        System.out.println("k=2: " + getKthToLastElement(l1, 2).val); // NPE check is omitted intentionally to keep it simple

        Node l2 = new Node(1);
        l2.next = new Node(6);
        l2.next.next = new Node(2);
        l2.next.next.next = new Node(3);
        l2.next.next.next.next = new Node(4);
        l2.next.next.next.next.next = new Node(7);
        printList(l2);
        System.out.println("k=1: " + getKthToLastElement(l2, 1).val);

        Node l3 = new Node(1);
        l3.next = new Node(6);
        l3.next.next = new Node(3);
        l3.next.next.next = new Node(3);
        l3.next.next.next.next = new Node(4);
        l3.next.next.next.next.next = new Node(7);
        printList(l3);
        System.out.println("k=6: " + getKthToLastElement(l3, 6).val);
    }
}
