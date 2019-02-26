package com.rampatra.base;

import com.rampatra.sorting.HeapSort;

import java.util.Arrays;

/**
 * A HEAP is a specialized tree-based ABSTRACT DATA TYPE that satisfies the heap property:
 * min-heap: All non-leaf elements are either smaller than or equal to their left and right child.
 * max-heap: All non-leaf elements are either greater than or equal to their left and right child.
 * <p/>
 * Often implemented as an array, where the children of the element at index i are at index
 * 2i+1 (left child) and 2i+2 (right child).
 * <p/>
 * The first element (minimum or maximum, depending on chosen order) can be found in O(1).
 * Each successor can be found in O(log n). The algorithm in maxHeapify() takes O(log n) time
 * Therefore, buildMaxHeap() would take O(n log n) time BUT IF OBSERVED CAREFULLY IT TAKES 0(N) TIME.
 * <p/>
 * Used in the HeapSort algorithm. Also can be used to implement a PriorityQueue.
 * <a href="@see http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap07.htm">Learn more</a>
 *
 * @author rampatra
 * @since 8/2/15
 */
public class MaxHeap {

    int[] heap;
    int size;

    public MaxHeap(int[] heap) {
        this.size = heap.length;
        this.heap = Arrays.copyOf(heap, size);
    }

    /**
     * Makes the array {@param a} satisfy the max heap property starting from
     * {@param index} till the end of array.
     * <p/>
     * See {@link HeapSort#maxHeapify} for a modified
     * version of maxHeapify.
     * <p/>
     * Time complexity: O(log n).
     *
     * @param index
     */
    public void maxHeapify(int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < size && heap[index] < heap[leftIndex]) {
            largest = leftIndex;
        }
        if (rightIndex < size && heap[largest] < heap[rightIndex]) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    /**
     * Converts array {@param a} in to a max heap.
     * <p/>
     * Time complexity: O(n) and is not O(n log n).
     */
    public void buildMaxHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    /**
     * Insert a new element into the heap satisfying
     * the heap property.
     * <p>
     * Time complexity: O(log n) where 'n' is total no. of
     * elements in heap or O(h) where 'h' is the height of
     * heap.
     *
     * @param elem
     */
    public void insert(int elem) {
        // increase heap size
        heap = Arrays.copyOf(heap, size + 1);
        int i = size;
        int parentIndex = (int) Math.floor((i - 1) / 2);
        // move up through the heap till you find the right position
        while (i > 0 && elem > heap[parentIndex]) {
            heap[i] = heap[parentIndex];
            i = parentIndex;
            parentIndex = (int) Math.floor((i - 1) / 2);
        }
        heap[i] = elem;
        size++;
    }

    public int findMax() {
        if (size == 0) {
            return -1;
        } else {
            return heap[0];
        }
    }

    public int extractMax() {
        if (size == 0) return -1;

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return min;
    }

    public int getSize() {
        return size;
    }

    public int[] getHeap() {
        return heap;
    }

    public void printHeap() {
        if (heap == null)
            System.out.print("null");
        int iMax = size - 1, i;
        if (iMax == -1)
            System.out.print("[]");

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (i = 0; i < iMax; i++) {
            b.append(heap[i]);
            b.append(", ");
        }
        System.out.println(b.append(heap[i]).append(']').toString());
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }

    // test cases
    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 5, 1, 6, 7, 8};
        MaxHeap maxHeap = new MaxHeap(a);
        maxHeap.printHeap();
        maxHeap.buildMaxHeap();
        maxHeap.printHeap();
        maxHeap.extractMax();
        maxHeap.printHeap();
        maxHeap.insert(12);
        maxHeap.printHeap();
    }
}
