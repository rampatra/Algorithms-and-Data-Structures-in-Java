package me.ramswaroop.arrays;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/12/15
 * @time: 11:19 PM
 */
public class MedianOfStream {

    public static int getMedianOfStream(int med, int elem, MaxHeap maxHeap, MinHeap minHeap) {

        switch (compare(maxHeap.getSize(), minHeap.getSize())) {
            case 0:
                if (elem < med) {
                    maxHeap.insert(elem);
                    med = maxHeap.findMax();
                } else {
                    minHeap.insert(elem);
                    med = minHeap.findMin();
                }
                break;
            case 1:
                if (elem < med) {
                    minHeap.insert(maxHeap.deleteMax());
                    maxHeap.insert(elem);
                } else {
                    minHeap.insert(elem);
                }
                med = (maxHeap.findMax() + minHeap.findMin()) / 2;
                break;
            case -1:
                if (elem < med) {
                    maxHeap.insert(elem);
                } else {
                    maxHeap.insert(minHeap.deleteMin());
                    minHeap.insert(elem);
                }
                med = (maxHeap.findMax() + minHeap.findMin()) / 2;
                break;
        }
        return med;
    }

    static void printMedianOfStream(int[] a) {
        int m = 0;
        MaxHeap maxHeap = new MaxHeap(12);
        MinHeap minHeap = new MinHeap(12);
        for (int i = 0; i < a.length; i++) {
            m = getMedianOfStream(m, a[i], maxHeap, minHeap);
        }
        System.out.println(m);
    }

    static int compare(int a, int b) {
        if (a == b) {
            return 0;
        } else {
            return a < b ? -1 : 1;
        }
    }

    public static void main(String a[]) {
        printMedianOfStream(new int[]{5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4});
    }
}

class MinHeap {
    /**
     * The number of children each node has *
     */
    private static final int d = 2;
    private int size;
    private int[] heap;

    /**
     * Constructor *
     */
    public MinHeap(int capacity) {
        size = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    /**
     * Function to check if heap is empty *
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check if heap is full *
     */
    public boolean isFull() {
        return size == heap.length;
    }

    /**
     * Clear heap
     */
    public void makeEmpty() {
        size = 0;
    }

    /**
     * Function to  get index parent of i *
     */
    private int parent(int i) {
        return (i - 1) / d;
    }

    /**
     * Function to get index of k th child of i *
     */
    private int kthChild(int i, int k) {
        return d * i + k;
    }

    /**
     * Function to insert element
     */
    public void insert(int x) {
        if (isFull())
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[size++] = x;
        heapifyUp(size - 1);
    }

    /**
     * Function to find least element *
     */
    public int findMin() {
        if (size == 0) return -1;
        return heap[0];
    }

    /**
     * Function to delete min element *
     */
    public int deleteMin() {
        int keyItem = heap[0];
        delete(0);
        return keyItem;
    }

    /**
     * Function to delete element at an index *
     */
    public int delete(int ind) {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[ind];
        heap[ind] = heap[size - 1];
        size--;
        heapifyDown(ind);
        return keyItem;
    }

    /**
     * Function heapifyUp  *
     */
    private void heapifyUp(int childInd) {
        int tmp = heap[childInd];
        while (childInd > 0 && tmp < heap[parent(childInd)]) {
            heap[childInd] = heap[parent(childInd)];
            childInd = parent(childInd);
        }
        heap[childInd] = tmp;
    }

    /**
     * Function heapifyDown *
     */
    private void heapifyDown(int ind) {
        int child;
        int tmp = heap[ind];
        while (kthChild(ind, 1) < size) {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }

    /**
     * Function to get smallest child *
     */
    private int minChild(int ind) {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < size)) {
            if (heap[pos] < heap[bestChild])
                bestChild = pos;
            pos = kthChild(ind, k++);
        }
        return bestChild;
    }

    public int getSize() {
        return size;
    }

    /**
     * Function to print heap *
     */
    public void printHeap() {
        System.out.print("\nHeap = ");
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}

class MaxHeap {
    private int[] heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    public int findMax() {
        if (size == 0) return -1;
        return heap[FRONT];
    }

    public int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
                if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        heap[++size] = element;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int getSize() {
        return size;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2 * i]
                    + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    public int deleteMax() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        maxHeapify(FRONT);
        return popped;
    }
}
