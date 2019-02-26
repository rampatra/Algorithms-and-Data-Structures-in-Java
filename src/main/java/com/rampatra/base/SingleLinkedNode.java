package com.rampatra.base;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/18/15
 * @time: 2:37 PM
 */
public class SingleLinkedNode<E extends Comparable<E>> {

    public E item;
    public SingleLinkedNode<E> next;

    public SingleLinkedNode(E item) {
        this(item, null);
    }

    public SingleLinkedNode(E item, SingleLinkedNode<E> next) {
        this.item = item;
        this.next = next;
    }

}
