package com.rickmune.dsproblems;

import java.util.Arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] arr = {10, -15, 19, -4, -7, -8, 1, 19, 16, -18, 1, 16};
        int k = 39;

        leftRotate(arr, 3);
        System.out.println("left rotate : " + Arrays.toString(arr));
        rightRotate(arr, 3);
        System.out.println("right rotate : " + Arrays.toString(arr));
    }

    private static void leftRotate(int[] arr, int d) {

        int n = arr.length;
        if (d > arr.length) d = d % arr.length;
        if (d % n == 0) return;

        int i, j, k;
        int gcd = gcd(n, d);
        for (i = 0; i < gcd; i++) {
            int temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i) break;      // K is back to start. hence break.

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }

    }

    private static void rightRotate(int[] arr, int d) {
        int n = arr.length;
        if (d > arr.length) d = d % arr.length;
        if (d % n == 0) return;

        d = n - d;
        leftRotate(arr, d);

    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
