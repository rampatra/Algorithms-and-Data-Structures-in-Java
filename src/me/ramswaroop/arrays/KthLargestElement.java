package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/1/15
 * @time: 11:26 PM
 */
public class KthLargestElement {

    /**
     * Naive approach.
     * <p/>
     * Time complexity: O(n log n)
     *
     * @param a
     * @param k
     * @return
     */
    public static int getKthLargestElement(int[] a, int k) {
        if (k >= a.length) return -1;

        a = MergeSort.mergeSort(a);

        return a[a.length - k];
    }

    public static void main(String a[]) {
        System.out.println(getKthLargestElement(new int[]{2, 4, 5, 7, 1, 8, 9}, 3));
    }
}
