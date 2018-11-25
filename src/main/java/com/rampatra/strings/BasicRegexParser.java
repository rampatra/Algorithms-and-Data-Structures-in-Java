package com.rampatra.strings;

/**
 * @author rampatra
 * @since 25/11/2018
 */
public class BasicRegexParser {

    /**
     * Implement a regular expression function isMatch that supports the '.' and '*' symbols.
     * The function receives two strings - text and pattern - and should return true if the
     * text matches the pattern as a regular expression. For simplicity, assume that the actual
     * symbols '.' and '*' do not appear in the text string and are used as special symbols only
     * in the pattern string.
     *
     * @param text
     * @param pattern
     * @return
     */
    private static boolean isMatch(String text, String pattern) {
        int textIndex = 0;
        int patternIndex = 0;

        while (textIndex < text.length()) {
            if (patternIndex >= pattern.length()) return false;

            if (pattern.charAt(patternIndex) == '.' || text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                // if the next character in the pattern is a '*' then forward the text pointer
                if (patternIndex < pattern.length() - 1 && pattern.charAt(patternIndex + 1) == '*') {
                    while (textIndex < text.length() - 1 && text.charAt(textIndex + 1) == text.charAt(textIndex)) {
                        textIndex++;
                    }
                    patternIndex++; // for the '*' in the pattern
                }
            } else if (patternIndex < pattern.length() - 1 && pattern.charAt(patternIndex + 1) == '*') { // if the text
                // and pattern are not equal at the index but the pattern has a '*' after then increment the pattern pointer
                textIndex--; // as we incrementing the text pointer outside but we should, in fact, stay at the current text index
                patternIndex++;
            } else {
                return false;
            }
            textIndex++;
            patternIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // output: false
        System.out.println(isMatch("aa", "aa")); // output: true
        System.out.println(isMatch("abc", "a.c")); // output: true
        System.out.println(isMatch("abbb", "ab*")); // output: true
        System.out.println(isMatch("acd", "ab*c.")); // output: true
        System.out.println(isMatch("abbdbb", "ab*d")); // output: false
        System.out.println(isMatch("aba", "a.a")); // output: true
        System.out.println(isMatch("acd", "ab*c.")); // output: true
        System.out.println(isMatch("abaa", "a.*a*")); // output: true
    }
}
