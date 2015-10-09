package me.ramswaroop.common;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/19/15
 * Time: 6:35 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinaryTree<E extends Comparable<E>> extends Tree<E> {

    public BinaryNode<E> root;
    Queue<BinaryNode<E>> queue = new LinkedQueue<>(); // needed for insertion

    /**
     * Inserts a node into the binary tree such that
     * it always forms a complete binary tree.
     *
     * @param value
     */
    public BinaryNode<E> put(E value) {
        return put(root, value);
    }

    public BinaryNode<E> put(BinaryNode<E> node, E value) {
        // create a new node from the value
        BinaryNode<E> newNode = new BinaryNode<>(value, null, null);

        if (node == null) {
            return root = queue.add(newNode);
        } else {
            BinaryNode<E> parentNode = queue.element();
            if (parentNode.left == null) {
                parentNode.left = newNode;
            } else if (parentNode.right == null) {
                parentNode.right = newNode;
                queue.remove(); // parent node has both left and right child now, so dequeue it
            }
            queue.add(newNode);
        }
        return node;
    }

    /**
     * Traversals.
     */


    /**
     * Prints the pre-order traversal of the tree.
     */
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }


    /**
     * Prints the in-order traversal of the tree.
     */
    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        out.print(node.value);
        inOrder(node.right);
    }


    /**
     * Prints the post-order traversal of the tree.
     */
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        out.print(node.value);
    }


    /**
     * Prints the node of the tree breadth-wise.
     * <p/>
     * DEF: Breadth-first search (BFS) is an algorithm for traversing or searching tree
     * or graph data structures. It starts at the tree root (or some arbitrary node of a
     * graph, sometimes referred to as a `search key'[1]) and explores the neighbor nodes
     * first, before moving to the next level neighbors.
     */
    public void breadthFirstTraversal() {
        // assuming level starts at zero
        breadthFirstTraversal(root, 0);
    }

    // todo need to correct, failing in some cases
    public void breadthFirstTraversal(BinaryNode<E> node, int level) {
        if (node == null) return;

        // print the starting node
        if (level == 0) printValue(node);

        // print the neighbour nodes
        printValue(node.left);
        printValue(node.right);

        // go to next level
        level++;
        breadthFirstTraversal(node.left, level);
        breadthFirstTraversal(node.right, level);
    }

    /**
     * Deletes the entire tree.
     */
    public void delete() {
        root = null;
    }

    /**
     * Deletes a particular node from the tree
     * and rearranges the remaining nodes.
     *
     * @param value
     */
    public void delete(E value) {

    }

    /**
     * Deletes all child nodes of {@param node}.
     *
     * @param node
     */
    public void deleteChildrens(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        node.left = null;
        node.right = null;
    }


    /**
     * Return the height of the tree.
     *
     * @return
     */
    public int height() {
        return height(root);
    }

    public int height(BinaryNode<E> node) {
        if (node == null) return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }


    /**
     * Returns the number of nodes currently in the tree.
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    public int size(BinaryNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.left) + 1 + size(node.right);
        }
    }

    /**
     * Tests if this tree is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }


    /**
     * The diameter of a tree (sometimes called the width) is the number
     * of nodes on the longest path between two leaves in the tree.
     *
     * @return the diameter of the tree.
     */
    public int diameter() {
        return diameter(root);
    }

    public int diameter(BinaryNode<E> node) {
        if (node == null) return 0;

        // diameter of current node
        int diameter = height(node.left) + height(node.right) + 1;

        // return max diameters of current node, left sub-tree and right sub-tree
        return Math.max(diameter, Math.max(diameter(node.left), diameter(node.right)));
    }


    /**
     * Width is the number of nodes in a particular level.
     *
     * @return maximum width of the tree.
     */
    public int width() {
        return width(root, 0);
    }

    public int width(BinaryNode<E> node, int width) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) return 1; // for single/leaf node

        int level_width = width(node.left, width) + width(node.right, width);

        if (level_width > width) width = level_width;

        return width;
    }

    public void printValue(BinaryNode<E> node) {
        if (node == null) return;

        out.print(node.value);
    }
}
