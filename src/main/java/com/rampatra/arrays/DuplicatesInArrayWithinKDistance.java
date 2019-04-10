package com.rampatra.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/18/15
 */
public class DuplicatesInArrayWithinKDistance {

    /**
     * Finds duplicates in an unsorted array {@code a} which are
     * only k distance apart from each other.
     *
     * @param a
     * @param k
     * @return
     */
    public static int[] findDuplicatesInArrayWithinKDistance(int[] a, int k) {
        int index = 0;
        int[] duplicates = new int[a.length];

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            if (hashSet.contains(a[i])) {
                duplicates[index++] = a[i];
            } else {
                hashSet.add(a[i]);
            }

            if (i >= k) {
                hashSet.remove(a[i - k]);
            }
        }

        return Arrays.copyOf(duplicates, index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDuplicatesInArrayWithinKDistance(new int[]{1, 2, 8, 1, 3, 4, 5, 6, 6, 7}, 3)));
    }
}
