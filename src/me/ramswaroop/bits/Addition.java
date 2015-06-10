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
     * Idea is to flip all the bits of {@param n} till
     * rightmost 0 bit in {@param n}.
     *
     * @param n
     * @return
     */
    public static int add1(int n) {
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
        System.out.println(add1(0));
        System.out.println(add1(1));
        System.out.println(add1(2));
        System.out.println(add1(3));
        System.out.println(add1(4));
        System.out.println(add1(5));
        System.out.println(add1(7));
    }
}
