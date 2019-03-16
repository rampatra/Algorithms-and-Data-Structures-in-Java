package com.rampatra.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array ar[] of n numbers and
 * another number x, determine whether or not there
 * exists two elements in ar[] whose sum is exactly x.
 * 
 * @author rampatra
 * @since 5/18/15
 */
public class PairSum {

    /**
     * Using sorting. If we use Merge Sort or Heap Sort
     * then (-)(nlogn) in worst case. If we use Quick Sort
     * then O(n^2) in worst case.
     *
     * @param ar
     * @param sum
     * @return
     */
    static boolean pairSum(int[] ar, int sum) {
        Arrays.sort(ar);

        int len = ar.length;

        for (int i = 0, j = len - 1; i < j; ) {
            if (ar[i] + ar[j] == sum) {
                return true;
            } else if (ar[i] + ar[j] < sum) { // approach towards larger elements
                i++;
            } else { // approach towards smaller elements
                j--;
            }
        }
        return false;
    }

    /**
     * Using hashmap in O(n) time.
     *
     * @param ar
     * @param sum
     * @param numSet
     * @return
     */
    static boolean pairSum(int[] ar, int sum, Set<Integer> numSet) {
        for (int i = 0; i < ar.length; i++) {
            if (numSet.contains(sum - ar[i])) {
                return true;
            }
            numSet.add(ar[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(pairSum(new int[]{-3, 4, -6, 1, 1}, -2));
        System.out.println(pairSum(new int[]{-3, 4, -6, 1, 1}, 5));
        System.out.println(pairSum(new int[]{-3, 4, -6, 1, 1}, 0));
        System.out.println("--------");
        System.out.println(pairSum(new int[]{-3, 4, -6, 1, 1}, -2, new HashSet<>()));
        System.out.println(pairSum(new int[]{-3, 4, -6, 1, 1}, 5, new HashSet<>()));
        System.out.println(pairSum(new int[]{-3, 4, -6, 1, 1}, 0, new HashSet<>()));
    }
}
