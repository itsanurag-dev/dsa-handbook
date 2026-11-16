# DSA Handbook

[![Java CI with Maven](https://github.com/anurag-tiwari-3108/dsa-handbook/actions/workflows/ci.yml/badge.svg)](https://github.com/anurag-tiwari-3108/dsa-handbook/actions)
![Java](https://img.shields.io/badge/Java-11%20%7C%2017%20%7C%2021-blue.svg)
![Build](https://img.shields.io/badge/Maven-3.9+-green.svg)
![Tests](https://img.shields.io/badge/JUnit-5-brightgreen.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

An interview-grade, modular, and fully tested reference repository for **Data Structures and Algorithms** in Java. Designed for technical interview preparation at tier-1 tech firms and quant trading platforms.

🌐 **Interactive Web Portal:** [https://anurag-tiwari-3108.github.io/dsa-handbook/](https://anurag-tiwari-3108.github.io/dsa-handbook/)

---

## Progress & Curriculum Checklist

### 1. Reusable Data Structures
- [x] **AVL Tree** (Self-Balancing BST with 4 rotation cases: LL, RR, LR, RL) — `com.codex.dsa.trees.AVLTree`
- [x] **Separate Chaining Hash Table** (Load factor dynamic rehashing) — `com.codex.dsa.hashmaps.SeparateChainingHashTable`
- [x] **LFU Cache** ($O(1)$ operations with frequency buckets and LRU tie-breaking) — `com.codex.dsa.hashmaps.LFUCache`
- [x] **Trie (Prefix Tree)** (Insert, search, prefix count, word deletion) — `com.codex.dsa.trie.Trie`
- [x] **Bloom Filter** (Probabilistic set membership with double hashing) — `com.codex.dsa.hashmaps.BloomFilter`
- [x] **Skip List** (Probabilistic $O(\log N)$ search, insert, and delete) — `com.codex.dsa.linkedlists.SkipList`
- [x] **Segment Tree** (Range sum queries with lazy propagation) — `com.codex.dsa.trees.SegmentTree`
- [x] **Fenwick Tree (Binary Indexed Tree)** (Prefix sums & point updates) — `com.codex.dsa.trees.FenwickTree`
- [x] **Disjoint Set Union (DSU / Union-Find)** (Path compression & rank) — `com.codex.dsa.graphs.MinimumSpanningTree.DSU`
- [x] **Flexible Multi-Stack** (Dynamic $K$ stacks in a shared array) — `com.codex.dsa.stacks.FlaxibleMultistackFromArray`

### 2. Graph Algorithms
- [x] **Minimum Spanning Tree (MST)**
  - [x] Kruskal's Algorithm (DSU + greedy edge sorting) — `MinimumSpanningTree.kruskalMST`
  - [x] Prim's Algorithm (Min-Heap + adjacency list) — `MinimumSpanningTree.primMST`
- [x] **Advanced Shortest Paths**
  - [x] Bellman-Ford (Negative edge weights & cycle detection) — `AdvancedShortestPaths.bellmanFord`
  - [x] Floyd-Warshall (All-Pairs Shortest Path $O(V^3)$) — `AdvancedShortestPaths.floydWarshall`
- [x] **Connectivity & Components**
  - [x] Tarjan's Bridge-Finding (Critical connections) — `TarjanGraphAlgorithms.findBridges`
  - [x] Tarjan's Strongly Connected Components (SCC) — `TarjanGraphAlgorithms.findSCCs`
- [x] **Topological Sorting & Cycle Detection**
  - [x] Kahn's Algorithm (Indegree queue BFS) — `com.codex.dsa.graphs.KahnTopologicalSort`
  - [x] 3-Color DFS Cycle Detection — `com.codex.dsa.graphs.CyckeDetectionInDAG`
  - [x] Route Between Nodes BFS — `com.codex.dsa.graphs.RouteBetweenNodes`
- [x] **Breadth-First Search (BFS) & Depth-First Search (DFS)** — `com.codex.dsa.graphs.*`

### 3. String & Pattern Matching
- [x] **Knuth-Morris-Pratt (KMP)** ($O(N + M)$ deterministic linear matching) — `StringMatchingAlgorithms.kmpSearch`
- [x] **Rabin-Karp** (Rolling polynomial hash matching) — `StringMatchingAlgorithms.rabinKarpSearch`
- [x] **Shortest Balanced Fragment** — `com.codex.dsa.strings.BalanceString`

### 4. Algorithmic Paradigms
- [x] **Binary Search on Answer** (Monotonic predicate search, capacity shipping, split array sum) — `BinarySearchOnAnswer`
- [x] **Dynamic Programming**
  - [x] 0/1 & Unbounded Knapsack ($O(N \cdot W)$ time, $O(W)$ space) — `com.codex.dsa.dynamicprogramming.Knapsack`
  - [x] Unique BSTs (Catalan DP) — `com.codex.dsa.binarysearchtree.UniqueBST`
  - [x] Longest Common Subsequence & Levenshtein Distance
- [x] **Greedy & Combinatorics**
  - [x] Activity Selection Problem (Interval scheduling) — `com.codex.dsa.greedyalgorithms.ActivitySelectionProblem`
  - [x] Permutation Sequence ($K$-th permutation in factorial number system) — `com.codex.dsa.arrays.PermutationSequence`
- [x] **Matrix Operations**
  - [x] In-place 90° Clockwise Rotation — `com.codex.dsa.matrices.RotateMatrix`
- [x] **Backtracking** (N-Queens, Sudoku, Rat in Maze, Knight's Tour, Word Boggle) — `com.codex.dsa.backtracking.*`

---

## Complexity Cheat Sheet

A comprehensive reference for time and space complexities is available at:
👉 **[docs/COMPLEXITY_CHEAT_SHEET.md](docs/COMPLEXITY_CHEAT_SHEET.md)**

---

## Getting Started

### Prerequisites
- **Java Development Kit (JDK):** Version 11 or higher (JDK 17/21 recommended)
- **Apache Maven:** Version 3.8+

### Build and Test
```bash
# Compile all source files
mvn clean compile

# Execute all JUnit 5 test suites
mvn test

# Package JAR
mvn package
```

---

## Project Structure

```
Data-Structure-And-Algo/
├── .github/workflows/ci.yml       # Automated GitHub Actions CI workflow
├── docs/
│   └── COMPLEXITY_CHEAT_SHEET.md  # Complete Big-O cheat sheet
├── pom.xml                        # Maven configuration & JUnit 5 test harness
├── .gitignore                     # Java, Maven, IntelliJ, Mac exclusion rules
├── README.md                      # Documentation & progress checklist
└── src/
    ├── main/java/com/codex/dsa/   # Production source implementations
    │   ├── arrays/
    │   ├── backtracking/
    │   ├── binarysearchtree/
    │   ├── bitwise/
    │   ├── divideandconquer/
    │   ├── dynamicprogramming/
    │   ├── graphs/
    │   ├── greedyalgorithms/
    │   ├── hashmaps/
    │   ├── linkedlists/
    │   ├── matrices/
    │   ├── stacks/
    │   ├── strings/
    │   ├── trees/
    │   └── trie/
    └── test/java/com/codex/dsa/   # Unit tests with JUnit 5
        ├── divideandconquer/
        ├── graphs/
        ├── hashmaps/
        ├── strings/
        └── trees/
```

---

## Contributing
1. Follow standard Java naming conventions and generics.
2. Provide Javadoc with explicit **Time & Space Complexity** and approach details.
3. Every new data structure or algorithm must have a corresponding JUnit 5 test class under `src/test/java/` covering standard and edge cases.
4. Ensure `mvn clean test` passes with zero warnings or failures.

---

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
