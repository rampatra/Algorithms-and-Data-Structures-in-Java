package me.ramswaroop.trees;

import me.ramswaroop.common.BinaryNode;
import me.ramswaroop.common.BinarySearchTree;
import me.ramswaroop.common.LinkedStack;
import me.ramswaroop.common.Stack;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/26/15
 * @time: 7:31 PM
 */
public class InOrderUsingStack<E extends Comparable<E>> extends BinarySearchTree<E> {

    public void inOrder() {
        inOrderUsingStack(root);
    }

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

    public static void main(String a[]) {
        InOrderUsingStack<Integer> bst = new InOrderUsingStack<>();
        bst.put(6);
        bst.put(3);
        bst.put(5);
        bst.put(7);
        bst.put(8);
        bst.put(9);
        bst.inOrder();
    }
}
