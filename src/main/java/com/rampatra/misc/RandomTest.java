package com.rampatra.misc;

import java.util.Random;

/**
 * @author rampatra
 * @since 2/23/15
 */
public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(1));
        System.out.println(randInt(0, 1, false));
        //System.out.print(randInts(1, 0));
    }

    public static int randInt(int start, int end, boolean startInclusive) {
        int diff = end - start;
        if (start < 0 || end < 0 || diff <= 0) return -1;

        Random random = new Random();
        if (startInclusive) {
            return random.nextInt(diff + 1) + start;
        } else {
            return random.nextInt(diff) + start + 1;
        }
    }

    public static int randInt(int max, int exclude) {
        // some validation
        if (max <= 0) return -1;
        Random random = new Random();
        int randInt = random.nextInt(max);
        if (randInt == exclude) {
            return (randInt == max) ? randInt - 1 : randInt + 1;
        } else {
            return randInt;
        }
    }

    public static int[] randInts(int max, int exclude) {
        int[] randInts = new int[2];
        randInts[0] = randInt(max, exclude);
        do {
            randInts[1] = randInt(max, exclude);
        } while ((randInts[0] != -1 & randInts[1] != -1) && (randInts[0] == randInts[1]));

        return randInts;
    }
}
