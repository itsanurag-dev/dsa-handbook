---
layout: home

hero:
  name: "DSA Codex"
  text: "The Algorithmic Standard Library"
  tagline: "178 battle-tested Java implementations engineered from first principles. Formally analyzed complexities, zero-dependency architectures, and comprehensive JUnit 5 verification."
  actions:
    - theme: brand
      text: Browse Library (178)
      link: /arrays/continuoussubarraymaximumsum
    - theme: alt
      text: Complexity Matrix
      link: /complexity
    - theme: alt
      text: GitHub Repository
      link: https://github.com/itsanurag-dev/dsa-handbook

features:
  - title: First-Principles Implementations
    details: "From self-balancing AVL trees and Tarjan's SCC to O(1) LFU caches and rolling hashes—engineered with zero external dependencies."
  - title: Provable Invariants & Big-O
    details: "Strict mathematical analysis of average, worst-case, and auxiliary space bounds, paired with deep algorithmic trade-off documentation."
  - title: Regression-Gated Test Suites
    details: "58 comprehensive JUnit 5 suites stress-testing edge cases: branch degenerations, hash collisions, tree rotations, and empty bounds."
---

<div style="margin-top: 64px; margin-bottom: 24px;">
  <div style="display: flex; align-items: baseline; justify-content: space-between; border-bottom: 1px solid var(--vp-c-divider); padding-bottom: 12px;">
    <h2 style="font-size: 1.4rem; font-weight: 700; letter-spacing: -0.02em; margin: 0;">Architectural Modules</h2>
    <span style="font-size: 0.85rem; color: var(--vp-c-text-2); font-family: var(--vp-font-family-mono);">15 Packages • 178 Implementations</span>
  </div>
</div>

<div class="category-grid">
  <a href="./arrays/continuoussubarraymaximumsum.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Arrays & Sliding Window</span>
      <span class="card-badge">38 files</span>
    </div>
    <p>Kadane's algorithm, Dutch National Flag, two-pointer bounds, and sliding window optimization.</p>
  </a>

  <a href="./trees/avltree.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Trees & Traversals</span>
      <span class="card-badge">29 files</span>
    </div>
    <p>Self-balancing AVL trees with LL/RR/LR/RL rotations, diameter, views, and serialized N-ary trees.</p>
  </a>

  <a href="./strings/stringmatchingalgorithms.html" class="category-card">
    <div class="card-header">
      <span class="card-title">String Algorithms</span>
      <span class="card-badge">21 files</span>
    </div>
    <p>Knuth-Morris-Pratt (KMP), Rabin-Karp polynomial rolling hash, LCS, and Levenshtein edit distance.</p>
  </a>

  <a href="./graphs/advancedshortestpaths.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Graph Algorithms</span>
      <span class="card-badge">19 files</span>
    </div>
    <p>Bellman-Ford, Floyd-Warshall, Kruskal & Prim MST, Tarjan's bridges & SCC, and Kahn's topological sort.</p>
  </a>

  <a href="./hashmaps/separatechaininghashtable.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Hash Maps & Caches</span>
      <span class="card-badge">15 files</span>
    </div>
    <p>Separate chaining with dynamic load-factor rehashing, O(1) LFU cache, and probabilistic Bloom filter.</p>
  </a>

  <a href="./backtracking/nqueen.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Backtracking</span>
      <span class="card-badge">11 files</span>
    </div>
    <p>N-Queens, 9x9 Sudoku solver, Rat in a Maze, Knight's Tour, and Boggle word search.</p>
  </a>

  <a href="./stacks/flaxiblemultistackfromarray.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Stacks & Queues</span>
      <span class="card-badge">9 files</span>
    </div>
    <p>Flexible multi-stack in a single array with free-list allocation, Min-Stack, and balanced delimiters.</p>
  </a>

  <a href="./binarysearchtree/bstcrudoperations.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Binary Search Trees</span>
      <span class="card-badge">9 files</span>
    </div>
    <p>BST CRUD operations, preorder reconstruction, monotonic validation, and minimal tree generation.</p>
  </a>

  <a href="./linkedlists/skiplist.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Linked Lists</span>
      <span class="card-badge">6 files</span>
    </div>
    <p>Probabilistic Skip List express lanes, Floyd's cycle detection, and K-way sorted list merging.</p>
  </a>

  <a href="./dynamicprogramming/knapsack.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Dynamic Programming</span>
      <span class="card-badge">3 files</span>
    </div>
    <p>0/1 & Unbounded Knapsack (1D space-optimized), Catalan number unique BSTs, and coin change.</p>
  </a>

  <a href="./divideandconquer/binarysearchonanswer.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Divide & Conquer</span>
      <span class="card-badge">3 files</span>
    </div>
    <p>Monotonic binary search on answer template, capacity shipping, and multi-million element search.</p>
  </a>

  <a href="./trie/trie.html" class="category-card">
    <div class="card-header">
      <span class="card-title">Trie & Prefix Trees</span>
      <span class="card-badge">3 files</span>
    </div>
    <p>Dynamic alphabet Trie with prefix word count, recursive word deletion, and Word Search II.</p>
  </a>
</div>
