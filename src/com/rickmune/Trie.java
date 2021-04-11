package com.rickmune;

import java.util.HashMap;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)) curr.children.put(c, new TrieNode(c));
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private TrieNode getNode(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) return null;
            curr = curr.children.get(c);
        }
        return curr;
    }


    public static class TrieNode {
        public boolean isWord;
        public char c;
        public HashMap<Character, TrieNode> children;

        public TrieNode(char c) {
            this.c = c;
            isWord = false;
            children = new HashMap<Character, TrieNode>();
        }
    }
}
