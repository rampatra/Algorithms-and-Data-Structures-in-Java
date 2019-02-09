package com.ctci.stacksandqueues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we
 * would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks. pop() should behave identically to a single
 * stack (that is, pop() should return the same values as it would if there were just a single stack).
 *
 * @author rampatra
 * @since 2019-02-08
 */
public class StackOfPlates {

    private static final int capacity = 3;
    private static List<Stack<Integer>> stackList = new ArrayList<>();

    private static int push(int item) {
        return getLastStack().push(item);
    }

    private static int pop() {
        Stack<Integer> lastStack = stackList.get(stackList.size() - 1);
        if (lastStack == null || (stackList.size() == 1 && lastStack.empty())) {
            throw new EmptyStackException();
        } else if (lastStack.empty()) {
            stackList.remove(stackList.size() - 1);
            return pop();
        } else {
            return lastStack.pop();
        }
    }

    private static Stack<Integer> getLastStack() {
        if (stackList.size() == 0 || isFull(stackList.get(stackList.size() - 1))) {
            stackList.add(new Stack<>());
        }
        return stackList.get(stackList.size() - 1);
    }

    private static boolean isFull(Stack<Integer> stack) {
        return stack.size() >= capacity;
    }

    private static void print() {
        System.out.print("[");
        stackList.stream().flatMap(Collection::stream).forEach(System.out::print);
        System.out.println("]");
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        print();
        push(3);
        print();
        push(4);
        push(5);
        print();
        push(6);
        push(7);
        print();
        pop();
        print();
        pop();
        pop();
        pop();
        print();
        pop();
        pop();
        pop();
        print();
    }
}
