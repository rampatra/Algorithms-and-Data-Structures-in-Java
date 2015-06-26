package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;
import me.ramswaroop.common.BinaryTree;
import me.ramswaroop.common.LinkedQueue;
import me.ramswaroop.common.Queue;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/26/15
 * @time: 7:34 PM
 */
public class BFSUsingQueue<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Breadth first traversal (Level-order traversal using Queue).
     */
    public void breadthFirstTraversalUsingQueue() {
        Queue<BinaryNode<E>> queue = new LinkedQueue<>();
        breadthFirstTraversalUsingQueue(root, queue);
    }

    public void breadthFirstTraversalUsingQueue(BinaryNode<E> node, Queue<BinaryNode<E>> queue) {

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

    public static void main(String a[]) {
        BFSUsingQueue<Integer> bt = new BFSUsingQueue<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        bt.breadthFirstTraversalUsingQueue();
    }
}
