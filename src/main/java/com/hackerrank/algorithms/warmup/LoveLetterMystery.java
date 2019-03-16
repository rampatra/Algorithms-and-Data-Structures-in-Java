package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/17/15
 * Time: 3:22 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class LoveLetterMystery {
    static int calcPalindromeSteps(String s) {
        int steps = 0, length = s.length(), a, b;
        for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
            if ((a = (int) s.charAt(i)) != (b = (int) s.charAt(j))) {
                steps += Math.abs(a - b);
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        String s[] = new String[t];

        for (int i = 0; i < t; i++) {
            s[i] = in.next();
        }

        for (int i = 0; i < t; i++) {
            System.out.println(calcPalindromeSteps(s[i]));
        }
    }
}
