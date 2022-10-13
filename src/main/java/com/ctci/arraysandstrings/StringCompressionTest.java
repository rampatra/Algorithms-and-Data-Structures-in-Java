package com.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionTest {
    @Test
    public void testEmptyString() {
        String str = "";
        assertEquals(StringCompression.compressString(str), "");
    }

    @Test
    public void testSingleCharacter() {
        String str = "a";
        assertEquals(StringCompression.compressString(str), "a");
    }

    @Test
    public void testNoConsecutiveCharacter() {
        String str = "abcdef";
        assertEquals(StringCompression.compressString(str), "abcdef");
    }

    @Test
    public void testCompressedNotShorterThanOriginal() {
        String str = "aabbccddee";
        assertEquals(StringCompression.compressString(str), "aabbccddee");
    }

    @Test
    public void testLowercaseNexttoUppercase() {
        String str = "aAbbBBBCCCCcccc";
        assertEquals(StringCompression.compressString(str), "a1A1b2B3C4c4");
    }

    @Test
    public void testRandomString() {
        String str = "aabcccccccccccccccccccccccccaaa";
        assertEquals(StringCompression.compressString(str), "a2b1c25a3");
    }
}
