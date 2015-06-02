package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/2/15
 * @time: 12:18 PM
 */
public class PowerOf2 {

    /**
     * Power of 2 no. always has only one set bit.
     *
     * @param n
     * @return
     */
    public static boolean isPowerOf2ByCountingSetBits(long n) {
        return CountSetBits.countSetBits(n) == 1;
    }

    /**
     * AND operation of power of 2 no.s and the no. minus 1 is always 0.
     * ex: 100 & 011 is 000
     *
     * @param n
     * @return
     */
    public static boolean isPowerOf2(long n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String a[]) {
        System.out.println(isPowerOf2ByCountingSetBits(18));
        System.out.println(isPowerOf2(18));

        System.out.println(isPowerOf2ByCountingSetBits(16));
        System.out.println(isPowerOf2(16));
    }
}
