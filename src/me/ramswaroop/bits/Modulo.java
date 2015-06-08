package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/8/15
 * @time: 11:28 PM
 */
public class Modulo {

    public static int getNmoduloD(int n, int d) {
        return n & (d - 1);
    }

    public static void main(String a[]) {
        System.out.println(getNmoduloD(18, 8));
        System.out.println(getNmoduloD(18, 4));
        System.out.println(getNmoduloD(13, 4));
        System.out.println(getNmoduloD(13, 1));
        System.out.println(getNmoduloD(2, 2));
        System.out.println(getNmoduloD(13, 16));
    }
}

/**
 * For example,
 *
 * 18 = 10010
 *  8 = 01000
 *  2 = 00010 (remainder = 18 & (8-1))
 */
