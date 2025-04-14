package com.ctci.stacksandqueues;

import java.util.Arrays;
import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary
 * stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the
 * following operations: push, pop, peek, and isEmpty.
 * 
 * @author rampatra
 * @since 2019-02-08
 */
public class SortStack {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.empty()) {
            tempStack.push(stack.pop());
        }
        while (!tempStack.empty()) {
            Integer item = tempStack.pop();
            if (stack.empty()) {
                stack.push(item);
            } else {
                while (!stack.empty() && item > stack.peek()) {
                    tempStack.push(stack.pop());
                }
                stack.push(item);
            }
        }
    }

    public static void printStack(Stack<Integer> stack) {
        System.out.println(Arrays.toString(stack.toArray()));
    }

    public static void main(String[] args) {
        Stack<Integer> unsortedStack = new Stack<>();
//        unsortedStack.push(2);
//        unsortedStack.push(5);
//        unsortedStack.push(1);
//        unsortedStack.push(3);
        printStack(unsortedStack);
        sortStack(unsortedStack);
        printStack(unsortedStack);
    }
}
