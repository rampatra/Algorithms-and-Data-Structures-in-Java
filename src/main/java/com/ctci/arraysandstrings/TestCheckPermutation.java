package com.ctci.arraysandstrings;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestCheckPermutation {

	@Test
	void testPermutationStringWithEmpty() {
		String a1 = "";
		String a2 = "";
		
		String b1 = "1234567890 qwertyuiopasdfghjklzxcvbnm !@#$%^&*()-=";
		String b2 = "";
		
		String c1 = "";
		String c2 = "1234567890 qwertyuiopasdfghjklzxcvbnm !@#$%^&*()-=";
		
		
		boolean resultA = CheckPermutation.isOnePermutationOfOther(a1, a2);
		boolean resultB = CheckPermutation.isOnePermutationOfOther(b1, b2);
		boolean resultC = CheckPermutation.isOnePermutationOfOther(c1, c2);
		
		assertTrue(resultA);
		assertFalse(resultB);
		assertFalse(resultC);
	}
	
	@Test
	void testPermutationStringAllCharacter() {
		String a1 = "1234567890 qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM !@#$%^&*()-=";
		String a2 = "!@#$%^&*()-= 1234567890 qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM";
		
		String b1 = "~!@#$%^&*([{<>}])+-=:;'\\\",./? ";
		String b2 = " ?/.,\"\\';:=-+)}]><[{(*&^%$#@!~";
		
		String c1 = "Â Ă Ơ Ô Ư Ê â ă ơ ô ư ê";
		String c2 = "ê ư ô ơ ă â Ê Ư Ô Ơ Ă Â";
		
		String d1 = "ÂÂ ĂĂ ƠƠ ÔÔ ƯƯ ÊÊ ââ ăă ơơ ôô ưư êê";
		String d2 = "ê ư ô ơ ă â Ê Ư Ô Ơ Ă Â";
		
		
		boolean resultA = CheckPermutation.isOnePermutationOfOther(a1, a2);
		boolean resultB = CheckPermutation.isOnePermutationOfOther(b1, b2);
		boolean resultC = CheckPermutation.isOnePermutationOfOther(c1, c2);
		boolean resultD = CheckPermutation.isOnePermutationOfOther(d1, d2);
		
		assertTrue(resultA);
		assertTrue(resultB);
		assertTrue(resultC);
		assertFalse(resultD);
	}
	
	@Test
	void testPermutationWithAsciiAndStringEmpty() {
		String a1 = "";
		String a2 = "";
		
		String b1 = "1234567890 qwertyuiopasdfghjklzxcvbnm !@#$%^&*()-=";
		String b2 = "";
		
		String c1 = "";
		String c2 = "1234567890 qwertyuiopasdfghjklzxcvbnm !@#$%^&*()-=";
		
		
		boolean resultA = CheckPermutation.isOnePermutationOfOtherGivenThatStringsContainOnlyAscii(a1, a2);
		boolean resultB = CheckPermutation.isOnePermutationOfOtherGivenThatStringsContainOnlyAscii(b1, b2);
		boolean resultC = CheckPermutation.isOnePermutationOfOtherGivenThatStringsContainOnlyAscii(c1, c2);
		
		assertTrue(resultA);
		assertFalse(resultB);
		assertFalse(resultC);
	}
	
	@Test
	void testPermutationWithAsciiAndStringAllCharacter() {
		String a1 = "1234567890 qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM !@#$%^&*()-=";
		String a2 = "!@#$%^&*()-= 1234567890 qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM";
		
		String b1 = "~!@#$%^&*([{<>}])+-=:;'\\\",./? ";
		String b2 = " ?/.,\"\\';:=-+)}]><[{(*&^%$#@!~";
		
		String c1 = "Â Ă Ơ Ô Ư Ê â ă ơ ô ư ê";
		String c2 = "ê ư ô ơ ă â Ê Ư Ô Ơ Ă Â";
		
		String d1 = "Â Ă Ơ Ô Ư Ê â ă ơ ô ư ê";
		String e2 = "ê ư ô ơ ă â Ê Ư Ô Ơ Ă Â";
		
		
		boolean resultA = CheckPermutation.isOnePermutationOfOtherGivenThatStringsContainOnlyAscii(a1, a2);
		boolean resultB = CheckPermutation.isOnePermutationOfOtherGivenThatStringsContainOnlyAscii(b1, b2);
		boolean resultC = CheckPermutation.isOnePermutationOfOtherGivenThatStringsContainOnlyAscii(c1, c2);
		
		assertTrue(resultA);
		assertTrue(resultB);
		assertFalse(resultC);
	}
}
