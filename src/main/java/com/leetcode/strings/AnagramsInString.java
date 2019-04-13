package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode Problem: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * @author rampatra
 * @since 2019-04-13
 */
public class AnagramsInString {

    private static List<Integer> findAllAnagramsInTextNaive(String text, String pattern) {
        List<Integer> indexes = new ArrayList<>();
        
        int textLen = text.length();
        int patternLen = pattern.length();
        
        char[] patternChars = pattern.toCharArray();
        Arrays.sort(patternChars); // takes O(m log m) time
        String sortedPattern = String.valueOf(patternChars);
        
        String subText;
        char[] subTextChars;
        String sortedSubText;
        
        for (int i = 0; i <= textLen - patternLen; i++) { // loops n-m number of times
            subText = text.substring(i, i + patternLen); 
            subTextChars = subText.toCharArray();
            Arrays.sort(subTextChars); // sorts m number of characters, takes O(m log m)
            sortedSubText = String.valueOf(subTextChars);
            
            if (sortedSubText.equals(sortedPattern)) { // compare m characters takes m time
                indexes.add(i);
            }
        }
        return indexes;
    }
    
    public static void main(String[] args) {
        // basic use cases
        System.out.println(findAllAnagramsInTextNaive("cbaebabacd", "abc"));
        System.out.println(findAllAnagramsInTextNaive("abab", "ab"));
        
        // corner cases
        System.out.println(findAllAnagramsInTextNaive("abab", ""));
        System.out.println(findAllAnagramsInTextNaive("", "ab"));
        System.out.println(findAllAnagramsInTextNaive("", ""));
    }
}