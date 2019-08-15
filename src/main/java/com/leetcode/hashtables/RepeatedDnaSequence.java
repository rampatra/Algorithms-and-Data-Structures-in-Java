package com.leetcode.hashtables;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/repeated-dna-sequences/submissions/
 * Problem Description:
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When
 * studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * TODO: Figure another method which would have a better runtime.
 *
 * @author rampatra
 * @since 2019-07-29
 */
public class RepeatedDnaSequence {

    /**
     * Rabin-Karp Algorithm: https://brilliant.org/wiki/rabin-karp-algorithm/
     * Following Rabin-Karp's approach let's you avoid spurious hits (worst case scenario) but once the hash matches,
     * you will have to compare and check the string you're searching. I tried to just rely on the hash and few test
     * cases failed for me (https://leetcode.com/submissions/detail/247342702/).
     * <p>
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/247343438/">38 ms</a>.
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();

        Set<String> repeatedSequences = new HashSet<>();
        Map<Long, Set<String>> hashToStringMap = new HashMap<>();
        long hashOfSequence = computeHash(s);
        hashToStringMap.put(hashOfSequence, new HashSet<String>() {{
            add(s.substring(0, 10));
        }});

        long pow = (long) Math.pow(4, 9);

        for (int i = 10; i < s.length(); i++) {
            hashOfSequence = (hashOfSequence - (pow * (s.charAt(i - 10) - 'A'))) * 4 + (s.charAt(i) - 'A');
            String subString = s.substring(i - 10 + 1, i + 1);

            if (hashToStringMap.get(hashOfSequence) != null && hashToStringMap.get(hashOfSequence).contains(subString)) {
                repeatedSequences.add(subString);
                continue;
            }

            hashToStringMap.putIfAbsent(hashOfSequence, new HashSet<>());
            hashToStringMap.get(hashOfSequence).add(subString);
        }

        return new ArrayList<>(repeatedSequences);
    }

    private static long computeHash(String s) {
        long hash = 0;
        for (int i = 0; i < 10; i++) {
            hash += (Math.pow(4, i) * (s.charAt(9 - i) - 'A'));
        }
        return hash;
    }

    public static void main(String[] args) {
        assertEquals(new ArrayList<>(),
                findRepeatedDnaSequences("AAAAACCC"));

        assertEquals(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"),
                findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

        assertEquals(Collections.singletonList("AAAAAAAAAA"),
                findRepeatedDnaSequences("AAAAAAAAAAAA"));

        assertEquals(Collections.singletonList("BBBBBBBBBB"),
                findRepeatedDnaSequences("BBBBBBBBBBBB"));
    }
}