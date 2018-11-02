package com.rampatra.arrays;

/**
 * Created by ramswaroop on 31/05/2016.
 */
public class CountDivisors {

    /**
     * Counts the number of integers in the range {@param begin} and
     * {@param end} that are divisible by {@param n}.
     *
     * @param begin
     * @param end
     * @param n
     * @return
     */
    public static int countDivisorsInRange(int begin, int end, int n) {
        int b = end / n + 1;  // From 0 to end the integers divisible by n
        int a = begin / n + 1;  // From 0 to begin the integers divisible by n

        if (begin % n == 0) { // "begin" is inclusive; if divisible by n then
            --a;        //   remove 1 from "a"
        }
        return b - a;     // return integers in range
    }

    public static void main(String[] a) {
        countDivisorsInRange(0, 2000000000, 5);
    }
}
