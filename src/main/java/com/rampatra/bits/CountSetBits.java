package com.rampatra.bits;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 4/4/15
 * Time: 8:52 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class CountSetBits {

    /**
     * Unoptimized version. Works for -ve numbers as well.
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
     * Optimized version. Works for -ve numbers as well.
     * <p>
     * Uses BRIAN KERNIGAN'S bit counting. Acc. to this, the  right most/least significant set bit is unset
     * in each iteration. The time complexity is proportional to the number of bits set.
     *
     * @param n
     * @return
     * @link http://stackoverflow.com/questions/12380478/bits-counting-algorithm-brian-kernighan-in-an-integer-time-complexity
     * @link http://graphics.stanford.edu/~seander/bithacks.html#ParityNaive
     */
    static int countSetBits(long n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1; // right most set bit in n is unset
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = Long.parseLong(in.nextLine());
        System.out.println(countSetBits(n));
        System.out.println(Integer.toBinaryString((int) -n));
        System.out.println(countSetBits((int) -n));


    }
}

/**
 * Learn more:
 * http://javarevisited.blogspot.in/2014/06/how-to-count-number-of-set-bits-or-1s.html
 */