package com.codex.dsa.stacks;

import java.util.EmptyStackException;

/**
 * Concept:
 * Flexible Multi-Stack in a Single Array:
 * Implements K flexible stacks within a single shared array of total capacity N.
 *
 * Implemented using three parallel arrays:
 * 1. `arr[N]`: stores the actual data elements.
 * 2. `top[K]`: stores the index of the top element for each of the K stacks (initialized to -1).
 * 3. `next[N]`: stores the index of the previous item in the same stack, OR points to the next free slot
 *    in the free list.
 * 4. `free`: points to the beginning of the free slots linked list.
 *
 * Space efficiency: Any stack can grow as long as there is ANY free slot left in the shared array.
 *
 * Time Complexity:
 * - push(stackNum, val): O(1)
 * - pop(stackNum): O(1)
 * - peek(stackNum): O(1)
 *
 * Space Complexity:
 * - O(N + K) auxiliary storage.
 */
public class FlaxibleMultistackFromArray {

    private final int[] arr;
    private final int[] top;
    private final int[] next;
    private final int numStacks;
    private int free;

    public FlaxibleMultistackFromArray(int numStacks, int totalCapacity) {
        if (numStacks <= 0 || totalCapacity <= 0) {
            throw new IllegalArgumentException("Stacks count and capacity must be positive");
        }
        this.numStacks = numStacks;
        this.arr = new int[totalCapacity];
        this.top = new int[numStacks];
        this.next = new int[totalCapacity];

        // All stacks are initially empty
        for (int i = 0; i < numStacks; i++) {
            top[i] = -1;
        }

        // Initialize free list: 0 -> 1 -> 2 -> ... -> totalCapacity - 1 -> -1
        this.free = 0;
        for (int i = 0; i < totalCapacity - 1; i++) {
            next[i] = i + 1;
        }
        next[totalCapacity - 1] = -1;
    }

    public boolean isFull() {
        return free == -1;
    }

    public boolean isEmpty(int stackNum) {
        checkStackNum(stackNum);
        return top[stackNum] == -1;
    }

    public void push(int stackNum, int val) {
        checkStackNum(stackNum);
        if (isFull()) {
            throw new IllegalStateException("Stack Overflow: Total capacity exhausted");
        }

        // Allocate first free slot
        int i = free;
        free = next[i];

        // Link element into stackNum
        next[i] = top[stackNum];
        top[stackNum] = i;
        arr[i] = val;
    }

    public int pop(int stackNum) {
        checkStackNum(stackNum);
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        // Find top index of stackNum
        int i = top[stackNum];
        top[stackNum] = next[i];

        // Return slot i to free list
        next[i] = free;
        free = i;

        return arr[i];
    }

    public int peek(int stackNum) {
        checkStackNum(stackNum);
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return arr[top[stackNum]];
    }

    private void checkStackNum(int stackNum) {
        if (stackNum < 0 || stackNum >= numStacks) {
            throw new IllegalArgumentException("Invalid stack number: " + stackNum);
        }
    }
}
