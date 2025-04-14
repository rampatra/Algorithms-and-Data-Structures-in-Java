package com.leetcode.arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SearchInsertPositionTest {
    @Test
    public void testTargetFound() {
        assertEquals(2, SearchInsertPosition.searchInsert(new int[]{1,3,5,6}, 5));
    }

    @Test
    public void testInsertPosition() {
        assertEquals(1, SearchInsertPosition.searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    public void testInsertAtEnd() {
        assertEquals(4, SearchInsertPosition.searchInsert(new int[]{1,3,5,6}, 7));
    }

    @Test
    public void testInsertAtBeginning() {
        assertEquals(0, SearchInsertPosition.searchInsert(new int[]{1,3,5,6}, 0));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, SearchInsertPosition.searchInsert(new int[]{}, 3));
    }
}