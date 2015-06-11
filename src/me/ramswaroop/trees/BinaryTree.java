package me.ramswaroop.trees;

import me.ramswaroop.common.*;

import java.util.ArrayList;
import java.util.EmptyStackException;
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

    BinaryNode<E> root;
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
        out.print("\nSpiral Traversal: ");
        binaryTree.spiralTraversal();
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
        out.print("\nRoot to Leaf Sum: " + binaryTree.rootToLeafPathsSum(binaryTree.root, new ArrayList<Integer>(), 13));
        out.print("\nBFS after Double tree: ");
        binaryTree.doubleTree();
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
     * In spiral order traversal, nodes at different levels
     * are printed in alternating order.
     */
    public void spiralTraversal() {
        spiralTraversal(root, 0); // uses recursion
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

    public void spiralTraversalUsingStacks(BinaryNode<E> node) {
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


    public void constructTreeWithInOrderAndPreOrder(List<BinaryNode<E>> inOrder, List<BinaryNode<E>> preOrder) {
        for (int i = 0; i < preOrder.size(); i++) {

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

        // if its either a leaf node or null then path is complete, add all in the list
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


    /**
     * Converts a given tree to its Double tree. To create a Double tree
     * of the given tree, create a new duplicate for each node, and insert
     * the duplicate as the left child of the original node.
     */
    public void doubleTree() {
        doubleTree(root);
    }

    public void doubleTree(BinaryNode<E> node) {
        if (node == null) return;

        BinaryNode<E> newNode = new BinaryNode<>(node.value, node.left, null);

        node.left = newNode;

        doubleTree(newNode.left);
        doubleTree(node.right);
    }


    /**
     * Utility methods.
     */

    protected void printValue(BinaryNode<E> node) {
        if (node == null) return;

        out.print(node.value);
    }
}
