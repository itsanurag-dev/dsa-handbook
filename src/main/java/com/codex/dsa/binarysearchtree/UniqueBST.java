package com.codex.dsa.binarysearchtree;

/**
 * Concept:
 * Unique Binary Search Trees (Catalan Number):
 * Given an integer n, return the number of structurally unique BST's (binary search trees)
 * which have exactly n nodes with unique values from 1 to n.
 *
 * Recurrence:
 * G(n) = sum_{i=1}^n G(i-1) * G(n-i)
 * where G(0) = 1, G(1) = 1.
 *
 * Time Complexity:
 * - O(N^2) dynamic programming.
 *
 * Space Complexity:
 * - O(N) auxiliary space.
 */
public class UniqueBST {

    public static int numTrees(int n) {
        if (n <= 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
