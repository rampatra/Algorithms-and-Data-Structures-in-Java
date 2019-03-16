package com.rampatra.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 7/21/15
 * @time: 2:52 PM
 */
public class ReservoirSampling {

    /**
     * Returns {@param k} non-repeating random numbers from {@param stream}
     * using reservoir sampling method.
     * <p/>
     * Explanation:
     * 1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
     * 2) Now one by one consider all items from (k+1)th item to nth item.
     * a) Generate a random number from 0 to i where i is index of current item in
     * stream[]. Let the generated random number is j.
     * b) If j is in range 0 to k-1, replace reservoir[j] with arr[i].
     * <p>
     * In the above procedure, we are computing random number for each of the indexes greater than k
     * thereby giving all items an equal probability.
     * <p>
     * NOTE: When {@param k} is small enough we can use a simpler method as follows:
     * Create an array reservoir[] of maximum size k. One by one randomly select an
     * item from stream[0..n-1]. If the selected item is not previously selected, then
     * put it in reservoir[]. To check if an item is previously selected or not, we
     * need to search the item in reservoir[].
     * The time complexity of this algorithm will be O(k^2). This can be costly
     * if k is big. Also, this is not efficient if the input is in the form of a stream.
     *
     * @param stream
     * @param k
     * @return
     */
    public static int[] getKRandomNumbers(int[] stream, int k) {
        int i;
        int[] reservoir = new int[k];

        for (i = 0; i < k; i++) {
            reservoir[i] = stream[i];
        }

        for (; i < stream.length; i++) {
            int rand = new Random().nextInt(i);

            if (rand < k) {
                reservoir[rand] = stream[i];
            }
        }

        return reservoir;

    }

    public static void main(String[] args) {
        int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(getKRandomNumbers(stream, 4)));
    }
}
