package com.rampatra.trees;

import com.rampatra.base.BinaryNode;
import com.rampatra.base.BinaryTree;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/26/15
 * @time: 5:52 PM
 */
public class RootToLeafPaths<E extends Comparable<E>> extends BinaryTree<E> {

    /**
     * Prints the node to leaf paths, one per line.
     */
    public void rootToLeafPaths() {
        List<E> pathList = new ArrayList<>();
        rootToLeafPaths(root, pathList);

        /*E[] pathList = (E[]) new Object[100];
        rootToLeafPaths(root, pathList, 0);*/
    }

    /**
     * Prints the node to leaf paths, one per line.
     * (Using array)
     */
    public void rootToLeafPaths(BinaryNode<E> node, E[] pathList, int pathLength) {
        if (node == null) return;

        pathList[pathLength] = node.value;
        pathLength++;

        // if its a leaf node then print the list
        if (node.left == null && node.right == null) {
            int i;
            for (i = 0; i < pathLength - 1; i++) {
                out.print(pathList[i] + " -> ");
            }
            // outside the loop so that "->" doesn't appear after the last node
            out.println(pathList[i]);
        } else {
            // do the same for subtrees
            rootToLeafPaths(node.left, pathList, pathLength);
            rootToLeafPaths(node.right, pathList, pathLength);
        }
    }

    /**
     * Prints the node to leaf paths, one per line.
     * (Using ArrayList)
     */
    public void rootToLeafPaths(BinaryNode<E> node, List<E> pathList) {
        if (node == null) return;

        pathList.add(node.value);

        // if its a leaf node then print the list
        if (node.left == null && node.right == null) {
            int i;
            for (i = 0; i < pathList.size() - 1; i++) {
                out.print(pathList.get(i) + " -> ");
            }
            // outside the loop so that "->" doesn't appear after the last node
            out.println(pathList.get(i));
        } else {
            // do the same for subtrees
            rootToLeafPaths(node.left, new ArrayList<>(pathList));
            rootToLeafPaths(node.right, new ArrayList<>(pathList));
        }
    }


    /**
     * Given a binary tree and a number, return true if the tree has a root-to-leaf
     * path such that adding up all the values along the path equals the given number.
     * Return false if no such path can be found.
     *
     * @param node
     * @param pathList
     * @param pathSum
     * @return
     */
    public boolean rootToLeafPathsSum(BinaryNode<E> node, List<E> pathList, int pathSum) {
        int sum = 0;

        if (node != null) pathList.add(node.value);

        // if its either a leaf node or null then path is complete, add all elements present in list
        if (node == null || (node.left == null && node.right == null)) {
            for (int i = 0; i < pathList.size(); i++) {
                sum += Integer.parseInt(pathList.get(i).toString());
            }
            return sum == pathSum;
        } else {
            // do the same for subtrees
            return rootToLeafPathsSum(node.left, new ArrayList<>(pathList), pathSum) ||
                    rootToLeafPathsSum(node.right, new ArrayList<>(pathList), pathSum);
        }
    }

    public static void main(String[] args) {
        RootToLeafPaths<Integer> bt = new RootToLeafPaths<>();
        bt.put(6);
        bt.put(3);
        bt.put(5);
        bt.put(7);
        bt.put(8);
        bt.put(9);
        out.println("Root to leafs: ");
        bt.rootToLeafPaths();
        out.println("Root to Leaf Sum: ");
        out.println(bt.rootToLeafPathsSum(bt.root, new ArrayList<Integer>(), 13));
    }
}
