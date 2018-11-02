package rampatra.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 11/1/15
 * @time: 8:53 PM
 */
public class ArrangeNosToFormBiggestNo {

    /**
     * Sorts no.s in array {@param a} such that if you form a number {@code n}
     * by concatenating digits in order a[0]....a[size], it results being the
     * largest number possible.
     * <p/>
     * For example,
     * I/P: {54, 546, 548, 60}
     * O/P: {60, 548, 546, 54} i.e, 6054854654
     * <p/>
     * I/P: {1, 34, 3, 98, 9, 76, 45, 4}
     * O/P: {9, 98, 76, 45, 4, 34, 3, 1} i.e, 998764543431
     *
     * @param a
     * @return
     */
    public static Integer[] arrangeArrayOfNosToFormBiggestNo(Integer[] a) {

        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.parseInt(o1 + "" + o2) > Integer.parseInt(o2 + "" + o1) ? -1 : 1;
            }
        });

        return a;
    }

    public static void main(String a[]) {
        System.out.println(Arrays.toString(arrangeArrayOfNosToFormBiggestNo(new Integer[]{45, 567, 12, 1})));
        System.out.println(Arrays.toString(arrangeArrayOfNosToFormBiggestNo(new Integer[]{54, 546, 548, 60})));
        System.out.println(Arrays.toString(arrangeArrayOfNosToFormBiggestNo(new Integer[]{1, 34, 3, 98, 9, 76, 45, 4})));
    }
}
