package com.rampatra.strings;

import com.sun.tools.javac.util.Assert;

/**
 * Given two strings, base and remove, return a version of the base string where all instances
 * of the remove string have been removed (not case sensitive). You may assume that the remove
 * string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing
 * "xx" leaves "x".
 *
 * @author rampatra
 * @since 2019-01-23
 */
public class WithoutString {

    private static String withoutString(String base, String remove) {
        String original = base;
        base = base.toLowerCase();
        remove = remove.toLowerCase();
        int baseLen = base.length();
        int removeLen = remove.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < baseLen; ) {
            int j = 0;
            // when we see a match, advance the pointer
            while (j < removeLen && i + j < baseLen && base.charAt(i + j) == remove.charAt(j)) {
                j++;
            }
            if (j == removeLen) { // an entire match was found, move ahead and skip these chars
                i += removeLen;
            } else {
                sb.append(original.charAt(i)); // entire match was not found so append the char to StringBuilder
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Assert.check(withoutString("Hello there", "llo").equals("He there"));
        Assert.check(withoutString("THIS is a FISH", "is").equals("TH  a FH"));
        Assert.check(withoutString("xxx", "x").equals(""));
    }
}
