package com.rickmune.dsproblems;

public class Parenthesis {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Possible combination of total " + n + " pair of parenthesis");
        printParentheses(3);
    }

    private static void printParentheses(int n) {
        char[] str = new char[2*n];
        _printParentheses(str, n, 0, 0, 0);
    }

    private static void _printParentheses(char[] str, int n, int pos, int open, int close) {
        if(close == n) {
            System.out.println(String.valueOf(str));
        } else {
            if(open > close) {
                str[pos] = ')';
                _printParentheses(str, n, pos+1, open, close+1);
            }
            if(open < n ){
                str[pos] = '(';
                _printParentheses(str, n, pos+1, open+1, close);
            }
        }
    }
}
