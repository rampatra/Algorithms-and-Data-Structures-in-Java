package com.leetcode.arrays.binarysearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.leetcode.arrays.binarysearch.SearchInsertPosition;

/**
 * Unit tests for SearchInsertPosition.
 */
class SearchInsertPositionTest {

    @Test
    void test_targetFound() {
        int[] nums = {1, 3, 5, 6};
        assertEquals(2, SearchInsertPosition.searchInsert(nums, 5));
    }

    @Test
    void test_targetSmallerThanAll() {
        int[] nums = {10, 20, 30, 40};
        assertEquals(0, SearchInsertPosition.searchInsert(nums, 5));
    }

    @Test
    void test_targetGreaterThanAll() {
        int[] nums = {10, 20, 30, 40};
        assertEquals(4, SearchInsertPosition.searchInsert(nums, 50));
    }

    @Test
    void test_targetBetweenTwoElements() {
        int[] nums = {1, 3, 5, 6};
        assertEquals(1, SearchInsertPosition.searchInsert(nums, 2));
    }

    @Test
    void test_emptyArray() {
        int[] nums = {};
        assertEquals(0, SearchInsertPosition.searchInsert(nums, 7));
    }

    @Test
    void test_nullArray_throwsException() {
        int[] nums = null;
        assertThrows(IllegalArgumentException.class,
                () -> SearchInsertPosition.searchInsert(nums, 1));
    }
}
