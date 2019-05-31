package com.rampatra.arrays;

import java.util.ArrayList;
import java.util.List;

public class FlattenArray {

    /**
     * Given a nested array like [[1, 2], 3, [4]], return an array like [1, 2, 3, 4, 5].
     *
     * @param nestedArray an Object array
     * @return a list of all elements in the nestedArray but all at the same level
     */
    private static List<Integer> flattenArray(Object[] nestedArray) {
        if (nestedArray == null || nestedArray.length == 0) return new ArrayList<>();

        List<Integer> flattenedArray = new ArrayList<>();

        for (Object obj : nestedArray) {
            if (obj instanceof Object[]) {
                flattenedArray.addAll(flattenArray((Object[]) obj));
            } else if (obj instanceof Integer) {
                flattenedArray.add((Integer) obj);
            }
        }

        return flattenedArray;
    }

    public static void main(String[] args) {
        System.out.println(flattenArray(null));
        System.out.println(flattenArray(new Object[]{null}));
        System.out.println(flattenArray(new Object[]{new Object[]{}}));
        System.out.println(flattenArray(new Object[]{new Object[]{1, 2}}));
        System.out.println(flattenArray(new Object[]{1, 2, new Object[]{4, 5}, 6}));
        System.out.println(flattenArray(new Object[]{new Object[]{4, 5}, 1, 2, 6}));
        System.out.println(flattenArray(new Object[]{1, 2, 6, new Object[]{4, 5}}));
    }
}