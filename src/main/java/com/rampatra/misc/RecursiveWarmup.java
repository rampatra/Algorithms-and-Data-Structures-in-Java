package com.rampatra.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/28/15
 * @time: 8:37 PM
 */
public class RecursiveWarmup {

    /**
     * Reverses the string {@param input} iteratively.
     *
     * @param input
     * @return the reversed {@code String}.
     */
    public String reverse(String input) {

        int len = input.length();
        char[] charArray = input.toCharArray();
        char[] revCharArray = new char[len];

        for (int i = 0; i < len; i++) {
            revCharArray[len - i - 1] = charArray[i];
        }

        return String.valueOf(revCharArray);
    }

    /**
     * Reverses the string {@param input} recursively.
     * NOTE: This is BAD programming practice.
     *
     * @param input
     * @return the reversed {@code String}.
     */
    public String reverseRecursive(String input) {
        if (input.length() > 1) {
            char c = input.charAt(0);
            String rev = reverseRecursive(input.substring(1));
            input = rev + c;
        }
        return input;
    }


    /**
     * Reverses a list {@param input}.
     *
     * @param input
     * @return reversed {@code List}.
     */
    public List<Integer> reverse(List<Integer> input) {

        List<Integer> revList = new ArrayList<>();

        for (int i = input.size() - 1; i >= 0; i--) {
            revList.add(input.get(i));
        }

        return revList;
    }

    /**
     * Reverses a list {@param input} recursively.
     * NOTE: This is BAD programming practice.
     *
     * @param input
     * @return reversed {@code List}.
     */
    public List<Integer> reverseRecursive(List<Integer> input) {

        if (!input.isEmpty()) {
            Integer item = input.remove(0);
            reverseRecursive(input);
            input.add(item);
        }
        return input;
    }

    /**
     * Starting point of the program.
     *
     * @param a
     */
    public static void main(String[] args) {
        RecursiveWarmup RecursiveWarmup = new RecursiveWarmup();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        System.out.println("========= String reverse test cases =========");
        System.out.println(RecursiveWarmup.reverse("apple"));
        System.out.println(RecursiveWarmup.reverse("a"));
        System.out.println(RecursiveWarmup.reverse(""));
        System.out.println("========= String reverse recursive test cases =========");
        System.out.println(RecursiveWarmup.reverseRecursive("apple"));
        System.out.println(RecursiveWarmup.reverseRecursive("a"));
        System.out.println(RecursiveWarmup.reverseRecursive(""));
        System.out.println("========== List reverse test cases ==========");
        System.out.println(RecursiveWarmup.reverse(list1));
        System.out.println(RecursiveWarmup.reverse(list2));
        System.out.println(RecursiveWarmup.reverse(list3));
        System.out.println("========== List reverse recursive test cases ==========");
        System.out.println(RecursiveWarmup.reverseRecursive(list1));
        System.out.println(RecursiveWarmup.reverseRecursive(list2));
        System.out.println(RecursiveWarmup.reverseRecursive(list3));
        System.exit(0);
    }
}
