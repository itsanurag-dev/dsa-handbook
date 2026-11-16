package com.codex.dsa.hashmaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LFUCacheTest {

    @Test
    @DisplayName("LFU cache evicts least frequently used key")
    public void testLFUEviction() {
        LFUCache<Integer, Integer> cache = new LFUCache<>(2);

        cache.put(1, 10);
        cache.put(2, 20);

        // Access key 1 -> freq(1) = 2, freq(2) = 1
        assertEquals(10, cache.get(1));

        // Insert key 3 -> capacity reached (2). Key 2 has freq 1, key 1 has freq 2. Key 2 evicted!
        cache.put(3, 30);

        assertNull(cache.get(2)); // Evicted
        assertEquals(10, cache.get(1));
        assertEquals(30, cache.get(3));
    }

    @Test
    @DisplayName("LFU cache breaks frequency ties using LRU policy")
    public void testTieBreakingWithLRU() {
        LFUCache<String, String> cache = new LFUCache<>(2);

        cache.put("A", "Alpha");
        cache.put("B", "Beta");

        // Both A and B have frequency 1. A was put first, B was put second.
        // Inserting C should evict A (least recently used among tie).
        cache.put("C", "Gamma");

        assertNull(cache.get("A")); // Evicted
        assertEquals("Beta", cache.get("B"));
        assertEquals("Gamma", cache.get("C"));
    }

    @Test
    @DisplayName("Updating existing key updates value and increments frequency without eviction")
    public void testUpdateKey() {
        LFUCache<Integer, Integer> cache = new LFUCache<>(2);

        cache.put(1, 100);
        cache.put(1, 101); // updates value, freq becomes 2

        assertEquals(101, cache.get(1)); // freq becomes 3
        cache.put(2, 200); // freq(2) = 1

        // Insert 3 -> evicts key 2
        cache.put(3, 300);
        assertNull(cache.get(2));
        assertEquals(101, cache.get(1));
    }
}

