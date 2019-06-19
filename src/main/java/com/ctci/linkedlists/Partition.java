package com.ctci.linkedlists;

/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all
 * nodes greater than or equal to x. If x is contained within the list, the values of x only need to be
 * after the elements less than x (see below). The partition element x can appear anywhere in the "right
 * partition"; it does not need to appear between the left and right partitions.
 * <p>
 * EXAMPLE:
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 * @author rampatra
 * @since 2019-01-28
 */
public class Partition {

    private static Node partition(Node head, int x) {
        Node leftPartitionHead = null;
        Node leftPartitionCurr = null;
        Node rightPartitionHead = null;
        Node rightPartitionCurr = null;
        Node curr = head;

        while (curr != null) {
            if (curr.val < x) {
                if (leftPartitionHead == null) {
                    leftPartitionHead = curr;
                    leftPartitionCurr = curr;
                } else {
                    leftPartitionCurr.next = curr;
                    leftPartitionCurr = leftPartitionCurr.next;
                }
            } else {
                if (rightPartitionHead == null) {
                    rightPartitionHead = curr;
                    rightPartitionCurr = curr;
                } else {
                    rightPartitionCurr.next = curr;
                    rightPartitionCurr = rightPartitionCurr.next;
                }
            }
            curr = curr.next;
        }

        if (leftPartitionCurr != null) leftPartitionCurr.next = rightPartitionHead;
        if (rightPartitionCurr != null) rightPartitionCurr.next = null;

        return leftPartitionHead;
    }

    public static void main(String[] args) {
        Node l1 = new Node(3);
        l1.next = new Node(5);
        l1.next.next = new Node(8);
        l1.next.next.next = new Node(5);
        l1.next.next.next.next = new Node(10);
        l1.next.next.next.next.next = new Node(2);
        l1.next.next.next.next.next.next = new Node(1);
        l1.print();
        l1.print();

        System.out.println("----");

        l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.print();
        l1.print();

        System.out.println("----");

        l1 = new Node(3);
        l1.next = new Node(2);
        l1.next.next = new Node(1);
        l1.print();
        l1.print();

        System.out.println("----");
        
        l1 = new Node(1);
        l1.print();
        l1.print();

        System.out.println("----");

        l1 = null;
        l1.print();
        l1.print();

        System.out.println("----");
    }
}
