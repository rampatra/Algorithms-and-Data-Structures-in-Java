package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/2/15
 * @time: 5:08 PM
 */
public class NextPowerOf2 {

    /**
     * Finds the left most set bit position and returns
     * 2 to the power of that position plus 1.
     *
     * @param n
     * @return
     */
    public static long nextPowerOf2(long n) {
        if (PowerOf2.isPowerOf2(n)) {
            return n;
        }

        int c = 0;
        for (int i = 0; i < 64; i++) {
            if ((n & 1) == 1) {
                c = i;
            }
            n >>= 1;
        }

        return (c == 0) ? 1 : (long) Math.pow(2, (c + 1)); // check added for input 0
    }

    public static void main(String a[]) {
        System.out.println(nextPowerOf2(2));
        System.out.println(nextPowerOf2(3));
        System.out.println(nextPowerOf2(18));
        System.out.println(nextPowerOf2(6));
        System.out.println(nextPowerOf2(7));
        System.out.println(nextPowerOf2(1));
        System.out.println(nextPowerOf2(0));
    }
}
