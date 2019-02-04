package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by rampatra on 29/05/2016.
 */
public class TheTimeInWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        String timeInWords;
        String[] words = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
                "twenty seven", "twenty eight", "twenty nine"};

        if (m == 0) {
            timeInWords = words[h] + " o' clock";
        } else if (m == 1) {
            timeInWords = words[m] + " minute past " + words[h];
        } else if (m == 15) {
            timeInWords = "quarter past " + words[h];
        } else if (m < 30) {
            timeInWords = words[m] + " minutes past " + words[h];
        } else if (m == 30) {
            timeInWords = "half past " + words[h];
        } else if (m == 45) {
            timeInWords = "quarter to " + words[(h == 12) ? h - 11 : h + 1];
        } else if (60 - m == 1) {
            timeInWords = words[60 - m] + " minute to " + words[(h == 12) ? h - 11 : h + 1];
        } else {
            timeInWords = words[60 - m] + " minutes to " + words[(h == 12) ? h - 11 : h + 1];
        }
        System.out.println(timeInWords);
    }
}
