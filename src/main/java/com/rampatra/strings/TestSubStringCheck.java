package com.rampatra.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
	

public class TestSubStringCheck {
	static String assumedFilledString =  "QWERTYUIOPASDFGHJKLZXCVBNM 1234567890 qwertyuiopasdfghjklzxcvbnm -=+!@#$%^&*() >:{ }|\\]";
	static String assumedFilledSubString =  "QWERTYUIOPASDFGHJKLZXCVBNM";
	static String emptyString = "";
	static String nullString = null;
	static String nonASCIIString = "Ă Â Ô Ơ Ư Ê ⏩ ☕ ☝ ♈ ぁ あ ぃ い ぅ う ぇ え ぉ お ؀  ؄  ç ù";
	static String nonASCIISubString = "ぁ あ ぃ い ぅ う ぇ え ぉ お ؀  ؄  ç ù";
	static String spaceString = "                ";
	
	
	@Test
	static void happyCases() {
		//First slot is main string
		boolean resultA = SubStringCheck.isSubString(assumedFilledString, assumedFilledSubString);
				
		//Second slot is main string
		boolean resultB = SubStringCheck.isSubString(assumedFilledSubString, assumedFilledString);
		
		//Both slot is the same
		boolean resultC = SubStringCheck.isSubString(assumedFilledSubString, assumedFilledSubString);
				
				
		//Assertion
		assertTrue(resultA);
		assertFalse(resultB);
		assertTrue(resultC);
	}
	
	@Test
	static void emptyCases() {
		
		//First slot is empty
		boolean resultA = SubStringCheck.isSubString(emptyString, assumedFilledString);
		
		//Second slot is empty
		boolean resultB = SubStringCheck.isSubString(assumedFilledString, emptyString);
		
		//Both slot is empty
		boolean resultC = SubStringCheck.isSubString(emptyString, emptyString);
		
		
		//Assertion
		assertFalse(resultA);
		assertTrue(resultB);
		assertTrue(resultC);
	}
	
	@Test
	static void nullCases() {
		//First slot is null
		boolean resultA = SubStringCheck.isSubString(nullString, assumedFilledString);
		
		//Second slot is null
		boolean resultB = SubStringCheck.isSubString(assumedFilledString, nullString);
		
		//Both slot is null
		boolean resultC = SubStringCheck.isSubString(nullString, nullString);
		
		//First slot is null and second slot is empty
		boolean resultD = SubStringCheck.isSubString(nullString, emptyString);

		//First slot is empty and second slot is null
		boolean resultE = SubStringCheck.isSubString(emptyString, nullString);

		//Assertion
		assertFalse(resultA);
		assertFalse(resultB);
		assertFalse(resultC);
		assertFalse(resultD);
		assertFalse(resultE);
	}
	
	@Test
	static void spaceCases() {
		//First slot is full of spaces
		boolean resultA = SubStringCheck.isSubString(spaceString, assumedFilledString);

		
		//Second slot is full of spaces
		boolean resultB = SubStringCheck.isSubString(assumedFilledString, spaceString);

		
		//Both slot is full of spaces
		boolean resultC = SubStringCheck.isSubString(spaceString, spaceString);
		
		//Assertion
		assertFalse(resultA);
		assertFalse(resultB);
		assertTrue(resultC);
	}
	
	@Test
	static void nonASCIICases() {
		//Good case
		boolean resultA = SubStringCheck.isSubString(nonASCIIString, nonASCIISubString);

		
		//Second slot is empty
		boolean resultB = SubStringCheck.isSubString(nonASCIIString, emptyString);

		
		//Second slot is null
		boolean resultC = SubStringCheck.isSubString(nonASCIIString, nullString);
		
		//Assertion
		assertTrue(resultA);
		assertTrue(resultB);
		assertFalse(resultC);
	}
	
    public static void main(String[] args) {
    	happyCases();
        emptyCases();
        nullCases();
        spaceCases();
        nonASCIICases();
    }
}
