package com.rickmune.dsproblems;

public class NumberConversion {
    public static void main(String[] args) {
        int num = 3859; // MMMDCCCLIX
        String romanNumber = "MMMDXLIX";
        System.out.println("NumberConversion.main : " + intToRoman(num));
    }

    private static String intToRoman(int num) {

        String s = "";
        String base = "";
        int n = 1;
        int x = 1;
        while (num > 0) {
            if (num > 3999) return null;

            if (num > 1000) {
                n = 1000;
                base = "M";
            } else if (num > 500) {
                if (num >= 900) {
                    n = 900;
                    base = "CM";
                } else {
                    n = 500;
                    base = "D";
                }
            } else if (num > 100) {
                if (num >= 400) {
                    n = 400;
                    base = "CD";
                } else {
                    n = 100;
                    base = "C";
                }
            } else if (num > 50) {
                if (num >= 90) {
                    n = 90;
                    base = "XC";
                } else {
                    n = 50;
                    base = "L";
                }
            } else if (num > 10) {
                if (num >= 40) {
                    n = 40;
                    base = "XL";
                } else {
                    n = 10;
                    base = "X";
                }
                num = num % 10;
            } else if (num > 5) {
                if (num == 9) {
                    n = 9;
                    base = "IX";
                } else {
                    n = 5;
                    base = "V";
                }
            } else if (num == 4) {
                s = s + "IV";
                return s;
            } else if (num == 3) {
                s = s + "III";
                return s;
            } else if (num == 2) {
                s = s + "II";
                return s;
            } else {
                s = s + "I";
                return s;
            }

            x = num / n;
            num = num % n;

            for (int i = 0; i < x; i++) {
                s = s + base;
            }
        }
        return s;

    }

    private static int romanToInt(String s) {
        int num = 0;

        if (s == null) return 0;

        if (s.length() == 1) return getBaseVal(s.charAt(0));

        int s1 = getBaseVal(s.charAt(0));
        for(int i = 1;i< s.length();i++) {

            int s2 = getBaseVal(s.charAt(i));


        }

        return num;
    }


    private static int getBaseVal(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return 0;
    }
}
