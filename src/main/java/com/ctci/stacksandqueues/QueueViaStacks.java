package com.ctci.stacksandqueues;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implement a queue using two stacks. No other data structures to be used.
 *
 * @author rampatra
 * @since 2019-02-06
 */
public class QueueViaStacks<T> {

    private Stack<T> stackFront = new Stack<>();
    private Stack<T> stackRear = new Stack<>();

    private T add(T item) {
        return stackRear.push(item);
    }

    private T remove() {
        if (stackFront.empty() && stackRear.empty()) {
            throw new NoSuchElementException();
        } else if (!stackFront.empty()) {
            return stackFront.pop();
        } else {
            while (!stackRear.empty()) {
                stackFront.push(stackRear.pop());
            }
            return stackFront.pop();
        }
    }

    private void print() {
        Stack<T> tempStack = new Stack<>();
        while (!stackFront.empty()) {
            tempStack.push(stackFront.pop());
        }
        System.out.print("[");
        tempStack.forEach(item -> System.out.print(item + ","));
        stackRear.forEach(item -> System.out.print(item + ","));
        System.out.println("]");
        while (!tempStack.empty()) {
            stackFront.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        QueueViaStacks<Integer> queue = new QueueViaStacks<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.print();
        queue.remove();
        queue.print();
        queue.remove();
        queue.print();
        queue.remove();
        queue.print();
    }
}
