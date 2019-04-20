package com.leetcode.strings;

/**
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
     * Runtime: <a href="https://leetcode.com/submissions/detail/223735469/">1 ms</a>.
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        int row;
        for (int col = 0; col < Integer.MAX_VALUE; col++) {
            for (row = 0; row < strs.length - 1; row++) {
                // once we find a different character under one column, break the loop
                if (col == strs[row].length()
                        || col == strs[row + 1].length()
                        || strs[row].charAt(col) != strs[row + 1].charAt(col)) {
                    break;
                }
            }

            // check the row counter to figure whether all characters in a particular column are identical
            if (row == strs.length - 1 && strs[0].length() > 0 && col < strs[0].length()) {
                sb.append(strs[0].charAt(col));
            } else {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
