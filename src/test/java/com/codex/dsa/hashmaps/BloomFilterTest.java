package com.codex.dsa.hashmaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloomFilterTest {

    @Test
    @DisplayName("Zero false negatives: all inserted elements report mightContain as true")
    public void testNoFalseNegatives() {
        BloomFilter<String> filter = new BloomFilter<>(1000, 0.01);

        for (int i = 0; i < 1000; i++) {
            filter.add("item_" + i);
        }

        for (int i = 0; i < 1000; i++) {
            assertTrue(filter.mightContain("item_" + i), "Bloom filter must never produce false negative");
        }
    }

    @Test
    @DisplayName("False positive rate matches theoretical expectations within statistical tolerance")
    public void testFalsePositiveRate() {
        int n = 5000;
        double targetFPR = 0.05;
        BloomFilter<String> filter = new BloomFilter<>(n, targetFPR);

        for (int i = 0; i < n; i++) {
            filter.add("present_" + i);
        }

        int falsePositives = 0;
        int testCount = 5000;
        for (int i = 0; i < testCount; i++) {
            if (filter.mightContain("absent_" + i)) {
                falsePositives++;
            }
        }

        double observedFPR = (double) falsePositives / testCount;
        // Check that observed FPR is within reasonable statistical bounds (< 2x target)
        assertTrue(observedFPR < 0.10, "Observed FPR " + observedFPR + " exceeded tolerance");
    }
}

