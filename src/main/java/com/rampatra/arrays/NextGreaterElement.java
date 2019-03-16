package com.rampatra.arrays;

import com.rampatra.base.LinkedStack;
import com.rampatra.base.Stack;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/26/15
 * @time: 12:35 PM
 */
public class NextGreaterElement {

    /**
     * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element
     * for an element x is the first greater element on the right side of x in array. Elements for which
     * no greater element exist, consider next greater element as -1.
     *
     * @param a
     * @return
     */
    public static void nextGreaterElements(int[] a) {
        int i = 0;
        Stack<Integer> stack = new LinkedStack<>(); // used to store elements whose NGE is yet to be determined

        for (; i < a.length - 1; i++) {
            stack.push(a[i]);

            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                if (pop < a[i + 1]) { // NGE found for popped element
                    System.out.println(pop + "->" + a[i + 1]);
                } else {
                    stack.push(pop); // NGE still not found for popped element, so push it again
                    break;
                }
            }
        }

        // no NGE for elements left in stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + "->" + -1);
        }

        // no NGE for last element
        System.out.println(a[i] + "->" + -1);
    }

    public static void main(String[] args) {
        int[] ar = new int[]{4, 5, 2, 25};
        nextGreaterElements(ar);
        System.out.println("=========");
        ar = new int[]{11, 13, 21, 3};
        nextGreaterElements(ar);
        System.out.println("=========");
        ar = new int[]{1, 5, 3, 4, 2, 0, 11};
        nextGreaterElements(ar);
        System.out.println("=========");
        ar = new int[]{3, 6, 8, 2, 1, 5, 12, 4, 9};
        nextGreaterElements(ar);
    }
}
