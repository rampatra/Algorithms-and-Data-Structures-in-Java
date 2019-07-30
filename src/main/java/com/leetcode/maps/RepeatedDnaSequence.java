package com.leetcode.maps;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author rampatra
 * @since 2019-07-29
 */
public class RepeatedDnaSequence {

    /**
     * Rabin-Karp Algorithm: https://brilliant.org/wiki/rabin-karp-algorithm/
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