package com.hackerrank.algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by rampatra on 29/05/2016.
 */
public class ExtraLongFactorials {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger res = BigInteger.ONE;
        for (int i = n; i > 0; i--) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        System.out.println(res);
    }
}
