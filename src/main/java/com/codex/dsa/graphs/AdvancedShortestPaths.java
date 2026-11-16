package com.codex.dsa.graphs;

import java.util.*;

/**
 * Concept:
 * Advanced Shortest Path Algorithms:
 * 1. Bellman-Ford Algorithm:
 *    - Single-source shortest paths on directed/undirected graphs supporting negative edge weights.
 *    - Relaxes all E edges (V - 1) times.
 *    - A V-th iteration detects negative weight cycles reachable from source.
 * 2. Floyd-Warshall Algorithm:
 *    - All-Pairs Shortest Path (APSP) using dynamic programming.
 *    - Considers each vertex k in {0..V-1} as an intermediate vertex.
 *    - Detects negative cycles if distance[i][i] < 0.
 *
 * Time Complexity:
 * - Bellman-Ford: O(V * E)
 * - Floyd-Warshall: O(V^3)
 *
 * Space Complexity:
 * - Bellman-Ford: O(V) for distances and predecessor arrays.
 * - Floyd-Warshall: O(V^2) for distance matrix.
 */
public class AdvancedShortestPaths {

    public static final int INF = 100_000_000; // Large sentinel avoiding 32-bit addition overflow

    public static class Edge {
        public final int u;
        public final int v;
        public final int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static class BellmanFordResult {
        public final int[] distances;
        public final int[] predecessor;
        public final boolean hasNegativeCycle;

        public BellmanFordResult(int[] distances, int[] predecessor, boolean hasNegativeCycle) {
            this.distances = distances;
            this.predecessor = predecessor;
            this.hasNegativeCycle = hasNegativeCycle;
        }

        public List<Integer> getPathTo(int dest) {
            if (hasNegativeCycle || distances[dest] >= INF) {
                return Collections.emptyList();
            }
            LinkedList<Integer> path = new LinkedList<>();
            for (int curr = dest; curr != -1; curr = predecessor[curr]) {
                path.addFirst(curr);
            }
            return path;
        }
    }

    /**
     * Computes single-source shortest path using Bellman-Ford algorithm.
     *
     * @param numVertices number of vertices (0 to numVertices - 1)
     * @param edges list of directed edges
     * @param source source vertex
     * @return BellmanFordResult containing distances, paths, and negative cycle indicator
     */
    public static BellmanFordResult bellmanFord(int numVertices, List<Edge> edges, int source) {
        int[] dist = new int[numVertices];
        int[] pred = new int[numVertices];
        Arrays.fill(dist, INF);
        Arrays.fill(pred, -1);
        dist[source] = 0;

        // Relax all edges (V - 1) times
        for (int i = 1; i < numVertices; i++) {
            boolean relaxed = false;
            for (Edge edge : edges) {
                if (dist[edge.u] < INF && dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                    pred[edge.v] = edge.u;
                    relaxed = true;
                }
            }
            if (!relaxed) {
                break; // Early termination optimization if no edge relaxed
            }
        }

        // V-th iteration: Check for negative-weight cycles
        boolean hasNegativeCycle = false;
        for (Edge edge : edges) {
            if (dist[edge.u] < INF && dist[edge.u] + edge.weight < dist[edge.v]) {
                hasNegativeCycle = true;
                break;
            }
        }

        return new BellmanFordResult(dist, pred, hasNegativeCycle);
    }

    /**
     * Computes All-Pairs Shortest Path using Floyd-Warshall algorithm.
     *
     * @param numVertices number of vertices
     * @param matrix initial adjacency weight matrix (matrix[i][j] = INF if no edge, matrix[i][i] = 0)
     * @return 2D distance matrix of shortest paths, or null if a negative cycle is detected
     */
    public static int[][] floydWarshall(int numVertices, int[][] matrix) {
        int[][] dist = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                dist[i][j] = matrix[i][j];
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }

        // Negative cycle check: if any dist[i][i] < 0
        for (int i = 0; i < numVertices; i++) {
            if (dist[i][i] < 0) {
                return null; // Negative cycle detected
            }
        }

        return dist;
    }
}

