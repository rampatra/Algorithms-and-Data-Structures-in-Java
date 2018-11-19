package com.ctci.arraysandstrings;

/**
 * @author rampatra
 * @since 19/11/2018
 */
public class URLify {

    /**
     * We space encode the string such that all spaces in the string are replaced with '%20'. The string {@code str}
     * contains extra spaces to accommodate the extra characters.
     *
     * @param str string with spaces
     * @return string with spaces replaced with %20
     */
    private static String urlify(String str) {
        char[] chars = str.toCharArray();
        int curr = chars.length - 1; // we will start backwards so that we don't have to worry about characters we overwrite
        int insertIndex = curr;

        // move the curr pointer to the last character which isn't a space
        while (chars[curr] == 32) {
            curr--;
        }

        while (curr >= 0) {
            if (chars[curr] == 32) {
                chars[insertIndex--] = '0';
                chars[insertIndex--] = '2';
                chars[insertIndex--] = '%';
            } else {
                chars[insertIndex--] = chars[curr];
            }
            curr--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith    "));
        System.out.println(urlify("Mr  Ram Patra      "));
    }
}
