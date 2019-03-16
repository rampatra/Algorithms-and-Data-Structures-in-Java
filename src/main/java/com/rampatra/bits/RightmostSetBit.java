package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/3/15
 * @time: 11:56 PM
 */
public class RightmostSetBit {

    /**
     * Returns the position of the rightmost set bit
     * in {@param n} where the position starts from 1.
     * <p/>
     * Works for -ve no.s as well.
     *
     * @param n
     * @return
     */
    public static int getRightmostSetBitPosition(long n) {
        int position = 0;
        while (n != 0) {
            position++;
            if ((n & 1) == 1) {
                break;
            }
            n >>= 1;
        }
        return position;
    }

    public static long unsetRightmostSetBit(long n) {
        return n & (n - 1); // brian kerningham's algorithm
    }

    public static void main(String[] args) {
        System.out.println(getRightmostSetBitPosition(0));
        System.out.println(getRightmostSetBitPosition(1));
        System.out.println(getRightmostSetBitPosition(2));
        System.out.println(getRightmostSetBitPosition(5));
        System.out.println(getRightmostSetBitPosition(18));
        System.out.println(getRightmostSetBitPosition(19));
        System.out.println(getRightmostSetBitPosition(-1));
        System.out.println(getRightmostSetBitPosition(-2));
        System.out.println(getRightmostSetBitPosition(-4));

        System.out.println("========================");

        System.out.println(unsetRightmostSetBit(0));
        System.out.println(unsetRightmostSetBit(2));
        System.out.println(unsetRightmostSetBit(12));
        System.out.println(unsetRightmostSetBit(16));
        System.out.println(unsetRightmostSetBit(18));
        System.out.println(unsetRightmostSetBit(-1));
    }
}
