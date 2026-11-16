# Segment Tree with Lazy Propagation

A Segment Tree capable of answering range queries (e.g. range sum) and performing deferred range updates in $O(\log N)$ using **Lazy Propagation**.

---

## Complexities

| Operation | Time Complexity | Space Complexity |
| :--- | :---: | :---: |
| **Build** | $O(N)$ | $4N = O(N)$ |
| **Range Query $[L, R]$** | $O(\log N)$ | $O(\log N)$ stack |
| **Range Update $[L, R]$** | $O(\log N)$ | $O(\log N)$ stack |

---

## Java Implementation (`SegmentTree.java`)

<<< @/../src/main/java/com/codex/dsa/trees/SegmentTree.java

---

## Unit Tests (`SegmentTreeTest.java`)

<<< @/../src/test/java/com/codex/dsa/trees/SegmentTreeTest.java

