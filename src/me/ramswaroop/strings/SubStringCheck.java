package me.ramswaroop.strings;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 10/20/15
 * @time: 1:15 PM
 * @see: me.ramswaroop.strings.StringRotation for a similar problem.
 */
public class SubStringCheck {

    /**
     * Naive approach to determine whether string {@param s2} is a
     * substring of string {@param s1}.
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isSubString(String s1, String s2) {
        char[] c1 = s1.toCharArray(),
                c2 = s2.toCharArray();
        int l1 = c1.length,
                l2 = c2.length,
                i, j;

        for (i = 0; i <= l1 - l2; i++) {
            for (j = 0; j < l2 && i + j < l1; j++) {
                if (c1[i + j] != c2[j]) break;
            }
            if (j == l2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String a[]) {
        System.out.println(isSubString("ramswaroop", "ramswaroop"));
        System.out.println(isSubString("ramswaroop", ""));
        System.out.println(isSubString("ramswaroop", "ram"));
        System.out.println(isSubString("ramswaroop", "rams"));
        System.out.println(isSubString("ramswaroop", "ramss"));
        System.out.println(isSubString("ramswaroop", "ar"));
    }
}
