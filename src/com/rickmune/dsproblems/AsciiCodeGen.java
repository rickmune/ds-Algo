package com.rickmune.dsproblems;
/**
 * Given a integer , return corresponding ASCII char representation without using language building in feature.
 * ex. input interger 1234, return "1234" in string or characters
 */

public class AsciiCodeGen {

    public static void main(String[] args) {
        String str = "asciicodegen";
        System.out.println("\"" + str + "\" == " + asciiCodeGen(str));

        //System.out.println("\"3256\" == " + convertStringToNumber("3256"));
        //System.out.println("\"4598\" == " + convertStringToNumber("4598"));
    }

    private static String asciiCodeGen(String str) {
        String result = "";
        char[] c = str.toCharArray();
        for (char ci : c) {
            result = result + (int) ci;
        }

        return result;
    }

    private static int convertStringToNumber(String numStr) {

        char[] ch = numStr.toCharArray();
        int sum = 0;
        //get ascii value for zero
        int zeroAscii = (int) '0';
        for (char c : ch) {
            int tmpAscii = (int) c;
            sum = (sum * 10) + (tmpAscii - zeroAscii);
        }
        return sum;
    }
}
