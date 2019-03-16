package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/4/15
 * @time: 4:28 PM
 */
public class IntegerOverflow {

    /**
     * Adds {@param a} and {@param b} and if the result can't
     * be stored as an integer it throws an exception
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) throws Exception {

        if (a > Integer.MAX_VALUE - b) {
            throw new Exception("Integer Overflow");
        } else {
            return a + b;
        }
    }

    /**
     * Adds {@param a} and {@param b} and if the result can't
     * be stored as an integer it throws an exception
     *
     * @param a
     * @param b
     * @return
     */
    public static int add_V1(int a, int b) throws Exception {

        if ((a > 0 && b > 0 && a + b < 0) || (a < 0 && b < 0 && a + b > 0)) {
            throw new Exception("Integer Overflow");
        } else {
            return a + b;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(add(2, 3));
            System.out.println(add(2147483647, 999999999));
            System.out.println(add(-2147483647, -999999999));
            System.out.println(add_V1(2, 3));
            System.out.println(add_V1(2147483647, 999999999));
            System.out.println(add_V1(-2147483647, -999999999));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
