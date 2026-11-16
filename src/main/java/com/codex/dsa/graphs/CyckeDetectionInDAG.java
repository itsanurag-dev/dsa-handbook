package com.codex.dsa.graphs;

import java.util.*;

/**
 * Concept:
 * Cycle Detection in a Directed Graph (DAG verification) using 3-color DFS state tracking:
 * - WHITE (0): Unvisited
 * - GRAY (1): Currently visiting in the current DFS recursion stack (active call stack)
 * - BLACK (2): Completely visited and all descendants explored
 *
 * If DFS encounters a GRAY vertex, a back-edge exists, confirming a cycle.
 *
 * Time Complexity:
 * - O(V + E)
 *
 * Space Complexity:
 * - O(V) for color tracking and recursion call stack.
 */
public class CyckeDetectionInDAG {

    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    /**
     * Checks if the directed graph contains a cycle.
     *
     * @param numVertices number of vertices
     * @param adj directed adjacency list
     * @return true if a cycle exists, false if it is a valid DAG
     */
    public static boolean hasCycle(int numVertices, List<List<Integer>> adj) {
        int[] color = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (color[i] == WHITE) {
                if (dfsCheckCycle(i, color, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCheckCycle(int u, int[] color, List<List<Integer>> adj) {
        color[u] = GRAY;

        for (int v : adj.get(u)) {
            if (color[v] == GRAY) {
                return true; // Found back-edge to an ancestor on current path
            }
            if (color[v] == WHITE && dfsCheckCycle(v, color, adj)) {
                return true;
            }
        }

        color[u] = BLACK;
        return false;
    }
}
