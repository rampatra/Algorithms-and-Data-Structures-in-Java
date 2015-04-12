package me.ramswaroop;

import me.ramswaroop.common.LinkedQueue;
import me.ramswaroop.common.LinkedStack;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("======== Stack ========");

        LinkedStack<Integer> stack = new LinkedStack();
        stack.push(5);
        stack.push(7);
        stack.push(2);
        stack.push(6);
        stack.print();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.print();
        stack.push(1);
        stack.push(2);
        stack.print();
        System.out.print(stack.peek());
        stack.print();

        System.out.println("\n======== Queue ========");

        LinkedQueue<Integer> queue = new LinkedQueue();
        queue.add(5);
        queue.add(7);
        queue.add(2);
        queue.add(6);
        queue.add(8);
        queue.add(10);
        queue.add(11);
        queue.add(4);
        queue.print();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.print();
        queue.remove();
        queue.print();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.print();
        //queue.remove();
        //queue.remove();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.print();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.print();
        queue.remove();
        queue.print();
    }
}
