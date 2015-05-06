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
        RecursiveBST<Integer> bst = new RecursiveBST<>();
        bst.put(6);
        bst.put(3);
        bst.put(5);
        bst.put(7);
        bst.put(8);
        bst.put(9);
        bst.preOrder();
        Utils.println("");
        bst.inOrder();
        Utils.println("");
        bst.postOrder();
        Utils.println("\n" + bst.size());
        Utils.println(BinaryTree.isIdentical(bst.root.right, bst.root.right));
        Utils.println(bst.isIdentical(bst.root));
        Utils.println(bst.height());
        /*obj.delete();
        Utils.println("After deletion: ");
        obj.postOrder();*/
        Utils.println("In Order: ");
        bst.inOrder();
        /*Utils.println("\nAfter mirroring: ");
        obj.mirror();
        obj.inOrder();*/
        Utils.println("\nRoot to leafs: ");
        bst.rootToLeafPaths();
        Utils.println("LCA: " + bst.leastCommonAncestor(bst.root, 6, 8).value);
        Utils.println("Min: " + bst.min().value);
        Utils.println("BFS: ");
        bst.breadthFirstTraversal();
        Utils.println("\nBFS using queue: ");
        bst.breadthFirstTraversalUsingQueue();
        Utils.println("\nNo. of leaf nodes: " + bst.countLeafNodes());
        Utils.println("Is BST: " + bst.isBST());
        Utils.print("Tree to list: ");
        bst.treeToList();
    }


    /**
     * Inserts a node into the BST.
     *
     * @param value
     */
    public void put(E value) {
        put(root, value);
    }

    public BinaryNode<E> put(BinaryNode<E> node, E value) {
        BinaryNode<E> newNode = new BinaryNode<>(value, null, null);

        if (node == null) {
            return root = new BinaryNode<>(value, null, null);
        } else {
            if (value.compareTo(node.value) < 0) {
                if (node.left == null) {
                    return node.left = newNode;
                } else {
                    return put(node.left, value);
                }
            } else {
                if (node.right == null) {
                    return node.right = newNode;
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

        BinaryNode<E> aList = treeToList(node.left);
        BinaryNode<E> bList = treeToList(node.right);

        node.left = node;
        node.right = node;

        // attach left child then root followed by right child (so that final list is in ascending order)
        aList = addToList(aList, node);
        aList = addToList(aList, bList);

        return aList;
    }

    private BinaryNode<E> addToList(BinaryNode<E> aList, BinaryNode<E> bList) {

        if (aList == null) return bList;
        if (bList == null) return aList;

        // find the last node in each list
        BinaryNode<E> aListLast = aList.left;
        BinaryNode<E> bListLast = bList.left;

        // join end of one list to beginning of another
        aListLast.right = bList;
        bList.left = aListLast;

        // make circular
        aListLast.left = bListLast;
        bListLast.right = aList;

        return aList;
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
