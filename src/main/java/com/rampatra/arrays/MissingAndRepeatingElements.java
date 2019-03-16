package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/7/15
 * @time: 10:54 AM
 */
public class MissingAndRepeatingElements {

    /**
     * Finds two numbers in an unsorted array of size n with elements in range from
     * 1 to n where one number from set {1, 2, …n} is missing and one number occurs
     * twice in array.
     *
     * @param a
     * @return an array where 1st element is the repeating element and 2nd is the missing one
     */
    public static int[] findMissingAndRepeatingElements(int[] a) {
        int[] result = new int[2];
        for (int i = 0; i < a.length; i++) {
            // we use indices to mark already encountered numbers
            if (a[Math.abs(a[i]) - 1] < 0) {
                result[0] = Math.abs(a[i]); // repeating element
            } else {
                a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
            }
        }
        // no. is +ve means its index wasn't encountered
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                result[1] = i + 1; // missing element
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingAndRepeatingElements(new int[]{3, 1, 3})));
        System.out.println(Arrays.toString(findMissingAndRepeatingElements(new int[]{4, 3, 6, 2, 1, 1})));
        System.out.println(Arrays.toString(findMissingAndRepeatingElements(new int[]{4, 4, 6, 2, 5, 1})));
    }
}
