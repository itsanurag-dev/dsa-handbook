package com.codex.dsa.hashmaps;

import java.util.HashMap;
import java.util.Map;

/**
 * Concept:
 * Least Frequently Used (LFU) Cache eviction policy.
 * When cache capacity is reached, it invalidates and removes the item with the lowest access frequency.
 * If there is a tie in minimum frequency, the Least Recently Used (LRU) item among them is evicted.
 *
 * Implemented using:
 * 1. `keyToNode` map: maps key -> Node(key, val, freq).
 * 2. `freqToList` map: maps frequency -> DoublyLinkedList of Nodes with that frequency.
 * 3. `minFreq`: tracks the current minimum frequency across all stored nodes.
 *
 * Time Complexity:
 * - get(key): O(1) worst and average case.
 * - put(key, val): O(1) worst and average case.
 *
 * Space Complexity:
 * - O(C) where C is the maximum cache capacity.
 *
 * @param <K> key type
 * @param <V> value type
 */
public class LFUCache<K, V> {

    public static class Node<K, V> {
        final K key;
        V value;
        int freq;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private static class DoublyLinkedList<K, V> {
        final Node<K, V> head;
        final Node<K, V> tail;
        int size;

        DoublyLinkedList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            size--;
        }

        Node<K, V> removeLast() {
            if (size == 0) return null;
            Node<K, V> lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<K, Node<K, V>> keyToNode;
    private final Map<Integer, DoublyLinkedList<K, V>> freqToList;

    public LFUCache(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non-negative: " + capacity);
        }
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
    }

    public int size() {
        return keyToNode.size();
    }

    public int capacity() {
        return capacity;
    }

    public V get(K key) {
        Node<K, V> node = keyToNode.get(key);
        if (node == null) {
            return null;
        }
        updateFreq(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node<K, V> node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        if (keyToNode.size() >= capacity) {
            // Evict least frequently used node (and LRU if frequency ties)
            DoublyLinkedList<K, V> minList = freqToList.get(minFreq);
            Node<K, V> evicted = minList.removeLast();
            if (evicted != null) {
                keyToNode.remove(evicted.key);
            }
        }

        Node<K, V> newNode = new Node<>(key, value);
        keyToNode.put(key, newNode);
        minFreq = 1;

        DoublyLinkedList<K, V> list = freqToList.computeIfAbsent(1, k -> new DoublyLinkedList<>());
        list.addFirst(newNode);
    }

    private void updateFreq(Node<K, V> node) {
        int oldFreq = node.freq;
        DoublyLinkedList<K, V> oldList = freqToList.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        DoublyLinkedList<K, V> newList = freqToList.computeIfAbsent(node.freq, k -> new DoublyLinkedList<>());
        newList.addFirst(node);
    }
}

