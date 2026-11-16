package com.codex.dsa.hashmaps;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Concept:
 * A Hash Table based on Separate Chaining collision resolution.
 * Keys are mapped to an array bucket index using a hash function. Collisions are handled
 * by maintaining a linked chain of entries at each bucket. When the load factor (size / capacity)
 * exceeds the load factor threshold (0.75), dynamic rehashing is triggered: the bucket array capacity
 * is doubled, and all active key-value pairs are re-hashed into the new bucket array.
 *
 * Time Complexity:
 * - get(key): O(1) average, O(N) worst case (all keys hash to same bucket).
 * - put(key, val): O(1) amortized average, O(N) worst case.
 * - remove(key): O(1) average, O(N) worst case.
 *
 * Space Complexity:
 * - O(N + M) where N is number of key-value pairs and M is capacity of bucket array.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class SeparateChainingHashTable<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    public static class Entry<K, V> {
        final K key;
        V value;
        final int hash;
        Entry<K, V> next;

        public Entry(K key, V value, int hash, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private Entry<K, V>[] table;
    private int size;
    private int capacity;
    private final double loadFactor;

    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable(int initialCapacity, double loadFactor) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive: " + initialCapacity);
        }
        if (loadFactor <= 0 || Double.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Load factor must be positive: " + loadFactor);
        }
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.table = (Entry<K, V>[]) new Entry[capacity];
        this.size = 0;
    }

    public SeparateChainingHashTable() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return capacity;
    }

    private int hash(K key) {
        if (key == null) return 0;
        int h = key.hashCode();
        // Supplemental hash function to distribute higher bits
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int getBucketIndex(int hash, int tableCapacity) {
        return Math.abs(hash) % tableCapacity;
    }

    public V put(K key, V value) {
        int hash = hash(key);
        int bucket = getBucketIndex(hash, capacity);

        Entry<K, V> curr = table[bucket];
        while (curr != null) {
            if (curr.hash == hash && Objects.equals(curr.key, key)) {
                V oldVal = curr.value;
                curr.value = value;
                return oldVal;
            }
            curr = curr.next;
        }

        // Add to front of bucket chain
        table[bucket] = new Entry<>(key, value, hash, table[bucket]);
        size++;

        if ((double) size / capacity >= loadFactor) {
            rehash();
        }

        return null;
    }

    public V get(K key) {
        int hash = hash(key);
        int bucket = getBucketIndex(hash, capacity);

        Entry<K, V> curr = table[bucket];
        while (curr != null) {
            if (curr.hash == hash && Objects.equals(curr.key, key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        int bucket = getBucketIndex(hash, capacity);

        Entry<K, V> curr = table[bucket];
        while (curr != null) {
            if (curr.hash == hash && Objects.equals(curr.key, key)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public V remove(K key) {
        int hash = hash(key);
        int bucket = getBucketIndex(hash, capacity);

        Entry<K, V> curr = table[bucket];
        Entry<K, V> prev = null;

        while (curr != null) {
            if (curr.hash == hash && Objects.equals(curr.key, key)) {
                if (prev == null) {
                    table[bucket] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        int newCapacity = capacity * 2;
        Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[newCapacity];

        for (int i = 0; i < capacity; i++) {
            Entry<K, V> curr = table[i];
            while (curr != null) {
                Entry<K, V> next = curr.next;
                int newBucket = getBucketIndex(curr.hash, newCapacity);
                curr.next = newTable[newBucket];
                newTable[newBucket] = curr;
                curr = next;
            }
        }

        this.table = newTable;
        this.capacity = newCapacity;
    }

    public List<K> keys() {
        List<K> keyList = new ArrayList<>(size);
        for (int i = 0; i < capacity; i++) {
            Entry<K, V> curr = table[i];
            while (curr != null) {
                keyList.add(curr.key);
                curr = curr.next;
            }
        }
        return keyList;
    }
}

