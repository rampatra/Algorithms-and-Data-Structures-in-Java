package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/12/15
 * @time: 6:18 PM
 */
public class SmallestOf3Integers {

    /**
     * Returns min of 2 numbers without using
     * any comparison operators.
     *
     * @param x
     * @param y
     * @return
     */
    private static int min(int x, int y) {
        return y + ((x - y) & ((x - y) >> 31));
    }

    /**
     * Returns the smallest element in an
     * array of length 3.
     *
     * @param a
     * @return
     */
    public static int getSmallest(int a[]) {
        return min(a[0], min(a[1], a[2]));
    }

    /**
     * This method uses repeated subtraction to
     * find the smallest element in an array.
     *
     * @param a
     * @return
     */
    public static int getSmallest_V1(int a[]) {
        int c = 0;
        while (a[0] > 0 && a[1] > 0 && a[2] > 0) {
            a[0]--;
            a[1]--;
            a[2]--;
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(getSmallest(new int[]{4, 5, 6}));
        System.out.println(getSmallest_V1(new int[]{4, 5, 6}));
    }
}
