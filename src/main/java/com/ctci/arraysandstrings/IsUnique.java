package com.ctci.arraysandstrings;

/**
 * @author rampatra
 * @since 18/11/2018
 */
public class IsUnique {

    /**
     * Check whether the input string contains different individual characters and it in the ASCII table.
     *
     * @param str Input string
     * @return true if all characters are different from each other, otherwise false.
     */
    public static boolean isAllCharactersUniqueAndInASCII(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int maxCharIndex = 128;
        int stringLength = str.length();

        if (stringLength > maxCharIndex) {
            return false;
        }

        boolean[] characterTrack = new boolean[maxCharIndex]; // assuming the string contains only ASCII characters
        for (int i = 0; i < stringLength; i++) {
            int charIndex = str.charAt(i);
            if (charIndex >= maxCharIndex
                    || characterTrack[charIndex]) {
                return false;
            }

            characterTrack[charIndex] = true;
        }
        return true;
    }

    private static boolean hasAllUniqueCharactersWhenStringContainsAllLowercase(String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int charValue = s.charAt(i) - 'a';
            if ((checker & (1 << charValue)) > 0) {
                return false;
            }
            checker |= (1 << charValue);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ram";
        System.out.println(isAllCharactersUniqueAndInASCII(s));
        s = "rama";
        System.out.println(isAllCharactersUniqueAndInASCII(s));
        s = "ramA";
        System.out.println(isAllCharactersUniqueAndInASCII(s));
        System.out.println("-------");
        s = "ram";
        System.out.println(hasAllUniqueCharactersWhenStringContainsAllLowercase(s));
        s = "rama";
        System.out.println(hasAllUniqueCharactersWhenStringContainsAllLowercase(s));
        // not working as the input contains different cases
        s = "ramA";
        System.out.println(hasAllUniqueCharactersWhenStringContainsAllLowercase(s));
    }
}
