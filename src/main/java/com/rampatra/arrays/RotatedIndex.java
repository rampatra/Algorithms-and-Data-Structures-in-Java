package com.rampatra.arrays;

/**
 * @author rampatra
 * @since 2019-04-04
 */
public class RotatedIndex {

    private static int findIndexOfRotationPoint(String[] words) {
        return findIndexOfRotationPoint(words, 0, words.length - 1);
    }

    private static int findIndexOfRotationPoint(String[] words, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        
        if (mid == 0 || mid == words.length - 1) return -1;

        if (words[mid].compareTo(words[mid - 1]) < 0 && words[mid].compareTo(words[mid + 1]) < 0) {
            return mid;
        } else if (words[mid].compareTo(words[mid - 1]) > 0 && words[mid].compareTo(words[mid + 1]) < 0) {
            return findIndexOfRotationPoint(words, start, mid - 1);
        } else {
            return findIndexOfRotationPoint(words, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(findIndexOfRotationPoint(new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        }));

        System.out.println(findIndexOfRotationPoint(new String[]{}));
        
        System.out.println(findIndexOfRotationPoint(new String[]{
                "asymptote",
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        }));
    }
}