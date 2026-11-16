package com.codex.dsa.graphs;

import java.util.*;

/**
 * Concept:
 * Minimum Spanning Tree (MST) algorithms for connected, undirected, weighted graphs.
 * - Kruskal's Algorithm: Greedy edge-centric approach. Sorts all edges in non-decreasing
 *   order of weight and greedily adds each edge to the MST if it does not form a cycle,
 *   using Disjoint Set Union (Union-Find) with path compression and rank optimization.
 * - Prim's Algorithm: Greedy vertex-centric approach. Starts from an arbitrary source vertex
 *   and repeatedly grows the spanning tree by selecting the minimum-weight cut edge using a Min-Heap.
 *
 * Time Complexity:
 * - Kruskal's Algorithm: O(E log E) or O(E log V) to sort edges, where DSU operations take O(E * alpha(V)).
 * - Prim's Algorithm: O(E log V) using a binary priority queue.
 *
 * Space Complexity:
 * - Kruskal: O(V + E) for DSU and edge list.
 * - Prim: O(V + E) for adjacency list, visited set, and priority queue.
 */
public class MinimumSpanningTree {

    public static class Edge implements Comparable<Edge> {
        public final int u;
        public final int v;
        public final int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }

        @Override
        public String toString() {
            return String.format("(%d - %d : %d)", u, v, weight);
        }
    }

    public static class MSTResult {
        public final List<Edge> edges;
        public final int totalWeight;

        public MSTResult(List<Edge> edges, int totalWeight) {
            this.edges = edges;
            this.totalWeight = totalWeight;
        }
    }

    /**
     * Internal Disjoint Set Union with path compression and union by rank.
     */
    public static class DSU {
        private final int[] parent;
        private final int[] rank;
        private int components;

        public DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]); // Path compression
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) return false;

            // Union by rank
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
            components--;
            return true;
        }

        public int getComponents() {
            return components;
        }
    }

    /**
     * Kruskal's MST algorithm.
     *
     * @param numVertices number of vertices (0 to numVertices - 1)
     * @param edges list of undirected edges
     * @return MSTResult containing the MST edges and total weight, or null if graph is disconnected
     */
    public static MSTResult kruskalMST(int numVertices, List<Edge> edges) {
        if (numVertices <= 0) return new MSTResult(Collections.emptyList(), 0);
        if (numVertices == 1) return new MSTResult(Collections.emptyList(), 0);

        List<Edge> sortedEdges = new ArrayList<>(edges);
        Collections.sort(sortedEdges);

        DSU dsu = new DSU(numVertices);
        List<Edge> mstEdges = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : sortedEdges) {
            if (dsu.union(edge.u, edge.v)) {
                mstEdges.add(edge);
                totalWeight += edge.weight;
                if (mstEdges.size() == numVertices - 1) {
                    break;
                }
            }
        }

        if (mstEdges.size() != numVertices - 1) {
            // Graph is disconnected, no spanning tree covers all vertices
            return null;
        }

        return new MSTResult(mstEdges, totalWeight);
    }

    /**
     * Prim's MST algorithm using an Adjacency List and PriorityQueue.
     *
     * @param numVertices number of vertices (0 to numVertices - 1)
     * @param edges list of undirected edges
     * @return MSTResult containing the MST edges and total weight, or null if graph is disconnected
     */
    public static MSTResult primMST(int numVertices, List<Edge> edges) {
        if (numVertices <= 0) return new MSTResult(Collections.emptyList(), 0);
        if (numVertices == 1) return new MSTResult(Collections.emptyList(), 0);

        // Build adjacency list
        List<List<Edge>> adj = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adj.add(new ArrayList<>());
        }
        for (Edge e : edges) {
            adj.get(e.u).add(new Edge(e.u, e.v, e.weight));
            adj.get(e.v).add(new Edge(e.v, e.u, e.weight));
        }

        boolean[] visited = new boolean[numVertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Start from vertex 0
        visited[0] = true;
        for (Edge e : adj.get(0)) {
            pq.offer(e);
        }

        List<Edge> mstEdges = new ArrayList<>();
        int totalWeight = 0;

        while (!pq.isEmpty() && mstEdges.size() < numVertices - 1) {
            Edge minEdge = pq.poll();
            int dest = minEdge.v;

            if (visited[dest]) {
                continue;
            }

            visited[dest] = true;
            mstEdges.add(minEdge);
            totalWeight += minEdge.weight;

            for (Edge neighborEdge : adj.get(dest)) {
                if (!visited[neighborEdge.v]) {
                    pq.offer(neighborEdge);
                }
            }
        }

        if (mstEdges.size() != numVertices - 1) {
            return null; // Disconnected graph
        }

        return new MSTResult(mstEdges, totalWeight);
    }
}

