package com.codex.dsa.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Concept:
 * An interview-grade Trie (Prefix Tree) supporting Unicode / dynamic alphabet.
 * Tracks both full word termination and the count of words sharing each prefix.
 * Supports insert, search, startsWith, prefix count, and full word deletion.
 *
 * Time Complexity:
 * - insert(word): O(L) where L is length of word.
 * - search(word): O(L)
 * - startsWith(prefix): O(L)
 * - countPrefix(prefix): O(L)
 * - delete(word): O(L)
 *
 * Space Complexity:
 * - O(N * L * Sigma) worst case, where N is word count, L is average length, Sigma is alphabet size.
 */
public class Trie {

    public static class TrieNode {
        public final Map<Character, TrieNode> children;
        public boolean isEndOfWord;
        public int prefixCount;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
            this.prefixCount = 0;
        }
    }

    private final TrieNode root;
    private int wordCount;

    public Trie() {
        this.root = new TrieNode();
        this.wordCount = 0;
    }

    public int size() {
        return wordCount;
    }

    public boolean isEmpty() {
        return wordCount == 0;
    }

    /**
     * Inserts a word into the Trie.
     */
    public void insert(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word cannot be null");
        }
        TrieNode curr = root;
        curr.prefixCount++;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            curr = curr.children.computeIfAbsent(ch, c -> new TrieNode());
            curr.prefixCount++;
        }

        if (!curr.isEndOfWord) {
            curr.isEndOfWord = true;
            wordCount++;
        }
    }

    /**
     * Returns true if the word is in the Trie.
     */
    public boolean search(String word) {
        if (word == null) return false;
        TrieNode node = findNode(word);
        return node != null && node.isEndOfWord;
    }

    /**
     * Returns true if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        return findNode(prefix) != null;
    }

    /**
     * Returns how many words in the Trie share the given prefix.
     */
    public int countWordsWithPrefix(String prefix) {
        if (prefix == null) return 0;
        TrieNode node = findNode(prefix);
        return node == null ? 0 : node.prefixCount;
    }

    private TrieNode findNode(String str) {
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            curr = curr.children.get(ch);
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }

    /**
     * Deletes a word from the Trie if present.
     * Returns true if the word was present and removed, false otherwise.
     */
    public boolean delete(String word) {
        if (word == null || !search(word)) {
            return false;
        }
        deleteHelper(root, word, 0);
        wordCount--;
        return true;
    }

    private boolean deleteHelper(TrieNode curr, String word, int index) {
        curr.prefixCount--;

        if (index == word.length()) {
            curr.isEndOfWord = false;
            return curr.children.isEmpty();
        }

        char ch = word.charAt(index);
        TrieNode child = curr.children.get(ch);
        boolean shouldDeleteChild = deleteHelper(child, word, index + 1);

        if (shouldDeleteChild && !child.isEndOfWord) {
            curr.children.remove(ch);
            return curr.children.isEmpty() && !curr.isEndOfWord;
        }

        return false;
    }
}

