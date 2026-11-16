package com.codex.dsa.trees;

/**
 * Concept:
 * A Fenwick Tree (or Binary Indexed Tree / BIT) is an implicit tree structure represented as an array.
 * Each index stores the sum of a range of elements determined by the least significant bit (LSB)
 * of the index: LSB(i) = i & (-i).
 * It enables computing prefix sums and updating individual values in logarithmic time with minimal code
 * and zero pointer overhead.
 *
 * Time Complexity:
 * - Point Update: O(log N)
 * - Prefix Sum Query [0, i]: O(log N)
 * - Range Sum Query [l, r]: O(log N)
 * - Construction: O(N) linear build
 *
 * Space Complexity:
 * - O(N) array storage.
 */
public class FenwickTree {

    private final int size;
    private final long[] tree;

    public FenwickTree(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Tree size must be positive: " + n);
        }
        this.size = n;
        this.tree = new long[n + 1]; // 1-based indexing internally
    }

    public FenwickTree(int[] array) {
        this(array.length);
        // O(N) linear construction
        for (int i = 0; i < size; i++) {
            tree[i + 1] += array[i];
            int parent = (i + 1) + ((i + 1) & -(i + 1));
            if (parent <= size) {
                tree[parent] += tree[i + 1];
            }
        }
    }

    /**
     * Adds delta to the element at 0-based index.
     */
    public void add(int index, long delta) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int i = index + 1; // convert to 1-based
        while (i <= size) {
            tree[i] += delta;
            i += i & (-i);
        }
    }

    /**
     * Computes the prefix sum from index 0 to index (inclusive, 0-based).
     */
    public long queryPrefix(int index) {
        if (index < 0) return 0;
        if (index >= size) index = size - 1;

        long sum = 0;
        int i = index + 1;
        while (i > 0) {
            sum += tree[i];
            i -= i & (-i);
        }
        return sum;
    }

    /**
     * Computes range sum [l, r] (inclusive, 0-based).
     */
    public long queryRange(int l, int r) {
        if (l < 0 || r >= size || l > r) {
            throw new IndexOutOfBoundsException("Invalid range: [" + l + ", " + r + "]");
        }
        return queryPrefix(r) - queryPrefix(l - 1);
    }
}

