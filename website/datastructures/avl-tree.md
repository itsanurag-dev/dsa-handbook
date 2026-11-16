# AVL Tree (Self-Balancing Binary Search Tree)

An **AVL Tree** is a self-balancing Binary Search Tree where the heights of the two child subtrees of any node differ by at most one (Balance Factor $\in \{-1, 0, 1\}$).

---

## Complexities

| Operation | Average Case | Worst Case | Space Complexity |
| :--- | :---: | :---: | :---: |
| **Search** | $O(\log N)$ | $O(\log N)$ | $O(1)$ |
| **Insert** | $O(\log N)$ | $O(\log N)$ | $O(\log N)$ call stack |
| **Delete** | $O(\log N)$ | $O(\log N)$ | $O(\log N)$ call stack |

---

## Rotations Summary
- **Left-Left (LL):** Single right rotation on parent.
- **Right-Right (RR):** Single left rotation on parent.
- **Left-Right (LR):** Left rotation on child, followed by right rotation on parent.
- **Right-Left (RL):** Right rotation on child, followed by left rotation on parent.

---

## Java Implementation (`AVLTree.java`)

<<< @/../src/main/java/com/codex/dsa/trees/AVLTree.java

---

## Unit Tests (`AVLTreeTest.java`)

<<< @/../src/test/java/com/codex/dsa/trees/AVLTreeTest.java

