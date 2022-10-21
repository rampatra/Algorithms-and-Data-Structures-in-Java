package com.rampatra.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {
    @Test
    public void testWithEmptyArray() {
        int[] array = {};
        int[] expectedArray = {};

        QuickSort.quickSort(array);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testWithOneElementArray() {
        int[] array = {9};
        int[] expectedArray = {9};

        QuickSort.quickSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testWithAnArray() {
        int[] array = {897, 695, 101, 377, 859, 176, 515, 613, 154, 978, 797, 136, 575, 577, 232, 118, 301, 951, 679, 114};
        int[] expectedArray = {101, 114, 118, 136, 154, 176, 232, 301, 377, 515, 575, 577, 613, 679, 695, 797, 859, 897, 951, 978};
        QuickSort.quickSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testWithSortedArray() {
        int[] array = {101, 114, 118, 136, 154, 176, 232, 301, 377, 515, 575, 577, 613, 679, 695, 797, 859, 897, 951, 978};
        int[] expectedArray = {101, 114, 118, 136, 154, 176, 232, 301, 377, 515, 575, 577, 613, 679, 695, 797, 859, 897, 951, 978};
        QuickSort.quickSort(array);

        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testWithSortedReverseArray() {
        int[] array = {978, 951, 897, 859, 797, 695, 679, 613, 577, 575, 515, 377, 301, 232, 176, 154, 136, 118, 114, 101};
        int[] expectedArray = {101, 114, 118, 136, 154, 176, 232, 301, 377, 515, 575, 577, 613, 679, 695, 797, 859, 897, 951, 978};
        QuickSort.quickSort(array);

        assertArrayEquals(expectedArray, array);
    }
}
