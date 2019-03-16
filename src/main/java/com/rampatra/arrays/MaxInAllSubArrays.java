package com.rampatra.arrays;

import com.rampatra.base.MaxHeap;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/3/15
 * @time: 9:21 PM
 */
public class MaxInAllSubArrays {

    /**
     * Naive approach.
     * <p/>
     * Finds the maximum element in each and every sub-array
     * in {@param a} of size {@param k}.
     * <p/>
     * Time complexity: O(n*k), or more precisely O((n-k) * k)
     *
     * @param a
     * @param k
     */
    public static int[] maxInAllSubArraysOfSizeKNaive(int[] a, int k) {
        int[] maxElements = new int[a.length - k + 1];
        int[] kElements;

        for (int i = 0; i <= a.length - k; i++) {
            kElements = Arrays.copyOfRange(a, i, i + k);
            /**
             * maxHeapify() can't be used because to call maxHeapify() on i because left(i) and right (i) should 
             * already satisfy the max heap property which isn't true in this case.
             */
            MaxHeap maxHeap = new MaxHeap(kElements);
            maxHeap.buildMaxHeap();
            maxElements[i] = maxHeap.findMax();
        }

        return maxElements;
    }

    /**
     * Finds the maximum element in each and every sub-array
     * in {@param a} of size {@param k}.
     * <p>
     * Time complexity: O(n)
     * Auxiliary Space: O(k)
     *
     * @param a
     * @param k
     * @return
     */
    public static int[] maxInAllSubArraysOfSizeK(int[] a, int k) {
        int i, j = 0;
        int[] result = new int[a.length - k + 1];
        /**
         * Create a Double Ended Queue, Qi that will store indexes of array elements
         * The queue will store indexes of useful elements in every window and it will
         * maintain decreasing order of values from front to rear in Qi, i.e, 
         * arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order.
         */
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (i = 0; i < k; i++) {
            // remove smaller elements on left side of current element
            while (!deque.isEmpty() && a[i] > a[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for (; i < a.length; i++) {
            result[j++] = a[deque.peekFirst()];

            // remove elements that are outside window k
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            // remove smaller elements on left side of current element
            while (!deque.isEmpty() && a[i] > a[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // for max in last k elements
        result[j] = a[deque.peekFirst()];

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxInAllSubArraysOfSizeKNaive(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3)));
        System.out.println(Arrays.toString(maxInAllSubArraysOfSizeKNaive(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4)));
        System.out.println(Arrays.toString(maxInAllSubArraysOfSizeK(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3)));
        System.out.println(Arrays.toString(maxInAllSubArraysOfSizeK(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4)));
    }
}
