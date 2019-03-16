package com.rampatra.trees;

import com.rampatra.base.BinaryNode;
import com.rampatra.base.BinaryTree;
import com.rampatra.base.LinkedQueue;
import com.rampatra.base.Queue;

import java.util.NoSuchElementException;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/26/15
 * @time: 7:34 PM
 */
public class BFSUsingQueue {

    /**
     * Breadth first traversal (Level-order traversal using Queue).
     *
     * @param node a tree node with left and right references and a value of type {@code E}
     * @param <E> the type of value that the {@code node} holds
     */
    public static <E extends Comparable<E>> void breadthFirstTraversalUsingQueue(BinaryNode<E> node) {
        Queue<BinaryNode<E>> queue = new LinkedQueue<>();
        breadthFirstTraversalUsingQueue(node, queue);
    }

    private static <E extends Comparable<E>> void breadthFirstTraversalUsingQueue(BinaryNode<E> node,
                                                                                 Queue<BinaryNode<E>> queue) {

        if (node != null) {
            printValue(node);
            queue.add(node.left);
            queue.add(node.right);
        }

        try {
            breadthFirstTraversalUsingQueue(queue.remove(), queue);
        } catch (NoSuchElementException e) {
            return;
        }
    }

    private static <E extends Comparable<E>> void printValue(BinaryNode<E> node) {
        if (node == null) return;

        out.print(node.value);
    }

    /**
     * Level order traversal using queue but iteratively.
     *
     * @param root the root node from where the traversal should start
     * @param <E> type of the {@code value} that {@code BinaryNode} holds
     */
    public static <E extends Comparable<E>> void breadthFirstTraversalUsingQueueIterative(BinaryNode<E> root) {
        if (root == null) return;

        Queue<BinaryNode<E>> q = new LinkedQueue<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryNode<E> node = q.remove();
            out.print(node.value);

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        breadthFirstTraversalUsingQueue(bt.root);
        System.out.println();
        breadthFirstTraversalUsingQueueIterative(bt.root);
    }
}
