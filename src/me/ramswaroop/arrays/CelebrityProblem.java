package me.ramswaroop.arrays;

import me.ramswaroop.common.LinkedStack;
import me.ramswaroop.common.Stack;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 10/2/15
 * @time: 10:48 PM
 */
public class CelebrityProblem {

    /**
     * Checks if person {@param a} knows person {@param b}.
     *
     * @param peoples
     * @param a
     * @param b
     * @return
     */
    public static boolean haveAcquaintance(int[][] peoples, int a, int b) {
        return peoples[a][b] == 1;
    }

    /**
     * Finds the celebrity in {@param peoples} where
     * peoples[i][j] is 1 when person i knows person j.
     *
     * @param peoples
     * @return
     */
    public static int findCelebrity(int[][] peoples) {

        Stack<Integer> possibleCelebrities = new LinkedStack<>();

        for (int i = 0; i < peoples.length; i++) {
            for (int j = 0; j < peoples[0].length; j++) {
                if (haveAcquaintance(peoples, i, j)) {
                    possibleCelebrities.push(j);
                }
            }
        }

        int firstPerson = -1, secondPerson;
        while (!possibleCelebrities.isEmpty()) {
            firstPerson = possibleCelebrities.pop();

            // we have found the celebrity
            if (possibleCelebrities.isEmpty()) break;

            secondPerson = possibleCelebrities.pop();
            if (haveAcquaintance(peoples, firstPerson, secondPerson)) {
                possibleCelebrities.push(secondPerson);
            } else {
                possibleCelebrities.push(firstPerson);
            }
        }

        return firstPerson;
    }

    public static void main(String a[]) {
        System.out.println(findCelebrity(new int[][]{{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}}));
        System.out.println(findCelebrity(new int[][]{{0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}}));
    }
}
