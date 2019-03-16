package com.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/18/15
 * Time: 12:27 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class PalindromeIndex {

    static int makePalindrome(String s) {
        int index = -1, l = s.length();
        if (isPalindrome(s)) {
            return -1;
        }
        for (int i = 0; i < l; i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            String str = sb.toString();
            if (isPalindrome(str)) {
                return i;
            }
        }
        return index;
    }

    static boolean isPalindrome(String s) {
        int l = s.length(), i, j;
        for (i = 0, j = l - 1; i < l / 2; i++, j--) {
            if ((int) s.charAt(i) != (int) s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        String s[] = new String[t];

        for (int i = 0; i < t; i++) {
            s[i] = in.next();
        }

        for (int i = 0; i < t; i++) {
            System.out.println(makePalindrome(s[i]));
        }
    }
}
