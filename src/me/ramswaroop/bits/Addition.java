package me.ramswaroop.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/10/15
 * @time: 12:55 PM
 */
public class Addition {

    /**
     * Best method.
     * <p/>
     * -n = ~n + 1.
     * ~n = -(n+1). Therefore, n+1 = -(~n).
     * <p/>
     * Works for -ve numbers.
     * <p/>
     * Note: This method works only if the numbers
     * are stored in 2’s complement form.
     *
     * @param n
     * @return
     */
    public static int add1(int n) {
        return -(~n);
    }

    /**
     * Idea is to flip all the bits of {@param n} till
     * rightmost 0 bit in {@param n}.
     * <p/>
     * Doesn't work for -ve numbers.
     *
     * @param n
     * @return
     */
    public static int add1_V1(int n) {
        int mask = 1;
        // flip all bits in n until rightmost 0 bit
        while ((n & mask) != 0) {
            n ^= mask;
            mask <<= 1;
        }
        // flip the rightmost 0 bit
        return n ^ mask;
    }

    public static void main(String a[]) {
        System.out.println(add1_V1(0));
        System.out.println(add1_V1(1));
        System.out.println(add1_V1(2));
        System.out.println(add1_V1(3));
        System.out.println(add1_V1(4));
        System.out.println(add1_V1(5));
        System.out.println(add1_V1(7));
        System.out.println("------");
        System.out.println(add1(1));
        System.out.println(add1(5));
        System.out.println(add1(-0));
        System.out.println(add1(-5));
    }
}
