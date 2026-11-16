package com.codex.dsa.graphs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AdvancedShortestPathsTest {

    @Test
    @DisplayName("Bellman-Ford finds single-source shortest path with negative edge weights")
    public void testBellmanFordNegativeWeights() {
        int V = 5;
        List<AdvancedShortestPaths.Edge> edges = new ArrayList<>();
        edges.add(new AdvancedShortestPaths.Edge(0, 1, -1));
        edges.add(new AdvancedShortestPaths.Edge(0, 2, 4));
        edges.add(new AdvancedShortestPaths.Edge(1, 2, 3));
        edges.add(new AdvancedShortestPaths.Edge(1, 3, 2));
        edges.add(new AdvancedShortestPaths.Edge(1, 4, 2));
        edges.add(new AdvancedShortestPaths.Edge(3, 2, 5));
        edges.add(new AdvancedShortestPaths.Edge(3, 1, 1));
        edges.add(new AdvancedShortestPaths.Edge(4, 3, -3));

        AdvancedShortestPaths.BellmanFordResult result = AdvancedShortestPaths.bellmanFord(V, edges, 0);

        assertFalse(result.hasNegativeCycle);
        assertEquals(0, result.distances[0]);
        assertEquals(-1, result.distances[1]);
        assertEquals(2, result.distances[2]);
        assertEquals(-2, result.distances[3]);
        assertEquals(1, result.distances[4]);

        assertEquals(Arrays.asList(0, 1, 4, 3), result.getPathTo(3));
    }

    @Test
    @DisplayName("Bellman-Ford detects negative weight cycles")
    public void testBellmanFordDetectsNegativeCycle() {
        int V = 4;
        List<AdvancedShortestPaths.Edge> edges = new ArrayList<>();
        edges.add(new AdvancedShortestPaths.Edge(0, 1, 1));
        edges.add(new AdvancedShortestPaths.Edge(1, 2, 2));
        edges.add(new AdvancedShortestPaths.Edge(2, 3, 3));
        edges.add(new AdvancedShortestPaths.Edge(3, 1, -10)); // Cycle 1->2->3->1 with sum -5

        AdvancedShortestPaths.BellmanFordResult result = AdvancedShortestPaths.bellmanFord(V, edges, 0);
        assertTrue(result.hasNegativeCycle);
    }

    @Test
    @DisplayName("Floyd-Warshall computes correct All-Pairs Shortest Path matrix")
    public void testFloydWarshallAPSP() {
        int V = 4;
        int INF = AdvancedShortestPaths.INF;
        int[][] matrix = {
            {0,   3,   INF, 5},
            {2,   0,   INF, 4},
            {INF, 1,   0,   INF},
            {INF, INF, 2,   0}
        };

        int[][] dist = AdvancedShortestPaths.floydWarshall(V, matrix);

        assertNotNull(dist);
        assertEquals(0, dist[0][0]);
        assertEquals(3, dist[0][1]);
        assertEquals(7, dist[0][2]);
        assertEquals(5, dist[0][3]);

        assertEquals(2, dist[1][0]);
        assertEquals(0, dist[1][1]);
        assertEquals(6, dist[1][2]);
        assertEquals(4, dist[1][3]);
    }

    @Test
    @DisplayName("Floyd-Warshall detects negative weight cycle")
    public void testFloydWarshallNegativeCycle() {
        int V = 3;
        int INF = AdvancedShortestPaths.INF;
        int[][] matrix = {
            {0,   1,   INF},
            {INF, 0,   -3},
            {-2,  INF, 0}
        };

        int[][] dist = AdvancedShortestPaths.floydWarshall(V, matrix);
        assertNull(dist, "Must return null when negative cycle exists");
    }
}

