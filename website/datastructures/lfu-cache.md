# LFU Cache (Least Frequently Used)

An $O(1)$ LFU Cache eviction implementation using dual hash maps and doubly linked frequency lists.

---

## Complexities

| Operation | Average Case | Worst Case | Space Complexity |
| :--- | :---: | :---: | :---: |
| **Get** | $O(1)$ | $O(1)$ | $O(1)$ |
| **Put** | $O(1)$ | $O(1)$ | $O(1)$ |

---

## Java Implementation (`LFUCache.java`)

<<< @/../src/main/java/com/codex/dsa/hashmaps/LFUCache.java

---

## Unit Tests (`LFUCacheTest.java`)

<<< @/../src/test/java/com/codex/dsa/hashmaps/LFUCacheTest.java

