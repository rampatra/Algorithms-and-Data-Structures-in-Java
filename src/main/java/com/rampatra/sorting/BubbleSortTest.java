package BubbleSort;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BubbleSortTest {
	   @Test
	    public void shouldDoNothingWithEmptyArray() {
	        int[] values = {};
	 
	        BubbleSort.bubbleSort(values);
	    }
	 
	    @Test
	    public void shouldDoNothingWithOneElementArray() {
	        int[] values = {16};
	 
	        BubbleSort.bubbleSort(values);
	 
	        assertArrayEquals(new int[] {16}, values);
	    }
	 
	    @Test
	    public void shouldSortValues() {
	        int[] values = { 11, -4, 3, 0, 1};
	        int[] expectedOrder = { -4, 0, 1, 3, 11};
	 
	        BubbleSort.bubbleSort(values);
	 
	        assertArrayEquals(expectedOrder, values);
	    }
}
