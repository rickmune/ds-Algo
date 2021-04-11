package com.rickmune.dsproblems;

public class SlidingWindow {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 2, 32, 45, 12, 87, 22, 5, 43, 67, 23, 54, 33, 54, 21, 7, 32, 78};

        int k = 6;
        int n = arr.length;

        int max = 0;
        for (int i = 0; i < k; i++)
            max += arr[i];

        int res = max;
        for (int i = k; i < n; i++) {
            res = res + arr[i] - arr[i - k];
            max = Math.max(res, max);
        }

        System.out.println("SlidingWindow.main: " + max);
    }
}
