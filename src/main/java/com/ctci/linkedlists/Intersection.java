package com.ctci.linkedlists;

/**
 * @author rampatra
 * @since 2019-02-02
 */
public class Intersection {

    /**
     * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that
     * the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is
     * the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
     *
     * @param n1
     * @param n2
     * @return the intersecting node, {@code null} otherwise.
     */
    private static Node findIntersectingNode(Node n1, Node n2) {
        Node curr1 = n1;
        Node curr2 = n2;
        int len1 = 1;
        int len2 = 1;
        
        /* Calculate the length of both linked lists */
        while (curr1 != null && curr1.next != null) {
            len1++;
            curr1 = curr1.next;
        }
        while (curr2 != null && curr2.next != null) {
            len2++;
            curr2 = curr2.next;
        }
        
        // if different tail nodes, they don't intersect
        if (curr1 != curr2) {
            return null;
        }
        
        curr1 = n1;
        curr2 = n2;
        
        /* Get rid of the extra nodes from the longer list */
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                curr1 = curr1.next;
            }
        }
        if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                curr2 = curr2.next;
            }
        }
        
        // move both pointers until you have a collision
        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        // return either
        return curr1;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(5);
        Node l2 = new Node(1);
        l2.next = new Node(4);
        l2.next.next = new Node(2);
        l2.next.next.next = new Node(3);
        l2.next.next.next.next = l1.next.next.next;
        l1.print();
        l2.print();
        System.out.println(findIntersectingNode(l1, l2).val); // may throw NPE, not handling for the sake of simplicity

        System.out.println("----");

        l1 = new Node(1);
        l2 = l1;
        l1.print();
        l2.print();
        System.out.println(findIntersectingNode(l1, l2).val); // may throw NPE, not handling for the sake of simplicity

        System.out.println("----");

        l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(5);
        l2 = new Node(1);
        l2.next = new Node(4);
        l2.next.next = new Node(2);
        l2.next.next.next = new Node(3);
        l1.print();
        l2.print();
        System.out.println(findIntersectingNode(l1, l2));
    }
}
