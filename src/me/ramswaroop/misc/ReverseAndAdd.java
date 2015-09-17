package me.ramswaroop.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/16/15
 * @time: 10:53 PM
 */
public class ReverseAndAdd {

    public static BigInteger getReverse(BigInteger n) {
        return new BigInteger(new StringBuilder().append(n).reverse().toString());
    }

    public static boolean isPalindrome(BigInteger n) {
        return n.compareTo(getReverse(n)) == 0;
    }

    public static boolean isNegative(BigInteger n) {
        return n.compareTo(new BigInteger("0")) == -1;
    }

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

    public static void readFile(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                BigInteger[] result = reverseAddAndCheck(line);
                System.out.println(result[0].toString() + " " + result[1].toString());
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
