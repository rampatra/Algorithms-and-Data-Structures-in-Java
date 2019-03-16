package com.rampatra.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 5/18/15
 * @time: 10:24 PM
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array ar[] of n numbers and another number x, determine whether
 * or not there exists two elements in ar[] whose difference is exactly x.
 * This problem is similar to {@link PairSum}.
 */
public class PairDiff {

    /**
     * Using sorting. If we use Merge Sort or Heap Sort
     * then (-)(nlogn) in worst case. If we use Quick Sort
     * then O(n^2) in worst case.
     *
     * @param ar
     * @param x
     * @return
     */
    static boolean pairDiff(int ar[], int x) {
        Arrays.sort(ar);

        int len = ar.length;

        for (int i = 0, j = 1; i < len && j < len; ) {
            if (i != j && ar[j] - ar[i] == x) {
                return true;
            } else if (ar[j] - ar[i] < x) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }

    /**
     * Using HashMap in O(n) time.
     *
     * @param ar
     * @param x
     * @param map
     * @return
     */
    static boolean pairDiff(int ar[], int x, Map<Integer, Integer> map) {
        for (int i = 0; i < ar.length; i++) {
            if (map.containsKey(x + ar[i])) {
                return true;
            }
            map.put(ar[i], 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(pairDiff(new int[]{-3, 4, -6, 1, 1}, -4));
        System.out.println(pairDiff(new int[]{3, 1}, 2));
        System.out.println(pairDiff(new int[]{-3, 4, -6, 1, 1}, -4, new HashMap<Integer, Integer>()));
        System.out.println(pairDiff(new int[]{3, 1}, 2, new HashMap<Integer, Integer>()));
    }
}
