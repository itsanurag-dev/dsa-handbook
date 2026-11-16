package com.codex.dsa.trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SegmentTreeTest {

    @Test
    @DisplayName("Range sum query matches linear sum")
    public void testRangeSumQuery() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        // Sum of [1, 3] = 3 + 5 + 7 = 15
        assertEquals(15, st.queryRange(1, 3));
        // Sum of entire array [0, 5] = 36
        assertEquals(36, st.queryRange(0, 5));
    }

    @Test
    @DisplayName("Lazy propagation range update updates segments correctly")
    public void testLazyRangeUpdate() {
        int[] arr = {1, 2, 3, 4, 5};
        SegmentTree st = new SegmentTree(arr);

        // Add 10 to range [1, 3] -> arr becomes {1, 12, 13, 14, 5}
        st.updateRange(1, 3, 10);

        assertEquals(1, st.queryRange(0, 0));
        assertEquals(12, st.queryRange(1, 1));
        assertEquals(39, st.queryRange(1, 3)); // 12 + 13 + 14 = 39
        assertEquals(45, st.queryRange(0, 4)); // 1 + 12 + 13 + 14 + 5 = 45
    }

    @Test
    @DisplayName("Invalid range throws IndexOutOfBoundsException")
    public void testInvalidRange() {
        SegmentTree st = new SegmentTree(new int[]{1, 2, 3});
        assertThrows(IndexOutOfBoundsException.class, () -> st.queryRange(-1, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> st.queryRange(1, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> st.queryRange(2, 1));
    }
}

