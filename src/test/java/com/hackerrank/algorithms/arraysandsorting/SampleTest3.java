package com.hackerrank.algorithms.arraysandsorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SampleTest3 {
    InsertionSort1 insertionSort1 = new InsertionSort1();
	@Test
	public void tesInsertIntoSorted() {
		int[] inputArr = new int[] {1,2,4};
		int[] inputResult = new int[] {1,2,4};
		InsertionSort1.insertIntoSorted(inputArr);
		assertArrayEquals(inputResult, inputArr);
	}
	
	@Test
	public void tesInsertIntoSorted2() {
		int[] inputArr = new int[] {1,6,4};
		int[] inputResult = new int[] {1, 4, 6};
		InsertionSort1.insertIntoSorted(inputArr);
		assertArrayEquals(inputResult, inputArr);
	}
}
