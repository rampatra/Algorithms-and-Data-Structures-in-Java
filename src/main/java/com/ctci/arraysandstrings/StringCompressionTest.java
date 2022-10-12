package com.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionTest {
    @Test
    public void stringCompression_EmptyString() {
        String str = "";
        assertEquals(StringCompression.compressString(""), "");
    }

    @Test
    public void stringCompression_SingleCharacter() {
        String str = "a";
        assertEquals(StringCompression.compressString("a"), "a");
    }

    @Test
    public void stringCompression_NoConsecutiveCharacter() {
        String str = "abcdef";
        assertEquals(StringCompression.compressString("abcdef"), "abcdef");
    }

    @Test
    public void stringCompression_CompressedNotShorterThanOriginal() {
        String str = "aabbccddee";
        assertEquals(StringCompression.compressString("aabbccddee"), "aabbccddee");
    }

    @Test
    public void stringCompression_LowercaseNexttoUppercase() {
        String str = "aAbbBBBCCCCcccc";
        assertEquals(StringCompression.compressString("aAbbBBBCCCCcccc"), "a1A1b2B3C4c4");
    }

    @Test
    public void stringCompression_RandomString() {
        String str = "aabcccccccccccccccccccccccccaaa";
        assertEquals(StringCompression.compressString("aabcccccccccccccccccccccccccaaa"), "a2b1c25a3");
    }
}
