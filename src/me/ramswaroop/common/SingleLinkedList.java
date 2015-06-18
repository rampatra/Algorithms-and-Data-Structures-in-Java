package me.ramswaroop.common;

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

    SingleLinkedNode<E> head;
    int size;

    @Override
    public boolean add(E item) {
        SingleLinkedNode<E> newNode = new SingleLinkedNode<>(item, null);
        if (head == null) { // list empty
            head = newNode;
        } else { // add to the end of list
            SingleLinkedNode<E> curr = head;
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
            SingleLinkedNode<E> nodeAtPrevIndex = getPredecessorNode(index);
            SingleLinkedNode<E> newNode = new SingleLinkedNode<>(item, nodeAtPrevIndex.next);
            nodeAtPrevIndex.next = newNode;
            size++;
        }
        return true;
    }

    @Override
    public void addFirst(E item) {
        SingleLinkedNode<E> newNode = new SingleLinkedNode<>(item, head);
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
        size--;
        return item;
    }

    @Override
    public E remove(int index) {
        isLinkedListEmpty();

        SingleLinkedNode<E> prevNode = getPredecessorNode(index);
        SingleLinkedNode<E> delNode;
        if (prevNode == null) { // index = 0
            delNode = head;
            head = head.next;
            size--;
            return delNode.item;
        } else {
            delNode = prevNode.next;
            prevNode.next = delNode.next;
            size--;
            return delNode.item;
        }
    }

    @Override
    public boolean removeItem(E item) {
        isLinkedListEmpty();

        if (!contains(item)) return false;

        SingleLinkedNode<E> prevNode = getPredecessorNode(item);
        if (prevNode == null) { // index = 0
            head = head.next;
            size--;
        } else {
            prevNode.next = prevNode.next.next;
            size--;
        }
        return true;
    }

    @Override
    public E set(int index, E item) {
        SingleLinkedNode<E> node = getNode(index);
        node.item = item;
        return node.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printList() {
        SingleLinkedNode<E> curr = head;
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

    private SingleLinkedNode<E> getPredecessorNode(int index) {
        isIndexOutOfBounds(index);

        SingleLinkedNode<E> curr = head;
        int i = 0;
        while (i < index - 1) {
            curr = curr.next;
            i++;
        }
        return (index == 0) ? null : curr;
    }

    private SingleLinkedNode<E> getPredecessorNode(E item) {
        SingleLinkedNode<E> prev = null;
        SingleLinkedNode<E> curr = head;
        if (item == null) {
            while (curr != null) {
                if (curr.item == item) { // when item is null, use == rather than equals()
                    return prev;
                }
                prev = curr;
                curr = curr.next;
            }
        } else {
            while (curr != null) {
                if (curr.item.equals(item)) {
                    return prev;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return null;
    }

    protected SingleLinkedNode<E> getNode(int index) {
        isIndexOutOfBounds(index);

        SingleLinkedNode<E> curr = head;
        int i = 0;
        while (i < index) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    protected SingleLinkedNode<E> getNode(E item) {
        SingleLinkedNode<E> curr = head;
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

    private void isIndexOutOfBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be less than " + size);
        }
    }
}
