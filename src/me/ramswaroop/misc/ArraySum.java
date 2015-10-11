package me.ramswaroop.misc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 10/11/15
 * @time: 7:26 PM
 */
public class ArraySum {

    public static int doesPairExistsWithSum(int[] a, int sum) {
        Arrays.sort(a);

        int len = a.length;

        for (int i = 0, j = len - 1; i < j; ) {
            if (a[i] + a[j] == sum) {
                return 1;
            } else if (a[i] + a[j] < sum) { // approach towards larger elements
                i++;
            } else { // approach towards smaller elements
                j--;
            }
        }
        return 0;
    }

    public static void main(String a[]) {
        Scanner in = new Scanner(System.in);

        int sum = Integer.parseInt(in.nextLine());
        int length = Integer.parseInt(in.nextLine());

        int[] in_ar = new int[length];

        for (int i = 0; i < length; i++) {
            in_ar[i] = Integer.parseInt(in.nextLine());
        }

        System.out.println(doesPairExistsWithSum(in_ar, sum));
    }
}
