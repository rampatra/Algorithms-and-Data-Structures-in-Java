package com.rampatra.arrays;

/**
 * @author rampatra
 * @since 31/05/2016
 */
public class CountDivisors {

    /**
     * Counts the number of integers in the range {@code begin}
     * and {@code end} that are divisible by {@code n}.
     *
     * @param begin
     * @param end
     * @param n
     * @return
     */
    private static int countDivisorsInRange(int begin, int end, int n) {
        int b = end / n + 1;  // From 0 to end the integers divisible by n
        int a = begin / n + 1;  // From 0 to begin the integers divisible by n

        if (begin % n == 0) { // "begin" is inclusive; if divisible by n then
            --a;        //   remove 1 from "a"
        }
        return b - a;     // return integers in range
    }

    public static void main(String[] args) {
        System.out.println(countDivisorsInRange(0, 0, 5));
        System.out.println(countDivisorsInRange(1, 1, 5));
        System.out.println(countDivisorsInRange(0, 1, 5));
        System.out.println(countDivisorsInRange(0, 10, 5));
        System.out.println(countDivisorsInRange(0, 2000000000, 5));
    }
}