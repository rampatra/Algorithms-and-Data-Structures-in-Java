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
    public static boolean isPersonAKnowPersonB(int[][] peoples, int a, int b) {
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
     * - Pop off top two persons from the stack, discard one person based on return status of isPersonAKnowPersonB(A, B).
     * - Push the remained person onto stack.
     * - Repeat step 2 and 3 until only one person remains in the stack.
     * - Check the remained person in stack does not have acquaintance with anyone else.
     *
     * @param peoples
     * @return
     */
    public static int findCelebrity(int[][] peoples) {

        Stack<Integer> possibleCelebrities = new LinkedStack<>();

        for (int a = 0; a < peoples.length; a++) {
            for (int b = 0; b < peoples[0].length; b++) {
                if (isPersonAKnowPersonB(peoples, a, b)) {
                    possibleCelebrities.push(b);
                }
            }
        }

        int personA = -1;
        int personB;
        while (!possibleCelebrities.isEmpty()) {
            personA = possibleCelebrities.pop();

            // we have found the celebrity
            if (possibleCelebrities.isEmpty()) break;

            personB = possibleCelebrities.pop();
            if (isPersonAKnowPersonB(peoples, personA, personB)) {
                possibleCelebrities.push(personB);
            } else {
                possibleCelebrities.push(personA);
            }
        }

        return personA;
    }

    public static void main(String[] args) {
        int[][] people1 = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };

        int[][] people2 = {
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        };

        System.out.println(findCelebrity(people1));
        System.out.println(findCelebrity(people2));
    }
}
