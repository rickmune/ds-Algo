package com.rickmune.dsproblems;
import java.util.HashMap;

/**
 * Find first non repeating character in a String
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        findFirstNonRepeatingChar("repeatingcharacter");
        findFirstNonRepeatingChar2("repeatingcharacter");
    }

    private static void findFirstNonRepeatingChar(String s) {
        if (s == null) return;
        if (s.length() == 1) {
            System.out.println("FirstNonRepeatingCharacter.findFirstNonRepeatingChar -- " + s);
            return;
        }
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int val = 0;
            if (charCount.containsKey(c))
                val = charCount.get(c);

            charCount.put(c, val + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                System.out.println("FirstNonRepeatingCharacter.findFirstNonRepeatingChar -- " + s.charAt(i));
                break;
            }
        }
    }

    private static void findFirstNonRepeatingChar2(String s) {
        if (s == null) return;
        if (s.length() == 1) {
            System.out.println("FirstNonRepeatingCharacter.findFirstNonRepeatingChar -- " + s);
            return;
        }
        final int MAX = 256;
        int[] arr = new int[MAX];

        for (int i = 0; i < MAX; i++)
            arr[i] = -1;


        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (arr[c] == -1) {
                arr[c] = i;
            } else {
                arr[c] = -2;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < MAX; i++) {
            if (arr[i] > 0)
                res = arr[i] < res ? arr[i] : res;
        }

        if (res >= 0 && res < len)
            System.out.println("ExampleUnitTest.getFirstNonRepeatedCharInString -- " + s.charAt(res));
        else
            System.out.println("ExampleUnitTest.getFirstNonRepeatedCharInString -- Char not found");
    }
}
