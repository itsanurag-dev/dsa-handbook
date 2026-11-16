package com.codex.dsa.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeTest {

    private AVLTree<Integer> tree;

    @BeforeEach
    public void setUp() {
        tree = new AVLTree<>();
    }

    @Test
    @DisplayName("Empty tree boundary conditions")
    public void testEmptyTree() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertEquals(0, tree.height());
        assertFalse(tree.contains(42));
        assertTrue(tree.isValidAVL());
    }

    @Test
    @DisplayName("Left-Left (LL) rotation rebalancing on sequential descending insertions")
    public void testLeftLeftRotation() {
        tree.insert(30);
        tree.insert(20);
        tree.insert(10); // Causes LL imbalance at 30

        assertEquals(3, tree.size());
        assertEquals(2, tree.height());
        assertTrue(tree.isValidAVL());
        assertEquals(Arrays.asList(10, 20, 30), tree.inorderTraversal());
    }

    @Test
    @DisplayName("Right-Right (RR) rotation rebalancing on sequential ascending insertions")
    public void testRightRightRotation() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30); // Causes RR imbalance at 10

        assertEquals(3, tree.size());
        assertEquals(2, tree.height());
        assertTrue(tree.isValidAVL());
        assertEquals(Arrays.asList(10, 20, 30), tree.inorderTraversal());
    }

    @Test
    @DisplayName("Left-Right (LR) double rotation rebalancing")
    public void testLeftRightRotation() {
        tree.insert(30);
        tree.insert(10);
        tree.insert(20); // Causes LR imbalance

        assertEquals(3, tree.size());
        assertEquals(2, tree.height());
        assertTrue(tree.isValidAVL());
        assertEquals(Arrays.asList(10, 20, 30), tree.inorderTraversal());
    }

    @Test
    @DisplayName("Right-Left (RL) double rotation rebalancing")
    public void testRightLeftRotation() {
        tree.insert(10);
        tree.insert(30);
        tree.insert(20); // Causes RL imbalance

        assertEquals(3, tree.size());
        assertEquals(2, tree.height());
        assertTrue(tree.isValidAVL());
        assertEquals(Arrays.asList(10, 20, 30), tree.inorderTraversal());
    }

    @Test
    @DisplayName("Large random sequential insertion maintains balance factor <= 1")
    public void testLargeInsertions() {
        int[] vals = {50, 25, 75, 10, 30, 60, 80, 5, 15, 27, 35, 55, 65, 77, 90};
        for (int v : vals) {
            tree.insert(v);
            assertTrue(tree.isValidAVL());
        }

        assertEquals(vals.length, tree.size());
        for (int v : vals) {
            assertTrue(tree.contains(v));
        }
        assertFalse(tree.contains(999));
    }

    @Test
    @DisplayName("Deletion of leaf, single child, and 2 children with rebalancing")
    public void testDeletion() {
        int[] vals = {40, 20, 60, 10, 30, 50, 70, 25};
        for (int v : vals) {
            tree.insert(v);
        }

        // Delete leaf node
        tree.delete(25);
        assertFalse(tree.contains(25));
        assertTrue(tree.isValidAVL());

        // Delete node with single child
        tree.delete(30);
        assertFalse(tree.contains(30));
        assertTrue(tree.isValidAVL());

        // Delete node with two children (root 40)
        tree.delete(40);
        assertFalse(tree.contains(40));
        assertTrue(tree.isValidAVL());

        assertEquals(5, tree.size());
    }

    @Test
    @DisplayName("Duplicate insertion is idempotent")
    public void testDuplicateInsertion() {
        tree.insert(10);
        tree.insert(10);
        assertEquals(1, tree.size());
    }
}

