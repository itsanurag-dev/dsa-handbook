package com.codex.dsa.strings;

/**
 * Concept:
 * Balanced String Fragment:
 * A string is balanced if every letter occurring in it appears in both uppercase and lowercase.
 * Finds the length of the shortest balanced fragment within string S, or -1 if none exists.
 *
 * Implemented using divide-and-conquer:
 * - Count presence of lowercase and uppercase characters in S.
 * - If a character appears in one case but not the other, it can never be part of ANY balanced fragment.
 * - Split the string at these invalid delimiter characters and recurse on the valid substrings.
 *
 * Time Complexity:
 * - O(26 * N) = O(N) average, O(N^2) worst case.
 *
 * Space Complexity:
 * - O(N) recursion stack.
 */
public class BalanceString {

    public static int getShortestBalancedFragment(String s) {
        if (s == null || s.length() < 2) {
            return -1;
        }

        int result = findShortest(s);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int findShortest(String s) {
        if (s.length() < 2) return Integer.MAX_VALUE;

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) lower[c - 'a'] = true;
            else if (Character.isUpperCase(c)) upper[c - 'A'] = true;
        }

        // Find the first character that violates the balanced property
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isImbalanced = (Character.isLowerCase(c) && !upper[c - 'a']) ||
                                   (Character.isUpperCase(c) && !lower[c - 'A']);
            if (isImbalanced) {
                // Split around i and search both sides
                int left = findShortest(s.substring(0, i));
                int right = findShortest(s.substring(i + 1));
                return Math.min(left, right);
            }
        }

        // Entire string s is balanced
        return s.length();
    }
}
