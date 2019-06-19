package com.ctci.linkedlists;

/**
 * @author rampatra
 * @since 2019-01-27
 */
public class DeleteMiddleNode {

    /**
     * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not
     * necessarily the exact middle) of a singly linked list, given only access to that node.
     * <p>
     * EXAMPLE
     * Input: the node c from the linked list a->b->c->d->e->f
     * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
     *
     * @param middle the node to be deleted
     */
    private static void deleteMiddleNode(Node middle) {
        if (middle == null || middle.next == null) {
            return;
        }
        // copy the data from the next node over to the middle node, and then to delete the next node
        Node next = middle.next;
        middle.val = next.val;
        middle.next = next.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(6);
        l1.print();
        deleteMiddleNode(l1.next.next);
        l1.print();

        System.out.println("----");

        l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.print();
        deleteMiddleNode(l1.next);
        l1.print();

        System.out.println("----");

        l1 = new Node(1);
        l1.next = new Node(3);
        l1.print();
        deleteMiddleNode(l1);
        l1.print();

        System.out.println("----");

        l1 = new Node(1);
        l1.next = new Node(3);
        l1.print();
        deleteMiddleNode(l1.next);
        l1.print();
    }
}
