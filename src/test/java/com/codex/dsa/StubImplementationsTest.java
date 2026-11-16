package com.codex.dsa;

import com.codex.dsa.arrays.PermutationSequence;
import com.codex.dsa.binarysearchtree.UniqueBST;
import com.codex.dsa.dynamicprogramming.Knapsack;
import com.codex.dsa.graphs.CyckeDetectionInDAG;
import com.codex.dsa.graphs.KahnTopologicalSort;
import com.codex.dsa.graphs.RouteBetweenNodes;
import com.codex.dsa.greedyalgorithms.ActivitySelectionProblem;
import com.codex.dsa.matrices.RotateMatrix;
import com.codex.dsa.stacks.FlaxibleMultistackFromArray;
import com.codex.dsa.strings.BalanceString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StubImplementationsTest {

    @Test
    @DisplayName("0/1 and Unbounded Knapsack optimal DP value calculation")
    public void testKnapsack() {
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 6;

        // 0/1 Knapsack: take all 3 -> 10 + 15 + 40 = 65
        assertEquals(65, Knapsack.zeroOneKnapsack(weights, values, capacity));

        // Unbounded Knapsack: take item 3 twice (weight 3+3=6, value 40+40=80)
        assertEquals(80, Knapsack.unboundedKnapsack(weights, values, capacity));
    }

    @Test
    @DisplayName("Kahn Topological Sort on DAG and Cycle detection")
    public void testKahnTopologicalSort() {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(3);

        List<Integer> order = KahnTopologicalSort.topologicalSort(V, adj);
        assertNotNull(order);
        assertEquals(4, order.size());
        assertEquals(0, order.get(0));
        assertEquals(3, order.get(3));

        // Add cycle 3 -> 0
        adj.get(3).add(0);
        assertNull(KahnTopologicalSort.topologicalSort(V, adj));
    }

    @Test
    @DisplayName("Cycle detection in DAG using 3-color DFS")
    public void testCycleDetectionInDAG() {
        int V = 3;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);

        assertFalse(CyckeDetectionInDAG.hasCycle(V, adj));

        adj.get(2).add(0); // Create cycle
        assertTrue(CyckeDetectionInDAG.hasCycle(V, adj));
    }

    @Test
    @DisplayName("In-place 90 degree clockwise matrix rotation")
    public void testRotateMatrix() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        RotateMatrix.rotateClockwise(matrix);

        int[][] expected = {
            {7, 4, 1},
            {8, 5, 2},
            {9, 6, 3}
        };

        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Activity selection greedily picks maximum non-overlapping intervals")
    public void testActivitySelection() {
        List<ActivitySelectionProblem.Activity> activities = Arrays.asList(
            new ActivitySelectionProblem.Activity(1, 4),
            new ActivitySelectionProblem.Activity(3, 5),
            new ActivitySelectionProblem.Activity(0, 6),
            new ActivitySelectionProblem.Activity(5, 7),
            new ActivitySelectionProblem.Activity(3, 8),
            new ActivitySelectionProblem.Activity(5, 9),
            new ActivitySelectionProblem.Activity(6, 10),
            new ActivitySelectionProblem.Activity(8, 11),
            new ActivitySelectionProblem.Activity(8, 12),
            new ActivitySelectionProblem.Activity(2, 13),
            new ActivitySelectionProblem.Activity(12, 14)
        );

        var selected = ActivitySelectionProblem.selectMaxActivities(activities);
        assertEquals(4, selected.size());
        assertEquals(1, selected.get(0).start);
        assertEquals(4, selected.get(0).finish);
    }

    @Test
    @DisplayName("Route between nodes BFS search")
    public void testRouteBetweenNodes() {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);

        assertTrue(RouteBetweenNodes.hasRoute(V, adj, 0, 2));
        assertFalse(RouteBetweenNodes.hasRoute(V, adj, 2, 0));
        assertFalse(RouteBetweenNodes.hasRoute(V, adj, 0, 3));
    }

    @Test
    @DisplayName("Unique BST Catalan counts")
    public void testUniqueBST() {
        assertEquals(1, UniqueBST.numTrees(1));
        assertEquals(2, UniqueBST.numTrees(2));
        assertEquals(5, UniqueBST.numTrees(3));
        assertEquals(14, UniqueBST.numTrees(4));
    }

    @Test
    @DisplayName("Permutation sequence factorial number system")
    public void testPermutationSequence() {
        // n = 3, k = 3 -> "213"
        assertEquals("213", PermutationSequence.getPermutation(3, 3));
        // n = 4, k = 9 -> "2314"
        assertEquals("2314", PermutationSequence.getPermutation(4, 9));
    }

    @Test
    @DisplayName("Balanced string fragment shortest length")
    public void testBalancedString() {
        assertEquals(8, BalanceString.getShortestBalancedFragment("CATattac"));
        assertEquals(-1, BalanceString.getShortestBalancedFragment("Madam"));
    }

    @Test
    @DisplayName("Flexible multi-stack dynamic allocation within single array")
    public void testFlexibleMultiStack() {
        FlaxibleMultistackFromArray ms = new FlaxibleMultistackFromArray(3, 6);

        ms.push(0, 10);
        ms.push(0, 20);
        ms.push(1, 30);
        ms.push(2, 40);
        ms.push(2, 50);
        ms.push(2, 60);

        assertTrue(ms.isFull());
        assertEquals(20, ms.pop(0));
        assertEquals(10, ms.pop(0));
        assertEquals(60, ms.pop(2));
        assertEquals(30, ms.pop(1));
    }
}

