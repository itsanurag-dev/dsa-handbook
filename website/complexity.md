# Complexity Cheat Sheet

A quick-reference guide to Time and Space complexities for core Data Structures and Algorithms implemented in this repository.

---

## 1. Data Structures Operations

| Data Structure | Access (Avg / Worst) | Search (Avg / Worst) | Insertion (Avg / Worst) | Deletion (Avg / Worst) | Space Complexity |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Array** | $O(1)$ / $O(1)$ | $O(N)$ / $O(N)$ | $O(N)$ / $O(N)$ | $O(N)$ / $O(N)$ | $O(N)$ |
| **Dynamic Array (`ArrayList`)** | $O(1)$ / $O(1)$ | $O(N)$ / $O(N)$ | $O(1)^*$ / $O(N)$ | $O(N)$ / $O(N)$ | $O(N)$ |
| **Singly Linked List** | $O(N)$ / $O(N)$ | $O(N)$ / $O(N)$ | $O(1)$ / $O(1)$ | $O(1)$ / $O(1)$ | $O(N)$ |
| **Doubly Linked List** | $O(N)$ / $O(N)$ | $O(N)$ / $O(N)$ | $O(1)$ / $O(1)$ | $O(1)$ / $O(1)$ | $O(N)$ |
| **Stack (Array / List)** | $O(N)$ / $O(N)$ | $O(N)$ / $O(N)$ | $O(1)$ / $O(1)$ | $O(1)$ / $O(1)$ | $O(N)$ |
| **Queue (Circular Buffer / List)** | $O(N)$ / $O(N)$ | $O(N)$ / $O(N)$ | $O(1)$ / $O(1)$ | $O(1)$ / $O(1)$ | $O(N)$ |
| **Hash Table (Chaining / Probing)** | N/A | $O(1)$ / $O(N)$ | $O(1)^*$ / $O(N)$ | $O(1)$ / $O(N)$ | $O(N)$ |
| **Binary Search Tree (BST)** | $O(\log N)$ / $O(N)$ | $O(\log N)$ / $O(N)$ | $O(\log N)$ / $O(N)$ | $O(\log N)$ / $O(N)$ | $O(N)$ |
| **AVL Tree (Self-Balancing)** | $O(\log N)$ / $O(\log N)$ | $O(\log N)$ / $O(\log N)$ | $O(\log N)$ / $O(\log N)$ | $O(\log N)$ / $O(\log N)$ | $O(N)$ |
| **Binary Heap (Min / Max)** | $O(1)$ (peek min) | $O(N)$ | $O(\log N)$ | $O(\log N)$ (extract) | $O(N)$ |
| **Trie (Prefix Tree)** | N/A | $O(L)$ | $O(L)$ | $O(L)$ | $O(\Sigma \cdot N \cdot L)$ |
| **Segment Tree** | N/A | $O(\log N)$ (range query) | $O(\log N)$ (point/range) | N/A | $O(N)$ ($4N$ storage) |
| **Fenwick Tree (BIT)** | N/A | $O(\log N)$ (prefix sum) | $O(\log N)$ (point update) | N/A | $O(N)$ |
| **Disjoint Set Union (DSU)** | N/A | $O(\alpha(N))$ (find) | $O(\alpha(N))$ (union) | N/A | $O(N)$ |

*\* Denotes amortized complexity.*  
*$L$ = Length of string; $\Sigma$ = Alphabet size.*  
*$\alpha(N)$ = Inverse Ackermann function ($\le 4$ for all practical input sizes).*

---

## 2. Sorting Algorithms

| Algorithm | Best Time | Average Time | Worst Time | Space (Worst) | Stable? |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Merge Sort** | $O(N \log N)$ | $O(N \log N)$ | $O(N \log N)$ | $O(N)$ | Yes |
| **Quick Sort (3-Way / Random)** | $O(N \log N)$ | $O(N \log N)$ | $O(N^2)$ (rare) | $O(\log N)$ | No |
| **Heap Sort** | $O(N \log N)$ | $O(N \log N)$ | $O(N \log N)$ | $O(1)$ | No |
| **Counting Sort** | $O(N + K)$ | $O(N + K)$ | $O(N + K)$ | $O(K)$ | Yes |
| **Radix Sort** | $O(D \cdot (N + K))$ | $O(D \cdot (N + K))$ | $O(D \cdot (N + K))$ | $O(N + K)$ | Yes |
| **Insertion Sort** | $O(N)$ | $O(N^2)$ | $O(N^2)$ | $O(1)$ | Yes |

*$K$ = Range of integers; $D$ = Number of digits.*

---

## 3. Graph Algorithms

| Algorithm | Problem / Purpose | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Breadth-First Search (BFS)** | Shortest path (unweighted), traversal | $O(V + E)$ | $O(V)$ |
| **Depth-First Search (DFS)** | Reachability, cycle detection, topological sort | $O(V + E)$ | $O(V)$ |
| **Dijkstra's Algorithm** | Single-Source Shortest Path (non-negative weights) | $O(E \log V)$ | $O(V + E)$ |
| **Bellman-Ford Algorithm** | Single-Source Shortest Path (negative weights + cycle detection) | $O(V \cdot E)$ | $O(V)$ |
| **Floyd-Warshall Algorithm** | All-Pairs Shortest Path (APSP) | $O(V^3)$ | $O(V^2)$ |
| **Kruskal's Algorithm** | Minimum Spanning Tree (MST) | $O(E \log E)$ | $O(V + E)$ |
| **Prim's Algorithm** | Minimum Spanning Tree (MST) | $O(E \log V)$ | $O(V + E)$ |
| **Tarjan's Bridges** | Critical connections / bridges in undirected graphs | $O(V + E)$ | $O(V + E)$ |
| **Tarjan's SCC** | Strongly Connected Components in directed graphs | $O(V + E)$ | $O(V + E)$ |
| **Kahn's Algorithm** | Topological sorting via indegree BFS | $O(V + E)$ | $O(V + E)$ |

---

## 4. String & Pattern Matching

| Algorithm | Average Time | Worst Time | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Knuth-Morris-Pratt (KMP)** | $O(N + M)$ | $O(N + M)$ | $O(M)$ (LPS array) |
| **Rabin-Karp** | $O(N + M)$ | $O(N \cdot M)$ | $O(1)$ |
| **Z-Algorithm** | $O(N + M)$ | $O(N + M)$ | $O(N + M)$ |
| **Manacher's Algorithm** | $O(N)$ | $O(N)$ | $O(N)$ |

