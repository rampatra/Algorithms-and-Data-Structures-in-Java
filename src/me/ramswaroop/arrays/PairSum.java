package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 5/18/15
 * @time: 10:24 PM
 */

import java.util.Arrays;

/**
 * Given an array ar[] of n numbers and
 * another number x, determine whether or not there
 * exists two elements in ar[] whose sum is exactly x.
 */
public class PairSum {

    static boolean pairSum(int ar[], int x) {
        Arrays.sort(ar);

        int len = ar.length;

        for (int i = 0, j = len - 1; i < j; ) {
            if (ar[i] + ar[j] == x) {
                return true;
            } else if (ar[i] + ar[j] < x) { // approach towards larger elements
                i++;
            } else { // approach towards smaller elements
                j--;
            }
        }

        return false;
    }

    public static void main(String a[]) {
        System.out.print(pairSum(new int[]{3, 4, 6, 1, 1}, 9));
    }
}
