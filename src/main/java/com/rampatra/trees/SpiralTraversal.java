package com.rampatra.trees;

import com.rampatra.base.BinaryNode;
import com.rampatra.base.BinaryTree;
import com.rampatra.base.LinkedStack;
import com.rampatra.base.Stack;

import java.util.EmptyStackException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/26/15
 * @time: 5:14 PM
 */
public class SpiralTraversal<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * In spiral order traversal, nodes at different levels
     * are printed in alternating order.
     */
    public void spiralTraversal() {
        spiralTraversal(root, 0); // uses recursion
    }

    public void spiralTraversal(BinaryNode<E> node, int level) {
        if (node == null) return;

        // print the starting node
        if (level == 0) printValue(node);

        // print the neighbour nodes
        if (level % 2 == 0) {
            printValue(node.left);
            printValue(node.right);
        } else {
            printValue(node.right);
            printValue(node.left);
        }

        // go to next level
        level++;
        if (level % 2 == 0) {
            spiralTraversal(node.left, level);
            spiralTraversal(node.right, level);
        } else {
            spiralTraversal(node.right, level);
            spiralTraversal(node.left, level);
        }
    }

    public void spiralTraversalUsingStacks(BinaryNode<E> node) {
        Stack<BinaryNode<E>> stack1 = new LinkedStack<>(); // for nodes to be printed ltr
        Stack<BinaryNode<E>> stack2 = new LinkedStack<>(); // for nodes to be printed rtl

        printValue(node);

        stack1.push(node.right);
        stack1.push(node.left);

        // pop stack1 and push their child nodes in stack2
        while (!stack1.isEmpty()) {

            BinaryNode<E> leftChild = stack1.pop();
            BinaryNode<E> rightChild = stack1.pop();

            printValue(leftChild);
            printValue(rightChild);

            try {
                if (leftChild != null) stack2.push(leftChild.left);
                if (leftChild != null) stack2.push(leftChild.right);
                if (rightChild != null) stack2.push(rightChild.left);
                if (rightChild != null) stack2.push(rightChild.right);
            } catch (EmptyStackException e) {
                // ignore error when stack empty
            }
        }

        // pop stack2 and push their child nodes in stack1
        while (!stack2.isEmpty()) {

            BinaryNode<E> rightChild = stack2.pop();
            BinaryNode<E> leftChild = stack2.pop();

            printValue(rightChild);
            printValue(leftChild);

            try {
                if (rightChild != null) stack1.push(rightChild.right);
                if (rightChild != null) stack1.push(rightChild.left);
                if (leftChild != null) stack1.push(leftChild.right);
                if (leftChild != null) stack1.push(leftChild.left);
            } catch (EmptyStackException e) {
                // ignore error when stack empty
            }
        }
    }

    public static void main(String[] args) {
        SpiralTraversal<Integer> bt = new SpiralTraversal<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        bt.breadthFirstTraversal();
        System.out.println("");
        bt.spiralTraversal();
        System.out.println("");
        bt.spiralTraversalUsingStacks(bt.root);
    }
}
