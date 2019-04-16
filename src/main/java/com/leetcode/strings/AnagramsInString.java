package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * @author rampatra
 * @since 2019-04-13
 */
public class AnagramsInString {

    /**
     * Time complexity: O ((n-m) * m log m)
     * where,
     * n = text length
     * m = pattern length
     *
     * @param text
     * @param pattern
     * @return
     */
    private static List<Integer> findAllAnagramsInTextNaive(String text, String pattern) {
        List<Integer> indexes = new ArrayList<>();

        int textLen = text.length();
        int patternLen = pattern.length();

        char[] patternChars = pattern.toCharArray();
        Arrays.sort(patternChars); // takes O(m log m) time
        String patternSorted = String.valueOf(patternChars);

        String subText;
        char[] subTextChars;
        String subTextSorted;

        for (int i = 0; i <= textLen - patternLen; i++) { // loops n-m number of times
            subText = text.substring(i, i + patternLen);
            subTextChars = subText.toCharArray();
            Arrays.sort(subTextChars); // sorts m number of characters, takes O(m log m)
            subTextSorted = String.valueOf(subTextChars);

            if (subTextSorted.equals(patternSorted)) { // compare m characters takes m time
                indexes.add(i);
            }
        }
        return indexes;
    }

    /**
     * Completes within <a href="https://leetcode.com/submissions/detail/222911434/">7ms on leetcode.</a>
     * Time complexity: O(n)
     * where,
     * n = length of text or number of characters in text
     *
     * @param text
     * @param pattern
     * @return
     */
    private static List<Integer> findAllAnagramsInText(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();

        int textLen = text.length();
        int patternLen = pattern.length();

        int[] textCharCountInWindow = new int[26];
        int[] patternCharCount = new int[26];

        for (int i = 0; i < patternLen; i++) {
            patternCharCount[pattern.charAt(i) - 'a']++;
        }

        for (int i = 0; i < textLen; i++) {
            textCharCountInWindow[text.charAt(i) - 'a']++;
            if (i >= patternLen) {
                textCharCountInWindow[text.charAt(i - patternLen) - 'a']--;
            }
            if (Arrays.equals(textCharCountInWindow, patternCharCount)) { // loops 26 times no matter the text/pattern length
                indices.add(i - patternLen + 1);
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        // basic use cases
        System.out.println(findAllAnagramsInTextNaive("cbaebabacd", "abc"));
        System.out.println(findAllAnagramsInTextNaive("abab", "ab"));
        System.out.println(findAllAnagramsInTextNaive("af", "af"));
        System.out.println(findAllAnagramsInTextNaive("af", "be"));

        // corner case
        System.out.println(findAllAnagramsInTextNaive("", "ab"));

        System.out.println("-----");

        // basic use cases
        System.out.println(findAllAnagramsInText("cbaebabacd", "abc"));
        System.out.println(findAllAnagramsInText("abab", "ab"));
        System.out.println(findAllAnagramsInText("af", "af"));
        System.out.println(findAllAnagramsInText("af", "be"));

        // corner case
        System.out.println(findAllAnagramsInText("", "ab"));
    }
}