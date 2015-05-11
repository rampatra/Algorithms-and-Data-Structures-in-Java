package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;

import java.util.NoSuchElementException;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/19/15
 * Time: 6:36 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    public static void main(String[] a) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.put(6);
        bst.put(3);
        bst.put(5);
        bst.put(7);
        bst.put(8);
        bst.put(9);
        bst.preOrder();
        out.println("");
        bst.inOrder();
        out.println("");
        bst.postOrder();
        out.println("\n" + bst.size());
        out.println(BinaryTree.isIdentical(bst.root.right, bst.root.right));
        out.println(bst.isIdentical(bst.root));
        out.println(bst.height());
        /*obj.delete();
        out.println("After deletion: ");
        obj.postOrder();*/
        out.println("In Order: ");
        bst.inOrder();
        /*out.println("\nAfter mirroring: ");
        obj.mirror();
        obj.inOrder();*/
        out.println("\nRoot to leafs: ");
        bst.rootToLeafPaths();
        out.println("LCA: " + bst.leastCommonAncestor(bst.root, 6, 8).value);
        out.println("Min: " + bst.min().value);
        out.println("BFS: ");
        bst.breadthFirstTraversal();
        out.println("\nBFS using queue: ");
        bst.breadthFirstTraversalUsingQueue();
        out.println("\nNo. of leaf nodes: " + bst.countLeafNodes());
        out.println("Is BST: " + bst.isBST());
        out.print("Tree to list: ");
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
        out.println("Enter value 1: ");
        value1 = (E) Integer.valueOf(in.nextLine());
        out.println("Enter value 1: ");
        value2 = (E) in.nextLine();
        out.println("LCA of " + value1 + " and " + value2 + " is: " + leastCommonAncestor(root, value1, value2).value);*/
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
        out.print("[");
        if (current == null) {
            out.println("]");
            return;
        }
        while (current.right != node) {
            out.print(current.value + ",");
            current = current.right;
        }
        out.println(current.value + "]");
    }
}
