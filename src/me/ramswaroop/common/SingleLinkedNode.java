package me.ramswaroop.common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/18/15
 * @time: 2:37 PM
 */
public class SingleLinkedNode<E> {

    public E item;
    public SingleLinkedNode<E> next;

    SingleLinkedNode(E item, SingleLinkedNode<E> next) {
        this.item = item;
        this.next = next;
    }

    SingleLinkedNode(SingleLinkedNode<E> node) {
        if (node == null) return;

        this.item = node.item;
        this.next = node.next;
    }
}
