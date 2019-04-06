package com.rampatra.trees;

import com.rampatra.base.BinaryNode;
import com.rampatra.base.BinarySearchTree;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/26/15
 * @time: 7:38 PM
 */
public class LeastCommonAncestorInBST {


    public void leastCommonAncestor() {
        /*int value1, value2;
        Scanner in = new Scanner(System.in);
        out.println("Enter value 1: ");
        value1 = (E) Integer.valueOf(in.nextLine());
        out.println("Enter value 1: ");
        value2 = (E) in.nextLine();
        out.println("LCA of " + value1 + " and " + value2 + " is: " + leastCommonAncestor(root, value1, value2).value);*/
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
     *
     * @param node
     * @param value1
     * @param value2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> BinaryNode<E> leastCommonAncestor(BinaryNode<E> node, E value1, E value2) {
        if (node == null || value1 == null || value2 == null || value1.compareTo(value2) > 0) {
            throw new NoSuchElementException();
        }

        if (value1.compareTo(node.value) <= 0 && value2.compareTo(node.value) >= 0) {
            return node;
        } else if (value1.compareTo(node.value) > 0 && value2.compareTo(node.value) > 0) {
            return leastCommonAncestor(node.right, value1, value2);
        } else {
            return leastCommonAncestor(node.left, value1, value2);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.put(6);
        bst.put(3);
        bst.put(5);
        bst.put(7);
        bst.put(8);
        bst.put(9);
        System.out.println(leastCommonAncestor(bst.root, 5, 6).value);
    }
}
