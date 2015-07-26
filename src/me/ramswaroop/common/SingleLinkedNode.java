package me.ramswaroop.common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/18/15
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

    public SingleLinkedNode(SingleLinkedNode<E> node) {
        if (node == null) return;

        this.item = node.item;
        this.next = node.next;
    }
}
