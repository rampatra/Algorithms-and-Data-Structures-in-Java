package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/10/15
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
    public static int add(int n) {
        return -(~n);
    }

    /**
     * Good solution.
     * <p/>
     * Adds two numbers without using any
     * arithmetic operators.
     *
     * @param x
     * @param y
     * @return sum of {@param x} and {@param y}
     */
    public static int add(int x, int y) {
        int carry;
        while (y != 0) {
            carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }

    /**
     * Naive approach.
     * <p/>
     * Adds two numbers without using any
     * arithmetic operators.
     *
     * @param x
     * @param y
     * @return sum of {@param x} and {@param y}
     */
    public static int addNaive(int x, int y) {
        int carry = 0, sum = 0, c = 0, xLSB, yLSB;
        while (c < 32) {
            xLSB = x & 1;
            yLSB = y & 1;
            sum |= (xLSB ^ yLSB ^ carry) << c;
            if ((xLSB & yLSB) == 1 || (xLSB & carry) == 1 || (yLSB & carry) == 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            x >>= 1;
            y >>= 1;
            c++;
        }
        return sum;
    }

    /**
     * Idea is to flip all the bits of {@param n} till
     * rightmost 0 bit (inclusive).
     * <p/>
     * Doesn't work for -ve numbers.
     *
     * @param n
     * @return
     */
    public static int addByFlip(int n) {
        int mask = 1;
        // flip all bits in n until rightmost 0 bit
        while ((n & mask) != 0) {
            n ^= mask;
            mask <<= 1;
        }
        // flip the rightmost 0 bit
        return n ^ mask;
    }

    public static void main(String[] args) {
        System.out.println(add(0, 0)); //0
        System.out.println(add(12, 12)); //24
        System.out.println(add(12, 5)); //17
        System.out.println(add(3, 5)); //8
        System.out.println(add(8, 5)); //13
        System.out.println(add(13, 256)); // 269
        System.out.println(add(456, 982348234)); // 982348690
        System.out.println(add(1, 0xffffffff)); // 0
        System.out.println("------");
        System.out.println(addNaive(0, 0)); //0
        System.out.println(addNaive(12, 12)); //24
        System.out.println(addNaive(12, 5)); //17
        System.out.println(addNaive(3, 5)); //8
        System.out.println(addNaive(8, 5)); //13
        System.out.println(addNaive(13, 256)); // 269
        System.out.println(addNaive(456, 982348234)); // 982348690
        System.out.println(addNaive(1, 0xffffffff)); // 0
        System.out.println("------");
        System.out.println(addByFlip(0));
        System.out.println(addByFlip(1));
        System.out.println(addByFlip(2));
        System.out.println(addByFlip(3));
        System.out.println(addByFlip(4));
        System.out.println(addByFlip(5));
        System.out.println(addByFlip(7));
        System.out.println("------");
        System.out.println(add(1));
        System.out.println(add(5));
        System.out.println(add(-0));
        System.out.println(add(-5));
    }
}
