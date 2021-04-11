package com.rickmune;

import java.util.*;

public class Anagrams {

    public static boolean isAnagram(String s, String t) {
        System.out.println("\nisAnagram");
        long st = System.nanoTime();
        if (s.length() != t.length()) {
            System.out.printf("%d", System.nanoTime() - st);
            return false;
        }

        int []count= new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) return false;
        }

        for(int i = 0; i < 256; i++)
            if (count[i] != 0) {
                System.out.printf("%d", System.nanoTime() - st);
                return false;
            }
        System.out.printf("%d", System.nanoTime() - st);
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        System.out.println("\nisAnagram2");
        long st = System.nanoTime();
        if (s.length() != t.length()) {
            System.out.printf("%d", System.nanoTime() - st);
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                System.out.printf("%d", System.nanoTime() - st);
                return false;
            }
        }
        System.out.printf("%d", System.nanoTime() - st);
        return true;
    }

    public static boolean isAnagram3(String s, String t) {
        System.out.println("\nisAnagram3");
        long st = System.nanoTime();
        if(s.length()!=t.length()){System.out.printf("%d", System.nanoTime() - st);return false;}
        int sl=s.length();
        s = s.toLowerCase();
        t = t.toLowerCase();

        HashMap<Character,Integer> smap=new HashMap<>();
        for(int i=0;i<sl;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
        }
        for(char c:smap.keySet()){
            if(smap.get(c)!=0){System.out.printf("%d", System.nanoTime() - st);return false;}
        }
        System.out.printf("%d", System.nanoTime() - st);
        return true;
    }

    public static boolean isAnagram4(String s, String t) {
        System.out.println("\nisAnagram4");
        long st = System.nanoTime();
        if (s.length() != t.length()) {
            System.out.printf("%d", System.nanoTime() - st);
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        System.out.printf("%d", System.nanoTime() - st);
        return Arrays.equals(str1, str2);
    }

    public static boolean isAnagram1ms(String s, String t) {
        System.out.println("\nisAnagram1ms");
        long st = System.nanoTime();
        if(s.length() != t.length()) {
            System.out.printf("%d", System.nanoTime() - st);
            return false;
        }

        int[] count = new int[26];

        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            if(--count[c - 'a'] < 0) {
                System.out.printf("%d", System.nanoTime() - st);
                return false;
            }
        }
        System.out.printf("%d", System.nanoTime() - st);
        return true;
    }

    public static List<Integer> allAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if (s.isEmpty()) return indices;
        int pLen = p.length();
        for (int i = 0; i < s.length(); i++) {
            if (i + pLen <= s.length() && isAnagram2(s.substring(i, i + pLen), p)) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        //System.out.printf("\nIs Anagram: %b", isAnagram3("Hello", "hello"));
        //System.out.printf("\nIs Anagram: %b", isAnagram("cart", "rat"));
        //System.out.printf("\nIs Anagram: %b", isAnagram2("car", "rat"));
        //System.out.printf("\nIs Anagram: %b", isAnagram2("cart", "rat"));
        System.out.printf("\nIs Anagram: %b", isAnagram1ms("cart", "rat"));

        //System.out.printf("\nmake Anagram: %d", makeAnagram("showman", "woman"));
        //System.out.printf("\nallAnagrams: %s", allAnagrams("cbaebabacd", "abc").toString());
    }

    private static int makeAnagram(String a, String b) {

        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) - 1);
        }

        for (char c : map.keySet()) {
            count += Math.abs(map.getOrDefault(c, 0));
        }
        return count;
    }

    public List<Integer> findAnagrams85ms(String s, String p) {
        int sl = s.length();
        int pl = p.length();

        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> pm = new HashMap<>();

        for(Character ch : p.toCharArray()){
            if(pm.containsKey(ch)){
                pm.put(ch, pm.get(ch) + 1);
            } else {
                pm.put(ch, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < sl; i++){
            char ch = s.charAt(i);
            if(sm.containsKey(ch)){
                sm.put(ch, sm.get(ch) + 1);
            } else {
                sm.put(ch, 1);
            }


            if(i >= pl){
                ch = s.charAt(i - pl);
                if(sm.get(ch) == 1){
                    sm.remove(ch);
                } else {
                    sm.put(ch, sm.get(ch) - 1);
                }
            }

            if(pm.equals(sm)){
                result.add(i - pl + 1);
            }
        }
        return result;
    }

    public List<Integer> findAnagrams3ms(String s, String p) {
        int[] map = new int[26];
        for(int i=0;i<p.length();++i) {
            map[p.charAt(i)-'a']++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0,j=0;i<s.length();++i) {
            int idx = s.charAt(i) - 'a';
            map[idx]--; // add the new character
            if(i>=p.length()) map[s.charAt(j++)-'a']++; // if the length is greater than windows length, pop the left charcater in the window

            boolean finish = true;
            for(int k=0;k<26;k++)
                if(map[k]!=0){ // if it is not an anagram of string p
                    finish = false;
                    break;
                }

            if(i>=p.length()-1 && finish)
                res.add(j);
        }
        return res;
    }
}
