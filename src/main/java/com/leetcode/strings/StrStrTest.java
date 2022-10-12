package com.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrStrTest {
    @Test
    public void strStr_EdgeCase1() {
        String haystack = "";
        String needle = "";
        assertEquals(StrStr.strStr(haystack, needle), 0);
    }

    @Test
    public void strStr_EdgeCase2() {
        String haystack = "";
        String needle = "abc";
        assertEquals(StrStr.strStr(haystack, needle), -1);
    }

    @Test
    public void strStr_EdgeCase3() {
        String haystack = "aaaa";
        String needle = "";
        assertEquals(StrStr.strStr(haystack, needle), 0);
    }

    @Test
    public void strStr_EdgeCase4() {
        String haystack = "aaa";
        String needle = "aaaa";
        assertEquals(StrStr.strStr(haystack, needle), -1);
    }

    @Test
    public void strStr_RandomCase1_NotFound() {
        String haystack = "aaaa";
        String needle = "bba";
        assertEquals(StrStr.strStr(haystack, needle), -1);
    }

    @Test
    public void strStr_RandomCase2_Found() {
        String haystack = "mississippi";
        String needle = "issip";
        assertEquals(StrStr.strStr(haystack, needle), 4);
    }

    @Test
    public void strStr_RandomCase3_Found() {
        String haystack = "duuuuuuy";
        String needle = "u";
        assertEquals(StrStr.strStr(haystack, needle), 1);
    }
}
