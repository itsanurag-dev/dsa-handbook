# Topological Sort & Cycle Detection

Algorithms for Directed Acyclic Graphs (DAGs) and dependency resolution.

---

## 1. Kahn's Algorithm
- BFS-based topological sorting using in-degrees.
- Detects cycles when extracted order size $< V$.
- **Time Complexity:** $O(V + E)$
- **Space Complexity:** $O(V + E)$

---

## 2. 3-Color DFS Cycle Detection
- Uses WHITE (0), GRAY (1), and BLACK (2) vertex states to detect back-edges.
- **Time Complexity:** $O(V + E)$
- **Space Complexity:** $O(V)$

---

## Java Implementation (`KahnTopologicalSort.java`)

<<< @/../src/main/java/com/codex/dsa/graphs/KahnTopologicalSort.java

---

## Java Implementation (`CyckeDetectionInDAG.java`)

<<< @/../src/main/java/com/codex/dsa/graphs/CyckeDetectionInDAG.java

