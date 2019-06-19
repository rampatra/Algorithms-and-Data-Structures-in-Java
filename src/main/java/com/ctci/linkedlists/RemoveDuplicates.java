package com.ctci.linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * @author rampatra
 * @since 21/11/2018
 */
public class RemoveDuplicates {

    /**
     * Removes duplicates in an unsorted linked list by using additional memory
     * and two references.
     * <p>
     * If asked not to use any additional memory then you can
     * loop through the list for each node and check for repeated elements but bear
     * in mind that the time complexity of this would be O(n^2) where n is the number
     * of nodes in the linked list.
     *
     * @param head reference to the head of the linked list
     */
    private static void removeDuplicatesFromUnsortedList(Node head) {
        Set<Integer> valuesInList = new HashSet<>();
        Node curr = head;
        Node prev = curr;
        while (curr != null) {
            if (valuesInList.contains(curr.val)) {
                prev.next = curr.next;
            }
            valuesInList.add(curr.val);
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(5);
        System.out.print("With dups: ");
        l1.print();
        removeDuplicatesFromUnsortedList(l1);
        System.out.print("Without dups: ");
        l1.print();

        Node l2 = new Node(1);
        l2.next = new Node(1);
        l2.next.next = new Node(2);
        l2.next.next.next = new Node(3);
        l2.next.next.next.next = new Node(4);
        l2.next.next.next.next.next = new Node(5);
        System.out.print("\nWith dups: ");
        l2.print();
        removeDuplicatesFromUnsortedList(l2);
        System.out.print("Without dups: ");
        l2.print();

        Node l3 = new Node(1);
        l3.next = new Node(2);
        l3.next.next = new Node(3);
        l3.next.next.next = new Node(3);
        l3.next.next.next.next = new Node(4);
        l3.next.next.next.next.next = new Node(5);
        System.out.print("\nWith dups: ");
        l3.print();
        removeDuplicatesFromUnsortedList(l3);
        System.out.print("Without dups: ");
        l3.print();

        Node l4 = new Node(1);
        System.out.print("\nWith dups: ");
        l4.print();
        removeDuplicatesFromUnsortedList(l4);
        System.out.print("Without dups: ");
        l4.print();

        Node l5 = null;
        System.out.print("\nWith dups: ");
        l5.print();
        removeDuplicatesFromUnsortedList(l5);
        System.out.print("Without dups: ");
        l5.print();
    }
}