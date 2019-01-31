package com.ctci.linkedlists;

import static com.ctci.linkedlists.Node.printList;

/**
 * @author rampatra
 * @since 2019-01-31
 */
public class SumLists {

    private static Node sumLists(Node num1, Node num2) {
        int carry = 0;
        int sum;
        Node sumList = null, curr = null;
        while (num1 != null || num2 != null) {
            sum = ((num1 == null) ? 0 : num1.val) + ((num2 == null) ? 0 : num2.val) + carry;
            carry = sum / 10;
            if (sumList == null) {
                sumList = new Node(sum % 10);
                curr = sumList;
            } else {
                curr.next = new Node(sum % 10);
                curr = curr.next;
            }
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
        }
        if (carry != 0) {
            curr.next = new Node(carry);
        }
        return sumList;
    }
    
    public static void main(String[] args) {
        Node l1 = new Node(9);
        l1.next = new Node(9);
        l1.next.next = new Node(9);

        Node l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(9);

        printList(l1);
        printList(l2);
        printList(sumLists(l1, l2));
        System.out.println("-----------");

        l1 = new Node(9);
        l1.next = new Node(9);

        l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(9);

        printList(l1);
        printList(l2);
        printList(sumLists(l1, l2));
        System.out.println("-----------");

        l1 = null;
        l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(8);

        printList(l1);
        printList(l2);
        printList(sumLists(l1, l2));
    }
}
