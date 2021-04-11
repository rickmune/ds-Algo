package com.rickmune.dsproblems;

import java.util.ArrayList;

/**
 * Given a number k, print the pascal's traingle with k rows.
 * Also, given a row and column, print the pascal triangle value
 */

public class Pascal {

    public static void main(String args[]) {
        System.out.println("Pascal :  printing pascal's traingle ");
        printPascalTraingle(6);

        System.out.println("Pascal : printing pascal's value");
        System.out.println(printPascalValue(4, 3));
    }

    private static void printPascalTraingle(int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int C = 1;
            ArrayList<Integer> x = new ArrayList<>();
            for (int j = 1; j <= i + 1; j++) {
                x.add(C);
                C = C * (i + 1 - j) / j;
            }
            list.add(x);
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static int printPascalValue(int r, int c) {
        if (c == 0 || r == c) {
            return 1;
        }

        return printPascalValue(r - 1, c) + printPascalValue(r - 1, c - 1);
    }
}
