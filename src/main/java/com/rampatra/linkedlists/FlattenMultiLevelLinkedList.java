package com.rampatra.linkedlists;

import com.rampatra.base.DoubleLinkedNode;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/26/15
 */
public class FlattenMultiLevelLinkedList {

    /**
     * Flattens a multilevel linked list into a single level linked list. You can
     * {@see http://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/} for
     * clarity on question.
     * <p>
     * Solution:
     * 1) Take "cur" pointer, which will point to head of the fist level of the list
     * 2) Take "tail" pointer, which will point to end of the first level of the list
     * 3) Repeat the below procedure while "curr" is not NULL.
     * I) if current node has a child then
     * a) append this new child list to the "tail"
     * tail->next = cur->child
     * b) find the last node of new child list and update "tail"
     * while (tail->next != null) {
     * tail = tail->next;
     * }
     * II) move to the next node. i.e. cur = cur->next
     *
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> DoubleLinkedNode<E> flatten(DoubleLinkedNode<E> node) {
        DoubleLinkedNode<E> curr = node, tail;

        // set tail to last node in 1st level
        while (curr.next != null) {
            curr = curr.next;
        }
        tail = curr;

        curr = node;
        while (curr != null) {
            if (curr.prev != null) {
                // append child to tail
                tail.next = curr.prev;
                // update tail
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
            curr = curr.next;
        }
        return node;
    }

    /**
     * Prints the list.
     *
     * @param node
     * @param <E>
     */
    public static <E extends Comparable<E>> void printList(DoubleLinkedNode<E> node) {
        DoubleLinkedNode<E> curr = node;
        out.print("[");
        if (curr == null) {
            out.println("]");
            return;
        }
        while (curr.next != null) {
            out.print(curr.item.toString() + ",");
            curr = curr.next;
        }
        out.println(curr.item.toString() + "]");
    }

    public static void main(String[] args) {
        // 1st level
        DoubleLinkedNode<Integer> head = new DoubleLinkedNode<>(1);
        head.next = new DoubleLinkedNode<>(5);
        head.next.next = new DoubleLinkedNode<>(4);
        head.next.next.next = new DoubleLinkedNode<>(8);
        head.next.next.next.next = new DoubleLinkedNode<>(9);
        // 2nd level under node 1
        head.prev = new DoubleLinkedNode<>(10);
        head.prev.next = new DoubleLinkedNode<>(10);
        head.prev.next.next = new DoubleLinkedNode<>(12);
        head.prev.next.next.next = new DoubleLinkedNode<>(14);
        // 2nd level under node 2
        head.next.prev = new DoubleLinkedNode<>(16);
        head.next.prev.next = new DoubleLinkedNode<>(17);
        head.next.prev.next.next = new DoubleLinkedNode<>(18);
        head.next.prev.next.next.next = new DoubleLinkedNode<>(20);
        // 3rd level under node 2
        head.next.prev.prev = new DoubleLinkedNode<>(22);
        head.next.prev.prev.next = new DoubleLinkedNode<>(24);
        head.next.prev.prev.next.next = new DoubleLinkedNode<>(26);
        head.next.prev.prev.next.next.next = new DoubleLinkedNode<>(28);
        // after flattening
        printList(flatten(head));
    }
}
