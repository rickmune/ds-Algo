package com.rickmune.dsproblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * from https://github.com/saggi-swati/DataStructures/blob/master/app/src/test/java/ds/saggi/in/datastructures/booking/TrieDS.java
 */
public class TrieDS {

    class TrieNode {

        String s;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean endOfWord;

        TrieNode() {
        }

        public TrieNode(String s) {
            this.s = s;
        }

        private boolean isEndOfWord() {
            return endOfWord;
        }

        private void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        private <TrieNOde> Map<Character, TrieNode> getChildren() {
            return children;
        }

        void insert(String word) {
            TrieNode current = this;

            for (int i = 0; i < word.length(); i++) {
                current = current.getChildren()
                        .computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            current.setEndOfWord(true);
        }

        boolean find(String word) {
            TrieNode current = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.getChildren().get(ch);
                if (node == null) {
                    return false;
                }
                current = node;
            }
            return current.isEndOfWord();
        }
    }

    class Review {
        int index;
        int goodness;

        Review(int index, int goodness) {
            this.index = index;
            this.goodness = goodness;
        }
    }

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        if (A == null || A.isEmpty()) return new ArrayList<>();

        String[] goodWords = A.split("_");

        TrieNode root = new TrieNode();
        for (String word : goodWords) {
            root.insert(word);
        }

        Comparator<Review> comp = ((o1, o2) -> {
            if(o1.goodness == o2.goodness){
                return Integer.compare(o1.index, o2.index);
            }
            else return o2.goodness - o1.goodness;
        });

        ArrayList<Review> ret = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            String b = B.get(i);
            String[] reviewWords = b.split("_");
            int goodness = 0;
            for (String rw : reviewWords) {
                if (root.find(rw)) {
                    goodness++;
                }
            }
            ret.add(new Review(i, goodness));
        }

        ret.sort(comp);

        return ret.stream().map(r -> r.index).collect(Collectors.toCollection(ArrayList::new));
    }
}
