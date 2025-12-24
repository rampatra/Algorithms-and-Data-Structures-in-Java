package test;

import com.rampatra.sorting.BubbleSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {
    @Test
    public void testWithEmptyArray(){
        int[] inputArray = {};
        int[] expectOutput = {};
        BubbleSort.bubbleSort(inputArray);
        assertArrayEquals(expectOutput, inputArray);
    }

    @Test
    public void testWithOneValue(){
        int[] inputArray = {100};
        int[] expectOutput = {100};
        BubbleSort.bubbleSort(inputArray);
        assertArrayEquals(expectOutput, inputArray);
    }

    @Test
    public void testWithAnCompletedArray(){
        int[] inputArray = {3,2,5,1,4,7,9,0};
        int[] expectOutput = {0,1,2,3,4,5,7,9};
        BubbleSort.bubbleSort(inputArray);
        assertArrayEquals(expectOutput, inputArray);
    }

    @Test
    public void testWithSortedArray(){
        int[] inputArray = {0,1,2,3,4,5,7,9};
        int[] expectOutput = {0,1,2,3,4,5,7,9};
        BubbleSort.bubbleSort(inputArray);
        assertArrayEquals(expectOutput, inputArray);
    }
}
