package com.hackerrank.tutorials.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Question: https://www.hackerrank.com/challenges/ctci-ransom-note
 * Level: Easy
 *
 * @author rampatra
 * @version 30/09/2016
 */
public class RansomNote {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {

        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        String[] magazineWords = magazine.split(" ");
        String[] noteWords = note.split(" ");
        Integer c;

        for (int i = 0; i < magazineWords.length; i++) {
            if ((c = magazineMap.get(magazineWords[i])) == null) {
                magazineMap.put(magazineWords[i], 1);
            } else {
                magazineMap.put(magazineWords[i], c + 1);
            }
        }

        for (int i = 0; i < noteWords.length; i++) {
            if ((c = noteMap.get(noteWords[i])) == null) {
                noteMap.put(noteWords[i], 1);
            } else {
                noteMap.put(noteWords[i], c + 1);
            }
        }
    }

    public boolean solve() {
        for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {
            if (magazineMap.get(entry.getKey()) == null || magazineMap.get(entry.getKey()) - entry.getValue() < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        if (s.solve()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
