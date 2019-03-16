package com.hackerrank.bitmanipulation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/24/15
 * @time: 12:03 PM
 */
public class CounterGame {

    public static boolean isPowerOf2(BigInteger n) {
        return !n.equals(BigInteger.ZERO) && (n.and(n.subtract(BigInteger.ONE))).equals(BigInteger.ZERO);
    }

    public static BigInteger nextLowerPowerOf2(BigInteger n) {
        BigInteger p = BigInteger.ONE;
        while (p.compareTo(n) == -1) {
            p = p.shiftLeft(1);
        }
        return (n.compareTo(BigInteger.ONE) == 1) ? p.shiftRight(1) : n; // check for n = 0 or 1;
    }

    public static String computeWinner(BigInteger n) {
        boolean louiseTurn = true;
        while (!n.equals(BigInteger.ONE)) {
            if (isPowerOf2(n)) {
                n = n.shiftRight(1);
            } else {
                n = n.subtract(nextLowerPowerOf2(n));
            }
            louiseTurn = !louiseTurn;
        }
        return (louiseTurn) ? "Richard" : "Louise";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        BigInteger[] in_ar = new BigInteger[t];

        for (int i = 0; i < t; i++) {
            in_ar[i] = in.nextBigInteger();
        }

        for (BigInteger i : in_ar) {
            System.out.println(computeWinner(i));
        }
    }
}
