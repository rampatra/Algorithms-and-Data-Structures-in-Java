import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSort {
    @BeforeAll
    public static void BeforeAll() {
        System.out.println("Start All Test");
    }

    @AfterAll
    public static void AfterAll() {
        System.out.println("End All Test");
    }

    @BeforeEach
    public void BeforeEach() {
        System.out.println("Begin Test");
    }

    @AfterEach
    public void AfterEach() {
        System.out.println("After Test");
    }

    @Test
    @DisplayName("Default Test")
    void testArray() {
        int[] ar = {2, 5, 1, 7, 8};
        BubbleSort.bubbleSort(ar);
        int[] expected = {1, 2, 5, 7, 8};
        assertArrayEquals(expected, ar);
    }

    @Test
    @Tag("Array")
    @DisplayName("Test With Empty Array")
    public void testEmptyArray() {
        int[] ar = {};
        BubbleSort.bubbleSort(ar);
        int[] expected = {};
        assertArrayEquals(expected, ar);
    }

    @Test
    @Tag("Array")
    @DisplayName("Test With Duplicate Element")
    public void testDuplicateParameter() {
        int[] ar = {9, 5, 6, 0, 5, 6, 11, 2, 4};
        BubbleSort.bubbleSort(ar);
        int[] expected = {0, 2, 4, 5, 5, 6, 6, 9, 11};
        assertArrayEquals(expected, ar);
    }

    @Test
    @Tag("Array")
    @DisplayName("Test With Negative Integer Element")
    public void testSameArray() {
        int[] ar = {-1, -2, 5, 7, -8};
        BubbleSort.bubbleSort(ar);
        int[] expected = {-8, -2, -1, 5, 7};
        Assertions.assertArrayEquals(expected, ar);
    }

    @Test
    @Tag("Array")
    @DisplayName("Test With Array Reverse")
    public void testReverseArray() {
        int[] ar = {8, 7, 5, 2, 1};
        BubbleSort.bubbleSort(ar);
        int[] expected = {1, 2, 5, 7, 8};
        assertArrayEquals(expected, ar);
    }
}

