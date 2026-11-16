# Knapsack Problem

Dynamic programming solutions for 0/1 Knapsack and Unbounded Knapsack with 1D space optimizations.

---

## 1. 0/1 Knapsack
- Each item can be chosen at most once.
- Traverses capacities backwards: $W \to w_i$.
- **Time Complexity:** $O(N \cdot W)$
- **Space Complexity:** $O(W)$

---

## 2. Unbounded Knapsack
- Items may be reused an unlimited number of times.
- Traverses capacities forwards: $w_i \to W$.
- **Time Complexity:** $O(N \cdot W)$
- **Space Complexity:** $O(W)$

---

## Java Implementation (`Knapsack.java`)

<<< @/../src/main/java/com/codex/dsa/dynamicprogramming/Knapsack.java

