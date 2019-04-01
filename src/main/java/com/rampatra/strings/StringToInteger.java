package com.rampatra.strings;

/**
 * @author rampatra
 * @since 2019-04-01
 */
public class StringToInteger {

    /**
     * This method converts a {@code String} to an {@code int}. It assumes the {@code string} contains ASCII
     * characters only.
     *
     * @param str the input string, for example, 0, 123, +123, -123, etc.
     * @return the equivalent integer.
     */
    private static int getIntegerFromString(String str) {
        int number = 0;
        int digit;
        char ch;
        int weight = 0;
        boolean isNegative = false;

        // remove all leading and trailing whitespaces
        str = str.trim();
        if (str.length() == 0) {
            throw new NumberFormatException("Empty string");
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            if (ch == '-' && i == 0) {
                isNegative = true;
                continue;
            } else if (ch == '+' && i == 0) {
                continue;
            }

            digit = ch - '0';

            if (digit < 0 || digit > 9) {
                throw new NumberFormatException("Invalid characters");
            }

            number += digit * (Math.pow(10, weight++));
        }
        return isNegative ? -number : number;
    }

    public static void main(String[] args) {
        // normal cases
        System.out.println(getIntegerFromString("0"));
        System.out.println(getIntegerFromString("123"));
        System.out.println(getIntegerFromString("0123"));
        System.out.println(getIntegerFromString("+123"));
        System.out.println(getIntegerFromString("-123"));

        // error cases
        System.out.println(getIntegerFromString("1-23"));
        System.out.println(getIntegerFromString(""));
        System.out.println(getIntegerFromString(" "));
        System.out.println(getIntegerFromString("  "));
        System.out.println(getIntegerFromString("123L"));
    }
}