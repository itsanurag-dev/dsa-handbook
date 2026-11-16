# String Matching Algorithms

Linear and sub-linear string pattern matching algorithms.

---

## 1. Knuth-Morris-Pratt (KMP)
- Avoids re-matching characters by computing the Longest Proper Prefix which is also a Suffix (LPS / $\pi$ array).
- **Time Complexity:** $O(N + M)$ deterministic.
- **Space Complexity:** $O(M)$ for the $\pi$ array.

---

## 2. Rabin-Karp Algorithm
- Uses rolling polynomial hash to compare windows in $O(1)$ amortized time.
- Verifies characters on match to prevent hash collisions.
- **Time Complexity:** $O(N + M)$ average, $O(N \cdot M)$ worst case.
- **Space Complexity:** $O(1)$ auxiliary.

---

## Java Implementation (`StringMatchingAlgorithms.java`)

<<< @/../src/main/java/com/codex/dsa/strings/StringMatchingAlgorithms.java

---

## Unit Tests (`StringMatchingAlgorithmsTest.java`)

<<< @/../src/test/java/com/codex/dsa/strings/StringMatchingAlgorithmsTest.java

