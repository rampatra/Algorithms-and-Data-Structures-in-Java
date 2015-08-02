package me.ramswaroop.common;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/2/15
 * @time: 11:57 AM
 */
public class Heap {

    public static void minHeapify(int[] a, int index) {
        int smallest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < a.length && a[index] > a[leftIndex]) {
            smallest = leftIndex;
        }
        if (rightIndex < a.length && a[smallest] > a[rightIndex]) {
            smallest = rightIndex;
        }

        if (smallest != index) {
            swap(a, index, smallest);
            minHeapify(a, smallest);
        }
    }

    public static void buildMinHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            minHeapify(a, i);
        }
    }

    public static void maxHeapify(int[] a, int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < a.length && a[index] < a[leftIndex]) {
            largest = leftIndex;
        }
        if (rightIndex < a.length && a[largest] < a[rightIndex]) {
            largest = rightIndex;
        }

        if (largest != index) {
            swap(a, index, largest);
            maxHeapify(a, largest);
        }
    }

    public static void buildMaxHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            maxHeapify(a, i);
        }
    }

    public static void swap(int[] a, int firstIndex, int secondIndex) {
        a[firstIndex] = a[firstIndex] + a[secondIndex];
        a[secondIndex] = a[firstIndex] - a[secondIndex];
        a[firstIndex] = a[firstIndex] - a[secondIndex];
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 5, 1, 6, 7, 8};
        System.out.println(Arrays.toString(a));
        buildMaxHeap(a);
        System.out.println(Arrays.toString(a));
        buildMinHeap(a);
        System.out.println(Arrays.toString(a));
    }
}
