# Tarjan's Graph Connectivity Algorithms

Discovers critical substructures in graphs using DFS tree discovery times (`tin`) and low-link values (`low`).

---

## 1. Bridges (Critical Connections)
- Identifies cut-edges in undirected graphs where removing the edge increases connected components.
- Condition: `low[v] > tin[u]`.
- **Time Complexity:** $O(V + E)$
- **Space Complexity:** $O(V + E)$

---

## 2. Strongly Connected Components (SCC)
- Partitions directed graphs into maximal subgraphs where every vertex is mutually reachable.
- Employs an explicit recursion stack tracking active SCC candidates.
- **Time Complexity:** $O(V + E)$
- **Space Complexity:** $O(V + E)$

---

## Java Implementation (`TarjanGraphAlgorithms.java`)

<<< @/../src/main/java/com/codex/dsa/graphs/TarjanGraphAlgorithms.java

---

## Unit Tests (`TarjanGraphAlgorithmsTest.java`)

<<< @/../src/test/java/com/codex/dsa/graphs/TarjanGraphAlgorithmsTest.java

