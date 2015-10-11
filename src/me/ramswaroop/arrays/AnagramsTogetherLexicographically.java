package me.ramswaroop.arrays;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 10/11/15
 * @time: 7:56 PM
 */
public class AnagramsTogetherLexicographically {

    /**
     * Takes an array of String {@param s} and prints anagrams in groups where the groups
     * are arranged lexicographically and the strings within each group are also arranged
     * lexicographically.
     *
     * @param s
     */
    public static void printAnagramsTogether(String[] s) {

        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        List<List<String>> output = new ArrayList<>();

        for (int i = 0; i < s.length; i++) {
            String removeSpaces = s[i].replaceAll("\\s+", "");
            char[] chars = removeSpaces.toCharArray();
            Arrays.sort(chars);

            List<Integer> indexes = hashMap.get(String.valueOf(chars));
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            hashMap.put(String.valueOf(chars), indexes);
        }

        for (Map.Entry<String, List<Integer>> entry : hashMap.entrySet()) {

            List<String> anagrams = new ArrayList<>();

            for (int i = 0; i < entry.getValue().size(); i++) {
                anagrams.add(s[entry.getValue().get(i)]);
            }

            // arrange anagrams lexicographically within a single line
            Collections.sort(anagrams);
            output.add(anagrams);
        }

        // the entire output should also be in lexicographic order
        Collections.sort(output, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }

    /**
     * Take list of strings from console and print anagrams in groups.
     *
     * @param a
     */
    public static void main(String a[]) {
        Scanner in = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        String s;
        // you should use in.hasNextLine()
        while (!(s = in.nextLine()).trim().equals("")) {
            strings.add(s);
        }
        printAnagramsTogether(strings.toArray(new String[0]));
    }
}
