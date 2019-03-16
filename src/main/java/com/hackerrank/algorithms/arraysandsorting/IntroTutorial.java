package com.hackerrank.algorithms.arraysandsorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 3/1/15
 * Time: 3:38 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class IntroTutorial {
    static int search(int searchVal, int[] arr) {
        return Arrays.binarySearch(arr, searchVal);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int searchVal = in.nextInt();
        int arrSize = in.nextInt();
        int[] arr = new int[arrSize];
        // as nextInt() doesn't read new line character
        in.nextLine();
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for (int _a_i = 0; _a_i < arrSize; _a_i++) {
            arr[_a_i] = Integer.parseInt(next_split[_a_i]);
        }

        System.out.print(search(searchVal, arr));
    }
}
