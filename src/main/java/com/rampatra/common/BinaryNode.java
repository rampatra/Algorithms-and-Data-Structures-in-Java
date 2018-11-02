package com.rampatra.common;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/11/15
 * Time: 7:11 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinaryNode<E extends Comparable<E>> {

    public E value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(E value, BinaryNode left, BinaryNode right) {
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
