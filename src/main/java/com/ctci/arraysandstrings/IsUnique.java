package com.ctci.arraysandstrings;

/**
 * @author rampatra
 * @since 18/11/2018
 */
public class IsUnique {

    private static boolean hasAllUniqueCharacters(String str) {
        if (str == null || str.length() > 128) return false;

        boolean[] charSet = new boolean[128]; // assuming the string contains only ASCII characters
        for (int i = 0; i < str.length(); i++) {
            int charVal = str.charAt(i);
            if (charSet[charVal]) {
                return false;
            }
            charSet[charVal] = true;
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
        System.out.println(hasAllUniqueCharacters(s));
        s = "rama";
        System.out.println(hasAllUniqueCharacters(s));
        s = "ramA";
        System.out.println(hasAllUniqueCharacters(s));
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
