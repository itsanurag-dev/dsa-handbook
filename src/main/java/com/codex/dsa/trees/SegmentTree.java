package com.codex.dsa.trees;

/**
 * Concept:
 * A Segment Tree is a binary tree data structure used for storing intervals or segments.
 * It allows querying which segments contain a given point and querying aggregate functions
 * (such as range sum, range minimum, range maximum) over an arbitrary interval [L, R] in O(log N).
 * With Lazy Propagation, range updates (adding a value to all elements in [L, R]) are also
 * deferred in O(log N) rather than updating all individual leaves.
 *
 * Time Complexity:
 * - Build: O(N)
 * - Range Query [L, R]: O(log N)
 * - Point Update: O(log N)
 * - Range Update [L, R] with Lazy Propagation: O(log N)
 *
 * Space Complexity:
 * - O(N) using a 4N sized array representation.
 */
public class SegmentTree {

    private final int n;
    private final long[] tree;
    private final long[] lazy;

    public SegmentTree(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty or null");
        }
        this.n = array.length;
        this.tree = new long[4 * n];
        this.lazy = new long[4 * n];
        build(array, 1, 0, n - 1);
    }

    private void build(int[] array, int node, int start, int end) {
        if (start == end) {
            tree[node] = array[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(array, 2 * node, start, mid);
        build(array, 2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    private void pushDown(int node, int start, int end) {
        if (lazy[node] != 0) {
            long addVal = lazy[node];
            int mid = start + (end - start) / 2;

            // Apply to left child
            tree[2 * node] += addVal * (mid - start + 1);
            lazy[2 * node] += addVal;

            // Apply to right child
            tree[2 * node + 1] += addVal * (end - mid);
            lazy[2 * node + 1] += addVal;

            lazy[node] = 0;
        }
    }

    /**
     * Updates range [l, r] by adding val to all elements (inclusive).
     */
    public void updateRange(int l, int r, long val) {
        if (l < 0 || r >= n || l > r) {
            throw new IndexOutOfBoundsException("Invalid range: [" + l + ", " + r + "]");
        }
        updateRange(1, 0, n - 1, l, r, val);
    }

    private void updateRange(int node, int start, int end, int l, int r, long val) {
        if (r < start || end < l) {
            return;
        }
        if (l <= start && end <= r) {
            tree[node] += val * (end - start + 1);
            lazy[node] += val;
            return;
        }

        pushDown(node, start, end);
        int mid = start + (end - start) / 2;
        updateRange(2 * node, start, mid, l, r, val);
        updateRange(2 * node + 1, mid + 1, end, l, r, val);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    /**
     * Queries the sum in range [l, r] (inclusive).
     */
    public long queryRange(int l, int r) {
        if (l < 0 || r >= n || l > r) {
            throw new IndexOutOfBoundsException("Invalid range: [" + l + ", " + r + "]");
        }
        return queryRange(1, 0, n - 1, l, r);
    }

    private long queryRange(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }

        pushDown(node, start, end);
        int mid = start + (end - start) / 2;
        long leftSum = queryRange(2 * node, start, mid, l, r);
        long rightSum = queryRange(2 * node + 1, mid + 1, end, l, r);
        return leftSum + rightSum;
    }
}

