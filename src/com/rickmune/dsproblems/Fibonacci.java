package com.rickmune.dsproblems;

public class Fibonacci {
    private static int MAX = 25;
    private static int[] fib = new int[MAX];

    public static void main(String[] args) {
        System.out.println("Fibonacci.printNFibonacciNumber " + fib(20));

        System.out.println("Fibonacci.printNFibonacciNumber " + fibIterative(20));

        for (int i = 0; i < MAX; i++) {
            fib[i] = -1;
        }

        System.out.println("Fibonacci.printNFibonacciNumber " + fibDPRecursive(20));
    }

    private static int fib(int n) {
        if (n <= 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    private static int fibIterative(int n) {

        int[] fib = new int[MAX];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    private static int fibDPRecursive(int n) {
        if (n <= 1) return 1;

        if (fib[n] == -1)
            fib[n] = fibDPRecursive(n - 1) + fibDPRecursive(n - 2);
        return fib[n];

    }
}
