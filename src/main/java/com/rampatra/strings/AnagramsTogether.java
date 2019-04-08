package com.rampatra.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/23/15
 */
public class AnagramsTogether {

    /**
     * Prints all the anagrams together from the string array {@code strings}.
     * <p/>
     * Anagrams are words consisting of the same letters but in the same or different
     * order. For example, "cat" and "tac" are anagrams. Same as "god" and "dog".
     *
     * @param strings
     */
    private static void printAnagramsTogether(String[] strings) {

        // each key holds all the indexes of a anagram
        HashMap<String, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            Arrays.sort(chars);

            List<Integer> indexes = hashMap.get(String.valueOf(chars));
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            hashMap.put(String.valueOf(chars), indexes);
        }

        for (Map.Entry<String, List<Integer>> entry : hashMap.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println(strings[entry.getValue().get(i)]);
            }
            System.out.println("------");
        }
    }

    public static void main(String[] args) {
        printAnagramsTogether(new String[]{"cat", "dog", "tac", "god", "act"});
        printAnagramsTogether(new String[]{"cat", "tac", "act", "god", "dog"});
    }
}