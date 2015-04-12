package me.ramswaroop.common;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/12/15
 * Time: 11:07 AM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class LinkedQueue<E> implements Queue<E> {

    Node<E> front;
    Node<E> rear;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    @Override
    public E add(E item) {
        if (front == null || rear == null) {
            front = rear = new Node<>(item, null);
        } else {
            rear.next = new Node<>(item, null);
            rear = rear.next;
        }
        return item;
    }

    @Override
    public E remove() {
        if (rear.next == front) {
            throw new NoSuchElementException();
        }
        E item = element();
        front = front.next;
        return item;
    }

    @Override
    public E element() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    @Override
    public int size() {
        int count = 0;
        if (rear.next == front) return count;
        for (Node node = front; node != rear; node = node.next) {
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return rear.next == front;
    }

    @Override
    public void print() {
        Node<E> node;
        System.out.print("[");
        if (rear.next == front) {
            System.out.print("]");
            return;
        }
        for (node = front; node != rear; node = node.next) {
            System.out.print(node.data + ",");
        }
        System.out.print(node.data + "]");
    }

    private class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
