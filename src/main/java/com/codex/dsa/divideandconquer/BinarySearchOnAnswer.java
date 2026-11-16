package com.codex.dsa.divideandconquer;

import java.util.function.Predicate;

/**
 * Concept:
 * Binary Search on Answer is an algorithmic paradigm used when:
 * 1. The search space is bounded [low, high] and monotonic:
 *    - For a feasibility predicate f(x), if f(x) is true, then f(y) is true for all y >= x (or y <= x).
 * 2. Finding the exact optimal answer directly is hard, but checking if a candidate answer is valid
 *    can be done efficiently in O(N).
 *
 * Examples covered:
 * - Minimum capacity required to ship all packages within D days.
 * - Split array largest sum into K sub-arrays to minimize the maximum sum.
 * - General template for first true / last true predicate search avoiding integer overflow.
 *
 * Time Complexity:
 * - O(N * log(Range)) where Range is high - low.
 *
 * Space Complexity:
 * - O(1) auxiliary space.
 */
public class BinarySearchOnAnswer {

    /**
     * General monotonic binary search template: finds the minimum value x in [low, high]
     * such that condition.test(x) is true.
     */
    public static long binarySearchFirstTrue(long low, long high, Predicate<Long> condition) {
        long ans = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2; // Protect against overflow
            if (condition.test(mid)) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid value
            } else {
                low = mid + 1;  // Not valid, must increase
            }
        }
        return ans;
    }

    /**
     * Capacity to ship packages within D days:
     * Given package weights and max days D, find the minimum boat capacity needed.
     */
    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalSum = 0;
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalSum += w;
        }

        long minCapacity = binarySearchFirstTrue(maxWeight, totalSum, capacity -> {
            int daysNeeded = 1;
            int currentLoad = 0;
            for (int w : weights) {
                if (currentLoad + w > capacity) {
                    daysNeeded++;
                    currentLoad = 0;
                }
                currentLoad += w;
            }
            return daysNeeded <= days;
        });

        return (int) minCapacity;
    }

    /**
     * Split array largest sum:
     * Split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
     */
    public static int splitArrayLargestSum(int[] nums, int k) {
        return shipWithinDays(nums, k);
    }
}

