package com.rampatra.arrays;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 11/1/15
 */
public class ArrangeNosToFormBiggestNo {

    /**
     * Sorts {@code numbers} such that if you form a number {@code n}
     * by concatenating digits in order a[0]....a[size], it results being the
     * largest number possible.
     * <p/>
     * For example,
     * I/P: {54, 546, 548, 60}
     * O/P: {60, 548, 546, 54}, i.e, 6054854654
     * <p/>
     * I/P: {1, 34, 3, 98, 9, 76, 45, 4}
     * O/P: {9, 98, 76, 45, 4, 34, 3, 1}, i.e, 998764543431
     *
     * @param numbers input integer array
     * @return integer array where if you concatenate all its elements, you will get the largest number
     */
    private static Integer[] arrangeArrayOfNosToFormBiggestNo(Integer[] numbers) {

        Arrays.sort(numbers, (o1, o2) -> Integer.parseInt(o1 + "" + o2) >= Integer.parseInt(o2 + "" + o1) ? -1 : 1);

        /*
            Use the below version (without lambda) if you use JDK < 8
        
            Arrays.sort(numbers, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.parseInt(o1 + "" + o2) >= Integer.parseInt(o2 + "" + o1) ? -1 : 1;
                }
            });
        */
        return numbers;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrangeArrayOfNosToFormBiggestNo(new Integer[]{45, 567, 12, 1})));
        System.out.println(Arrays.toString(arrangeArrayOfNosToFormBiggestNo(new Integer[]{54, 546, 548, 60})));
        System.out.println(Arrays.toString(arrangeArrayOfNosToFormBiggestNo(new Integer[]{1, 34, 3, 98, 9, 76, 45, 4})));
    }
}