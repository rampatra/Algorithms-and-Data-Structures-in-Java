package me.ramswaroop.common;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/16/15
 * @time: 1:00 PM
 */
public class DoubleLinkedList<E> implements LinkedList<E> {

    DoubleLinkedNode<E> head;

    @Override
    public boolean add(E item) {
        return false;
    }

    @Override
    public boolean add(int index, E item) {
        return false;
    }

    @Override
    public void addFirst(E item) {

    }

    @Override
    public void addLast(E item) {

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
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean removeItem(E item) {
        return false;
    }

    @Override
    public E set(int index, E item) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void printList() {
        DoubleLinkedNode<E> curr = head;
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
}
