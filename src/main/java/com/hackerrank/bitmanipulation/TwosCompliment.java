package com.hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 6/24/15
 * @time: 10:25 PM
 */
public class TwosCompliment {

    public static long countSetBitsInRange(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += Integer.bitCount(i);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        String[][] in_ar = new String[t][2];

        for (int i = 0; i < t; i++) {
            in_ar[i] = in.nextLine().split(" ");
        }

        for (String[] i : in_ar) {
            System.out.println(countSetBitsInRange(Integer.parseInt(i[0]), Integer.parseInt(i[1])));
        }
    }
}
