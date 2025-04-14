package InsertionSort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class InsertionSort2Test {
	   @Test
	    public void shouldDoNothingWithEmptyArray() {
	        int[] values = {};
	 
	        InsertionSort2.insertionSortPart2(values);
	    }
	 
	    @Test
	    public void shouldDoNothingWithOneElementArray() {
	        int[] values = {16};
	 
	        InsertionSort2.insertionSortPart2(values);
	 
	        assertArrayEquals(new int[] {16}, values);
	    }
	 
	    @Test
	    public void shouldSortValues() {
	        int[] values = { 11, -4, 3, 0, 1};
	        int[] expectedOrder = { -4, 0, 1, 3, 11};
	 
	        InsertionSort2.insertionSortPart2(values);
	 
	        assertArrayEquals(expectedOrder, values);
	    }
}
