package me.ramswaroop.linkedlists;

import me.ramswaroop.common.LinkedList;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/16/15
 * @time: 1:00 PM
 */
public class SingleLinkedList<E> implements LinkedList<E> {

    Node<E> head;
    int size;

    @Override
    public boolean add(E item) {
        Node<E> newNode = new Node<>(item, null);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E item) {
        isIndexOutOfBounds(index);

        if (index == 0) { // add at first
            addFirst(item);
        } else { // add at any other location
            Node<E> curr = head;
            int i = 0;
            while (i < index - 1) {
                curr = curr.next;
                i++;
            }
            Node<E> newNode = new Node<>(item, curr.next);
            curr.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item, head);
        head = newNode;
    }

    @Override
    public void addLast(E item) {
        add(item);
    }

    @Override
    public void clear() {

    }

    @Override
    public LinkedList<E> clone() {
        return null;
    }

    @Override
    public boolean contains(E item) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E remove() {
        E item = head.item;
        head = head.next;
        return item;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E item) {
        return false;
    }

    @Override
    public E set(int index, E item) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printList() {
        Node<E> curr = head;
        out.print("[");
        if (curr == null) {
            out.println("]");
            return;
        }
        while (curr.next != null) {
            out.print(curr.item + ",");
            curr = curr.next;
        }
        out.println(curr.item + "]");
    }

    private Node<E> getNode(int index) {
        isIndexOutOfBounds(index);

        Node<E> curr = head;
        int i = 0;
        while (i < index - 1) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    private void isIndexOutOfBounds(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("Index must be less than or equal to: " + size);
        }
    }

    private class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        Node(Node<E> node) {
            if (node == null) return;

            this.item = node.item;
            this.next = node.next;
        }
    }
}
