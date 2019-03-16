package com.rampatra.linkedlists;

import com.rampatra.base.DoubleLinkedNode;

import java.util.EmptyStackException;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/24/15
 * @time: 1:06 PM
 * <p/>
 * <p/>
 * Implement a stack with below operations in O(1) time complexity:
 * 1) push() which adds an element to the top of stack.
 * 2) pop() which removes an element from top of stack.
 * 3) findMiddle() which will return middle element of the stack.
 * 4) deleteMiddle() which will delete the middle element.
 * Push and pop are standard stack operations.
 * <p>
 * The idea is to use a double linked list to represent a stack with pointer pointing to the middle node.
 */
public class StackWithOperationOnMiddleElement<E extends Comparable<E>> {

    int i = -1;
    DoubleLinkedNode<E> top, mid;

    public void push(E item) {

        top = new DoubleLinkedNode<>(null, item, top);
        if (top.next != null) {
            top.next.prev = top;
        } else {
            mid = top;
        }

        if (i % 2 == 0) {
            mid = mid.prev;
        }
        i++;
    }

    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        DoubleLinkedNode<E> topNode = top;
        if (top.next != null) {
            top.next.prev = null;
        }
        top = top.next;

        i++;
        if (i % 2 == 0) {
            mid = mid.next;
        }

        return topNode.item;
    }

    public E getMiddleElement() {
        if (mid == null) {
            throw new EmptyStackException();
        }
        return mid.item;
    }

    /**
     * Prints the content of the stack.
     */
    public void print() {
        DoubleLinkedNode<E> curr = top;
        out.print("[");
        if (curr == null) {
            out.println("]");
            return;
        }
        // prints the list from first node
        while (curr.next != null) {
            out.print(curr.item.toString() + ",");
            curr = curr.next;
        }
        out.println(curr.item.toString() + "]");
        // prints the list from last node
        out.print("[");
        while (curr.prev != null) {
            out.print(curr.item.toString() + ",");
            curr = curr.prev;
        }
        out.println(curr.item.toString() + "]");
    }

    public static void main(String[] args) {
        StackWithOperationOnMiddleElement<Integer> stack = new StackWithOperationOnMiddleElement<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.print();
        System.out.println("Mid: " + stack.getMiddleElement());
        stack.pop();
        stack.print();
        System.out.println("Mid: " + stack.getMiddleElement());
        stack.push(7);
        stack.print();
        System.out.println("Mid: " + stack.getMiddleElement());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.print();
        System.out.println("Mid: " + stack.getMiddleElement());
    }
}
