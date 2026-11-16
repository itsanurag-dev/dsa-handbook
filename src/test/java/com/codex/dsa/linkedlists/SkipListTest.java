package com.codex.dsa.linkedlists;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SkipListTest {

    @Test
    @DisplayName("Insert and contains in ordered SkipList")
    public void testInsertAndContains() {
        SkipList<Integer> list = new SkipList<>();

        assertTrue(list.isEmpty());
        list.insert(15);
        list.insert(5);
        list.insert(25);
        list.insert(10);

        assertEquals(4, list.size());
        assertTrue(list.contains(5));
        assertTrue(list.contains(10));
        assertTrue(list.contains(15));
        assertTrue(list.contains(25));
        assertFalse(list.contains(99));
    }

    @Test
    @DisplayName("Duplicate insertion is ignored")
    public void testDuplicates() {
        SkipList<Integer> list = new SkipList<>();
        list.insert(42);
        list.insert(42);
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Delete removes node and updates level pointers")
    public void testDelete() {
        SkipList<Integer> list = new SkipList<>();
        int[] vals = {10, 20, 30, 40, 50};
        for (int v : vals) list.insert(v);

        assertTrue(list.delete(30));
        assertFalse(list.contains(30));
        assertEquals(4, list.size());

        assertFalse(list.delete(999));
        assertEquals(4, list.size());
    }
}

