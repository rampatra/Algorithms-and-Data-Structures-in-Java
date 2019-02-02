package com.ctci.linkedlists;

import java.util.Stack;

import static com.ctci.linkedlists.Node.printList;

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
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while (!stack.empty() && curr != null) {
            if (stack.pop() != curr.val) {
                return false;
            }
            curr = curr.next;
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
        printList(l1);
        System.out.println(isPalindrome(l1));
        System.out.println("------");

        l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(2);
        l1.next.next.next.next = new Node(1);
        printList(l1);
        System.out.println(isPalindrome(l1));
        System.out.println("------");

        l1 = new Node(0);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(3);
        l1.next.next.next.next = new Node(0);
        printList(l1);
        System.out.println(isPalindrome(l1));
        System.out.println("------");
        
        l1 = new Node(1);
        printList(l1);
        System.out.println(isPalindrome(l1));
    }
}
