package com.rampatra.arrays;

import com.rampatra.base.LinkedStack;
import com.rampatra.base.Stack;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 10/2/15
 * @time: 10:48 PM
 * <p/>
 * In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes,
 * (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger
 * (celebrity) in minimum number of questions.
 * <p>
 * TODO: Not tested.
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
     * <p/>
     * Algorithm:
     * - If A knows B, then A can’t be celebrity. Discard A, but B may be celebrity.
     * - If A does not know B, then B can’t be celebrity. Discard B, but A may be celebrity.
     * - Repeat above two steps till we left with only one person.
     * Find celebrity within remaining persons by performing the below operations:
     * - Push all the celebrities into a stack.
     * - Pop off top two persons from the stack, discard one person based on return status of HaveAcquaintance(A, B).
     * - Push the remained person onto stack.
     * - Repeat step 2 and 3 until only one person remains in the stack.
     * - Check the remained person in stack does not have acquaintance with anyone else.
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

    public static void main(String[] args) {
        System.out.println(findCelebrity(new int[][]{{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}}));
        System.out.println(findCelebrity(new int[][]{{0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}}));
    }
}
