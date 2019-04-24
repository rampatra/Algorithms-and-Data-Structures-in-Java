package com.leetcode.strings;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/ransom-note/
 *
 * @author rampatra
 * @since 2019-04-19
 */
public class RansomNote {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/223597898/">4 ms/a>.
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] charCount = new char[26];

        for (int i = 0; i < magazine.length(); i++) {
            charCount[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (charCount[ransomNote.charAt(i) - 'a']-- == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("", ""));
        System.out.println(canConstruct("a", "a"));
        System.out.println(canConstruct("ab", "ab"));
        System.out.println(canConstruct("aab", "ab"));
    }
}