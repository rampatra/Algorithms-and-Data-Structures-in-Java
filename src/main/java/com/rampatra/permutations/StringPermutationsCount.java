package com.rampatra.permutations;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * You have 2 string, one smaller, one larger. Write an algorithm to figure out how many permutations of the
 * smaller string exist in the bigger string.
 *
 * @author rampatra
 * @since 10/15/15
 * @time: 10:32 AM
 * @see: StringPermutations for a simpler version
 */
public class StringPermutationsCount {

    /**
     * Finds the number of permutations of string {@param s1} that exists in string {@param s2}.
     *
     * @param prefix
     * @param s1
     * @param s2
     * @param count
     * @return
     */
    public static int getStringPermutationsCount(String prefix, String s1, String s2, int count) {
        if (s1.isEmpty()) {
            if (s2.indexOf(prefix) != -1) count++;
        }

        for (int i = 0; i < s1.length(); i++) {
            count = getStringPermutationsCount(prefix + s1.substring(i, i + 1), s1.substring(0, i) + s1.substring(i + 1), s2, count);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(getStringPermutationsCount("", "abc", "abcba", 0));
        System.out.println(getStringPermutationsCount("", "abc", "abcbacb", 0));
    }
}
