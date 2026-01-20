package com.ctci.stacksandqueues;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

class SortStackTest {

	@Test
	void testCase1() {
		Stack<Integer> unsortedStack = new Stack<>();
		unsortedStack.push(2);
		unsortedStack.push(5);
		unsortedStack.push(1);
		unsortedStack.push(3);
		SortStack.sortStack(unsortedStack);		
		assertEquals(1,unsortedStack.pop());
		assertEquals(2,unsortedStack.pop());
		assertEquals(3,unsortedStack.pop());	
		assertEquals(5,unsortedStack.pop());
	}
	
	@Test
	void testCase2() {
		Stack<Integer> unsortedStack = new Stack<>();
		SortStack.sortStack(unsortedStack);		
		assertTrue(unsortedStack.isEmpty());
	}	
	
	@Test
	void testCase3() {
		Stack<Integer> unsortedStack = new Stack<>();
		unsortedStack.push(5);
		unsortedStack.push(3);
		unsortedStack.push(2);		
		unsortedStack.push(1);		
		SortStack.sortStack(unsortedStack);		
		assertEquals(1,unsortedStack.pop());
		assertEquals(2,unsortedStack.pop());
		assertEquals(3,unsortedStack.pop());
		assertEquals(5,unsortedStack.pop());
	}

}
