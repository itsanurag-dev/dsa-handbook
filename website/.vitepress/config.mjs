import { defineConfig } from 'vitepress'

export default defineConfig({
  title: 'DSA Reference Portal',
  description: 'Interactive Coding Interview & Algorithm Reference',
  base: '/Data-Structure-And-Algo/',
  themeConfig: {
    nav: [
      { text: 'Home', link: '/' },
      { text: 'Complexity Sheet', link: '/complexity' },
      { text: 'Data Structures', link: '/datastructures/avl-tree' },
      { text: 'Algorithms', link: '/algorithms/shortest-paths' },
      { text: 'GitHub', link: 'https://github.com/anurag-tiwari-3108/Data-Structure-And-Algo' }
    ],
    sidebar: [
      {
        text: 'Overview',
        items: [
          { text: 'Introduction & Progress', link: '/' },
          { text: 'Complexity Cheat Sheet', link: '/complexity' }
        ]
      },
      {
        text: 'Data Structures',
        items: [
          { text: 'AVL Tree (Self-Balancing)', link: '/datastructures/avl-tree' },
          { text: 'Separate Chaining Hash Table', link: '/datastructures/hash-table' },
          { text: 'LFU Cache', link: '/datastructures/lfu-cache' },
          { text: 'Trie (Prefix Tree)', link: '/datastructures/trie' },
          { text: 'Segment Tree (Lazy Propagation)', link: '/datastructures/segment-tree' },
          { text: 'Fenwick Tree (Binary Indexed Tree)', link: '/datastructures/fenwick-tree' },
          { text: 'Skip List', link: '/datastructures/skip-list' },
          { text: 'Bloom Filter', link: '/datastructures/bloom-filter' },
          { text: 'Flexible Multi-Stack', link: '/datastructures/multi-stack' }
        ]
      },
      {
        text: 'Graph Algorithms',
        items: [
          { text: 'Shortest Paths (Bellman-Ford & Floyd-Warshall)', link: '/algorithms/shortest-paths' },
          { text: 'Minimum Spanning Tree (Kruskal & Prim)', link: '/algorithms/mst' },
          { text: 'Connectivity (Tarjan Bridges & SCC)', link: '/algorithms/tarjan' },
          { text: 'Topological Sort (Kahn & DFS)', link: '/algorithms/topological-sort' }
        ]
      },
      {
        text: 'Dynamic Programming & Patterns',
        items: [
          { text: 'Knapsack (0/1 & Unbounded)', link: '/algorithms/knapsack' },
          { text: 'Binary Search on Answer', link: '/algorithms/binary-search-on-answer' },
          { text: 'String Matching (KMP & Rabin-Karp)', link: '/algorithms/string-matching' },
          { text: 'Greedy & Intervals', link: '/algorithms/greedy-intervals' }
        ]
      }
    ],
    socialLinks: [
      { icon: 'github', link: 'https://github.com/anurag-tiwari-3108/Data-Structure-And-Algo' }
    ],
    search: {
      provider: 'local'
    },
    footer: {
      message: 'Released under the MIT License.',
      copyright: 'Copyright © 2026 Anurag Tiwari'
    }
  }
})

