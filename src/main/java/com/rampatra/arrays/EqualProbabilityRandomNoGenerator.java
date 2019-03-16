package com.rampatra.arrays;

import java.util.Random;
import java.util.Scanner;

/**
 * Given a random number generator f(n) which generates a random number
 * from {@code 0} (inclusive) to {@code n} (exclusive), design a method
 * which uses f(n) to generate non repeating random numbers from
 * {@code 0} (inclusive) to {@code n} (exclusive)?
 *
 * @author rampatra
 * @since 8/13/15
 * @time: 1:41 PM
 */
public class EqualProbabilityRandomNoGenerator {

    static int[] bucket;
    static int size;

    /**
     * The algorithm is to create a bucket of numbers and then to keep on
     * removing the elements from the bucket which are returned.
     *
     * @return
     */
    public static int getRandom() {
        int random = f(size--);
        int result = bucket[random];
        bucket[random] = bucket[size];
        return result;
    }

    public static int f(int n) {
        return new Random().nextInt(n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many random numbers you would like to generate?");
        size = in.nextInt();

        bucket = new int[size];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = i;
        }
        for (int i = 0; i < bucket.length; i++) {
            System.out.println(getRandom());
        }
    }
}
