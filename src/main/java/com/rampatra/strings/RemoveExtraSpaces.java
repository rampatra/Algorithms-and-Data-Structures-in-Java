package com.rampatra.strings;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/25/15
 * @time: 9:44 PM
 */
public class RemoveExtraSpaces {

    /**
     * Removes extra spaces in string {@param s} without creating a
     * extra variable to hold the result, in O(n) time complexity.
     *
     * @param s
     * @return
     */
    public static String removeExtraSpaces(String s) {

        char[] c = s.toCharArray();
        int j = c.length;

        for (int i = 1; i < c.length; i++) {
            // check for two or more consecutive spaces
            if (c[i] == ' ' && c[i - 1] == ' ') {
                // if extra spaces encountered for the 1st time
                if (j == c.length) j = i;

                // skip all extra spaces
                while (i < c.length && c[i] == ' ') {
                    i++;
                }

                // if reached end of string then stop
                if (i == c.length) break;
            }

            // copy characters occurring after extra spaces to their appropriate positions
            while (i < c.length && j < c.length) {
                // stop when you encounter extra spaces again
                if (c[i] == ' ' && c[i - 1] == ' ') break;

                c[j] = c[i];
                i++;
                j++;
            }
        }

        return String.valueOf(Arrays.copyOf(c, j));
    }

    public static void main(String[] args) {
        System.out.println(removeExtraSpaces("ram swaroop is a good boy."));
        System.out.println(removeExtraSpaces("ram swaroop      is      a    good boy."));
        System.out.println(removeExtraSpaces("     ram swaroop      is      a    good boy."));
        System.out.println(removeExtraSpaces("ram swaroop      is      a    good    boy    ."));
        System.out.println(removeExtraSpaces("   ram swaroop      is      a    good boy    ."));
        System.out.println(removeExtraSpaces("    "));
        System.out.println(removeExtraSpaces(""));
        System.out.println(removeExtraSpaces(" "));
    }
}
