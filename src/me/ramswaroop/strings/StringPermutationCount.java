package me.ramswaroop.strings;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * You have 2 string, one smaller, one larger. Write an algorithm to figure out how many permutations of the
 * smaller string exist in the bigger string.
 *
 * @author: ramswaroop
 * @date: 10/15/15
 * @time: 10:32 AM
 */
public class StringPermutationCount {

    public static int getStringPermutationCount(String prefix, String s1, String s2, int count) {
        if (s1.isEmpty()) {
            if (s2.indexOf(prefix) != -1) count++;
        }

        for (int i = 0; i < s1.length(); i++) {
            count = getStringPermutationCount(prefix + s1.substring(i, i + 1), s1.substring(0, i) + s1.substring(i + 1), s2, count);
        }

        return count;
    }

    public static void main(String a[]) {
        System.out.println(getStringPermutationCount("", "abc", "abcba", 0));
        System.out.println(getStringPermutationCount("", "abc", "abcba", 0));
    }
}
