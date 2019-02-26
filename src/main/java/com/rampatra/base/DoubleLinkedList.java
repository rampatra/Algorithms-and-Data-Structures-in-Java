package com.rampatra.base;

import java.util.NoSuchElementException;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/16/15
 * @time: 1:00 PM
 */
public class DoubleLinkedList<E extends Comparable<E>> implements LinkedList<E> {

    public DoubleLinkedNode<E> head;
    public int size;

    @Override
    public boolean add(E item) {
        DoubleLinkedNode<E> newNode = new DoubleLinkedNode<>(null, item, null);
        if (head == null) { // list empty
            head = newNode;
        } else { // add to the end of list
            DoubleLinkedNode<E> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E item) {
        isPositionIndex(index);

        if (index == 0) { // add at first
            addFirst(item);
        } else { // add at any other location
            DoubleLinkedNode<E> prevNode = getPredecessorNode(index);
            DoubleLinkedNode<E> nextNode = prevNode.next;
            DoubleLinkedNode<E> newNode = new DoubleLinkedNode<>(prevNode, item, prevNode.next);
            prevNode.next = newNode;
            if (nextNode != null) nextNode.prev = newNode;
            size++;
        }
        return true;
    }

    @Override
    public void addFirst(E item) {
        DoubleLinkedNode<E> newNode = new DoubleLinkedNode<>(null, item, head);
        if (head != null) head.prev = newNode;
        head = newNode;
        size++;
    }

    @Override
    public void addLast(E item) {
        add(item);
    }

    @Override
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (DoubleLinkedNode<E> node = head; node != null; ) {
            DoubleLinkedNode<E> next = node.next;
            node.item = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
        head = null;
        size = 0;
    }

    @Override
    public LinkedList<E> clone() {
        return null;
    }

    @Override
    public boolean contains(E item) {
        return getNode(item) != null;
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public E getFirst() {
        isLinkedListEmpty();
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
        if (head != null) head.prev = null; // check for linked list size = 1
        size--;
        return item;
    }

    @Override
    public E remove(int index) {
        isLinkedListEmpty();

        DoubleLinkedNode<E> prevNode = getPredecessorNode(index);
        DoubleLinkedNode<E> nextNode;
        DoubleLinkedNode<E> delNode;
        if (prevNode == null) { // index = 0
            delNode = head;
            head = head.next;
            if (head != null) head.prev = null; // check for linked list size = 1
            size--;
            return delNode.item;
        } else {
            delNode = prevNode.next;
            nextNode = delNode.next;
            prevNode.next = nextNode;
            if (nextNode != null) nextNode.prev = prevNode; // check needed if node to be deleted is last node
            size--;
            return delNode.item;
        }
    }

    @Override
    public boolean removeItem(E item) {
        isLinkedListEmpty();

        if (!contains(item)) return false;

        DoubleLinkedNode<E> prevNode = getPredecessorNode(item);
        DoubleLinkedNode<E> nextNode;
        if (prevNode == null) { // index = 0
            head = head.next;
            if (head != null) head.prev = null; // condition for list size = 1
            size--;
        } else {
            nextNode = prevNode.next.next;
            prevNode.next = nextNode;
            if (nextNode != null) nextNode.prev = prevNode;
            size--;
        }
        return true;
    }

    @Override
    public E set(int index, E item) {
        DoubleLinkedNode<E> node = getNode(index);
        node.item = item;
        return node.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printList() {
        printList(head);
    }

    public static <E extends Comparable<E>> void printList(DoubleLinkedNode<E> node) {
        DoubleLinkedNode<E> curr = node;
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

    public static <E extends Comparable<E>> DoubleLinkedList<E> getLinkedList(DoubleLinkedNode<E> node) {
        DoubleLinkedList<E> linkedList = new DoubleLinkedList<>();
        // set head
        linkedList.head = node;
        // set size
        DoubleLinkedNode<E> curr = node;
        while (curr != null) {
            linkedList.size++;
            curr = curr.next;
        }
        return linkedList;
    }

    private DoubleLinkedNode<E> getPredecessorNode(int index) {
        return index > 0 ? getNode(index - 1) : null;
    }

    private DoubleLinkedNode<E> getPredecessorNode(E item) {
        return getNode(item) != null ? getNode(item).prev : null;
    }

    public DoubleLinkedNode<E> getNode(int index) {
        isElementIndex(index);

        DoubleLinkedNode<E> curr = head;
        int i = 0;
        while (i < index) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    public DoubleLinkedNode<E> getNode(E item) {
        DoubleLinkedNode<E> curr = head;
        if (item == null) {
            while (curr != null) { // when item is null, use == rather than equals()
                if (curr.item == item) {
                    return curr;
                }
                curr = curr.next;
            }
        } else {
            while (curr != null) {
                if (curr.item.equals(item)) {
                    return curr;
                }
                curr = curr.next;
            }
        }
        return null;
    }

    private void isLinkedListEmpty() {
        if (head == null) {
            throw new NoSuchElementException("LinkedList empty");
        }
    }

    /**
     * Tells if the argument is the index of an existing element.
     */
    private void isElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index [" + index + "] must be less than size [" + size + "]");
        }
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private void isPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index [" + index + "] must be less than or equal to size [" + size + "]");
        }
    }
}
