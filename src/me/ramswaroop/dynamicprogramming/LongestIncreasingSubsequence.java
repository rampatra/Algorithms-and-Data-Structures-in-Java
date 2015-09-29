package me.ramswaroop.dynamicprogramming;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/29/15
 * @time: 10:15 PM
 */
public class LongestIncreasingSubSequence {

    /**
     * TODO: Properly document and understand
     * The Longest Increasing SubSequence (LIS) problem is to find the length of
     * the longest sub-sequence of a given sequence such that all elements of the
     * sub-sequence are sorted in increasing order.
     * 
     * For example, 
     * Length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS 
     * is {10, 22, 33, 50, 60, 80}.
     * 
     * Optimal Substructure:
     * Let arr[0..n-1] be the input array and L(i) be the length of the LIS till index i such that arr[i] is part
     * of LIS and arr[i] is the last element in LIS, then L(i) can be recursively written as.
     * L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and if there is no such j then L(i) = 1
     * To get LIS of a given array, we need to return max(L(i)) where 0 < i < n So the LIS problem has optimal 
     * substructure property as the main problem can be solved using solutions to sub-problems. 
     * 
     * @param a
     * @return
     */
    public static int getLongestIncreasingSubSequenceLength(int[] a) {
        int len = a.length, maxLisLength = 0;
        int[] lis = new int[len];

        for (int i = 0; i < len; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            if (lis[i] > maxLisLength) {
                maxLisLength = lis[i];
            }
        }

        return maxLisLength;
    }

    public static void main(String a[]) {
        System.out.println(getLongestIncreasingSubSequenceLength(new int[]{2, 3, 7, 8, 15}));
        System.out.println(getLongestIncreasingSubSequenceLength(new int[]{2, 20, 7, 8, 1}));
        System.out.println(getLongestIncreasingSubSequenceLength(new int[]{20, 10, 5}));
    }
}
