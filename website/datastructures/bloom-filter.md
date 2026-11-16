# Bloom Filter

A space-efficient probabilistic data structure testing set membership with zero false negatives and configurable false positive rates using Kirsch-Mitzenmacher double hashing.

---

## Complexities

| Operation | Time Complexity | Space Complexity |
| :--- | :---: | :---: |
| **Add** | $O(K)$ | $O(M)$ bits |
| **MightContain** | $O(K)$ | $O(1)$ |

---

## Java Implementation (`BloomFilter.java`)

<<< @/../src/main/java/com/codex/dsa/hashmaps/BloomFilter.java

---

## Unit Tests (`BloomFilterTest.java`)

<<< @/../src/test/java/com/codex/dsa/hashmaps/BloomFilterTest.java

