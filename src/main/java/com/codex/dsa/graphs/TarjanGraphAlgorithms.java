package com.codex.dsa.graphs;

import java.util.*;

/**
 * Concept:
 * Tarjan's algorithms for discovering critical sub-structures in graphs using DFS tree properties
 * (Discovery time `tin` and Low-link value `low`).
 * 1. Bridges (Critical Connections):
 *    - An edge (u, v) is a bridge if removing it increases the number of connected components.
 *    - Condition in undirected graph: low[v] > tin[u] (no back-edge from subtree of v to u or higher).
 * 2. Strongly Connected Components (SCC):
 *    - A maximal subgraph of a directed graph where every vertex is reachable from every other vertex.
 *    - A vertex u is the root of an SCC when low[u] == tin[u]. All nodes in its SCC are popped from the stack.
 *
 * Time Complexity:
 * - Bridges: O(V + E) single DFS traversal.
 * - Tarjan's SCC: O(V + E) single DFS traversal.
 *
 * Space Complexity:
 * - O(V + E) for adjacency list, visited tracking, recursion stack, and result storage.
 */
public class TarjanGraphAlgorithms {

    public static class Edge {
        public final int u;
        public final int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return (u == edge.u && v == edge.v) || (u == edge.v && v == edge.u);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Math.min(u, v), Math.max(u, v));
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", u, v);
        }
    }

    /**
     * Finds all bridges (critical connections) in an undirected graph.
     *
     * @param numVertices number of vertices (0 to numVertices - 1)
     * @param edges list of undirected edges
     * @return list of bridges
     */
    public static List<Edge> findBridges(int numVertices, List<Edge> edges) {
        List<List<Integer>> adj = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adj.add(new ArrayList<>());
        }
        for (Edge e : edges) {
            adj.get(e.u).add(e.v);
            adj.get(e.v).add(e.u);
        }

        int[] tin = new int[numVertices];
        int[] low = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(tin, -1);
        Arrays.fill(low, -1);

        List<Edge> bridges = new ArrayList<>();
        int[] timer = new int[]{0};

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfsBridge(i, -1, timer, visited, tin, low, adj, bridges);
            }
        }

        return bridges;
    }

    private static void dfsBridge(int u, int p, int[] timer, boolean[] visited,
                                  int[] tin, int[] low, List<List<Integer>> adj, List<Edge> bridges) {
        visited[u] = true;
        tin[u] = low[u] = ++timer[0];

        for (int to : adj.get(u)) {
            if (to == p) continue; // Direct parent edge in undirected graph

            if (visited[to]) {
                // Back-edge
                low[u] = Math.min(low[u], tin[to]);
            } else {
                // Forward tree edge
                dfsBridge(to, u, timer, visited, tin, low, adj, bridges);
                low[u] = Math.min(low[u], low[to]);
                if (low[to] > tin[u]) {
                    bridges.add(new Edge(u, to));
                }
            }
        }
    }

    /**
     * Finds all Strongly Connected Components (SCCs) in a directed graph using Tarjan's algorithm.
     *
     * @param numVertices number of vertices (0 to numVertices - 1)
     * @param adj directed adjacency list
     * @return list of SCC components, where each component is a list of vertex IDs
     */
    public static List<List<Integer>> findSCCs(int numVertices, List<List<Integer>> adj) {
        int[] tin = new int[numVertices];
        int[] low = new int[numVertices];
        boolean[] inStack = new boolean[numVertices];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(tin, -1);
        Arrays.fill(low, -1);

        List<List<Integer>> sccs = new ArrayList<>();
        int[] timer = new int[]{0};

        for (int i = 0; i < numVertices; i++) {
            if (tin[i] == -1) {
                dfsSCC(i, timer, tin, low, inStack, stack, adj, sccs);
            }
        }

        return sccs;
    }

    private static void dfsSCC(int u, int[] timer, int[] tin, int[] low,
                               boolean[] inStack, Deque<Integer> stack,
                               List<List<Integer>> adj, List<List<Integer>> sccs) {
        tin[u] = low[u] = ++timer[0];
        stack.push(u);
        inStack[u] = true;

        for (int v : adj.get(u)) {
            if (tin[v] == -1) {
                dfsSCC(v, timer, tin, low, inStack, stack, adj, sccs);
                low[u] = Math.min(low[u], low[v]);
            } else if (inStack[v]) {
                low[u] = Math.min(low[u], tin[v]);
            }
        }

        // Head of SCC found
        if (low[u] == tin[u]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                inStack[node] = false;
                scc.add(node);
                if (node == u) break;
            }
            sccs.add(scc);
        }
    }
}

