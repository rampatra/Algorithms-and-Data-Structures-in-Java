package me.ramswaroop.common;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/11/15
 * Time: 7:11 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinaryNode<E> {
    E data;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(E data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
