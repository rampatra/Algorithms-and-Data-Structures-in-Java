package me.ramswaroop.common;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/5/15
 * Time: 4:47 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class Node<E> {
    private E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data, Node<E> left, Node<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
