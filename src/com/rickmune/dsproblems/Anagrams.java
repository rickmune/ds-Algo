package com.rickmune.dsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    private static ArrayList<ArrayList<String>> anagrams(final List<String> a) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            char[] c = a.get(i).toCharArray();
            Arrays.sort(c);
            String t = String.valueOf(c);
            if (map.get(t) == null) {
                ArrayList<String> l = new ArrayList<>();
                l.add(a.get(i));
                map.put(t, l);
            } else
                map.get(t).add(a.get(i));
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("cat");
        a.add("dog");
        a.add("god");
        a.add("odg");
        a.add("atc");
        ArrayList<ArrayList<String>> result = anagrams(a);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(
                    Arrays.toString(result.get(i).toArray()));
        }
    }
}
