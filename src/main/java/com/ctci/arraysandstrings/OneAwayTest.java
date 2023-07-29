package com.ctci.arraysandstrings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



class OneAwayTest {
	
	@Test
    static void testIsOneCharacterDiffAtMax() {
        assertTrue(OneAway.isOneCharacterDiffAtMax("", ""));
        assertTrue(OneAway.isOneCharacterDiffAtMax("abcdef", "abcdef"));
        assertTrue(OneAway.isOneCharacterDiffAtMax("abc", "abd"));
        
        assertFalse(OneAway.isOneCharacterDiffAtMax("abcdef", "abcfed"));
        assertFalse(OneAway.isOneCharacterDiffAtMax("abcabc", "abcdef"));
    }
	
	@Test
	static void testCheckForMaxOneInsertOrDeleteInS1() {
		assertFalse(OneAway.checkForMaxOneInsertOrDeleteInS1("mn", "mnpq"));
		assertFalse(OneAway.checkForMaxOneInsertOrDeleteInS1("abcd", "e"));
		
		assertTrue(OneAway.checkForMaxOneInsertOrDeleteInS1("", "p"));
        assertTrue(OneAway.checkForMaxOneInsertOrDeleteInS1("e", ""));
        
        assertTrue(OneAway.checkForMaxOneInsertOrDeleteInS1("bubble", "buble"));
        assertTrue(OneAway.checkForMaxOneInsertOrDeleteInS1("apple", "apples"));
        
        assertFalse(OneAway.isOneEditAway("abcdef", "abcfeda"));
    }
	
	@Test
	static void testIsOneEditAway() {
		assertTrue(OneAway.isOneEditAway("", ""));
	    assertTrue(OneAway.isOneEditAway("abc", "abc"));
        assertTrue(OneAway.isOneEditAway("pale", "bale"));
        assertFalse(OneAway.isOneEditAway("pale", "bake"));
        
        assertTrue(OneAway.isOneEditAway("pale", "pales"));
        assertFalse(OneAway.isOneEditAway("ram", "ramaaaaaaa"));
        
        assertTrue(OneAway.isOneEditAway("pale", "ple"));
        assertFalse(OneAway.isOneEditAway("ramaaaaaaa", "ram"));
        
    }
}
