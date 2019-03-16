package com.rampatra.bits;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/15/15
 * @time: 10:38 AM
 */
public class StrCmp {

    /**
     * Compares two strings {@param s1} and {@param s2} lexicographically ignoring case.
     * If both are equal it returns 0 otherwise their lexicographic differences.
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int compareStringIgnoreCase(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                // If characters don't match but case may be ignored,
                // try converting both characters to uppercase.
                // If the results match, then the comparison scan should
                // continue.
                c1 = Character.toUpperCase(c1);
                c2 = Character.toUpperCase(c2);
                if (c1 != c2) {
                    // Unfortunately, conversion to uppercase does not work properly
                    // for the Georgian alphabet, which has strange rules about case
                    // conversion. So we need to make one last check before
                    // exiting.
                    c1 = Character.toUpperCase(c1);
                    c2 = Character.toUpperCase(c2);
                    if (c1 != c2) {
                        // No overflow because of numeric promotion
                        return c1 - c2;
                    }
                }
            }
        }
        return n1 - n2;
    }

    public static void main(String[] args) {
        System.out.println(compareStringIgnoreCase("ram", "ram"));
        System.out.println(compareStringIgnoreCase("ram", "Ram"));
        System.out.println(compareStringIgnoreCase("", ""));
        System.out.println(compareStringIgnoreCase("", " "));
        System.out.println(compareStringIgnoreCase(" ", " "));
        System.out.println(compareStringIgnoreCase(" ", ""));
        System.out.println(compareStringIgnoreCase("Geeks", "apple"));
        System.out.println(compareStringIgnoreCase("", "ABCD"));
        System.out.println(compareStringIgnoreCase("ABCD", "z"));
        System.out.println(compareStringIgnoreCase("ABCD", "abcdEghe"));
        System.out.println(compareStringIgnoreCase("GeeksForGeeks", "gEEksFORGeEKs"));
        System.out.println(compareStringIgnoreCase("GeeksForGeeks", "geeksForGeeks"));
        System.out.println("--------------------");
        System.out.println("ram".compareToIgnoreCase("ram"));
        System.out.println("ram".compareToIgnoreCase("Ram"));
        System.out.println("".compareToIgnoreCase(""));
        System.out.println("".compareToIgnoreCase(" "));
        System.out.println(" ".compareToIgnoreCase(" "));
        System.out.println(" ".compareToIgnoreCase(""));
        System.out.println("Geeks".compareToIgnoreCase("apple"));
        System.out.println("".compareToIgnoreCase("ABCD"));
        System.out.println("ABCD".compareToIgnoreCase("z"));
        System.out.println("ABCD".compareToIgnoreCase("abcdEghe"));
        System.out.println("GeeksForGeeks".compareToIgnoreCase("gEEksFORGeEKs"));
        System.out.println("GeeksForGeeks".compareToIgnoreCase("geeksForGeeks"));
    }
}
