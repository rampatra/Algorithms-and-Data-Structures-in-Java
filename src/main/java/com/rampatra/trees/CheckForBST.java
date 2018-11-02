package com.rampatra.trees;

import com.rampatra.common.BinaryNode;
import com.rampatra.common.BinarySearchTree;
import com.rampatra.common.BinaryTree;

import java.util.List;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/26/15
 * @time: 7:14 PM
 */
public class CheckForBST {

    /**
     * Traverse the tree in in-order fashion and insert all nodes
     * in a list and check for sort order of list.
     * <p/>
     * Concept: In-order traversal of a BST is always sorted in ascending
     * manner.
     *
     * @param node
     * @param list
     * @return
     */
    public static <E extends Comparable<E>> boolean isBST(BinaryNode<E> node, List<BinaryNode<E>> list) {
        if (node == null) return true;

        boolean left = isBST(node.left, list);

        // while adding node to list, compare it with previous node in list
        if (list.size() > 0 && list.get(list.size() - 1).value.compareTo(node.value) > 0) {
            return false;
        }
        list.add(node);

        boolean right = isBST(node.right, list);

        return left && right;
    }

    /**
     * Traverse the tree in in-order fashion and keep track of its in-order
     * predecessor value. If at any point current node's value is found greater
     * than its predecessor value then return {@code false}.
     * <p/>
     * Concept: In-order traversal of a BST is always sorted in ascending
     * manner.
     *
     * @param node
     * @param prev
     * @return
     */
    public static <E extends Comparable<E>> boolean isBST(BinaryNode<E> node, BinaryNode<E> prev) {
        if (node == null) return true;

        boolean left = isBST(node.left, prev);

        // compare current node with previous node
        if (prev.value != null && prev.value.compareTo(node.value) > 0) {
            return false;
        }
        prev.value = node.value;

        boolean right = isBST(node.right, prev);

        return left && right;
    }

    /**
     * Simplest way to test whether a binary tree is a BST or not.
     * <p/>
     * CONCEPT: A node's left sub-tree cannot have a value more than
     * the node's value and similarly the node's right sub-tree cannot
     * have a value less than the node's value.
     *
     * @param node
     * @param minValue
     * @param maxValue
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isBST(BinaryNode<E> node, E minValue, E maxValue) {
        if (node == null) return true;

        if (node.value.compareTo(minValue) < 0 || node.value.compareTo(maxValue) > 0) {
            return false;
        }

        return isBST(node.left, minValue, node.value) && isBST(node.right, node.value, maxValue);
    }

    public static void main(String a[]) {
        // in-order approach
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.put(6);
        binarySearchTree.put(3);
        binarySearchTree.put(5);
        binarySearchTree.put(7);
        binarySearchTree.put(8);
        binarySearchTree.put(9);
        out.println("1) Is BST: ");
        out.println(isBST(binarySearchTree.root, new BinaryNode<>(null))); // should be true
        
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.put(6);
        binaryTree.put(4);
        binaryTree.put(9);
        binaryTree.put(2);
        binaryTree.put(8);
        binaryTree.put(7);
        binaryTree.put(10);
        out.println("2) Is BST: ");
        out.println(isBST(binaryTree.root, new BinaryNode<>(null))); // should be false
        
        // min max approach
        out.println("3) Is BST: ");
        out.println(isBST(binarySearchTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE)); // should be true
        out.println("4) Is BST: ");
        out.println(isBST(binaryTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE)); // should be false
    }
}
