package com.ctci.linkedlists;

/**
 * @author rampatra
 * @since 21/11/2018
 */
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    public static void printList(Node head) {
        if (head == null) return;

        Node curr = head;
        while (curr.next != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }
}
