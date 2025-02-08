package com.leetcode.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
*
* @author: quangrandz
* @since: 2023-6-30
*/


public class AnagramsTestCase {
	@BeforeAll
    public static void beforeAll() {
        System.out.println("BEFORE ALL");
    }
    
    @AfterAll
    public static void afterAll() {
        System.out.println("AFTER ALL");
    }
    
    @BeforeEach
    public void beforeEach() {
        System.out.println("BEFORE EACH");
    }
    
    @AfterEach
    public void afterEach() {
        System.out.println("AFTER EACH");
    }
    
    @Test
    public void testFindAllAnagramsInText() {
        String text = "cbaebabacd";
        String pattern = "abc";
        List<Integer> expected = Arrays.asList(0, 6);
        
        List<Integer> result = AnagramsInString.findAllAnagramsInText(text, pattern);
        
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    public void testFindAllAnagramsInText_NoAnagramFound() {
        String text = "abcd";
        String pattern = "xyz";
        List<Integer> expected = Collections.emptyList();
        
        List<Integer> result = AnagramsInString.findAllAnagramsInText(text, pattern);
        
        Assertions.assertEquals(expected, result);
    }
    
    @Test
    public void testFindAllAnagramsInText_EmptyText() {
        String text = "";
        String pattern = "abc";
        List<Integer> expected = Collections.emptyList();
        
        List<Integer> result = AnagramsInString.findAllAnagramsInText(text, pattern);
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindAllAnagramsInText_EmptyPattern() {
        String text = "abc";
        String pattern = "";
        List<Integer> expected = Arrays.asList(1,2,3);
        
        List<Integer> result = AnagramsInString.findAllAnagramsInText(text, pattern);
        
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindAllAnagramsInText_LongPattern() {
        String text = "cbaebabacd";
        String pattern = "abcabcabc";
        List<Integer> expected = Collections.emptyList();
        
        List<Integer> result = AnagramsInString.findAllAnagramsInText(text, pattern);
        
        Assertions.assertEquals(expected, result);
    }

    
    
}
