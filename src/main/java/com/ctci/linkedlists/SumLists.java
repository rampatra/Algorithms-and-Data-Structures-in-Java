package com.ctci.linkedlists;

/**
 * @author rampatra
 * @since 2019-01-31
 */
public class SumLists {

    /**
     * You have two numbers represented by a linked list, where each node contains a single digit. The digits are
     * stored in reverse order, such that the 1's digit is at the head of the list (or in other words, the least
     * significant digit is stored at the head of the list). Write a function that adds the two numbers and returns
     * the sum as a linked list.
     * <p>
     * EXAMPLE
     * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
     * Output: 2 -> 1 -> 9. That is, 912.
     *
     * @param num1
     * @param num2
     * @return
     */
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
    
    // TODO: After doing reverseListRecursive
    private static Node sumListsWithMostSignificantDigitAtHead(Node n1, Node n2) {
        return null;
    }
    
    public static void main(String[] args) {
        Node l1 = new Node(9);
        l1.next = new Node(9);
        l1.next.next = new Node(9);

        Node l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(9);

        l1.print();
        l2.print();
        sumLists(l1, l2).print();
        System.out.println("-----------");

        l1 = new Node(9);
        l1.next = new Node(9);

        l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(9);

        l1.print();
        l2.print();
        sumLists(l1, l2).print();
        System.out.println("-----------");

        l1 = null;
        l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(8);

        l1.print();
        l2.print();
        sumLists(l1, l2).print();
    }
}
