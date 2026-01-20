package com.ctci.arraysandstrings;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestIsUnique {
	@Test
	public void TesthasAllUniqueCharacters() {
		String TC1 = "qwertyuiop123456@#$%";
		String TC2 = "aaaaaaaaa";
		
		boolean R1 = IsUnique.hasAllUniqueCharacters(TC1);
		boolean R2 = IsUnique.hasAllUniqueCharacters(TC2);
		
		assertTrue(R1);
		assertFalse(R2);
	}
	@Test
	public void TesthasAllUniqueCharactersWhenStringContainsAllLowercase() {
		String TC1 = "qwertyuiop";
		String TC2 = "aaaaaaaaa";
		String TC3 = "QwertHfakjf";
		
		boolean R1 = IsUnique.hasAllUniqueCharactersWhenStringContainsAllLowercase(TC1);
		boolean R2 = IsUnique.hasAllUniqueCharactersWhenStringContainsAllLowercase(TC2);
		boolean R3 = IsUnique.hasAllUniqueCharactersWhenStringContainsAllLowercase(TC3);
		
		assertTrue(R1);
		assertFalse(R2);
		assertFalse(R3);

	}
}
