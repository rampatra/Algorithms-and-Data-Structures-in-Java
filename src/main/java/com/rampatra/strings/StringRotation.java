package com.rampatra.strings;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 10/21/15
 * @time: 10:06 AM
 * @see: me.ramswaroop.strings.SubString for a similar problem.
 */
public class StringRotation {

    /**
     * Determines if string {@param s2} is a rotation of string {@param s1}.
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isStringRotation(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int l1 = c1.length,
                l2 = c2.length,
                i, j, k;

        for (i = 0; i < l1; i++) {
            for (j = 0; j < l2 && i + j < l1; j++) {
                if (c1[i + j] != c2[j]) break;
            }
            k = 0;
            while (k < l1 && j < l2) {
                if (c1[k++] != c2[j]) break;
                j++;
            }
            if (j == l2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String a[]) {
        System.out.println(isStringRotation("ramswaroop", "swaroopram"));
        System.out.println(isStringRotation("ramswaroop", "swaroopramramram"));
        System.out.println(isStringRotation("ramswaroop", "mswaroopra"));
        System.out.println(isStringRotation("ramswaroop", "swarooppram"));
        System.out.println(isStringRotation("ramswaroop", ""));
        System.out.println(isStringRotation("mswaroopra", "ramswaroop"));
        System.out.println(isStringRotation("amam", "mama"));
    }
}
