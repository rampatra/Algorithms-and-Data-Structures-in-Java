package me.ramswaroop.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/16/15
 * @time: 10:53 PM
 */
public class ReverseAndAdd {

    public static long getReverse(long n) {
        return Long.valueOf(new StringBuilder().append(n).reverse().toString());
    }

    public static boolean isPalindrome(long n) {
        return n == getReverse(n);
    }

    public static boolean isNegative(long n) {
        return n < 0;
    }

    public static long[] reverseAddAndCheck(String n) {
        long additions = 1;
        long original = Long.valueOf(n);

        boolean isNegative = isNegative(original);
        if (isNegative) original = -original;

        long reverse;

        while (!isPalindrome(original + (reverse = getReverse(original)))) {
            original += reverse;
            additions++;
        }

        original += reverse;
        if (isNegative) original = -original;

        return new long[]{additions, original};
    }

    public static void readFile(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                long[] result = reverseAddAndCheck(line);
                System.out.println(result[0] + " " + result[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String a[]) {
        readFile(a[0]);
        System.exit(0);
    }
}
