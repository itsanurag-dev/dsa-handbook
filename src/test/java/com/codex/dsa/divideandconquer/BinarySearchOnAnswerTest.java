package com.codex.dsa.divideandconquer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchOnAnswerTest {

    @Test
    @DisplayName("Ship within D days finds minimal required vessel capacity")
    public void testShipWithinDays() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        // Day 1: [1..5] (15), Day 2: [6, 7] (13), Day 3: [8] (8), Day 4: [9] (9), Day 5: [10] (10) -> capacity 15
        assertEquals(15, BinarySearchOnAnswer.shipWithinDays(weights, days));
    }

    @Test
    @DisplayName("Split array largest sum partitions optimally into K subarrays")
    public void testSplitArrayLargestSum() {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        // [7, 2, 5] and [10, 8] -> max sum is 18
        assertEquals(18, BinarySearchOnAnswer.splitArrayLargestSum(nums, k));
    }

    @Test
    @DisplayName("When days equals array length, capacity is max single element")
    public void testDaysEqualsLength() {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int days = 6;
        assertEquals(4, BinarySearchOnAnswer.shipWithinDays(weights, days));
    }
}

