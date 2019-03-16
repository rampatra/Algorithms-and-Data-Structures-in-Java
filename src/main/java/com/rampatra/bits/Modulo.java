package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/8/15
 * @time: 11:28 PM
 */
public class Modulo {

    /**
     * Returns {@param n} modulo {@param d} provided
     * {@param d} is a power of 2.
     *
     * @param n
     * @param d
     * @return
     */
    public static int getNmoduloD(int n, int d) {
        return n & (d - 1);
    }

    public static void main(String[] args) {
        System.out.println(getNmoduloD(18, 8));
        System.out.println(getNmoduloD(18, 4));
        System.out.println(getNmoduloD(13, 4));
        System.out.println(getNmoduloD(13, 1));
        System.out.println(getNmoduloD(2, 2));
        System.out.println(getNmoduloD(13, 16));
    }
}

/**
 * Consider example, for 18 % 8
 * <p>
 * 18 = 10010
 * 7 = 00111 (8 = 2 ^ 3, therefore mask has to have three 1's)
 * 2 = 00010 (remainder = 18 & (8-1))
 */
