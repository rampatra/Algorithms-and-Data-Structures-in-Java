package com.rampatra.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/22/15
 * Time: 7:40 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
class SPOJ1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> inputList = new ArrayList<>();
        int input;
        for (; ; ) {
            input = Integer.parseInt(in.nextLine());
            if (input == 42) break;
            inputList.add(input);
        }

        for (long i : inputList) {
            System.out.println(i);
        }
    }
}
