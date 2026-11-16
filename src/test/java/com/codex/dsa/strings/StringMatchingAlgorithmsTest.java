package com.codex.dsa.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringMatchingAlgorithmsTest {

    @Test
    @DisplayName("KMP and Rabin-Karp find all pattern occurrences in text")
    public void testMultipleMatches() {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";

        List<Integer> expected = Arrays.asList(0, 9, 12);
        List<Integer> kmpMatches = StringMatchingAlgorithms.kmpSearch(text, pattern);
        List<Integer> rkMatches = StringMatchingAlgorithms.rabinKarpSearch(text, pattern);

        assertEquals(expected, kmpMatches);
        assertEquals(expected, rkMatches);
    }

    @Test
    @DisplayName("No matches returns empty list")
    public void testNoMatch() {
        String text = "abcdef";
        String pattern = "xyz";

        assertTrue(StringMatchingAlgorithms.kmpSearch(text, pattern).isEmpty());
        assertTrue(StringMatchingAlgorithms.rabinKarpSearch(text, pattern).isEmpty());
    }

    @Test
    @DisplayName("Pattern longer than text returns empty list")
    public void testPatternLongerThanText() {
        String text = "short";
        String pattern = "very long pattern";

        assertTrue(StringMatchingAlgorithms.kmpSearch(text, pattern).isEmpty());
        assertTrue(StringMatchingAlgorithms.rabinKarpSearch(text, pattern).isEmpty());
    }

    @Test
    @DisplayName("Handles repetitive characters and overlaps")
    public void testOverlappingOccurrences() {
        String text = "AAAAAA";
        String pattern = "AAA";

        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        assertEquals(expected, StringMatchingAlgorithms.kmpSearch(text, pattern));
        assertEquals(expected, StringMatchingAlgorithms.rabinKarpSearch(text, pattern));
    }
}

