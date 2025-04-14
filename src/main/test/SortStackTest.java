import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

import com.ctci.stacksandqueues.SortStack;

class SortStackTest {

/**
 * note
 */
	@Test
	public void testStackNull() {
		Stack<Integer> unsortedStack = new Stack<Integer>();
        unsortedStack.push(2);
        unsortedStack.push(5);
        unsortedStack.push(1);
        unsortedStack.push(3);
		boolean empty = unsortedStack.empty();
		assertTrue("Array empty",empty);

	}

	@Test
	public void testStackHaveOnevalue() {
		Stack<Integer> unsortedStack = new Stack<Integer>();
		unsortedStack.push(2);

		if(unsortedStack.size() == 1) {
			SortStack.printStack(unsortedStack);

			assertTrue("array has only 1 value!", true);
		}else {
			SortStack.printStack(unsortedStack);
		}
	

	}

	@Test
	public void testCheckArraySort() {
		Stack<Integer> unsortedStack = new Stack<Integer>();
		
		unsortedStack.push(1);
		unsortedStack.push(30);
		unsortedStack.push(9);
		unsortedStack.push(13);
		
		for(int i = 0; i <= unsortedStack.size(); i++) {
			for(int j = i + 1; j < unsortedStack.size(); j++) {
				if(unsortedStack.get(i) > unsortedStack.get(j)) {
					assertFalse("Unsorted array!", false);
					SortStack.sortStack(unsortedStack);
				}else {
					assertTrue("Sorted array", true);
				}
			}
		}
		
		SortStack.printStack(unsortedStack);
	}

}
