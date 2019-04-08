package com.rampatra.strings;

/**
 * @author rampatra
 * @since 2019-04-08
 */
public class CompressString {

    /**
     * Compress a string, consisting of only alphabets, such that the compressed string contains the letter and
     * a number next to it representing the number of times it is repeated. Also, compress only if the letter is
     * repeated more than once and ignore it occurs just once.
     * EXAMPLE:
     * Input: aaabbcdd
     * Output: a3b2cd2
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * where,
     * n is the number of characters in the input string
     *
     * @param str the input string consisting on only alphabets
     * @return the compressed string
     */
    private static String compress(String str) {
        // some basic validation
        if (str.length() == 0) {
            throw new IllegalArgumentException("Empty String");
        }
        
        StringBuilder sb = new StringBuilder();
        int letterCount = 0;

        for (int i = 0; i < str.length(); i++) {
            /*
                When the current character is a different one, append the previous character and its count to the
                result, and finally, reset the counter
             */
            if (i != 0 && str.charAt(i) != str.charAt(i - 1)) {
                sb.append(str.charAt(i - 1));
                if (letterCount > 1) sb.append(letterCount);
                letterCount = 0;
            }
            letterCount++;
        }

        // last character
        sb.append(str.charAt(str.length() - 1));
        if (letterCount > 1) sb.append(letterCount);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("a"));
        System.out.println(compress("aabbcc"));
        System.out.println(compress("aabcc"));
        System.out.println(compress("aaaabbbccaad"));
    }
}