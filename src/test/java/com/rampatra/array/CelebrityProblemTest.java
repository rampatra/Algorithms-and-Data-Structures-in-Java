package com.rampatra.array;

import com.rampatra.arrays.CelebrityProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Project: Algorithms-and-Data-Structures-in-Java
 * Package: com.rampatra.array
 * <p>
 * This is the CelebrityProblemTest
 *
 * @Author: truongnd
 * @Date: 25/10/2021
 * @Time: 21:50
 */
public class CelebrityProblemTest {

    private static int [][] tc1;
    private static int [][] tc2;
    private static int [][] tc3;
    private static int [][] tc4;

    @BeforeAll
    static void initValue() {
        tc1 = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}, {0, 0, 1, 0}};
        tc2 = new int[][]{{0, 0, 0, 0}, {1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        tc3 = new int[][]{{0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
        tc4 = new int[][]{{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}};
    }

    @Test
    public void findCelebrity_tc1_hasNoCeleb() {
        Assertions.assertEquals(0, CelebrityProblem.findCelebrity(tc1));
    }

    @Test
    public void findCelebrity_tc2_celebAtFirstIndex() {
        Assertions.assertEquals(0, CelebrityProblem.findCelebrity(tc2));
    }

    @Test
    public void findCelebrity_tc3_celebAtSecondIndex() {
        Assertions.assertEquals(1, CelebrityProblem.findCelebrity(tc3));
    }

    @Test
    public void findCelebrity_tc4_celebAtThirdIndex() {
        Assertions.assertEquals(2, CelebrityProblem.findCelebrity(tc4));
    }
}
