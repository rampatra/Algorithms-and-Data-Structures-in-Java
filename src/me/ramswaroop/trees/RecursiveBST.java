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

    BinaryNode<E> listRoot;

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
     *
     * P.S: For a better solution - http://cslibrary.stanford.edu/109/TreeListRecursion.html
     */
    public void treeToList() {
        treeToList(root);

        // print the list
        BinaryNode<E> node;
        Utils.print("[");
        for (node = listRoot; node.right != listRoot; node = node.right) {
            Utils.print(node.value + ",");
        }
        Utils.print(node.value + "]");
    }

    public void treeToList(BinaryNode<E> node) {
        if (node == null) return;

        treeToList(node.left);
        addToList(new BinaryNode<>(node));
        treeToList(node.right);
    }

    private void addToList(BinaryNode<E> node) {
        if (listRoot == null) {
            listRoot = new BinaryNode<>(node.value, null, null);
            listRoot.left = listRoot;
            listRoot.right = listRoot;
        } else {
            BinaryNode<E> head = listRoot;
            // go to the last node
            while (head.right != listRoot) {
                head = head.right;
            }
            // make it circular
            head.right = node;
            node.left = head;
            node.right = listRoot;
            listRoot.left = head;
        }
    }
}
