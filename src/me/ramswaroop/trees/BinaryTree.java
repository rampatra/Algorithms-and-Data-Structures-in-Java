package me.ramswaroop.trees;

import me.ramswaroop.common.*;
import me.ramswaroop.utils.Utils;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/19/15
 * Time: 6:35 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinaryTree<E extends Comparable<E>> extends Tree<E> {

    BinaryNode<E> root;
    Queue<BinaryNode<E>> queue = new LinkedQueue<>(); // needed for insertion

    public static void main(String[] a) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        /*binaryTree.put(6);
        binaryTree.put(3);
        binaryTree.put(9);
        binaryTree.put(2);
        binaryTree.put(4);
        binaryTree.put(5);*/
        binaryTree.put(10);
        binaryTree.put(8);
        binaryTree.put(2);
        binaryTree.put(3);
        binaryTree.put(5);
        binaryTree.put(1);
        binaryTree.put(1);
        Utils.print("Breadth-first Traversal: ");
        binaryTree.breadthFirstTraversal();
        Utils.print("\nSpiral Traversal: ");
        binaryTree.spiralTraversal();
        Utils.print("\nIn order traversal: ");
        binaryTree.inOrder();
        Utils.print("\nIs BST: " + binaryTree.isBST());
        Utils.print("\nIs Children Sum : " + binaryTree.isChildrenSum());
    }

    /**
     * Inserts a node into the binary tree such that
     * it always forms a complete binary tree.
     *
     * @param value
     */
    public void put(E value) {
        put(root, value);
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
     * Prints the pre-order traversal of the tree.
     */
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        Utils.print(node.value);
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
        Utils.print(node.value);
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
        Utils.print(node.value);
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
     * Breadth first traversal (Level-order traversal using Queue).
     */
    public void breadthFirstTraversalUsingQueue() {
        Queue<BinaryNode<E>> queue = new LinkedQueue<>();
        breadthFirstTraversalUsingQueue(root, queue);
    }

    public void breadthFirstTraversalUsingQueue(BinaryNode<E> node, Queue<BinaryNode<E>> queue) {

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


    /**
     * In spiral order traversal, nodes at different levels
     * are printed in alternating order.
     */
    public void spiralTraversal() {
        //spiralTraversal(root, 0); // uses recursion
        spiralTraversal(root); // uses 2 stacks
    }

    public void spiralTraversal(BinaryNode<E> node, int level) {
        if (node == null) return;

        // print the starting node
        if (level == 0) printValue(node);

        // print the neighbour nodes
        if (level % 2 == 0) {
            printValue(node.left);
            printValue(node.right);
        } else {
            printValue(node.right);
            printValue(node.left);
        }

        // go to next level
        level++;
        if (level % 2 == 0) {
            spiralTraversal(node.left, level);
            spiralTraversal(node.right, level);
        } else {
            spiralTraversal(node.right, level);
            spiralTraversal(node.left, level);
        }
    }

    public void spiralTraversal(BinaryNode<E> node) {
        Stack<BinaryNode<E>> stack1 = new LinkedStack<>(); // for nodes to be printed ltr
        Stack<BinaryNode<E>> stack2 = new LinkedStack<>(); // for nodes to be printed rtl

        printValue(node);

        stack1.push(node.right);
        stack1.push(node.left);

        // pop stack1 and push their child nodes in stack2
        while (!stack1.isEmpty()) {

            BinaryNode<E> leftChild = stack1.pop();
            BinaryNode<E> rightChild = stack1.pop();

            printValue(leftChild);
            printValue(rightChild);

            try {
                if (leftChild != null) stack2.push(leftChild.left);
                if (leftChild != null) stack2.push(leftChild.right);
                if (rightChild != null) stack2.push(rightChild.left);
                if (rightChild != null) stack2.push(rightChild.right);
            } catch (EmptyStackException e) {
                // ignore error when stack empty
            }
        }

        // pop stack2 and push their child nodes in stack1
        while (!stack2.isEmpty()) {

            BinaryNode<E> rightChild = stack2.pop();
            BinaryNode<E> leftChild = stack2.pop();

            printValue(rightChild);
            printValue(leftChild);

            try {
                if (rightChild != null) stack1.push(rightChild.right);
                if (rightChild != null) stack1.push(rightChild.left);
                if (leftChild != null) stack1.push(leftChild.right);
                if (leftChild != null) stack1.push(leftChild.left);
            } catch (EmptyStackException e) {
                // ignore error when stack empty
            }
        }
    }


    /**
     * Deletes a particular node from the tree.
     *
     * @param value
     */
    public void delete(E value) {

    }

    /**
     * TODO
     * Deletes the entire tree.
     */
    public void delete() {
        delete(root);
        root = null;
    }

    public void delete(BinaryNode<E> node) {
        if (node == null) {
            return;
        }
        // first delete the child nodes
        delete(node.left);
        delete(node.right);
        node = null; // delete node
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
     * Checks whether this tree and another with @param node
     * as root are identical or not.
     *
     * @param node
     * @return
     */
    public boolean isIdentical(BinaryNode<E> node) {
        return isIdentical(this.root, node);
    }

    /**
     * Checks whether two trees having their roots at node1 and node2
     * are identical or not.
     *
     * @param node1
     * @param node2
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isIdentical(BinaryNode<E> node1, BinaryNode<E> node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null && node2 != null || (node1 != null && node2 == null)) return false;

        if (node1.value == node2.value) {
            return true && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
        } else {
            return false;
        }
    }


    /**
     * Converts a Tree to its Mirror Tree.
     * <p/>
     * MIRROR OF A BINARY TREE T is another Binary Tree M(T) with
     * left and right children of all non-leaf nodes interchanged.
     * <p/>
     * TIP: In-order traversal of mirror tree is exactly the
     * reverse of the in-order traversal of the original tree.
     */
    public void mirror() {
        mirror(root);
    }

    public void mirror(BinaryNode<E> node) {
        if (node == null) return;

        BinaryNode<E> tempNode;

        // mirror sub-trees
        mirror(node.left);
        mirror(node.right);

        // swap nodes
        tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
    }


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
                Utils.print(pathList[i] + " -> ");
            }
            // outside the loop so that "->" doesn't appear after the last node
            Utils.println(pathList[i]);
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
                Utils.print(pathList.get(i) + " -> ");
            }
            // outside the loop so that "->" doesn't appear after the last node
            Utils.println(pathList.get(i));
        } else {
            // do the same for subtrees
            rootToLeafPaths(node.left, new ArrayList<>(pathList));
            rootToLeafPaths(node.right, new ArrayList<>(pathList));
        }
    }

    /**
     * Returns the number of leaf nodes in a binary tree.
     *
     * @return
     */
    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    public int countLeafNodes(BinaryNode<E> node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeafNodes(node.left) + countLeafNodes(node.right);
        }
    }


    /**
     * Checks whether the binary tree is a BST or not.
     * <p/>
     * Approach: Performs in-order traversal of the tree and if
     * the result isn't in ascending order then returns false.
     *
     * @return
     */
    public boolean isBST() {
        //List<BinaryNode<E>> list = new ArrayList<>();
        BinaryNode<E> prev = new BinaryNode<>(null);
        return isBST(root, prev);
    }

    /**
     * Traverse the tree in in-order fashion and insert all nodes
     * in a list and check for sort order of list.
     *
     * @param node
     * @param list
     * @return
     */
    public boolean isBST(BinaryNode<E> node, List<BinaryNode<E>> list) {
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
     * Traverse the tree in in-order fashion and keep track of prev node.
     * <p/>
     * TODO Clarify doubt: Why it doesn't work if I replace "prev.value" with "prev"
     *
     * @param node
     * @param prev
     * @return
     */
    public boolean isBST(BinaryNode<E> node, BinaryNode<E> prev) {
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
     * For every node, the value must be equal to
     * sum of values in the left and right child.
     * Consider data value as 0 for NULL child.
     *
     * @return
     */
    public boolean isChildrenSum() {
        return isChildrenSum(root);
    }

    public boolean isChildrenSum(BinaryNode<E> node) {
        if (node == null || node.left == null && node.right == null) return true;

        E leftChildValue = (E) (node.left == null ? 0 : node.left.value);
        E rightChildValue = (E) (node.right == null ? 0 : node.right.value);

        boolean left = isChildrenSum(node.left);
        boolean right = isChildrenSum(node.right);

        if (!node.value.toString().equals(
                String.valueOf(Integer.parseInt(leftChildValue.toString()) +
                        Integer.parseInt(rightChildValue.toString()))
        )) {
            return false;
        }

        return left && right;
    }


    /**
     * Utility methods.
     */

    protected void printValue(BinaryNode<E> node) {
        if (node == null) return;

        Utils.print(node.value);
    }
}
