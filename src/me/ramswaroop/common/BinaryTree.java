package me.ramswaroop.common;

import java.util.List;
import java.util.NoSuchElementException;

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

    public static void main(String[] a) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.put(6);
        binaryTree.put(3);
        binaryTree.put(9);
        binaryTree.put(2);
        /*binaryTree.put(4);
        binaryTree.put(5);
        binaryTree.put(7);*/
        out.print("Breadth-first Traversal: ");
        binaryTree.breadthFirstTraversal();
        out.print("\nIn order traversal: ");
        binaryTree.inOrder();
        out.print("\nIn order traversal without stack: ");
        binaryTree.inOrderWithoutStackAndRecursion(binaryTree.root);
        out.print("\nWidth: " + binaryTree.width());
        out.print("\nIs BST: " + binaryTree.isBST());
        out.print("\nIs Children Sum : " + binaryTree.isChildrenSum());
        /*binaryTree.toChildrenSum();
        out.print("\nBreadth-first Traversal after to children sum: ");
        binaryTree.breadthFirstTraversal();*/
        out.print("\nIs height balanced: " + binaryTree.isHeightBalanced());
        out.print("\nDiameter: " + binaryTree.diameter());

        binaryTree.breadthFirstTraversalUsingQueue();
        out.print("\nIn order traversal: ");
        binaryTree.inOrder();
        binaryTree.deleteChildrens(binaryTree.root);
        out.print("\nIn order traversal after deleteChildrens: ");
        binaryTree.inOrder();
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
     * Traversals using recursions.
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
     * Traversals without recursions.
     */

    /**
     * In-order traversal of tree using one stack and without recursion.
     *
     * @param node
     */
    public void inOrderUsingStack(BinaryNode<E> node) {
        if (node == null) return;

        Stack<BinaryNode<E>> stack = new LinkedStack<>();

        BinaryNode<E> curr = node; // set root node as current node
        stack.push(curr); // push current node

        while (!stack.isEmpty()) {

            while (curr != null) {
                curr = curr.left;
                if (curr != null) stack.push(curr); // push all left nodes of the current node
            }

            BinaryNode<E> top = stack.pop();
            out.print(top.value); // print top of stack
            curr = top.right;
            if (curr != null) stack.push(curr); // push right child of top node
        }
    }

    /**
     * Using Morris Traversal, we can traverse the tree without using stack and
     * recursion. The idea of Morris Traversal is based on Threaded Binary Tree.
     * In this traversal, we first create links to Inorder successor and print the
     * data using these links, and finally revert the changes to restore original tree.
     * <p/>
     * A binary tree is THREADED by making all right child pointers that would normally
     * be null point to the inorder successor of the node (if it exists), and all left
     * child pointers that would normally be null point to the inorder predecessor of
     * the node.
     * <p/>
     * PSEUDOCODE:
     * 1. Initialize current as root
     * 2. While current is not NULL
     * If current does not have left child
     * a) Print current’s data
     * b) Go to the right, i.e., current = current->right
     * Else
     * a) Make current as right child of the rightmost node in current's left subtree
     * b) Go to this left child, i.e., current = current->left
     *
     * @param node
     */
    public void inOrderWithoutStackAndRecursion(BinaryNode<E> node) {
        if (node == null) return;

        BinaryNode<E> curr = node;

        while (curr != null) {
            // print the leftmost node
            if (curr.left == null) {
                printValue(curr);
                curr = curr.right;
            } else { // make current as right child of the rightmost node in current's left subtree
                BinaryNode<E> pre = curr.left;

                while (pre.right != curr && pre.right != null) {
                    pre = pre.right;
                }
                if (pre.right != curr) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    printValue(curr);
                    curr = curr.right;
                    pre.right = null; // revert to the original tree structure
                }
            }
        }
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

    /**
     * An empty tree is height-balanced. A non-empty binary tree T is balanced if:
     * 1) Left subtree of T is balanced
     * 2) Right subtree of T is balanced
     * 3) The difference between heights of left subtree and right subtree is not more than 1.
     *
     * @return True if tree is height balanced otherwise false.
     */
    public boolean isHeightBalanced() {
        return isHeightBalanced(root);
    }

    public boolean isHeightBalanced(BinaryNode<E> node) {
        if (node == null) return true;

        if (Math.abs(height(node.left) - height(node.right)) > 1) {
            return false;
        }

        return isHeightBalanced(node.left) && isHeightBalanced(node.right);
    }

    /**
     * Children Sum Invariant: For every node, the value must be equal to
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
     */
    public void toChildrenSum() {
        toChildrenSum(root);
    }

    public void toChildrenSum(BinaryNode<E> node) {

        if (node == null || node.left == null && node.right == null) return;

        toChildrenSum(node.left);
        toChildrenSum(node.right);

        Integer nodeValue = (Integer) (node == null ? 0 : node.value);
        Integer leftChildValue = (Integer) (node.left == null ? 0 : node.left.value);
        Integer rightChildValue = (Integer) (node.right == null ? 0 : node.right.value);

        int diff = (nodeValue - (leftChildValue + rightChildValue));

        if (diff < 0) {
            increment(node, diff);
        } else if (diff > 0) {
            if (node.left != null) {
                increment(node.left, diff);
            } else {
                increment(node.right, diff);
            }
        }
    }

    // TODO
    private void increment(BinaryNode<E> node, int diff) {
        if (node.left != null) {
            //node.value += Math.abs(diff);
            increment(node.left, diff);
        } else if (node.right != null) {
            //node.value += Math.abs(diff);
            increment(node.right, diff);
        }
    }

    public void printValue(BinaryNode<E> node) {
        if (node == null) return;

        out.print(node.value);
    }
}
