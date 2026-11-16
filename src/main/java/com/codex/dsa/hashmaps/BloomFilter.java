package com.codex.dsa.hashmaps;

import java.util.BitSet;
import java.util.Objects;

/**
 * Concept:
 * A Bloom Filter is a space-efficient probabilistic data structure used to test whether
 * an element is a member of a set.
 * - False positive matches are possible (it may report that an element is in the set when it is not).
 * - False negatives are impossible (a query returns either "possibly in set" or "definitely not in set").
 *
 * Implemented using:
 * - A bit array of size M.
 * - K independent hash functions generated via Kirsch-Mitzenmacher double hashing optimization:
 *   hash_i(x) = (hash1(x) + i * hash2(x)) % M.
 *
 * Time Complexity:
 * - add(element): O(K) where K is number of hash functions.
 * - mightContain(element): O(K)
 *
 * Space Complexity:
 * - O(M) bits where M = ceil(- (n * ln(p)) / (ln(2)^2)).
 *
 * @param <T> element type
 */
public class BloomFilter<T> {

    private final BitSet bitSet;
    private final int bitSetSize;
    private final int numHashFunctions;
    private int elementCount;

    /**
     * Constructs a Bloom Filter parameterized by expected elements and acceptable false positive probability.
     *
     * @param expectedInsertions n: estimated number of elements to insert
     * @param falsePositiveRate p: desired false positive rate (e.g., 0.01 for 1%)
     */
    public BloomFilter(int expectedInsertions, double falsePositiveRate) {
        if (expectedInsertions <= 0) {
            throw new IllegalArgumentException("Expected insertions must be positive: " + expectedInsertions);
        }
        if (falsePositiveRate <= 0.0 || falsePositiveRate >= 1.0) {
            throw new IllegalArgumentException("False positive rate must be in (0, 1): " + falsePositiveRate);
        }

        // Optimal bit size: m = ceil(-(n * ln(p)) / (ln(2)^2))
        this.bitSetSize = (int) Math.ceil(-(expectedInsertions * Math.log(falsePositiveRate)) / (Math.log(2) * Math.log(2)));
        // Optimal hash count: k = round((m / n) * ln(2))
        this.numHashFunctions = Math.max(1, (int) Math.round(((double) bitSetSize / expectedInsertions) * Math.log(2)));
        this.bitSet = new BitSet(bitSetSize);
        this.elementCount = 0;
    }

    public int getBitSetSize() {
        return bitSetSize;
    }

    public int getNumHashFunctions() {
        return numHashFunctions;
    }

    public int getElementCount() {
        return elementCount;
    }

    private int[] getHashes(T element) {
        int[] hashes = new int[numHashFunctions];
        int hash1 = Objects.hashCode(element);
        // Supplemental hash
        int hash2 = hash1 ^ (hash1 >>> 16);
        if (hash2 == 0) hash2 = 17; // Ensure non-zero step

        for (int i = 0; i < numHashFunctions; i++) {
            long combined = ((long) hash1 + (long) i * hash2) & 0x7FFFFFFF;
            hashes[i] = (int) (combined % bitSetSize);
        }
        return hashes;
    }

    /**
     * Adds an element into the Bloom Filter.
     */
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        int[] hashes = getHashes(element);
        for (int h : hashes) {
            bitSet.set(h);
        }
        elementCount++;
    }

    /**
     * Returns true if the element might be in the set, or false if it is definitely not.
     */
    public boolean mightContain(T element) {
        if (element == null) return false;
        int[] hashes = getHashes(element);
        for (int h : hashes) {
            if (!bitSet.get(h)) {
                return false; // Definitely not present
            }
        }
        return true; // Possibly present
    }
}

