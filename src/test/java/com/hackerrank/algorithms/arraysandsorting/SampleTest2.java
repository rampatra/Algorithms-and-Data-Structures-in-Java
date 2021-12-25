package com.hackerrank.algorithms.arraysandsorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class SampleTest2 {
	InsertionSort1 insertionSort1 = new InsertionSort1();
	@Test
	public void tesInsertIntoSorted() {
		int[] inputArr = new int[] {1,2,4};
		int[] inputResult = new int[] {1,2,4};
		insertionSort1.insertIntoSorted(inputArr);
		assertArrayEquals(inputResult, inputArr);
	}
	
	@Test
	public void tesInsertIntoSorted2() {
		int[] inputArr     = new int[] {1,6,4};
		int[] inputResult = new int[] {1, 4, 6};
		insertionSort1.insertIntoSorted(inputArr);
		assertArrayEquals(inputResult, inputArr);
	}

}
