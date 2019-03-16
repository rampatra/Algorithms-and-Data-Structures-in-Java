package com.rampatra.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/16/15
 * @time: 10:53 PM
 */
public class ReverseAndAdd {

    /**
     * Reverses the number {@param n}.
     *
     * @param n
     * @return the reverse of the number {@param n}.
     */
    public static BigInteger getReverse(BigInteger n) {
        return new BigInteger(new StringBuilder().append(n).reverse().toString());
    }

    /**
     * Checks if {@param n} is palindrome.
     *
     * @param n
     * @return {@code true} if {@param n} is palindrome.
     */
    public static boolean isPalindrome(BigInteger n) {
        return n.compareTo(getReverse(n)) == 0;
    }

    /**
     * Checks if {@param n} is negative.
     *
     * @param n
     * @return {@code true} if {@param n} is negative, {@code false} otherwise.
     */
    public static boolean isNegative(BigInteger n) {
        return n.compareTo(new BigInteger("0")) == -1;
    }

    /**
     * Reverses the number {@param n}, adds to itself and then checks
     * for palindrome.
     *
     * @param n
     * @return an array of {@code BigInteger} with number of additions and final palindrome number respectively.
     */
    public static BigInteger[] reverseAddAndCheck(String n) {
        BigInteger additions = new BigInteger("1");
        BigInteger original = new BigInteger(n);

        boolean isNegative = isNegative(original);
        if (isNegative) original = original.multiply(new BigInteger("-1"));

        BigInteger reverse;

        while (!isPalindrome(original.add(reverse = getReverse(original)))) {
            original = original.add(reverse);
            additions = additions.add(new BigInteger("1"));
        }

        original = original.add(reverse);
        if (isNegative) original = original.multiply(new BigInteger("-1"));

        return new BigInteger[]{additions, original};
    }

    /**
     * Reads the input file mentioned in {@param filePath} line by line
     * and calls {@code reverseAddAndCheck()} for every line.
     *
     * @param filePath
     */
    public static void readFile(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                BigInteger[] result = reverseAddAndCheck(line);
                System.out.println(result[0] + " " + result[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starting point of the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        readFile(args[0]);
        System.exit(0);
    }
}
