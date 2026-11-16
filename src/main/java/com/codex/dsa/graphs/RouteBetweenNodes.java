package com.codex.dsa.graphs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Concept:
 * Route Between Nodes: Determines if there is a directed path between two given vertices
 * in a directed graph using Breadth-First Search (BFS).
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V) for visited array and BFS queue.
 */
public class RouteBetweenNodes {

    public static boolean hasRoute(int numVertices, List<List<Integer>> adj, int start, int end) {
        if (start < 0 || start >= numVertices || end < 0 || end >= numVertices) {
            return false;
        }
        if (start == end) return true;

        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : adj.get(curr)) {
                if (neighbor == end) {
                    return true;
                }
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }
}
