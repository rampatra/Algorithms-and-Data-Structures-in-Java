package com.ctci.arraysandstrings;

import org.junit.jupiter.api.*;

public class IsUniqueTest {

    @Nested
    @DisplayName("Test cases for isAllCharactersUniqueAndInASCII()")
    class TestCasesForIsAllCharactersUniqueAndInASCII{

        @Test
        public void isAllCharactersUniqueAndInASCII_StringIsNull_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII(null));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_StringIsEmpty_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII(""));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_StringLengthSmallerOrEqual128_ReturnFalse() {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 128; i++) {
                stringBuilder.append((char) i);
            }
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII(stringBuilder.toString()));

            stringBuilder.setLength(0);
            for (int i = 1; i < 127; i++) {
                stringBuilder.append((char) i);
            }
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII(stringBuilder.toString()));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_StringLengthLargerThan128_ReturnFalse() {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 128; i++) {
                stringBuilder.append((char) i);
            }
            stringBuilder.append("a");

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII(stringBuilder.toString()));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_DuplicateAtHead_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aab"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("AAb"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("ááb"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("ÁÁb"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("1123456"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_DuplicateAtMiddle_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("abcbd"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aBcBd"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aưcưd"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aƯcƯd"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("123436"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_DuplicateAtTail_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("aba"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("AbA"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("ăbă"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("ĂbĂ"));

            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("1234566"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_OnlyOneCharacter_ReturnTrue() {
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("a"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("1"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("A"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("#"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_OnlyOneCharacter_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("á"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("Ô"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("€"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_InvalidString_ReturnFalse() {
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("€á"));
            Assertions.assertFalse(IsUnique.isAllCharactersUniqueAndInASCII("áÂ"));
        }

        @Test
        public void isAllCharactersUniqueAndInASCII_ValidString_ReturnTrue() {
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("aAb"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("abcBd"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII("abA"));
            Assertions.assertTrue(IsUnique.isAllCharactersUniqueAndInASCII(
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
        }
    }
}
