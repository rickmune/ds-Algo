package com.rickmune.dsproblems;

import java.util.Arrays;
import java.util.HashSet;

public class CommonElements {

    public static void main(String[] args) {

        findCommonElements(new int[]{10, 8, 3, 2, 4, 6, 10}, new int[]{10, 1, 9, 3, 5, 7, 8}, new int[]{11, 10, 3, 5, 7, 9, 1});
    }

    private static void findCommonElements(int[] a, int[] b, int[] c) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int i : a) {
            set1.add(i);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int i : b) {
            set2.add(i);
        }

        HashSet<Integer> set3 = new HashSet<>();
        for (int i : c) {
            set3.add(i);
        }

        set1.retainAll(set2);
        set1.retainAll(set3);

        System.out.println("CommonElements.findCommonElements"
                + " -- " + Arrays.toString(set1.toArray())
        );

    }
}
