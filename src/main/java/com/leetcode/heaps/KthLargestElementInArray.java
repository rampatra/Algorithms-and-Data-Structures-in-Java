package com.leetcode.heaps;

import com.rampatra.base.MaxHeap;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Description:
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
 * the kth distinct element.
 * <p>
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * <p>
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @author rampatra
 * @since 2019-08-19
 */
public class KthLargestElementInArray {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/252999497/">1 ms</a>.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        return heapSortUntilK(nums, k);
    }

    /**
     * In heapsort, after each iteration we have the max element at the end of the array. Ergo, if we run the algorithm
     * k times then we would have our kth largest element.
     *
     * @param a
     * @param k
     * @return
     */
    public static int heapSortUntilK(int[] a, int k) {
        buildMaxHeap(a);
        int count = 0;

        for (int i = a.length - 1; i > 0; i--) {
            if (count++ == k) {
                break;
            }
            swap(a, 0, i);
            maxHeapify(a, 0, i);
        }

        return a[a.length - k];
    }

    /**
     * Makes the array {@param a} satisfy the max heap property starting from
     * {@param index} till {@param end} position in array.
     * <p/>
     * See this {@link MaxHeap#maxHeapify} for a basic version of maxHeapify.
     * <p/>
     * Time complexity: O(log n).
     *
     * @param a
     * @param index
     * @param end
     */
    public static void maxHeapify(int[] a, int index, int end) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < end && a[index] < a[leftIndex]) {
            largest = leftIndex;
        }
        if (rightIndex < end && a[largest] < a[rightIndex]) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(a, index, largest);
            maxHeapify(a, largest, end);
        }
    }

    /**
     * Converts array {@param a} in to a max heap.
     * <p/>
     * Time complexity: O(n) and is not O(n log n).
     */
    private static void buildMaxHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i, a.length);
        }
    }


    /**
     * When you poll() on a PriorityQueue the smallest number in the queue is removed. Based on this property, we can
     * iterate over the entire array and in the end we would be left with the k largest element in the queue.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestUsingPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            priorityQueue.add(num);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.isEmpty() ? -1 : priorityQueue.peek();
    }

    private static void swap(int[] a, int firstIndex, int secondIndex) {
        a[firstIndex] = a[firstIndex] + a[secondIndex];
        a[secondIndex] = a[firstIndex] - a[secondIndex];
        a[firstIndex] = a[firstIndex] - a[secondIndex];
    }

    public static void main(String[] args) {
        assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(3, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 4));

        assertEquals(5, findKthLargestUsingPriorityQueue(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(3, findKthLargestUsingPriorityQueue(new int[]{3, 2, 1, 5, 6, 4}, 4));
    }
}
