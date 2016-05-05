package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by ramswaroop on 02/05/2016.
 */
public class GridSearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for (int G_i = 0; G_i < R; G_i++) {
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for (int P_i = 0; P_i < r; P_i++) {
                P[P_i] = in.next();
            }
            int count = 0;
            int start = -1;

            for (int G_i = 0; G_i < R; G_i++) {
                if ((start = G[G_i].indexOf(P[0], start + 1)) > -1) {
                    count = 1;
                    for (int P_i = 1; P_i < r && G_i + P_i < R; P_i++) {
                        if (G[G_i + P_i].indexOf(P[P_i]) != start) {
                            break;
                        }
                        count++;
                    }
                    if (count == r) {
                        System.out.println("YES");
                        break;
                    } else {
                        G_i = 0;
                    }
                }
            }
            if (count != r) {
                System.out.println("NO");
            }
        }
    }
}

