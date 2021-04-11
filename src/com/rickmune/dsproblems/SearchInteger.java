package com.rickmune.dsproblems;

public class SearchInteger {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 2, 3243, 456567, 1232, 8766543, 223, 6523,
                4323, 6576, 223, 546, 2332, 54, 21, 7, 32, 78};

        int x = 1232;
        int n = arr.length;
        if (x == arr[n - 1]) {
            System.out.println("FOUND before loop");
            return;
        }
        int backup = arr[n - 1];
        arr[n - 1] = x;
        for (int i = 0; ; i++) {
            if (x == arr[i]) {
                arr[n - 1] = backup;

                if (i != n - 1) {
                    System.out.println("Found at " + i);
                    return;
                } else {
                    System.out.println("NOT found");
                    return;
                }
            }
        }

    }
}
