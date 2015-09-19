package me.ramswaroop.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/19/15
 * @time: 11:33 PM
 */
public class CountSmallerElementsOnRHS {

    public static int[] getSmallerElementsCountOnRHSNaive(int[] a) {
        int[] result = new int[a.length];
        int i, j, temp;
        for (i = a.length - 2; i >= 0; i--) {
            for (j = i + 1; a[i] < a[j]; j++) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            result[i] = j - i;
        }
        return result;
    }

    public static void main(String a[]) {
        System.out.println(Arrays.toString(getSmallerElementsCountOnRHSNaive(new int[]{12, 1, 2, 3, 0, 11, 4})));
    }
}
