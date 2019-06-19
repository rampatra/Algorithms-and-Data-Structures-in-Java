package com.ctci.linkedlists;

import java.util.Stack;

/**
 * @author rampatra
 * @since 2019-02-02
 */
public class Palindrome {

    /**
     * Checks whether a Linked List is palindrome by using a stack.
     *
     * @param head starting node of the linked list.
     * @return {@code true} if linked list palindrome, {@code false} otherwise.
     */
    private static boolean isPalindrome(Node head) {
        Node curr = head;
        Stack<Integer> stack = new Stack<>();
        // pop all elements into stack
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        // as stack contains the elements in reverse order, pop and compare with the list one by one
        while (curr != null) {
            if (curr.val != stack.pop()) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    /**
     * This is a similar approach like above but a bit faster as we are not iterating the entire list twice.
     *
     * @param head starting node of the linked list.
     * @return {@code true} if linked list palindrome, {@code false} otherwise.
     */
    private static boolean isPalindromeOptimized(Node head) {
        Node slow = head;
        Node fast = head;
        Stack<Integer> stack = new Stack<>();

        // push half of the elements into the stack
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // linked list has odd number of elements, so forward the slow reference by one
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {

        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(3);
        l1.next.next.next.next = new Node(2);
        l1.next.next.next.next.next = new Node(1);
        l1.print();
        System.out.println(isPalindrome(l1));
        System.out.println(isPalindromeOptimized(l1));
        System.out.println("------");

        l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(2);
        l1.next.next.next.next = new Node(1);
        l1.print();
        System.out.println(isPalindrome(l1));
        System.out.println(isPalindromeOptimized(l1));
        System.out.println("------");

        l1 = new Node(0);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(3);
        l1.next.next.next.next = new Node(0);
        l1.print();
        System.out.println(isPalindrome(l1));
        System.out.println(isPalindromeOptimized(l1));
        System.out.println("------");

        l1 = new Node(1);
        l1.print();
        System.out.println(isPalindrome(l1));
        System.out.println(isPalindromeOptimized(l1));

    }
}
