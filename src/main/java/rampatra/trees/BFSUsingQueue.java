package rampatra.trees;

import com.rampatra.common.BinaryNode;
import com.rampatra.common.BinaryTree;
import com.rampatra.common.LinkedQueue;
import com.rampatra.common.Queue;

import java.util.NoSuchElementException;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/26/15
 * @time: 7:34 PM
 */
public class BFSUsingQueue {

    /**
     * Breadth first traversal (Level-order traversal using Queue).
     */
    public static <E extends Comparable<E>> void breadthFirstTraversalUsingQueue(BinaryNode<E> node) {
        Queue<BinaryNode<E>> queue = new LinkedQueue<>();
        breadthFirstTraversalUsingQueue(node, queue);
    }

    public static <E extends Comparable<E>> void breadthFirstTraversalUsingQueue(BinaryNode<E> node,
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

    public static <E extends Comparable<E>> void printValue(BinaryNode<E> node) {
        if (node == null) return;

        out.print(node.value);
    }

    public static void main(String a[]) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        breadthFirstTraversalUsingQueue(bt.root);
    }
}
