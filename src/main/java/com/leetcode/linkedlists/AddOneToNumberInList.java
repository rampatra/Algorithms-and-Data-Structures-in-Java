package com.leetcode.linkedlists;

/**
 * Level: Easy
 * Problem Link: https://leetcode.com/problems/plus-one-linked-list/
 * Problem Description: Given a non-empty single linked list representing a number where the head is the
 * most significant bit, add one to the number and return a new linked list.
 *
 * @author rampatra
 * @since 2019-06-19
 */
public class AddOneToNumberInList {


    /**
     * Add {@code one} to the number represented by linked list {@code head}.
     *
     * @param head the starting node of the linked list
     * @return the head of the linked list after adding {@code one}
     */
    private static Node addOne(Node head) {
        Node currOrig = reverse(head);
        Node currRes = null;
        Node res = null;

        int sum = 1;
        int carry = 0;
        int rem;

        while (currOrig != null) {
            sum += carry + currOrig.val;
            rem = sum % 10;
            carry = sum / 10;

            if (res == null) {
                res = currRes = new Node(rem);
            } else {
                currRes.next = new Node(rem);
                currRes = currRes.next;
            }

            sum = 0;
            currOrig = currOrig.next;
        }

        if (carry != 0) {
            currRes.next = new Node(carry);
        }

        return reverse(res);
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }


    public static void main(String[] args) {
        Node node = new Node(9);
        node.next = new Node(9);
        node.next.next = new Node(9);
        node.print();
        addOne(node).print();

        System.out.println("---------");

        node = new Node(1);
        node.next = new Node(9);
        node.next.next = new Node(9);
        node.print();
        addOne(node).print();

        System.out.println("---------");

        node = new Node(0);
        node.print();
        addOne(node).print();
    }
}