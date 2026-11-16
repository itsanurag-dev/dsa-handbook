# Skip List

A probabilistic alternative to balanced trees, using layered express lanes for $O(\log N)$ search, insertion, and deletion.

---

## Complexities

| Operation | Average Case | Worst Case | Space Complexity |
| :--- | :---: | :---: | :---: |
| **Search** | $O(\log N)$ | $O(N)$ | $O(1)$ |
| **Insert** | $O(\log N)$ | $O(N)$ | $O(\text{height})$ |
| **Delete** | $O(\log N)$ | $O(N)$ | $O(1)$ |

---

## Java Implementation (`SkipList.java`)

<<< @/../src/main/java/com/codex/dsa/linkedlists/SkipList.java

---

## Unit Tests (`SkipListTest.java`)

<<< @/../src/test/java/com/codex/dsa/linkedlists/SkipListTest.java

