package com.codex.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Concept:
 * Permutation Sequence (Factorial Number System):
 * Given n and k, return the kth permutation sequence of numbers [1, 2, ..., n].
 * Rather than generating all n! permutations (which takes O(N * N!)),
 * we determine each digit directly using (n - 1)! blocks in O(N^2) time.
 *
 * Time Complexity:
 * - O(N^2) due to deleting elements from the list of numbers.
 *
 * Space Complexity:
 * - O(N) to store numbers and factorial lookups.
 */
public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);
        }

        // Convert k to 0-based index
        k--;

        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int block = fact[i - 1];
            int index = k / block;
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= block;
        }

        return sb.toString();
    }
}
