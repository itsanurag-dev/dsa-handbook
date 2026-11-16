# Advanced Shortest Paths

Implementations of single-source and all-pairs shortest paths on graphs supporting negative edge weights and negative cycle detection.

---

## 1. Bellman-Ford Algorithm
- Single-source shortest path algorithm that handles negative weight edges.
- Detects negative weight cycles on a $V$-th relaxation pass.
- **Time Complexity:** $O(V \cdot E)$
- **Space Complexity:** $O(V)$

---

## 2. Floyd-Warshall Algorithm
- All-Pairs Shortest Path (APSP) using dynamic programming.
- Uses intermediate vertex relaxation: $d[i][j] = \min(d[i][j], d[i][k] + d[k][j])$.
- **Time Complexity:** $O(V^3)$
- **Space Complexity:** $O(V^2)$

---

## Java Implementation (`AdvancedShortestPaths.java`)

<<< @/../src/main/java/com/codex/dsa/graphs/AdvancedShortestPaths.java

---

## Unit Tests (`AdvancedShortestPathsTest.java`)

<<< @/../src/test/java/com/codex/dsa/graphs/AdvancedShortestPathsTest.java

