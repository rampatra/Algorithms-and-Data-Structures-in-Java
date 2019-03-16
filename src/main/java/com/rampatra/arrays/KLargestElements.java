package com.rampatra.arrays;

import com.rampatra.base.MinHeap;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 8/3/15
 * @time: 3:47 PM
 */
public class KLargestElements {

    /**
     * Finds {@param k} largest elements in array {@param a}.
     * <p>
     * Algorithm:
     * 1) Build a Min Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array. This takes O(k) time.
     * <p>
     * 2) For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of MH.
     * ……a) If the element is greater than the root then make it root and call buildHeap for MH
     * ……b) Else ignore it.
     * This step takes (n-k) * O(k) time.
     * <p>
     * 3) Finally, MH has k largest elements and root of the MH is the kth largest element.
     * <p>
     * Therefore, the total time complexity of the above algorithm is: O(k) + (n-k) * O(k).
     *
     * @param a
     * @param k
     * @return
     */
    public static int[] getKLargestElements(int[] a, int k) {

        int[] kElements = Arrays.copyOfRange(a, 0, k);

        MinHeap minHeap = new MinHeap(kElements);
        minHeap.buildMinHeap();

        for (int i = k; i < a.length; i++) {
            if (a[i] > minHeap.findMin()) {
                minHeap.extractMin();
                minHeap.insert(a[i]);
            }
        }

        return minHeap.getHeap();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getKLargestElements(new int[]{2, 3, 4, 1, 5, 7, 9}, 3)));
    }
}
