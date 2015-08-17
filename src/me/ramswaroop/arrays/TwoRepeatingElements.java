package me.ramswaroop.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 8/17/15
 * @time: 7:23 PM
 */
public class TwoRepeatingElements {

    public static int[] getTwoRepeatingElements(int[] a) {
        int xor = a[0];
        int rightMostSetBit;
        int x = 0, y = 0;
        
        for (int i = 1; i < a.length; i++) {
            xor ^= a[i];
        }
        for (int i = 1; i <= a.length - 2; i++) {
            xor ^= i;
        }
        rightMostSetBit = xor & ~(xor - 1);

        for (int i = 0; i < a.length; i++) {
            if ((a[i] & rightMostSetBit) == 0) {
                x ^= a[i];
            } else {
                y ^= a[i];
            }
        }

        for (int i = 1; i <= a.length - 2; i++) {
            if ((i & rightMostSetBit) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        return new int[]{x, y};
    }

    public static void main(String a[]) {
        System.out.println(Arrays.toString(getTwoRepeatingElements(new int[]{4, 2, 4, 5, 2, 3, 1})));
    }
}
