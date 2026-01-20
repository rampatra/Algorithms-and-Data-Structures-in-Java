package com.ctci.arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

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

    @Test
	public void hasAllUniqueCharacters_tc1_null() {
		String s = null;
		Assert.assertFalse(hasAllUniqueCharacters(s));
	}
	
	@Test
	public void hasAllUniqueCharacters_tc2_greaterThan128() {
		String s = "Currently, each country has its own language, its own characters. Extended ASCII encoding was born with the goal of being diverse in that language";
		Assert.assertFalse(hasAllUniqueCharacters(s));
	}

	@Test
	public void hasAllUniqueCharacters_tc3_notUnique() {
		String s = "rama";
		Assert.assertFalse(hasAllUniqueCharacters(s));
	}
	
	@Test
	public void hasAllUniqueCharacters_tc4_Unique() {
		String s = "ram";
		Assert.assertTrue(hasAllUniqueCharacters(s));
	}
	
	@Test
	public void hasAllUniqueCharacters_tc5_UniqueWithCapital() {
		String s = "ramA";
		Assert.assertTrue(hasAllUniqueCharacters(s));
	}
	
	@Test
	public void hasAllUniqueCharactersWhenStringContainsAllLowercase_tc1_notUnique() {
		String s = "rama";
		Assert.assertFalse(hasAllUniqueCharactersWhenStringContainsAllLowercase(s));
	}
	
	@Test
	public void hasAllUniqueCharactersWhenStringContainsAllLowercase_tc2_Unique() {
		String s = "ram";
		Assert.assertTrue(hasAllUniqueCharactersWhenStringContainsAllLowercase(s));
	}
	
	@Test
	public void hasAllUniqueCharactersWhenStringContainsAllLowercase_tc3_UniqueWithCapital() {
		String s = "ramA";
		Assert.assertFalse(hasAllUniqueCharactersWhenStringContainsAllLowercase(s));
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
