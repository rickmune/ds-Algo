package com.rickmune.dsproblems;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

// Remove duplicates from array of integer maintaining original order.

public class ArrayDuplicates {

    public static void main(String[] args) {
        int[] arr = {6, 8, 1, 4, 1, 7, 1, 7, 2, 5, 4, 9, 6};
        System.out.println(Arrays.toString(removeDuplicates(arr)));
        System.out.println(Arrays.toString(removeDuplicatesJava8(arr)));

    }

    private static int[] removeDuplicates(int[] arr) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int value : arr) {
            set.add(value);
        }
        int[] a = new int[set.size()];
        int i = 0;
        for (int val : set)
            a[i++] = val;

        return a;

    }

    private static int[] removeDuplicatesJava8(int[] arr) {
        LinkedHashSet<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
