package com.ctci.stacksandqueues;

import com.sun.tools.javac.util.Assert;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 * 
 * @author rampatra
 * @since 2019-02-04
 */
public class StackMin {

    // the main stack to do push, pop, and min operations
    private static Stack<Integer> stack = new Stack<>();
    // another stack to store the mins (needed to make min() call O(1))
    private static Stack<Integer> minStack = new Stack<>();

    private static int push(int item) {
        minPush(item);
        return stack.push(item);
    }

    private static int pop() {
        minPop(stack.peek());
        return stack.pop();
    }

    private static int min() {
        return minStack.peek();
    }

    private static void minPush(int item) {
        if (minStack.empty() || item <= minStack.peek()) {
            minStack.push(item);
        }
    }

    private static void minPop(int item) {
        if (item == minStack.peek()) {
            minStack.pop();
        }
    }

    public static void main(String[] args) {
        push(2);
        push(5);
        push(1);
        push(1);
        push(6);
        push(8);
        Assert.check(min() == 1);
        pop();
        pop();
        pop();
        Assert.check(min() == 1);
        pop();
        Assert.check(min() == 2);
    }
}