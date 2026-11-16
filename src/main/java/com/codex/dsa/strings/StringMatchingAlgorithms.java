package com.codex.dsa.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Concept:
 * Classic linear and sub-linear string pattern matching algorithms:
 * 1. Knuth-Morris-Pratt (KMP):
 *    - Avoids re-matching characters by precomputing a Prefix Function (pi array / LPS).
 *    - pi[i] is the length of the longest proper prefix of pattern[0..i] that is also a suffix of pattern[0..i].
 * 2. Rabin-Karp:
 *    - Uses rolling polynomial hashing to match pattern in O(N + M) average time.
 *    - Compares hash values; on match, verifies characters to resolve hash collisions.
 *
 * Time Complexity:
 * - KMP: O(N + M) deterministic worst case, where N is text length and M is pattern length.
 * - Rabin-Karp: O(N + M) average time, O(N * M) worst case (with malicious hash collisions).
 *
 * Space Complexity:
 * - KMP: O(M) for the pi array.
 * - Rabin-Karp: O(1) auxiliary space.
 */
public class StringMatchingAlgorithms {

    /**
     * Computes the Knuth-Morris-Pratt (KMP) Longest Proper Prefix which is also Suffix (LPS) array.
     */
    public static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    /**
     * Finds all start indices where pattern occurs in text using KMP.
     */
    public static List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        if (text == null || pattern == null || pattern.isEmpty() || text.length() < pattern.length()) {
            return matches;
        }

        int[] pi = computeLPS(pattern);
        int j = 0; // index in pattern

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                matches.add(i - pattern.length() + 1);
                j = pi[j - 1]; // Continue searching for next occurrence
            }
        }

        return matches;
    }

    /**
     * Finds all start indices where pattern occurs in text using Rabin-Karp rolling hash.
     */
    public static List<Integer> rabinKarpSearch(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        if (text == null || pattern == null || pattern.isEmpty() || text.length() < pattern.length()) {
            return matches;
        }

        final int BASE = 256;
        final long MOD = 1_000_000_007L;

        int n = text.length();
        int m = pattern.length();

        long patternHash = 0;
        long textHash = 0;
        long h = 1;

        // h = (BASE^(m-1)) % MOD
        for (int i = 0; i < m - 1; i++) {
            h = (h * BASE) % MOD;
        }

        // Calculate initial window hash
        for (int i = 0; i < m; i++) {
            patternHash = (BASE * patternHash + pattern.charAt(i)) % MOD;
            textHash = (BASE * textHash + text.charAt(i)) % MOD;
        }

        // Slide window over text
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                // Verify characters to safeguard against hash collision
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    matches.add(i);
                }
            }

            // Calculate hash for next window: remove leading digit, add trailing digit
            if (i < n - m) {
                textHash = (BASE * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % MOD;
                if (textHash < 0) {
                    textHash = (textHash + MOD);
                }
            }
        }

        return matches;
    }
}

