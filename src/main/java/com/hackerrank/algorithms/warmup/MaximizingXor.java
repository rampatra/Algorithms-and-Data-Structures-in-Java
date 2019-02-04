package com.hackerrank.algorithms.warmup;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/7/15
 * Time: 11:07 AM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class MaximizingXor {

    static int maxXor(int l, int r) {
        TreeSet res = new TreeSet();
        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                res.add(i ^ j);
            }
        }
        return (int) res.last();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}
