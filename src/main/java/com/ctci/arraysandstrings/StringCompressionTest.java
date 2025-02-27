package com.ctci.arraysandstrings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {
    @Test
    void case1() {
        String input = "";
        String expectedOutput = "";
        String actualOutput = compressString(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void case2() {
        String input = "abc";
        String expectedOutput = "abc";
        String actualOutput = compressString(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void case3() {
        String input = "aaabbccc";
        String expectedOutput = "a3b2c3";
        String actualOutput = compressString(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void case4() {
        String input = "aaabbbccc";
        String expectedOutput = "a3b3c3";
        String actualOutput = compressString(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void case5() {
        String input = "abcd";
        String expectedOutput = "abcd";
        String actualOutput = compressString(input);
        assertEquals(expectedOutput, actualOutput);
    }


    private static String compressString(String str) {
        StringBuilder compressedSb = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result. */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedSb.append(str.charAt(i));
                compressedSb.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressedSb.length() < str.length() ? compressedSb.toString() : str;
    }
}