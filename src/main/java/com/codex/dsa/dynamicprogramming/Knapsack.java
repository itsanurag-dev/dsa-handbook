package com.codex.dsa.dynamicprogramming;

/**
 * Concept:
 * The Knapsack Problem is a classic optimization problem in Dynamic Programming.
 * 1. 0/1 Knapsack:
 *    - Each item can be chosen at most once (include or exclude).
 *    - State: dp[w] = maximum value attainable with exact or at most capacity w.
 *    - Space-optimized to 1D array traversing backwards from capacity W down to weight[i].
 * 2. Unbounded Knapsack:
 *    - Each item can be chosen an unlimited number of times.
 *    - Space-optimized to 1D array traversing forwards from weight[i] up to capacity W.
 *
 * Time Complexity:
 * - O(N * W) where N is number of items and W is max capacity.
 *
 * Space Complexity:
 * - O(W) using 1D space optimization.
 */
public class Knapsack {

    /**
     * Solves the 0/1 Knapsack problem.
     *
     * @param weights weights of items
     * @param values values of items
     * @param capacity maximum carrying capacity of knapsack
     * @return maximum achievable value
     */
    public static int zeroOneKnapsack(int[] weights, int[] values, int capacity) {
        if (weights == null || values == null || weights.length == 0 || capacity <= 0) {
            return 0;
        }

        int n = weights.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            int w = weights[i];
            int v = values[i];
            // Iterate backwards to ensure each item is used at most once
            for (int cap = capacity; cap >= w; cap--) {
                dp[cap] = Math.max(dp[cap], dp[cap - w] + v);
            }
        }

        return dp[capacity];
    }

    /**
     * Solves the Unbounded Knapsack problem.
     *
     * @param weights weights of items
     * @param values values of items
     * @param capacity maximum carrying capacity
     * @return maximum achievable value
     */
    public static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        if (weights == null || values == null || weights.length == 0 || capacity <= 0) {
            return 0;
        }

        int n = weights.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            int w = weights[i];
            int v = values[i];
            // Iterate forwards to allow multiple inclusions of item i
            for (int cap = w; cap <= capacity; cap++) {
                dp[cap] = Math.max(dp[cap], dp[cap - w] + v);
            }
        }

        return dp[capacity];
    }
}
