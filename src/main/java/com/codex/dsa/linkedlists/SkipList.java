package com.codex.dsa.linkedlists;

import java.util.Random;

/**
 * Concept:
 * A Skip List is a probabilistic data structure that allows O(log N) search, insertion,
 * and deletion within an ordered sequence of elements. It is an alternative to balanced trees (AVL/Red-Black),
 * using multiple layered linked lists where higher layers act as express lanes skipping over elements.
 *
 * Node height is chosen probabilistically using a geometric distribution (coin-flip with p = 0.5).
 *
 * Time Complexity:
 * - Search: O(log N) average, O(N) worst case.
 * - Insert: O(log N) average, O(N) worst case.
 * - Delete: O(log N) average, O(N) worst case.
 *
 * Space Complexity:
 * - O(N) average auxiliary memory.
 *
 * @param <T> comparable key type
 */
public class SkipList<T extends Comparable<T>> {

    private static final int MAX_LEVEL = 16;
    private static final double PROBABILITY = 0.5;

    public static class Node<T> {
        public final T value;
        public final Node<T>[] forward;

        @SuppressWarnings("unchecked")
        public Node(T value, int level) {
            this.value = value;
            this.forward = (Node<T>[]) new Node[level + 1];
        }
    }

    private final Node<T> head;
    private int currentLevel;
    private int size;
    private final Random random;

    public SkipList() {
        this.head = new Node<>(null, MAX_LEVEL);
        this.currentLevel = 0;
        this.size = 0;
        this.random = new Random();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int randomLevel() {
        int lvl = 0;
        while (lvl < MAX_LEVEL && random.nextDouble() < PROBABILITY) {
            lvl++;
        }
        return lvl;
    }

    /**
     * Searches for a value in the Skip List.
     */
    public boolean contains(T value) {
        if (value == null) return false;
        Node<T> curr = head;

        for (int i = currentLevel; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].value.compareTo(value) < 0) {
                curr = curr.forward[i];
            }
        }

        curr = curr.forward[0];
        return curr != null && curr.value.compareTo(value) == 0;
    }

    /**
     * Inserts a value into the Skip List.
     */
    @SuppressWarnings("unchecked")
    public void insert(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        Node<T>[] update = (Node<T>[]) new Node[MAX_LEVEL + 1];
        Node<T> curr = head;

        for (int i = currentLevel; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].value.compareTo(value) < 0) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        curr = curr.forward[0];

        // If value already exists, do not duplicate
        if (curr != null && curr.value.compareTo(value) == 0) {
            return;
        }

        int newLevel = randomLevel();
        if (newLevel > currentLevel) {
            for (int i = currentLevel + 1; i <= newLevel; i++) {
                update[i] = head;
            }
            currentLevel = newLevel;
        }

        Node<T> newNode = new Node<>(value, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }

        size++;
    }

    /**
     * Deletes a value from the Skip List.
     * Returns true if value was found and removed, false otherwise.
     */
    @SuppressWarnings("unchecked")
    public boolean delete(T value) {
        if (value == null) return false;

        Node<T>[] update = (Node<T>[]) new Node[MAX_LEVEL + 1];
        Node<T> curr = head;

        for (int i = currentLevel; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].value.compareTo(value) < 0) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        curr = curr.forward[0];

        if (curr == null || curr.value.compareTo(value) != 0) {
            return false;
        }

        for (int i = 0; i <= currentLevel; i++) {
            if (update[i].forward[i] != curr) {
                break;
            }
            update[i].forward[i] = curr.forward[i];
        }

        while (currentLevel > 0 && head.forward[currentLevel] == null) {
            currentLevel--;
        }

        size--;
        return true;
    }
}

