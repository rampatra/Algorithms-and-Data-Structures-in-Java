package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;
import me.ramswaroop.utils.Utils;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 3/24/15
 * Time: 3:02 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class RecursiveBST<E extends Comparable<E>> extends BinarySearchTree<E> {

    public static void main(String[] a) {
        RecursiveBST<Integer> obj = new RecursiveBST<>();
        obj.put(6);
        obj.put(3);
        obj.put(5);
        obj.put(7);
        obj.put(8);
        obj.put(9);
        obj.preOrder();
        Utils.println("");
        obj.inOrder();
        Utils.println("");
        obj.postOrder();
        Utils.println("\n" + obj.size());
        Utils.println(BinaryTree.isIdentical(obj.root.right, obj.root.right));
        Utils.println(obj.isIdentical(obj.root));
        Utils.println(obj.height());
        /*obj.delete();
        Utils.println("After deletion: ");
        obj.postOrder();*/
        Utils.println("In Order: ");
        obj.inOrder();
        /*Utils.println("\nAfter mirroring: ");
        obj.mirror();
        obj.inOrder();*/
        Utils.println("\nRoot to leafs: ");
        obj.rootToLeafPaths();
        Utils.println("LCA: " + obj.leastCommonAncestor(obj.root, 6, 8).value);
        Utils.println("Min: " + obj.min().value);
        Utils.println("BFS: ");
        obj.breadthFirstTraversal();
        Utils.println("\nBFS using queue: ");
        obj.breadthFirstTraversalUsingQueue();
        Utils.println("\nTree to list: ");
        obj.treeToList();
    }

    /**
     * Inserts a node into the tree.
     *
     * @param value
     */
    public void put(E value) {
        put(root, value);
    }

    public BinaryNode<E> put(BinaryNode<E> node, E value) {
        if (node == null) {
            return root = new BinaryNode<>(value, null, null);
        } else {
            if (value.compareTo(node.value) < 0) {
                if (node.left == null) {
                    return node.left = new BinaryNode<>(value, null, null);
                } else {
                    return put(node.left, value);
                }
            } else {
                if (node.right == null) {
                    return node.right = new BinaryNode<>(value, null, null);
                } else {
                    return put(node.right, value);
                }
            }
        }
    }

    /**
     * Returns the node with minimum value.
     *
     * @return
     */
    public BinaryNode<E> min() {
        return min(root);
    }

    public BinaryNode<E> min(BinaryNode<E> node) {
        if (node == null) throw new NoSuchElementException();

        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    /**
     * Determines the LCA for a BST
     * <p/>
     * DEFINITION OF LCA:
     * Let T be a rooted tree. The lowest
     * common ancestor between two nodes n1 and
     * n2 is defined as the lowest node in T that has
     * both n1 and n2 as descendants (where we allow
     * a node to be a descendant of itself).
     */
    public void leastCommonAncestor() {
        /*int value1, value2;
        Scanner in = new Scanner(System.in);
        Utils.println("Enter value 1: ");
        value1 = (E) Integer.valueOf(in.nextLine());
        Utils.println("Enter value 1: ");
        value2 = (E) in.nextLine();
        Utils.println("LCA of " + value1 + " and " + value2 + " is: " + leastCommonAncestor(root, value1, value2).value);*/
    }

    public BinaryNode<E> leastCommonAncestor(BinaryNode<E> node, E value1, E value2) {
        if (node == null || value1.compareTo(value2) > 0) throw new NoSuchElementException();

        if (value1.compareTo(node.value) <= 0 && value2.compareTo(node.value) >= 0) {
            return node;
        } else if (value1.compareTo(node.value) > 0 && value2.compareTo(node.value) > 0) {
            return leastCommonAncestor(node.right, value1, value2);
        } else {
            return leastCommonAncestor(node.left, value1, value2);
        }
    }

    /**
     * A recursive function that takes an ordered binary tree
     * and rearranges the internal pointers to make a circular
     * doubly linked list out of the tree nodes. The list should
     * be arranged so that the nodes are in increasing order.
     */
    public void treeToList() {
        // print the list
        printList(treeToList(root));
    }

    public BinaryNode<E> treeToList(BinaryNode<E> node) {
        if (node == null) return null;

        BinaryNode<E> list1 = treeToList(node.left);
        BinaryNode<E> list2 = treeToList(node.right);

        node.left = node;
        node.right = node;

        list1 = addToList(list1, node);
        list1 = addToList(list1, list2);

        return list1;
    }

    private BinaryNode<E> addToList(BinaryNode<E> node1, BinaryNode<E> node2) {

        if (node1 == null) return node2;
        if (node2 == null) return node1;

        node2.left = node1.left;
        node2.right = node1;
        node1.left.right = node2;
        node1.left = node2;

        return node1;
    }


    /**
     * Utility methods.
     */

    private void printList(BinaryNode<E> node) {
        BinaryNode<E> current = node;
        Utils.print("[");
        if (current == null) {
            System.out.println("]");
            return;
        }
        while (current.right != node) {
            Utils.print(current.value + ",");
            current = current.right;
        }
        Utils.println(current.value + "]");
    }
}
