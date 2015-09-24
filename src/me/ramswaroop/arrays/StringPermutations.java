package me.ramswaroop.arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/24/15
 * @time: 2:27 PM
 */
public class StringPermutations {

    public static void printAllPermutations(String prefix, String s) {
        int len = s.length();
        if (len == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < len; i++) {
                printAllPermutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, len));
            }
        }
    }

    public static void main(String a[]) {
        printAllPermutations("", "a");
        System.out.println("-------");
        printAllPermutations("", "ab");
        System.out.println("-------");
        printAllPermutations("", "abc");
    }
}
