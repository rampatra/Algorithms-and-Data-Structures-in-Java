package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/2/15
 * @time: 5:08 PM
 */
public class NextPowerOf2 {

    /**
     * Returns a power of 2 number which is larger
     * than {@param n} but if {@param n} is already
     * a power of 2 then it simply returns it.
     * <p/>
     * Left shifts 1 number of times equal to the
     * leftmost set bit position in n.
     *
     * @param n
     * @return
     */
    public static long nextHigherPowerOf2(long n) {
        // if n is already a power of 2 then return n
        if (n != 0 && ((n & (n - 1)) == 0)) return n;

        long p = 1;
        while (p < n) {
            p <<= 1;
        }
        return p;
    }

    /**
     * Returns a power of 2 number which is larger
     * than {@param n} but if {@param n} is already
     * a power of 2 then it simply returns it.
     * <p/>
     * Finds the leftmost set bit position and
     * left shifts 1 that many times.
     *
     * @param n
     * @return
     */
    public static long nextHigherPowerOf2_V2(long n) {
        // if n is already a power of 2 then return n
        if (n != 0 && ((n & (n - 1)) == 0)) return n;

        long c = 0;
        // finds the position of the leftmost set bit
        while (n > 0) {
            n >>= 1;
            c++;
        }

        return 1 << c;
    }

    /**
     * Returns a power of 2 number which is larger
     * than {@param n} but if {@param n} is already
     * a power of 2 then it simply returns it.
     * <p/>
     * Finds the leftmost set bit position and
     * left shifts 1 that many times.
     *
     * @param n
     * @return
     */
    public static long nextHigherPowerOf2_V1(long n) {
        if (PowerOf2.isPowerOf2(n)) {
            return n;
        }

        int c = 0;
        // finds the position of leftmost set bit
        for (int i = 1; i <= 64; i++) {
            if ((n & 1) == 1) {
                c = i;
            }
            n >>= 1;
        }

        return 1 << c;
    }


    /**
     * Returns a power of 2 number which is smaller
     * than {@param n}.
     *
     * @param n
     * @return
     */
    public static long nextLowerPowerOf2(long n) {
        long p = 1;
        while (p < n) {
            p <<= 1;
        }
        return (n > 1) ? p >> 1 : n; // check for n = 0 or 1;
    }

    public static void main(String[] args) {

        System.out.println(nextHigherPowerOf2(2));
        System.out.println(nextHigherPowerOf2(3));
        System.out.println(nextHigherPowerOf2(18));
        System.out.println(nextHigherPowerOf2(6));
        System.out.println(nextHigherPowerOf2(7));
        System.out.println(nextHigherPowerOf2(1));
        System.out.println(nextHigherPowerOf2(0));

        System.out.println("=================");

        System.out.println(nextHigherPowerOf2_V2(2));
        System.out.println(nextHigherPowerOf2_V2(3));
        System.out.println(nextHigherPowerOf2_V2(18));
        System.out.println(nextHigherPowerOf2_V2(6));
        System.out.println(nextHigherPowerOf2_V2(7));
        System.out.println(nextHigherPowerOf2_V2(1));
        System.out.println(nextHigherPowerOf2_V2(0));

        System.out.println("=================");

        System.out.println(nextHigherPowerOf2_V1(2));
        System.out.println(nextHigherPowerOf2_V1(3));
        System.out.println(nextHigherPowerOf2_V1(18));
        System.out.println(nextHigherPowerOf2_V1(6));
        System.out.println(nextHigherPowerOf2_V1(7));
        System.out.println(nextHigherPowerOf2_V1(1));
        System.out.println(nextHigherPowerOf2_V1(0));

        System.out.println("=================");

        System.out.println(nextLowerPowerOf2(2));
        System.out.println(nextLowerPowerOf2(3));
        System.out.println(nextLowerPowerOf2(18));
        System.out.println(nextLowerPowerOf2(6));
        System.out.println(nextLowerPowerOf2(7));
        System.out.println(nextLowerPowerOf2(1));
        System.out.println(nextLowerPowerOf2(0));
    }
}
