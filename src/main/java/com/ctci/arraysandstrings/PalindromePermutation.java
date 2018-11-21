package com.ctci.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rampatra
 * @since 21/11/2018
 */
public class PalindromePermutation {

    /**
     * This method exploits the fact that a palindrome will contain at most
     * one character with odd counts. All other characters should be of even
     * counts.
     *
     * @param str input string
     * @return {@code true} if {@code str} is a permutation of a palindrome
     */
    private static boolean isPermutationOfPalindrome(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();
        Integer freq;
        int oddCounts = 0; // keep count of odds so that we don't have to loop through the hashmap the second time
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != 32) {
                freq = charCounts.get(c) == null ? 0 : charCounts.get(c);
                if ((freq + 1) % 2 == 1) {
                    oddCounts++;
                } else {
                    oddCounts--;
                }
                charCounts.put(c, freq + 1);
            }
        }
        return oddCounts <= 1;
    }


    /**
     * This approach sets a bit in a number based on the character in the string and
     * then un-sets the bit if it sees the character again. Finally, checks if the
     * bitVector has at most one bit set only.
     *
     * @param str input string
     * @return {@code true} if {@code str} is a permutation of a palindrome
     */
    private static boolean isPermutationOfPalindromeViaBits(String str) {
        int bitVector = 0;
        int index;

        for (int i = 0; i < str.length(); i++) {
            index = getIndex(str.charAt(i));
            if (index != -1) {
                bitVector = toggleBitAt(bitVector, index);
            }
        }
        return (bitVector & (bitVector - 1)) == 0;
    }

    /**
     * Calculates the index to set the bit according to the character {@code c}.
     *
     * @param c
     * @return the index to set the bit as per the character {@code c}
     */
    private static int getIndex(char c) {
        char a = 'a';
        char z = 'z';

        // assuming string contains only lowercase characters
        if (c < a || c > z) {
            return -1;
        }

        return c - a;
    }

    /**
     * Toggles the bit at index {@code index} in {@code bitVector}.
     *
     * @param bitVector
     * @param index
     * @return the resulting {@code bitVector} after toggling the bit
     */
    private static int toggleBitAt(int bitVector, int index) {
        return bitVector ^ (1 << index);
    }

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("tactc oapapa"));
        System.out.println(isPermutationOfPalindrome("maam"));
        System.out.println(isPermutationOfPalindrome("maa m"));
        System.out.println(isPermutationOfPalindrome("rammmar"));
        System.out.println(isPermutationOfPalindrome("rammmara"));
        System.out.println("---------");
        System.out.println(isPermutationOfPalindromeViaBits("tactc oapapa"));
        System.out.println(isPermutationOfPalindromeViaBits("maam"));
        System.out.println(isPermutationOfPalindromeViaBits("maa m"));
        System.out.println(isPermutationOfPalindromeViaBits("rammmar"));
        System.out.println(isPermutationOfPalindromeViaBits("rammmara"));
    }
}
