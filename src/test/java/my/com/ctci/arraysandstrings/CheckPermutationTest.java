package my.com.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPermutationTest {
    @Test
    public void testIsOnePermutationOfOther_SameStrings() {
        assertEquals(true, CheckPermutation.isOnePermutationOfOther("ram", "mar"));
    }

    @Test
    public void testIsOnePermutationOfOther_DifferentLengths() {
        assertFalse(CheckPermutation.isOnePermutationOfOther("rama", "mar"));
    }

    @Test
    public void testIsOnePermutationOfOther_CaseSensitive() {
        assertFalse(CheckPermutation.isOnePermutationOfOther("rama", "marA"));
    }

    @Test
    public void testIsOnePermutationOfOtherGivenThatStringsContainOnlyAscii_SameStrings() {
        assertTrue(CheckPermutation.isOnePermutationOfOtherGivenThatStringsContainOnlyAscii("ram", "mar"));
    }

    @Test
    public void testIsOnePermutationOfOtherGivenThatStringsContainOnlyAscii_DifferentLengths() {
        assertFalse(CheckPermutation.isOnePermutationOfOtherGivenThatStringsContainOnlyAscii("rama", "mar"));
    }

}