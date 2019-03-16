package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/1/15
 * Time: 3:07 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class UtopianTree {
    static int calcHeight(int growthCycles) {
        int h = 1;

        for (int i = 1; i <= growthCycles; i++) {
            if (i % 2 != 0)
                h *= 2;
            else
                h += 1;
        }

        return h;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int n[] = new int[t];

        for (int i = 0; i < t; i++) {
            n[i] = in.nextInt();
        }

        for (int i = 0; i < t; i++) {
            System.out.println(calcHeight(n[i]));
        }
    }
}
