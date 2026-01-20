package com.hackerrank.algorithms.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestMakingAnagrams {

	@Test
	void testWithStringEmpty() {
		String a1 = "";
		String a2 = "";
		int resultA = 0;
		
		int countA = MakingAnagrams.makeAnagrams(a1, a2);
		assertEquals(countA, resultA);
		
		String b1 = "";
		String b2 = "1234567890qwertyuiop";
		int resultB = 20;
		
		int countB = MakingAnagrams.makeAnagrams(b1, b2);
		assertEquals(countB, resultB);
	}
	
	@Test
	void testWithStringAllCharacter() {
		String a1 = "1234567890 ~!@#$%^";
		String a2 = "&*()-+1234567890 ";
		int resultA = 13;
		
		int countA = MakingAnagrams.makeAnagrams(a1, a2);
		assertEquals(countA, resultA);
		
		String b1 = "asdfghjklb1234567890 ";
		String b2 = "1234567890 qwertyuiop";
		int resultB = 20;
		
		int countB = MakingAnagrams.makeAnagrams(b1, b2);
		assertEquals(countB, resultB);
		
		String c1 = "hello my world";
		String c2 = "this is my world";
		int resultC = 10;
		
		int countC = MakingAnagrams.makeAnagrams(c1, c2);
		assertEquals(countC, resultC);
	}

}
