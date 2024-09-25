package com.leetcode.strings;

/**
 * Level: Easy
 * Problem: https://leetcode.com/problems/longest-common-prefix/
 *
 * @author rampatra
 * @since 2019-04-20
 */
public class LongestCommonPrefix {

    /**
     * Time complexity: O(r * c)
     * where,
     * r = no. of strings
     * c = max. no. of characters in a particular string
     * <p>
     * Runtime: <a href="https://leetcode.com/submissions/detail/223737988/">1 ms</a>.
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int row;
        for (int col = 0; col < strs[0].length(); col++) {
            for (row = 0; row < strs.length - 1; row++) {
                // once we find a different character under one column, return the characters read so far
                if (col == strs[row].length()
                        || col == strs[row + 1].length()
                        || strs[row].charAt(col) != strs[row + 1].charAt(col)) {
                    return strs[row].substring(0, col);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        assertEquals("", longestCommonPrefix(new String[]{""}));
        assertEquals("a", longestCommonPrefix(new String[]{"a"}));
        assertEquals("abcd", longestCommonPrefix(new String[]{"abcdefg", "abcdgfe", "abcdsafa", "abcdewfad",
        "abcdacx", "abcdplp", "abcddmm", "abcdmms", "abcdsafa", "abcdwczsace", "abcdwfacesd", "abcdqwrq",
        "abcdeas", "abcdascadsa", "abcdqsxz", "abcdbc", "abcdavs", "abcdpmsadsa", "abcdsaca", "abcdbww",
        "abcdwqsax", "abcdasfe", "abcdaer"}));
        assertEquals("abcdefghijklmnopqrstuvwxyz",
        longestCommonPrefix(new String[]{
        "abcdefghijklmnopqrstuvwxyzafwfafaafqfwafafadafeaaffadacesgrbrfseesfegwafeagewzfafafsa",
        "abcdefghijklmnopqrstuvwxyzwasfdafsaawfdwafagafagagsgfsafsgdsdfdafafsafafadafaf"}));
        assertEquals("abcdefghijklmnopqrstuvwxyz",
        longestCommonPrefix(new String[]{
        "abcdefghijklmnopqrstuvwxyzplkmpknoknoknokndacesgrbrfseesfegwafeagewzfafafsa",
        "abcdefghijklmnopqrstuvwxyzlnokkjkjboknoknaffadacesgrbrfseesfegwafeagewzfafafsa",
        "abcdefghijklmnopqrstuvwxyznbkmbkkbkjoknonaaffadacesgrbrfseesfegwafeagewzfafafsa",
        "abcdefghijklmnopqrstuvwxyzpoinjnoonjnonooboaacesgrbrfseesfegwafeagewzfafafsa",
        "abcdefghijklmnopqrstuvwxyzfghdfsgsgdfhtdjdgsdfjdfhdsgdshdhdegwafeagewzfafafsa",
        "abcdefghijklmnopqrstuvwxyzthssfgegwgwgwfwfsfdsfdsfwfwfdfwfwfwfwfwfegwafeagewzfafafsa",
        "abcdefghijklmnopqrstuvwxyzrwgwwgegeggwgwfwfsfdsfdsfwfwfdfwfwfwfwfwfegwafeagewzfafafsa",
        "abcdefghijklmnopqrstuvwxyzrwgwwgegeggonaanfnfafnaffdfwfwfwfwfwfegwafeagewzfafafsa",
        "abcdefghijklmnopqrstuvwxyzwasfdafsaawfdwafagafagagsgfsafsgdsdfdafafsafafadafaf"}));
    }
}
