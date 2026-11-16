package com.codex.dsa.graphs;

import java.util.*;

/**
 * Concept:
 * Kahn's Algorithm for Topological Sorting of a Directed Acyclic Graph (DAG) using BFS.
 * - Computes the in-degree of all vertices.
 * - Enqueues all vertices with in-degree 0 (no dependencies).
 * - Repeatedly extracts a vertex from the queue, appends it to topological order,
 *   and decrements the in-degrees of its neighbors. If a neighbor reaches in-degree 0, enqueue it.
 * - If the result list has fewer than V vertices, the graph contains a cycle!
 *
 * Time Complexity:
 * - O(V + E) linear time.
 *
 * Space Complexity:
 * - O(V + E) for adjacency list and indegree queue.
 */
public class KahnTopologicalSort {

    /**
     * Computes a valid topological order using Kahn's algorithm.
     *
     * @param numVertices number of vertices (0 to numVertices - 1)
     * @param adj directed adjacency list
     * @return topological ordering of vertices, or null if the graph contains a cycle
     */
    public static List<Integer> topologicalSort(int numVertices, List<List<Integer>> adj) {
        if (numVertices <= 0) return Collections.emptyList();

        int[] inDegree = new int[numVertices];
        for (int u = 0; u < numVertices; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>(numVertices);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (order.size() != numVertices) {
            return null; // Cycle detected: graph is not a DAG
        }

        return order;
    }
}
