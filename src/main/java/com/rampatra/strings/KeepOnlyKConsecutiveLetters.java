package com.rampatra.strings;

/**
 * @author rampatra
 * @since 30/11/2018
 */
public class KeepOnlyKConsecutiveLetters {

    /**
     * A method which takes a string {@code str} and a number {@code k} and
     * returns a string with at most {@code k} consecutive characters in the
     * string.
     * <p>
     * For example,
     * 1) aaaaaabbbbbccccc, 3 -> aaabbbccc
     * 2) abc, 2 -> abc
     * 3) aabbccc, 3 -> aabbccc
     *
     * @param str input string
     * @param k
     * @return
     */
    private static String keepOnlyKConsecutiveLetters(String str, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            for (int j = 0; i + j < str.length() && j < k; j++) {
                char ch2 = str.charAt(i + j);
                if (ch2 == ch) {
                    sb.append(ch2);
                } else {
                    break;
                }
            }

            while (i + 1 < str.length() && str.charAt(i + 1) == str.charAt(i)) {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("aaaaabbbbbccccc, 5: " + keepOnlyKConsecutiveLetters("aaaaabbbbbccccc", 5));
        System.out.println("aaaaabbbbbccccc, 2: " + keepOnlyKConsecutiveLetters("aaaaabbbbbccccc", 2));
        System.out.println("aaaaabbbbbccccc, 1: " + keepOnlyKConsecutiveLetters("aaaaabbbbbccccc", 1));
        System.out.println("aabbcc, 2: " + keepOnlyKConsecutiveLetters("aabbcc", 2));
        System.out.println("aabbcc, 0: " + keepOnlyKConsecutiveLetters("aabbcc", 0));
        System.out.println("abc, 2: " + keepOnlyKConsecutiveLetters("abc", 2));
    }
}