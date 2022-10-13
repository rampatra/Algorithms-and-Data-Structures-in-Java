package com.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrStrTest {
    @Test
    public void testEdgeCase1() {
        String haystack = "";
        String needle = "";
        assertEquals(StrStr.strStr(haystack, needle), 0);
    }

    @Test
    public void testEdgeCase2() {
        String haystack = "";
        String needle = "abc";
        assertEquals(StrStr.strStr(haystack, needle), -1);
    }

    @Test
    public void testEdgeCase3() {
        String haystack = "aaaa";
        String needle = "";
        assertEquals(StrStr.strStr(haystack, needle), 0);
    }

    @Test
    public void testEdgeCase4() {
        String haystack = "aaa";
        String needle = "aaaa";
        assertEquals(StrStr.strStr(haystack, needle), -1);
    }

    @Test
    public void testRandomCase1NotFound() {
        String haystack = "aaaa";
        String needle = "bba";
        assertEquals(StrStr.strStr(haystack, needle), -1);
    }

    @Test
    public void testRandomCase2Found() {
        String haystack = "mississippi";
        String needle = "issip";
        assertEquals(StrStr.strStr(haystack, needle), 4);
    }

    @Test
    public void testRandomCase3Found() {
        String haystack = "duuuuuuy";
        String needle = "u";
        assertEquals(StrStr.strStr(haystack, needle), 1);
    }
}
