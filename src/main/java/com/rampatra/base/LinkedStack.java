package com.rampatra.base;

import java.util.EmptyStackException;

/**
 * Stack implementation using a singly linked list.
 *
 * @param <E> the data type to be stored in the stack
 * @author rampatra
 * @since 3/24/15
 */
public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;

    public LinkedStack() {
        top = null;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item
     */
    @Override
    public E push(E item) {
        top = new Node<>(item, top);
        return item;
    }

    /**
     * Removes the object at the top of this stack and
     * returns it.
     *
     * @return
     */
    @Override
    public E pop() {
        E item = peek();
        top = top.next;
        return item;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return
     */
    @Override
    public E peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.item;
    }

    /**
     * Returns the number of items currently in the stack.
     *
     * @return
     */
    @Override
    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    /**
     * Prints the content of the stack.
     */
    @Override
    public void print() {
        Node<E> node;
        System.out.print("[");
        if (top == null) {
            System.out.println("]");
            return;
        }
        for (node = top; node.next != null; node = node.next) {
            System.out.print(node.item + ",");
        }
        System.out.println(node.item + "]");
    }

    /**
     * Tests if this stack is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    private class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
