package me.ramswaroop.common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/18/15
 * @time: 2:42 PM
 */
public class DoubleLinkedNode<E> {

    E item;
    DoubleLinkedNode<E> next;
    DoubleLinkedNode<E> prev;

    DoubleLinkedNode(DoubleLinkedNode<E> prev, E item, DoubleLinkedNode<E> next) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    DoubleLinkedNode(DoubleLinkedNode<E> node) {
        if (node == null) return;

        this.item = node.item;
        this.next = node.next;
        this.prev = node.prev;
    }
}
