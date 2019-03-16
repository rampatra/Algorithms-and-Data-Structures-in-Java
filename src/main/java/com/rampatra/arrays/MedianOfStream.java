package com.rampatra.arrays;

import com.rampatra.base.MaxHeap;
import com.rampatra.base.MinHeap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/12/15
 * @time: 11:19 PM
 */
public class MedianOfStream {

    /**
     * @param med
     * @param elem
     * @param maxHeap
     * @param minHeap
     * @return
     */
    public static int getMedianOfStream(int med, int elem, MaxHeap maxHeap, MinHeap minHeap) {

        switch (compare(maxHeap.getSize(), minHeap.getSize())) {
            case 0: // sizes of maxHeap and minHeap are same
                if (elem < med) {
                    maxHeap.insert(elem);
                    med = maxHeap.findMax();
                } else {
                    minHeap.insert(elem);
                    med = minHeap.findMin();
                }
                break;
            case 1: // size of maxHeap greater than minHeap
                if (elem < med) {
                    minHeap.insert(maxHeap.extractMax());
                    maxHeap.insert(elem);
                } else {
                    minHeap.insert(elem);
                }
                med = (maxHeap.findMax() + minHeap.findMin()) / 2;
                break;
            case -1: // size of maxHeap smaller than minHeap
                if (elem < med) {
                    maxHeap.insert(elem);
                } else {
                    maxHeap.insert(minHeap.extractMin());
                    minHeap.insert(elem);
                }
                med = (maxHeap.findMax() + minHeap.findMin()) / 2;
                break;
        }
        return med;
    }

    static void printMedianOfStream(int[] a) {
        int m = 0;
        MaxHeap maxHeap = new MaxHeap(a);
        MinHeap minHeap = new MinHeap(a);

        // calling in a loop so at to resemble a stream
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

    public static void main(String[] args) {
        printMedianOfStream(new int[]{5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4});
        printMedianOfStream(new int[]{5, 15, 1});
        printMedianOfStream(new int[]{5, 15, 10, 20});
    }
}
