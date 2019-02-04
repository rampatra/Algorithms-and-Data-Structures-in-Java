package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 2/28/15
 * Time: 12:41 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class FlippingBits {

    static long flipBits(long i) {
        return i ^ 4294967295l;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        long[] in_ar = new long[t];

        for (int i = 0; i < t; i++) {
            in_ar[i] = in.nextLong();
        }

        for (long i : in_ar) {
            System.out.println(flipBits(i));
        }
    }
}
