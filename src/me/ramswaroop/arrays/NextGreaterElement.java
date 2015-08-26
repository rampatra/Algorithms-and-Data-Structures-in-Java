package me.ramswaroop.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/26/15
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
    public static int[] nextGreaterElements(int[] a) {
        int[] greaterElements = new int[a.length]; // stores the next greater element of each element in array a
        greaterElements[a.length - 1] = -1; // no elements greater than the last element

        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i + 1] > a[i]) { // if next element is greater than the current element
                greaterElements[i] = a[i + 1];
            } else { // if next element is smaller then find the greater element of the next element
                greaterElements[i] = greaterElements[i + 1];
            }
        }
        return greaterElements;
    }

    public static void main(String a[]) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{4, 5, 2, 25})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{11, 13, 21, 3})));
    }
}
