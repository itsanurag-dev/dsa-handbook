import { defineConfig } from 'vitepress'

export default defineConfig({
  title: 'DSA Handbook',
  description: 'Complete, Interview-Grade Data Structures & Algorithms Reference Portal',
  base: '/dsa-handbook/',
  themeConfig: {
    nav: [
      {
            "text": "Home",
            "link": "/"
      },
      {
            "text": "Complexity Sheet",
            "link": "/complexity"
      },
      {
            "text": "Topics",
            "items": [
                  {
                        "text": "Arrays & Sliding Window",
                        "link": "/arrays/continuoussubarraymaximumsum"
                  },
                  {
                        "text": "Trees & AVL",
                        "link": "/trees/avltree"
                  },
                  {
                        "text": "Graphs & Shortest Paths",
                        "link": "/graphs/advancedshortestpaths"
                  },
                  {
                        "text": "Dynamic Programming",
                        "link": "/dynamicprogramming/knapsack"
                  },
                  {
                        "text": "Hash Maps & Caches",
                        "link": "/hashmaps/separatechaininghashtable"
                  },
                  {
                        "text": "String Algorithms",
                        "link": "/strings/stringmatchingalgorithms"
                  }
            ]
      },
      {
            "text": "GitHub",
            "link": "https://github.com/anurag-tiwari-3108/dsa-handbook"
      }
],
    sidebar: [
      {
            "text": "Overview",
            "items": [
                  {
                        "text": "Introduction & Progress",
                        "link": "/"
                  },
                  {
                        "text": "Complexity Cheat Sheet",
                        "link": "/complexity"
                  }
            ]
      },
      {
            "text": "Arrays & Sliding Window (38)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Continuous Subarray Maximum Sum",
                        "link": "/arrays/continuoussubarraymaximumsum"
                  },
                  {
                        "text": "Degree Of Array",
                        "link": "/arrays/degreeofarray"
                  },
                  {
                        "text": "Distinct Combination",
                        "link": "/arrays/distinctcombination"
                  },
                  {
                        "text": "Dominator Indexx",
                        "link": "/arrays/dominatorindexx"
                  },
                  {
                        "text": "Dutch National Flag Algo",
                        "link": "/arrays/dutchnationalflagalgo"
                  },
                  {
                        "text": "Employee Free Time",
                        "link": "/arrays/employeefreetime"
                  },
                  {
                        "text": "Fibonacci",
                        "link": "/arrays/fibonacci"
                  },
                  {
                        "text": "First Duplicate",
                        "link": "/arrays/firstduplicate"
                  },
                  {
                        "text": "Fisher Yates Shuffle",
                        "link": "/arrays/fisheryatesshuffle"
                  },
                  {
                        "text": "Has Duplicate Sliding Window",
                        "link": "/arrays/hasduplicateslidingwindow"
                  },
                  {
                        "text": "Largest Subarray With Distinct Values",
                        "link": "/arrays/largestsubarraywithdistinctvalues"
                  },
                  {
                        "text": "Longest Substring With K Unique",
                        "link": "/arrays/longestsubstringwithkunique"
                  },
                  {
                        "text": "Max Consecutive Ones",
                        "link": "/arrays/maxconsecutiveones"
                  },
                  {
                        "text": "Max Sub Arraywith0 And1 Params",
                        "link": "/arrays/maxsubarraywith0and1params"
                  },
                  {
                        "text": "Maximum Diff In Array",
                        "link": "/arrays/maximumdiffinarray"
                  },
                  {
                        "text": "Maximum Gift Counts",
                        "link": "/arrays/maximumgiftcounts"
                  },
                  {
                        "text": "Meeting Rooms_II",
                        "link": "/arrays/meetingrooms_ii"
                  },
                  {
                        "text": "Merge Sorted Array",
                        "link": "/arrays/mergesortedarray"
                  },
                  {
                        "text": "Minimum Platforms",
                        "link": "/arrays/minimumplatforms"
                  },
                  {
                        "text": "Minimum Sum Subarray Greater",
                        "link": "/arrays/minimumsumsubarraygreater"
                  },
                  {
                        "text": "Minimum Sum Subarray Size",
                        "link": "/arrays/minimumsumsubarraysize"
                  },
                  {
                        "text": "Minimum Sum Subarray Value",
                        "link": "/arrays/minimumsumsubarrayvalue"
                  },
                  {
                        "text": "Move Element To End",
                        "link": "/arrays/moveelementtoend"
                  },
                  {
                        "text": "Moving Average",
                        "link": "/arrays/movingaverage"
                  },
                  {
                        "text": "Number Of Subarray Pair",
                        "link": "/arrays/numberofsubarraypair"
                  },
                  {
                        "text": "Partition",
                        "link": "/arrays/partition"
                  },
                  {
                        "text": "Permutation",
                        "link": "/arrays/permutation"
                  },
                  {
                        "text": "Permutation Sequence",
                        "link": "/arrays/permutationsequence"
                  },
                  {
                        "text": "Print Combination",
                        "link": "/arrays/printcombination"
                  },
                  {
                        "text": "Product Except Self Without Division",
                        "link": "/arrays/productexceptselfwithoutdivision"
                  },
                  {
                        "text": "Profit Earned",
                        "link": "/arrays/profitearned"
                  },
                  {
                        "text": "Remove Duplicates",
                        "link": "/arrays/removeduplicates"
                  },
                  {
                        "text": "Sub Set Sum1",
                        "link": "/arrays/subsetsum1"
                  },
                  {
                        "text": "Subarray Sum K",
                        "link": "/arrays/subarraysumk"
                  },
                  {
                        "text": "Subarray Sum Zero",
                        "link": "/arrays/subarraysumzero"
                  },
                  {
                        "text": "Subset Sum2",
                        "link": "/arrays/subsetsum2"
                  },
                  {
                        "text": "Top K Frequent Element",
                        "link": "/arrays/topkfrequentelement"
                  },
                  {
                        "text": "Top K Hotel",
                        "link": "/arrays/topkhotel"
                  }
            ]
      },
      {
            "text": "Backtracking (11)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Backtrack Util",
                        "link": "/backtracking/backtrackutil"
                  },
                  {
                        "text": "Generate IP",
                        "link": "/backtracking/generateip"
                  },
                  {
                        "text": "K Partition Problem",
                        "link": "/backtracking/kpartitionproblem"
                  },
                  {
                        "text": "Knight Tour",
                        "link": "/backtracking/knighttour"
                  },
                  {
                        "text": "N Queen",
                        "link": "/backtracking/nqueen"
                  },
                  {
                        "text": "N Queen2",
                        "link": "/backtracking/nqueen2"
                  },
                  {
                        "text": "Rat In Maze",
                        "link": "/backtracking/ratinmaze"
                  },
                  {
                        "text": "Rat In Maze BFS",
                        "link": "/backtracking/ratinmazebfs"
                  },
                  {
                        "text": "Shortest Routes In Rectangular",
                        "link": "/backtracking/shortestroutesinrectangular"
                  },
                  {
                        "text": "Sudoku",
                        "link": "/backtracking/sudoku"
                  },
                  {
                        "text": "Word Boggle",
                        "link": "/backtracking/wordboggle"
                  }
            ]
      },
      {
            "text": "Binary Search Tree (9)",
            "collapsed": true,
            "items": [
                  {
                        "text": "BSTCRUD Operations",
                        "link": "/binarysearchtree/bstcrudoperations"
                  },
                  {
                        "text": "Build BST From Preorder",
                        "link": "/binarysearchtree/buildbstfrompreorder"
                  },
                  {
                        "text": "Convert B Tto BST",
                        "link": "/binarysearchtree/convertbttobst"
                  },
                  {
                        "text": "Create Minimal BST",
                        "link": "/binarysearchtree/createminimalbst"
                  },
                  {
                        "text": "Lowest Common Ancestor Of BST",
                        "link": "/binarysearchtree/lowestcommonancestorofbst"
                  },
                  {
                        "text": "Node",
                        "link": "/binarysearchtree/node"
                  },
                  {
                        "text": "Unique BST",
                        "link": "/binarysearchtree/uniquebst"
                  },
                  {
                        "text": "Validate BST",
                        "link": "/binarysearchtree/validatebst"
                  },
                  {
                        "text": "Validate BST Inorder",
                        "link": "/binarysearchtree/validatebstinorder"
                  }
            ]
      },
      {
            "text": "Bit Manipulation (2)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Power Of Two",
                        "link": "/bitwise/poweroftwo"
                  },
                  {
                        "text": "Product Of1",
                        "link": "/bitwise/productof1"
                  }
            ]
      },
      {
            "text": "Divide & Conquer (3)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Binary Search On Answer",
                        "link": "/divideandconquer/binarysearchonanswer"
                  },
                  {
                        "text": "Number Frequency",
                        "link": "/divideandconquer/numberfrequency"
                  },
                  {
                        "text": "Search Number In Milions Of Data",
                        "link": "/divideandconquer/searchnumberinmilionsofdata"
                  }
            ]
      },
      {
            "text": "Dynamic Programming (3)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Knapsack",
                        "link": "/dynamicprogramming/knapsack"
                  },
                  {
                        "text": "Max Length Chain",
                        "link": "/dynamicprogramming/maxlengthchain"
                  },
                  {
                        "text": "Min Coin Changes",
                        "link": "/dynamicprogramming/mincoinchanges"
                  }
            ]
      },
      {
            "text": "Graph Algorithms (19)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Advanced Shortest Paths",
                        "link": "/graphs/advancedshortestpaths"
                  },
                  {
                        "text": "Cycke Detection In DAG",
                        "link": "/graphs/cyckedetectionindag"
                  },
                  {
                        "text": "Cycle In Un Directed Graph DFS",
                        "link": "/graphs/cycleinundirectedgraphdfs"
                  },
                  {
                        "text": "Cycle In Undirected Graph BFS",
                        "link": "/graphs/cycleinundirectedgraphbfs"
                  },
                  {
                        "text": "Graph",
                        "link": "/graphs/graph"
                  },
                  {
                        "text": "Graph BFS",
                        "link": "/graphs/graphbfs"
                  },
                  {
                        "text": "Graph Coloring BFS",
                        "link": "/graphs/graphcoloringbfs"
                  },
                  {
                        "text": "Graph Coloring DFS",
                        "link": "/graphs/graphcoloringdfs"
                  },
                  {
                        "text": "Graph DFS",
                        "link": "/graphs/graphdfs"
                  },
                  {
                        "text": "Graph M Coloring",
                        "link": "/graphs/graphmcoloring"
                  },
                  {
                        "text": "Kahn Topological Sort",
                        "link": "/graphs/kahntopologicalsort"
                  },
                  {
                        "text": "Minimum Spanning Tree",
                        "link": "/graphs/minimumspanningtree"
                  },
                  {
                        "text": "Robot Cleaning",
                        "link": "/graphs/robotcleaning"
                  },
                  {
                        "text": "Route Between Nodes",
                        "link": "/graphs/routebetweennodes"
                  },
                  {
                        "text": "Strongly Connected Graph",
                        "link": "/graphs/stronglyconnectedgraph"
                  },
                  {
                        "text": "Tarjan Graph Algorithms",
                        "link": "/graphs/tarjangraphalgorithms"
                  },
                  {
                        "text": "Topological Sort",
                        "link": "/graphs/topologicalsort"
                  },
                  {
                        "text": "Undirected Graph Connected Components",
                        "link": "/graphs/undirectedgraphconnectedcomponents"
                  },
                  {
                        "text": "Word Ladder_2",
                        "link": "/graphs/wordladder_2"
                  }
            ]
      },
      {
            "text": "Greedy Algorithms (4)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Activity Selection Problem",
                        "link": "/greedyalgorithms/activityselectionproblem"
                  },
                  {
                        "text": "Employee",
                        "link": "/greedyalgorithms/employee"
                  },
                  {
                        "text": "Employee Impl",
                        "link": "/greedyalgorithms/employeeimpl"
                  },
                  {
                        "text": "Huffman",
                        "link": "/greedyalgorithms/huffman"
                  }
            ]
      },
      {
            "text": "Hash Maps & Caches (15)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Bloom Filter",
                        "link": "/hashmaps/bloomfilter"
                  },
                  {
                        "text": "Executer With Concurrent Hashmap",
                        "link": "/hashmaps/executerwithconcurrenthashmap"
                  },
                  {
                        "text": "Hash Code Implemention",
                        "link": "/hashmaps/hashcodeimplemention"
                  },
                  {
                        "text": "Hash Map Operations",
                        "link": "/hashmaps/hashmapoperations"
                  },
                  {
                        "text": "Hashcode And Equals",
                        "link": "/hashmaps/hashcodeandequals"
                  },
                  {
                        "text": "Hashmap Intro",
                        "link": "/hashmaps/hashmapintro"
                  },
                  {
                        "text": "Java Map Employee",
                        "link": "/hashmaps/javamapemployee"
                  },
                  {
                        "text": "Java Map Employee Demo",
                        "link": "/hashmaps/javamapemployeedemo"
                  },
                  {
                        "text": "LFU Cache",
                        "link": "/hashmaps/lfucache"
                  },
                  {
                        "text": "LRU Cashe Implementation",
                        "link": "/hashmaps/lrucasheimplementation"
                  },
                  {
                        "text": "Node",
                        "link": "/hashmaps/node"
                  },
                  {
                        "text": "Price For Hash Code Implementation",
                        "link": "/hashmaps/priceforhashcodeimplementation"
                  },
                  {
                        "text": "Separate Chaining Hash Table",
                        "link": "/hashmaps/separatechaininghashtable"
                  },
                  {
                        "text": "Size Of Map",
                        "link": "/hashmaps/sizeofmap"
                  },
                  {
                        "text": "Sort Array Map",
                        "link": "/hashmaps/sortarraymap"
                  }
            ]
      },
      {
            "text": "Linked Lists (6)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Loop Detection",
                        "link": "/linkedlists/loopdetection"
                  },
                  {
                        "text": "Merge K Sorted List",
                        "link": "/linkedlists/mergeksortedlist"
                  },
                  {
                        "text": "Node",
                        "link": "/linkedlists/node"
                  },
                  {
                        "text": "Remove Duplicate",
                        "link": "/linkedlists/removeduplicate"
                  },
                  {
                        "text": "Reorder List",
                        "link": "/linkedlists/reorderlist"
                  },
                  {
                        "text": "Skip List",
                        "link": "/linkedlists/skiplist"
                  }
            ]
      },
      {
            "text": "2D Matrices & Grids (6)",
            "collapsed": true,
            "items": [
                  {
                        "text": "No Of Island2",
                        "link": "/matrices/noofisland2"
                  },
                  {
                        "text": "Number Of Island",
                        "link": "/matrices/numberofisland"
                  },
                  {
                        "text": "Replace Encountered Element",
                        "link": "/matrices/replaceencounteredelement"
                  },
                  {
                        "text": "Rotate Matrix",
                        "link": "/matrices/rotatematrix"
                  },
                  {
                        "text": "Walls And Gates",
                        "link": "/matrices/wallsandgates"
                  },
                  {
                        "text": "Word Search",
                        "link": "/matrices/wordsearch"
                  }
            ]
      },
      {
            "text": "Stacks & Queues (9)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Balanced Parenthiese",
                        "link": "/stacks/balancedparenthiese"
                  },
                  {
                        "text": "Fixed Multistack From Array",
                        "link": "/stacks/fixedmultistackfromarray"
                  },
                  {
                        "text": "Flaxible Multistack From Array",
                        "link": "/stacks/flaxiblemultistackfromarray"
                  },
                  {
                        "text": "Longest Parenthses",
                        "link": "/stacks/longestparenthses"
                  },
                  {
                        "text": "Min Stack With Extra Space",
                        "link": "/stacks/minstackwithextraspace"
                  },
                  {
                        "text": "Stack From Array",
                        "link": "/stacks/stackfromarray"
                  },
                  {
                        "text": "Stack From Linkedlist",
                        "link": "/stacks/stackfromlinkedlist"
                  },
                  {
                        "text": "Stack Implementation",
                        "link": "/stacks/stackimplementation"
                  },
                  {
                        "text": "Well Formed Parentheses",
                        "link": "/stacks/wellformedparentheses"
                  }
            ]
      },
      {
            "text": "String Algorithms (21)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Addition Of String Number",
                        "link": "/strings/additionofstringnumber"
                  },
                  {
                        "text": "Balance String",
                        "link": "/strings/balancestring"
                  },
                  {
                        "text": "Convert Number To Excel Column",
                        "link": "/strings/convertnumbertoexcelcolumn"
                  },
                  {
                        "text": "LCP",
                        "link": "/strings/lcp"
                  },
                  {
                        "text": "Levenshtein Distance",
                        "link": "/strings/levenshteindistance"
                  },
                  {
                        "text": "Longest Common Subsequence",
                        "link": "/strings/longestcommonsubsequence"
                  },
                  {
                        "text": "Longest Common Substring",
                        "link": "/strings/longestcommonsubstring"
                  },
                  {
                        "text": "Number Combination Digisible By N",
                        "link": "/strings/numbercombinationdigisiblebyn"
                  },
                  {
                        "text": "One Away Strings",
                        "link": "/strings/oneawaystrings"
                  },
                  {
                        "text": "Palindrome Permutation",
                        "link": "/strings/palindromepermutation"
                  },
                  {
                        "text": "Palindrome String",
                        "link": "/strings/palindromestring"
                  },
                  {
                        "text": "Permutations",
                        "link": "/strings/permutations"
                  },
                  {
                        "text": "Rejected Transaction",
                        "link": "/strings/rejectedtransaction"
                  },
                  {
                        "text": "Smoothie",
                        "link": "/strings/smoothie"
                  },
                  {
                        "text": "String Compression",
                        "link": "/strings/stringcompression"
                  },
                  {
                        "text": "String Matching Algorithms",
                        "link": "/strings/stringmatchingalgorithms"
                  },
                  {
                        "text": "String To Int",
                        "link": "/strings/stringtoint"
                  },
                  {
                        "text": "Top K Frequent Words",
                        "link": "/strings/topkfrequentwords"
                  },
                  {
                        "text": "UR Lify",
                        "link": "/strings/urlify"
                  },
                  {
                        "text": "Unique Character",
                        "link": "/strings/uniquecharacter"
                  },
                  {
                        "text": "Validate Rotated String",
                        "link": "/strings/validaterotatedstring"
                  }
            ]
      },
      {
            "text": "Trees & Traversals (29)",
            "collapsed": true,
            "items": [
                  {
                        "text": "AVL Tree",
                        "link": "/trees/avltree"
                  },
                  {
                        "text": "Binaray Tree Node",
                        "link": "/trees/binaraytreenode"
                  },
                  {
                        "text": "Binary Tree",
                        "link": "/trees/binarytree"
                  },
                  {
                        "text": "Binary Tree2 Double Linked List",
                        "link": "/trees/binarytree2doublelinkedlist"
                  },
                  {
                        "text": "Bottom View",
                        "link": "/trees/bottomview"
                  },
                  {
                        "text": "Boundary Of Binary Tree",
                        "link": "/trees/boundaryofbinarytree"
                  },
                  {
                        "text": "Build Special Tree",
                        "link": "/trees/buildspecialtree"
                  },
                  {
                        "text": "Diameter Of Tree",
                        "link": "/trees/diameteroftree"
                  },
                  {
                        "text": "Fenwick Tree",
                        "link": "/trees/fenwicktree"
                  },
                  {
                        "text": "Height Of Tree",
                        "link": "/trees/heightoftree"
                  },
                  {
                        "text": "Identical Tree",
                        "link": "/trees/identicaltree"
                  },
                  {
                        "text": "Inorder Predecessor",
                        "link": "/trees/inorderpredecessor"
                  },
                  {
                        "text": "Inorder Successor",
                        "link": "/trees/inordersuccessor"
                  },
                  {
                        "text": "Insert Delete BST Node",
                        "link": "/trees/insertdeletebstnode"
                  },
                  {
                        "text": "Left View",
                        "link": "/trees/leftview"
                  },
                  {
                        "text": "Left View Iterative",
                        "link": "/trees/leftviewiterative"
                  },
                  {
                        "text": "Level Order Traversal",
                        "link": "/trees/levelordertraversal"
                  },
                  {
                        "text": "List Of Depth",
                        "link": "/trees/listofdepth"
                  },
                  {
                        "text": "Lowest Common Ancestor",
                        "link": "/trees/lowestcommonancestor"
                  },
                  {
                        "text": "Max Sum Subtree",
                        "link": "/trees/maxsumsubtree"
                  },
                  {
                        "text": "N Ary Tree",
                        "link": "/trees/narytree"
                  },
                  {
                        "text": "N Ary Tree Serilization",
                        "link": "/trees/narytreeserilization"
                  },
                  {
                        "text": "Node",
                        "link": "/trees/node"
                  },
                  {
                        "text": "Print Right View",
                        "link": "/trees/printrightview"
                  },
                  {
                        "text": "Segment Tree",
                        "link": "/trees/segmenttree"
                  },
                  {
                        "text": "Spiral Order Traversal",
                        "link": "/trees/spiralordertraversal"
                  },
                  {
                        "text": "Subtree Under Tree",
                        "link": "/trees/subtreeundertree"
                  },
                  {
                        "text": "Tree Travesal",
                        "link": "/trees/treetravesal"
                  },
                  {
                        "text": "Vertical View",
                        "link": "/trees/verticalview"
                  }
            ]
      },
      {
            "text": "Trie (Prefix Trees) (3)",
            "collapsed": true,
            "items": [
                  {
                        "text": "Longest Common Prefix",
                        "link": "/trie/longestcommonprefix"
                  },
                  {
                        "text": "Trie",
                        "link": "/trie/trie"
                  },
                  {
                        "text": "Word Search2",
                        "link": "/trie/wordsearch2"
                  }
            ]
      }
],
    socialLinks: [
      { icon: 'github', link: 'https://github.com/anurag-tiwari-3108/dsa-handbook' }
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
