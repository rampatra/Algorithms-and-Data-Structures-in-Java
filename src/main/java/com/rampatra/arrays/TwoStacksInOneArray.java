package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * <p>
 * Implement two stacks using a single array with efficient use of space.
 * We could do this by dividing the array into two equal halves or storing stack
 * elements alternatively in the array but that wouldn't utilize the space fully.
 * So we stored stack1's elements at one end of the array and stack2's elements at
 * the other end.
 *
 * @author rampatra
 * @since 9/21/15
 * @time: 6:18 PM
 */
public class TwoStacksInOneArray {

    int[] array;
    int top1, top2, size;

    TwoStacksInOneArray(int size) {
        array = new int[size];
        this.size = size;
        top1 = -1;
        top2 = size;
    }

    void push(int stack, int item) {
        if (top1 == top2 - 1) {
            System.out.println("Stack is full");
            return;
        }

        if (stack == 1) {
            top1++;
            array[top1] = item;
        } else {
            top2--;
            array[top2] = item;
        }
    }

    int pop(int stack) {
        if (stack == 1) {
            if (top1 == -1) {
                System.out.println("Stack 1 is empty");
                return -1;
            }
            int pop = array[top1];
            top1--;
            return pop;
        } else {
            if (top2 == size) {
                System.out.println("Stack 2 is empty");
                return -1;
            }
            int pop = array[top2];
            top2++;
            return pop;
        }
    }

    void printStack(int stack) {
        if (stack == 1) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, top1 + 1)));
        } else {
            System.out.println(Arrays.toString(Arrays.copyOfRange(array, top2, size)));
        }
    }

    public static void main(String[] args) {
        TwoStacksInOneArray twoStack = new TwoStacksInOneArray(5);
        twoStack.push(1, 3);
        twoStack.push(1, 4);
        twoStack.push(1, 5);
        twoStack.push(2, 1);
        twoStack.push(1, 6);
        twoStack.push(1, 7);
        twoStack.printStack(1);
        twoStack.pop(1);
        twoStack.pop(1);
        twoStack.pop(1);
        twoStack.pop(1);
        twoStack.pop(1);
        twoStack.pop(1);
        twoStack.printStack(2);
        twoStack.pop(2);
        twoStack.pop(2);
        twoStack.printStack(2);
    }
}
