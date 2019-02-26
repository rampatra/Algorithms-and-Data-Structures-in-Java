package com.rampatra.base;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 4/11/15
 * Time: 7:11 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinaryNode<E extends Comparable<E>> {

    public E value;
    public BinaryNode<E> left;
    public BinaryNode<E> right;

    public BinaryNode(E value, BinaryNode<E> left, BinaryNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(BinaryNode<E> node) {
        if (node == null) return;

        this.value = node.value;
        this.left = node.left;
        this.right = node.right;
    }
}
