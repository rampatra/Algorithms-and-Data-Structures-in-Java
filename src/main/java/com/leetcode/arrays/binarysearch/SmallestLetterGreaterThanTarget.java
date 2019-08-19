package com.leetcode.arrays.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Easy
 * Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * Description:
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find
 * the smallest element in the list that is larger than the given target.
 *
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 *
 * Examples:
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 *
 * Note:
 * - letters has a length in range [2, 10000].
 * - letters consists of lowercase letters, and contains at least 2 unique letters.
 * - target is a lowercase letter.
 *
 * @author rampatra
 * @since 2019-08-19
 */
public class SmallestLetterGreaterThanTarget {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/253061487/">0 ms</a>.
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0, hi = letters.length - 1;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return letters[low % letters.length];
    }

    public static void main(String[] args) {
        assertEquals('a', nextGreatestLetter(new char[]{'a'}, 'z'));
        assertEquals('b', nextGreatestLetter(new char[]{'a', 'b'}, 'a'));
        assertEquals('b', nextGreatestLetter(new char[]{'a', 'b', 'c'}, 'a'));
        assertEquals('a', nextGreatestLetter(new char[]{'a', 'b', 'c'}, 'z'));
        assertEquals('c', nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        assertEquals('f', nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        assertEquals('f', nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        assertEquals('b', nextGreatestLetter(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}, 'a'));
    }
}