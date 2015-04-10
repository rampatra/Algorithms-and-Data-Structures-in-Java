package me.ramswaroop.bits;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/4/15
 * Time: 8:52 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class CountSetBits {

    /**
     * Unoptimized version
     *
     * @param number
     * @return
     */
    static int countSetBits(int number) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((number & 1) == 1) {
                count++;
            }
            number = number >>> 1;
        }
        return count;
    }

    /**
     * Optimized version
     *
     * @param n
     * @return
     */
    static int countSetBits(long n) {
        int count = 0;
        while (n > 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] a) {
        Scanner in = new Scanner(System.in);

        long n = Long.parseLong(in.nextLine());
        System.out.println(countSetBits(n));
    }
}

/**
 *
 * Learn more:
 * http://javarevisited.blogspot.in/2014/06/how-to-count-number-of-set-bits-or-1s.html
 *
 */