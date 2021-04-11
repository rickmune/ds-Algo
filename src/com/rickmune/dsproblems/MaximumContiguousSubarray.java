package com.rickmune.dsproblems;

/**
 * Find the max sum of the contiguous array and also print the max contiguous array.
 */

public class MaximumContiguousSubarray {

    private static void maxContSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        int start = 0, end = 0, temp = 0;

        for (int i = 0; i < arr.length; i++) {
            res = res + arr[i];

            if (max < res) {
                max = res;
                start = temp;
                end = i;
            }

            if (res < 0) {
                res = 0;
                temp = i + 1;
            }
        }

        System.out.println("Max sum  = " + max);
        System.out.println("Start index = " + start);
        System.out.println("End Index = " + end);

        System.out.println("Printing contiguous array");

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, -15, 19, -4, -7, -8, 1, 19, 16, -18, 1};
        maxContSubArray(arr);
    }
}
