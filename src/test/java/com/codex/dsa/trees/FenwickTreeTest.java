package com.codex.dsa.trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FenwickTreeTest {

    @Test
    @DisplayName("Fenwick tree prefix sum and range query matches expected values")
    public void testPrefixAndRangeQuery() {
        int[] arr = {3, 2, -1, 6, 5, 4, -3, 3};
        FenwickTree bit = new FenwickTree(arr);

        assertEquals(3, bit.queryPrefix(0));
        assertEquals(5, bit.queryPrefix(1)); // 3 + 2
        assertEquals(4, bit.queryPrefix(2)); // 3 + 2 - 1

        // Range [2, 5] -> -1 + 6 + 5 + 4 = 14
        assertEquals(14, bit.queryRange(2, 5));
    }

    @Test
    @DisplayName("Point update modifies prefix sums dynamically in O(log N)")
    public void testPointUpdate() {
        int[] arr = {1, 2, 3, 4, 5};
        FenwickTree bit = new FenwickTree(arr);

        assertEquals(15, bit.queryRange(0, 4));

        // Add 5 to index 2 (element 3 becomes 8)
        bit.add(2, 5);

        assertEquals(20, bit.queryRange(0, 4));
        assertEquals(11, bit.queryPrefix(2)); // 1 + 2 + 8 = 11
        assertEquals(8, bit.queryRange(2, 2));
    }

    @Test
    @DisplayName("Invalid indices throw IndexOutOfBoundsException")
    public void testBounds() {
        FenwickTree bit = new FenwickTree(5);
        assertThrows(IndexOutOfBoundsException.class, () -> bit.add(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> bit.add(5, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> bit.queryRange(3, 1));
    }
}

