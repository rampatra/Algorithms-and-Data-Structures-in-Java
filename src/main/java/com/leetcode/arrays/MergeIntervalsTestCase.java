package com.leetcode.arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
*
* @author: quangrandz
* @since: 2023-6-30
*/

public class MergeIntervalsTestCase {
	
	@BeforeAll
    public static void beforeAll() {
        System.out.println("BEFORE ALL");
    }
    
    @AfterAll
    public static void afterAll() {
        System.out.println("AFTER ALL");
    }
    
    @BeforeEach
    public void beforeEach() {
        System.out.println("BEFORE EACH");
    }
    
    @AfterEach
    public void afterEach() {
        System.out.println("AFTER EACH");
    }
	
	// Test case 1: Non-overlapping intervals
	@Test
	public void testMerge_NonOverlapping() {
		int[][] intervals = {{1, 3}, {4, 6}, {7, 9}};
        int[][] expected = {{1, 3}, {4, 6}, {7, 9}};
        Assertions.assertArrayEquals(expected, MergeIntervals.merge(intervals));
	}
	
	// Test case 2: Overlapping intervals
	@Test
	public void testMerge_Overlapping() {
		int[][] intervals = {{1, 4}, {2, 5}, {6, 8}};
        int[][] expected = {{1, 5}, {6, 8}};
        Assertions.assertArrayEquals(expected, MergeIntervals.merge(intervals));
	}
	
	// Test case 3: Empty input
	@Test
	public void testMerge_EmptyInput() {
		int[][] intervals = {};
        int[][] expected = {};
        Assertions.assertArrayEquals(expected, MergeIntervals.merge(intervals));
	}
	
	// Test case 4: Single interval
	@Test
	public void testMerge_SingleInterval() {
		int[][] intervals = {{2, 6}};
        int[][] expected = {{2, 6}};
        Assertions.assertArrayEquals(expected, MergeIntervals.merge(intervals));
	}
	
	// Test case 5: Overlapping intervals with different orders
	@Test
	public void testMerge_DifferentOrders() {
		int[][] intervals = {{9, 12}, {1, 4}, {6, 8}, {2, 5}};
        int[][] expected = {{1, 5}, {6, 8}, {9, 12}};
        Assertions.assertArrayEquals(expected, MergeIntervals.merge(intervals));
	}

	// Test case 6: There are many overlapping time periods
	@Test
	public void testMerge_ManyOverlapping() {
		int[][] intervals = {{1, 4}, {2, 5}, {3, 8}, {6, 9}};
	    int[][] expected = {{1, 9}};
	    Assertions.assertArrayEquals(expected, MergeIntervals.merge(intervals));
	}
}
