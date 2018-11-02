package rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 7/30/15
 * @time: 11:13 PM
 */
public class SmallestAndSecondSmallest {

    public static int[] getSmallestAndSecondSmallest(int[] a) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i] < secondSmallest && a[i] != smallest) { // a[i] != smallest; if numbers are repeated in array
                secondSmallest = a[i];
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static void main(String a[]) {
        System.out.println(Arrays.toString(getSmallestAndSecondSmallest(new int[]{100, 1, 60, -10, -80, 85, 70, -80})));
        System.out.println(Arrays.toString(getSmallestAndSecondSmallest(new int[]{100, 1, 60, 10, 80, 85, 70, 0})));
    }
}
