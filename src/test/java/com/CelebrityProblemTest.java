package com;

import com.rampatra.arrays.CelebrityProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CelebrityProblemTest {

    private static int[][] noCelebrity;
    private static int[][] celebrityAtPosition0;
    private static int[][] celebrityAtPosition1;
    private static int[][] celebrityAtPosition2;
    private static int[][] celebrityAtPosition3;
    private static int[][] emptyPeoplesArray;
    private static int[][] peoplesArrayWithOnePerson;

    @BeforeAll
    static void initValue() {
        noCelebrity = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        celebrityAtPosition0 = new int[][]{
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };
        celebrityAtPosition1 = new int[][]{
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        };
        celebrityAtPosition2 = new int[][]{
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };
        celebrityAtPosition3 = new int[][]{
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        emptyPeoplesArray = new int[][]{};
        peoplesArrayWithOnePerson = new int[][]{{0}};
    }

    @Test
    public void testNoCelebrity() {
        Assertions.assertEquals(-1, CelebrityProblem.findCelebrity(noCelebrity));
    }

    @Test
    public void testCelebrityAtPosition0() {
        Assertions.assertEquals(0, CelebrityProblem.findCelebrity(celebrityAtPosition0));
    }

    @Test
    public void testCelebrityAtPosition1() {
        Assertions.assertEquals(1, CelebrityProblem.findCelebrity(celebrityAtPosition1));
    }

    @Test
    public void testCelebrityAtPosition2() {
        Assertions.assertEquals(2, CelebrityProblem.findCelebrity(celebrityAtPosition2));
    }

    @Test
    public void testCelebrityAtPosition3() {
        Assertions.assertEquals(3, CelebrityProblem.findCelebrity(celebrityAtPosition3));
    }

    @Test
    public void testEmptyPeoplesArray() {
        Assertions.assertEquals(-1, CelebrityProblem.findCelebrity(emptyPeoplesArray));
    }

    @Test
    public void testPeoplesArrayWithOnePerson() {
        Assertions.assertEquals(-1, CelebrityProblem.findCelebrity(peoplesArrayWithOnePerson));
    }
}