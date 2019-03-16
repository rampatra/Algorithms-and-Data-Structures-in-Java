package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/15/15
 * @time: 9:17 PM
 */
public class ProductArrayPuzzle {

    /**
     * Construct a Product Array prod[] (of same size) such that prod[i] is
     * equal to the product of all the elements of arr[] except arr[i]. Solve
     * it without division operator and in O(n).
     * <p/>
     * You can do this by taking two arrays one containing the products from
     * left to right elements and other containing the products from right to
     * left elements and then finally multiplying those two arrays gives you
     * the answer. But the auxiliary space complexity of this method is O(n)
     * as well as the space complexity is O(n).
     * <p/>
     * The below method is the optimized way to do this in O(1) auxiliary space
     * but the space complexity is O(n).
     * <p/>
     * AUXILIARY SPACE is extra space or temporary space used by the algorithm,
     * which is mostly used in algorithm where we use swapping or temporary variables.
     * <p/>
     * SPACE COMPLEXITY means total space taken by the algorithm with respect to
     * input size.Space complexity calculated by both auxiliary space and space used
     * by the input.
     * <p/>
     * For example - If we want to compare standard sorting algorithm on the basis of
     * then auxiliary space would be better criteria than space complexity. Merge sort
     * uses O(n) auxiliary space,where Insertion sort and Heap sort uses O(1) auxiliary
     * space. Merge sort requires Ω(n) but Heap sort requires only a constant amount.
     * Space complexity of all these sorting algorithm is O(n) though.
     *
     * @param a
     * @return
     */
    public static int[] getProductArray(int[] a) {
        int[] prod = new int[a.length];

        // prod array consists of products of the elements
        prod[0] = 1;

        // fill prod with products of elements from left to right excluding current element
        for (int i = 1; i < a.length; i++) {
            prod[i] = a[i - 1] * prod[i - 1];
        }

        int temp = 1;
        // fill prod with products of elements from right to left excluding current element
        for (int i = a.length - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= a[i];
        }

        // final prod array is the answer
        return prod;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getProductArray(new int[]{10, 3, 5, 6, 2})));
        System.out.println(Arrays.toString(getProductArray(new int[]{0, 0})));
        System.out.println(Arrays.toString(getProductArray(new int[]{1})));
    }
}
