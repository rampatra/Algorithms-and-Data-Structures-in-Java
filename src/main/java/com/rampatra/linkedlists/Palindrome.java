package com.rampatra.linkedlists;

import com.rampatra.base.LinkedStack;
import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.SingleLinkedNode;
import com.rampatra.base.Stack;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/18/15
 */
public class Palindrome<E extends Comparable<E>> extends SingleLinkedList<E> {

    /**
     * Uses Stack to test whether a linked list starting
     * from {@param node} is palindrome or not.
     *
     * @param list
     * @return {@code true} if linked list palindrome, {@code false} otherwise.
     */
    private static <E extends Comparable<E>> boolean isPalindrome(SingleLinkedList<E> list) {
        SingleLinkedNode<E> head = list.getNode(0);
        SingleLinkedNode<E> curr = head;
        Stack<SingleLinkedNode<E>> stack = new LinkedStack<>();

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            if (curr.item != stack.pop().item) {
                return false;
            }
            curr = curr.next;
        }

        return true;
    }

    /**
     * Recursive function to test whether a linked list
     * starting from {@param node} is palindrome or not.
     * <p/>
     * NOTE: This method moves the head reference. (disadvantage)
     *
     * @param node
     * @return
     */
    private boolean isPalindromeRecursive(SingleLinkedNode<E> node) {
        if (node == null) return true;

        boolean isPalindrome = isPalindromeRecursive(node.next);

        if (head.item == node.item) {
            head = head.next;
            return isPalindrome;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Palindrome<Integer> linkedList = new Palindrome<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(0);
        linkedList.printList();
        System.out.println(isPalindrome(linkedList));
        linkedList.printList();
        System.out.println(linkedList.isPalindromeRecursive(linkedList.getNode(0)));
    }
}
