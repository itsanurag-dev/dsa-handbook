# Trie (Prefix Tree)

An interview-grade Trie supporting prefix queries, prefix counting, and complete word deletion.

---

## Complexities

| Operation | Average Case | Worst Case | Space Complexity |
| :--- | :---: | :---: | :---: |
| **Insert** | $O(L)$ | $O(L)$ | $O(L)$ |
| **Search** | $O(L)$ | $O(L)$ | $O(1)$ |
| **StartsWith** | $O(L)$ | $O(L)$ | $O(1)$ |
| **Delete** | $O(L)$ | $O(L)$ | $O(L)$ stack |

---

## Java Implementation (`Trie.java`)

<<< @/../src/main/java/com/codex/dsa/trie/Trie.java

---

## Unit Tests (`TrieTest.java`)

<<< @/../src/test/java/com/codex/dsa/trie/TrieTest.java

