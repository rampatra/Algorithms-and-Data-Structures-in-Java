package com.hackerrank.java.bignumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Problem Link: https://www.hackerrank.com/challenges/java-bigdecimal/
 *
 * @author rampatra
 * @since 2019-06-22
 */
class BigDecimal {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        s = Arrays.copyOfRange(s, 0, s.length - 2);
        List<String> input = Arrays.asList(s);
        Arrays.sort(s, (s1, s2) -> {
            int compare = new java.math.BigDecimal(s2).compareTo(new java.math.BigDecimal(s1));
            if (compare == 0) {
                return Integer.compare(input.indexOf(s1), input.indexOf(s2));
            }
            return compare;
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}