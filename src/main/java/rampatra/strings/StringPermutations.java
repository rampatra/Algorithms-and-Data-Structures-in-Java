package rampatra.strings;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/24/15
 * @time: 2:27 PM
 * @see: http://www.ericleschinski.com/c/java_permutations_recursion/
 * @see: http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
 * @see: me.ramswaroop.strings.StringPermutationCount for a modification of this problem
 */
public class StringPermutations {

    /**
     * Generates and prints all possible permutations (in order) 
     * of string {@param s}.
     * 
     * @param prefix
     * @param s
     */
    public static void printAllPermutations(String prefix, String s) {
        int len = s.length();
        if (len == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < len; i++) {
                printAllPermutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    public static void main(String a[]) {
        printAllPermutations("", "a");
        System.out.println("-------");
        printAllPermutations("", "ab");
        System.out.println("-------");
        printAllPermutations("", "abc");
    }
}
