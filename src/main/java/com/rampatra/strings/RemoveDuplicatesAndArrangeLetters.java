package com.rampatra.strings;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author rampatra
 * @since 2019-04-02
 */
public class RemoveDuplicatesAndArrangeLetters {

    private static String removeDuplicatesAndArrangeLettersLexicographically(String str) {
        Set<Character> charSet = new TreeSet<>();
        char[] chars = str.toCharArray();

        for (char ch : chars) {
            charSet.add(ch);
        }
        
        return charSet.toString();
    }

    private static String removeDuplicatesAndArrangeLettersLexicographically_Java8(String str) {
        return str.chars()
                .distinct()
                .sorted()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicatesAndArrangeLettersLexicographically("algo&dsInJava"));
        System.out.println(removeDuplicatesAndArrangeLettersLexicographically_Java8("algo&dsInJava"));
    }
}
