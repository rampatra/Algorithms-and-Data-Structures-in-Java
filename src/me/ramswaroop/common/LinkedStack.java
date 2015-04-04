package me.ramswaroop.common;

import me.ramswaroop.interfaces.Stack;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 3/24/15
 * Time: 3:02 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */

/**
 * Stack implementation using
 * a singly linked list
 *
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

    private Node top = null;

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item
     */
    @Override
    public void push(E item) {
        top = new Node(item, top);
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
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
            throw new NoSuchElementException();
        }
        return top.data;
    }

    /**
     * Returns the number of items currently in the stack.
     *
     * @return
     */
    @Override
    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = top.next) {
            count++;
        }
        return count;
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

    private class Node {
        E data;
        Node next;

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
