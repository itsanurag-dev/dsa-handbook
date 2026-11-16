package com.codex.dsa.trie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {

    @Test
    @DisplayName("Insert, search, and startsWith verification")
    public void testBasicTrieOperations() {
        Trie trie = new Trie();

        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));

        trie.insert("app");
        assertTrue(trie.search("app"));
        assertEquals(2, trie.size());
    }

    @Test
    @DisplayName("Prefix counting tracks words sharing common prefix")
    public void testPrefixCount() {
        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("caterpillar");
        trie.insert("catalog");
        trie.insert("dog");

        assertEquals(3, trie.countWordsWithPrefix("cat"));
        assertEquals(1, trie.countWordsWithPrefix("d"));
        assertEquals(0, trie.countWordsWithPrefix("z"));
    }

    @Test
    @DisplayName("Delete word removes word and updates prefix counts without corrupting branches")
    public void testDelete() {
        Trie trie = new Trie();

        trie.insert("hero");
        trie.insert("her");

        assertEquals(2, trie.countWordsWithPrefix("her"));

        assertTrue(trie.delete("her"));
        assertFalse(trie.search("her"));
        assertTrue(trie.search("hero"));
        assertEquals(1, trie.countWordsWithPrefix("her"));
        assertEquals(1, trie.size());

        assertFalse(trie.delete("nonexistent"));
    }
}

