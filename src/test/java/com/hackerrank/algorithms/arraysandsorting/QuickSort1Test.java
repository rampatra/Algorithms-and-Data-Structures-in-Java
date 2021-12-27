package com.hackerrank.algorithms.arraysandsorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class QuickSort1Test {
	
	QuickSort2 quickSort2 = new QuickSort2();
	
	@Test
	public void tesInsertIntoSorted1() {
		int[] inputArr = new int[] {10, 2, 15, 3, 7, 6, 20};
		int[] inputResult = new int[] {2, 3, 6, 7, 10, 15, 20};
		QuickSort2.quickSort(inputArr, 0, 6);
		assertArrayEquals(inputResult, inputArr);
	}

	@Test
	public void tesInsertIntoSorted2() {
		int[] inputArr = new int[] {-101, -100, -99, -95, -97, -96, -98};
		int[] inputResult = new int[] {-101,-100, -99, -98, -97, -96, -95};
		QuickSort2.quickSort(inputArr, 0, 6);
		assertArrayEquals(inputResult, inputArr);
	}

}
