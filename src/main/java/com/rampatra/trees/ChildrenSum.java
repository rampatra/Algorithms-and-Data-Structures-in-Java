package com.rampatra.trees;

import com.rampatra.base.BinaryNode;
import com.rampatra.base.BinaryTree;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/26/15
 * @time: 7:01 PM
 */
public class ChildrenSum {

    /**
     * Children Sum Invariant: For every node, the value must be equal to
     * sum of values in the left and right child.
     * Consider data value as 0 for NULL child.
     *
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isChildrenSum(BinaryNode<E> node) {
        if (node == null || node.left == null && node.right == null) return true;

        E leftChildValue = (E) (node.left == null ? 0 : node.left.value);
        E rightChildValue = (E) (node.right == null ? 0 : node.right.value);

        if (!node.value.toString().equals(
                String.valueOf(Integer.parseInt(leftChildValue.toString()) +
                        Integer.parseInt(rightChildValue.toString()))
        )) {
            return false;
        }

        return isChildrenSum(node.left) && isChildrenSum(node.right);
    }


    /**
     * Converts a tree to hold the children sum invariant.
     * <p/>
     * It only increments data values in any node (Does not
     * change structure of tree and cannot decrement value of
     * any node).
     *
     * @param node
     * @param <E>
     */
    public static <E extends Comparable<E>> void toChildrenSum(BinaryNode<E> node) {

        if (node == null || node.left == null && node.right == null) return;

        toChildrenSum(node.left);
        toChildrenSum(node.right);

        Integer nodeValue = (Integer) (node == null ? 0 : node.value);
        Integer leftChildValue = (Integer) (node.left == null ? 0 : node.left.value);
        Integer rightChildValue = (Integer) (node.right == null ? 0 : node.right.value);

        int diff = leftChildValue + rightChildValue - nodeValue;

        if (diff < 0) { // tricky: children sum is less
            increment(node, -diff);
        } else if (diff > 0) { // simple: children sum is more, so just add the diff to parent node
            //node.value += diff;
        }
    }

    // TODO: Not done due to generics
    private static <E extends Comparable<E>> void increment(BinaryNode<E> node, int diff) {
        if (node.left != null) {
            //node.left.value += Math.abs(diff);
            increment(node.left, diff);
        } else if (node.right != null) {
            //node.right.value += Math.abs(diff);
            increment(node.right, diff);
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
        out.println("Is Children Sum : ");
        out.println(isChildrenSum(bt.root));
        /*binaryTree.toChildrenSum();
        out.print("\nBreadth-first Traversal after to children sum: ");
        binaryTree.breadthFirstTraversal();*/
    }
}
