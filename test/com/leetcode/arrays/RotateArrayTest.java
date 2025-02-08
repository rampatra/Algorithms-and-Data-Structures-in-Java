package com.leetcode.arrays;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class RotateArrayTest {

    @Test
    public void testRotateArray_whenRotateThreeStep() {
        // Given
        RotateArray rotateArray = new RotateArray();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] exepctedArr = {5, 6, 7, 1, 2, 3, 4};

        // When
        rotateArray.rotate(arr, 3);

        // Then
        assertArrayEquals(arr, exepctedArr);
    }

    @Test
    public void testRotateArray_whenRotateFourStepAndArrayHasOnlyOneElement() {
        // Given
        RotateArray rotateArray = new RotateArray();
        int[] arr = {1};
        int[] exepctedArr = {1};

        // When
        rotateArray.rotate(arr, 4);

        // Then
        assertArrayEquals(arr, exepctedArr);
    }
}
