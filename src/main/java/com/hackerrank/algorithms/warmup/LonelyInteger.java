package com.hackerrank.algorithms.warmup;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 2/28/15
 * Time: 12:16 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class LonelyInteger {

    static int lonelyInteger(int[] a) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyInteger(_a);
        System.out.println(res);
    }
}
