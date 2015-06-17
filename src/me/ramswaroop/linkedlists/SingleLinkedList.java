package me.ramswaroop.linkedlists;

import me.ramswaroop.common.LinkedList;

import java.util.NoSuchElementException;

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
        if (head == null) { // list empty
            head = newNode;
        } else { // add to the end of list
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
            Node<E> nodeAtPrevIndex = getPredecessorNode(index);
            Node<E> newNode = new Node<>(item, nodeAtPrevIndex.next);
            nodeAtPrevIndex.next = newNode;
            size++;
        }
        return true;
    }

    @Override
    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item, head);
        head = newNode;
        size++;
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
        return getNode(index).item;
    }

    @Override
    public E getFirst() {
        return head.item;
    }

    @Override
    public E getLast() {
        return getNode(size - 1).item;
    }

    @Override
    public E remove() {
        isLinkedListEmpty();

        E item = head.item;
        head = head.next;
        return item;
    }

    @Override
    public E remove(int index) {
        isIndexOutOfBounds(index);

        Node<E> prevNode = getPredecessorNode(index);
        prevNode.next = prevNode.next.next;
        return prevNode.next.item;
    }

    @Override
    public boolean remove(E item) {
        return false;
    }

    @Override
    public E set(int index, E item) {
        isIndexOutOfBounds(index);

        Node<E> node = getNode(index);
        node.item = item;
        return node.item;
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

    private Node<E> getPredecessorNode(int index) {
        isIndexOutOfBounds(index);

        Node<E> curr = head;
        int i = 0;
        while (i < index - 1) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    private Node<E> getNode(int index) {
        isIndexOutOfBounds(index);

        Node<E> curr = head;
        int i = 0;
        while (i < index) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    private void isLinkedListEmpty() {
        if (head == null) {
            throw new NoSuchElementException("LinkedList empty");
        }
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
