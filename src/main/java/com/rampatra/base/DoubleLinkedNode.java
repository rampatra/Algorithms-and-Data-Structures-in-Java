package com.rampatra.base;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/18/15
 * @time: 2:42 PM
 */
public class DoubleLinkedNode<E extends Comparable<E>> {

    public E item;
    public DoubleLinkedNode<E> next;
    public DoubleLinkedNode<E> prev;

    public DoubleLinkedNode(E item) {
        this(null, item, null);
    }

    public DoubleLinkedNode(DoubleLinkedNode<E> prev, E item, DoubleLinkedNode<E> next) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
