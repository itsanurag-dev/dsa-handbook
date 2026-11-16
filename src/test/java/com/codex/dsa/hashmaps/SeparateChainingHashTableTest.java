package com.codex.dsa.hashmaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeparateChainingHashTableTest {

    private SeparateChainingHashTable<String, Integer> map;

    @BeforeEach
    public void setUp() {
        // Small initial capacity to trigger dynamic rehashing early
        map = new SeparateChainingHashTable<>(4, 0.75);
    }

    @Test
    @DisplayName("Empty hash table initialization")
    public void testEmptyTable() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        assertNull(map.get("key"));
        assertFalse(map.containsKey("key"));
    }

    @Test
    @DisplayName("Put and get basic operations with collision handling")
    public void testPutAndGet() {
        assertNull(map.put("one", 1));
        assertNull(map.put("two", 2));
        assertNull(map.put("three", 3));

        assertEquals(3, map.size());
        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(3, map.get("three"));
    }

    @Test
    @DisplayName("Update existing key returns old value")
    public void testUpdateKey() {
        assertNull(map.put("alpha", 100));
        assertEquals(100, map.put("alpha", 200));
        assertEquals(200, map.get("alpha"));
        assertEquals(1, map.size());
    }

    @Test
    @DisplayName("Dynamic rehashing expands capacity and preserves all keys")
    public void testRehashing() {
        assertEquals(4, map.capacity());

        for (int i = 0; i < 20; i++) {
            map.put("key_" + i, i);
        }

        assertEquals(20, map.size());
        assertTrue(map.capacity() >= 32);

        for (int i = 0; i < 20; i++) {
            assertEquals(i, map.get("key_" + i));
            assertTrue(map.containsKey("key_" + i));
        }
    }

    @Test
    @DisplayName("Remove key handles head and interior chained entries")
    public void testRemove() {
        map.put("k1", 10);
        map.put("k2", 20);
        map.put("k3", 30);

        assertEquals(20, map.remove("k2"));
        assertNull(map.get("k2"));
        assertFalse(map.containsKey("k2"));
        assertEquals(2, map.size());

        assertNull(map.remove("nonexistent"));
        assertEquals(2, map.size());
    }

    @Test
    @DisplayName("Null key handling")
    public void testNullKey() {
        assertNull(map.put(null, 999));
        assertTrue(map.containsKey(null));
        assertEquals(999, map.get(null));
        assertEquals(999, map.remove(null));
        assertFalse(map.containsKey(null));
    }
}

