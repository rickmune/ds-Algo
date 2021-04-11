package com.rickmune.dsproblems;

/**
 * Given a list of numbers, write a function that would return the consecutive sequence
 * of that list that sums up to a specific number.
 */

public class SubArrayToSum {

    private static void findSubArrayForSum(int[] arr, int sum) {
        int i = 1, start = 0;
        int len = arr.length;
        int arrSum = arr[0];
        for(;i<len;i++) {
            while(arrSum > sum && start < i-1) {
                arrSum -= arr[start];
                start++;
            }

            if(arrSum == sum) {
                System.out.println("SubArrayToSum.findSubArrayForSum : from " + start + " to " + (i-1) );
                return;
            }

            arrSum+=arr[i];
        }
    }

    public static void main(String[] args) {
        int sum = 20;

        int[] arr = {10, 15, 19, 4, 7, 8, 1, 19, 16, 18, 1};
        findSubArrayForSum(arr, sum);
    }
}
