# Separate Chaining Hash Table

A custom hash table implementation using **Separate Chaining** for collision resolution and automatic dynamic rehashing when the load factor $\alpha \ge 0.75$.

---

## Complexities

| Operation | Average Case | Worst Case | Space Complexity |
| :--- | :---: | :---: | :---: |
| **Get** | $O(1)$ | $O(N)$ | $O(1)$ |
| **Put** | $O(1)$ amortized | $O(N)$ | $O(1)$ |
| **Remove** | $O(1)$ | $O(N)$ | $O(1)$ |

---

## Java Implementation (`SeparateChainingHashTable.java`)

<<< @/../src/main/java/com/codex/dsa/hashmaps/SeparateChainingHashTable.java

---

## Unit Tests (`SeparateChainingHashTableTest.java`)

<<< @/../src/test/java/com/codex/dsa/hashmaps/SeparateChainingHashTableTest.java

