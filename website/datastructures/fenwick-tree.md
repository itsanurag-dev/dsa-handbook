# Fenwick Tree (Binary Indexed Tree)

A Fenwick Tree / Binary Indexed Tree (BIT) maintaining dynamic prefix sums and point updates via the least significant bit (`i & -i`).

---

## Complexities

| Operation | Time Complexity | Space Complexity |
| :--- | :---: | :---: |
| **Build** | $O(N)$ linear | $O(N)$ array |
| **Point Update** | $O(\log N)$ | $O(1)$ |
| **Prefix Query** | $O(\log N)$ | $O(1)$ |
| **Range Query $[L, R]$** | $O(\log N)$ | $O(1)$ |

---

## Java Implementation (`FenwickTree.java`)

<<< @/../src/main/java/com/codex/dsa/trees/FenwickTree.java

---

## Unit Tests (`FenwickTreeTest.java`)

<<< @/../src/test/java/com/codex/dsa/trees/FenwickTreeTest.java

