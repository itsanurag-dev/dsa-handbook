# Minimum Spanning Tree (MST)

Implementations of Kruskal's and Prim's algorithms for finding Minimum Spanning Trees in weighted, undirected graphs.

---

## 1. Kruskal's Algorithm
- Greedy edge-centric approach.
- Employs **Disjoint Set Union (DSU)** with **Path Compression** and **Union by Rank**.
- **Time Complexity:** $O(E \log E) = O(E \log V)$
- **Space Complexity:** $O(V + E)$

---

## 2. Prim's Algorithm
- Greedy vertex-centric approach growing tree from a source node using a Min-Heap.
- **Time Complexity:** $O(E \log V)$
- **Space Complexity:** $O(V + E)$

---

## Java Implementation (`MinimumSpanningTree.java`)

<<< @/../src/main/java/com/codex/dsa/graphs/MinimumSpanningTree.java

---

## Unit Tests (`MinimumSpanningTreeTest.java`)

<<< @/../src/test/java/com/codex/dsa/graphs/MinimumSpanningTreeTest.java

