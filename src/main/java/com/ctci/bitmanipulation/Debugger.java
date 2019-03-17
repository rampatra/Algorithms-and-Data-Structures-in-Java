package com.ctci.bitmanipulation;

/**
 * @author rampatra
 * @since 2019-03-17
 */
public class Debugger {

    /**
     * If after un-setting the least significant bit in n, it becomes 0 then it implies that it has only set bit. This
     * can also imply that n is a power of 2.
     *
     * @param n input integer
     * @return {@code true} if n has only set bit, {@code false} otherwise.
     */
    private static boolean hasOneSetBit(int n) {
        // edge case
        if (n == 0) {
            return false;
        }
        return (n & (n - 1)) == 0; // (n & (n - 1)) un-sets the least significant bit    
    }

    public static void main(String[] args) {
        System.out.println(hasOneSetBit(0));
        System.out.println(hasOneSetBit(2));
        System.out.println(hasOneSetBit(16));
        System.out.println(hasOneSetBit(10));
    }
}
