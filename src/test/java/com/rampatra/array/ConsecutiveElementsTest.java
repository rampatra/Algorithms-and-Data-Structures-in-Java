package com.rampatra.array;

import com.rampatra.arrays.ConsecutiveElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Project: Algorithms-and-Data-Structures-in-Java
 * Package: com.rampatra.array
 * <p>
 * This is the ConsecutiveElements Test
 *
 * @Author: truongnd
 * @Date: 29/10/2021
 * @Time: 22:07
 */
public class ConsecutiveElementsTest {

    private int [] trueOne;
    private int [] duplicateOne;
    private int [] falseOne;

    @BeforeEach
    public void initTrueOne() {
        trueOne = new int[]{5, 4, 3, 2, 1};
    }

    @Test
    public void areConsecutiveElements_tc1_returnTrue() {
        Assertions.assertTrue(ConsecutiveElements.areConsecutiveElements(trueOne));
    }

    @BeforeEach
    public void initDuplicateOne() {
        duplicateOne = new int[]{5, 4, 3, 3, 2, 1};
    }

    @Test
    public void areConsecutiveElements_tc1_returnFalse_duplicate() {
        Assertions.assertFalse(ConsecutiveElements.areConsecutiveElements(duplicateOne));
    }

    @BeforeEach
    public void initFalseOne() {
        falseOne = new int[]{5, 10, 3, 2, 1};
    }

    @Test
    public void areConsecutiveElements_tc1_returnFalse() {
        Assertions.assertFalse(ConsecutiveElements.areConsecutiveElements(falseOne));
    }
}
