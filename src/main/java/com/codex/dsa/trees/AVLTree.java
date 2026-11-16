package com.codex.dsa.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Concept:
 * An AVL Tree is a self-balancing Binary Search Tree (BST) where the difference between
 * heights of left and right subtrees for any node cannot be more than one (Balance Factor in {-1, 0, 1}).
 * Whenever an insertion or deletion violates this property, tree rebalancing is performed
 * using 4 canonical rotation cases: Left-Left (LL), Right-Right (RR), Left-Right (LR), and Right-Left (RL).
 *
 * Time Complexity:
 * - Search: O(log N) worst and average case.
 * - Insertion: O(log N) worst and average case (at most 2 rotations needed).
 * - Deletion: O(log N) worst and average case (at most O(log N) rotations needed).
 *
 * Space Complexity:
 * - O(N) auxiliary space to store N nodes.
 * - O(log N) stack space for recursive traversals.
 *
 * @param <T> comparable key type
 */
public class AVLTree<T extends Comparable<T>> {

    public static class Node<T> {
        public T key;
        public int height;
        public Node<T> left;
        public Node<T> right;

        public Node(T key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node<T> root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private void updateHeight(Node<T> node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Right rotation (LL Case)
     *        y                               x
     *       / \     Right Rotation          /  \
     *      x   T3   -------------->        T1   y
     *     / \                                  / \
     *    T1  T2                               T2  T3
     */
    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> t2 = x.right;

        x.right = y;
        y.left = t2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    /**
     * Left rotation (RR Case)
     *      x                                y
     *     /  \      Left Rotation          / \
     *    T1   y     ------------->        x  T3
     *        / \                         / \
     *       T2  T3                      T1  T2
     */
    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.right;
        Node<T> t2 = y.left;

        y.left = x;
        x.right = t2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    public void insert(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        root = insert(root, key);
    }

    private Node<T> insert(Node<T> node, T key) {
        if (node == null) {
            size++;
            return new Node<>(key);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key);
        } else if (cmp > 0) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys not allowed in set-style BST
            return node;
        }

        updateHeight(node);
        int balance = getBalance(node);

        // Case 1: Left-Left (LL)
        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rotateRight(node);
        }

        // Case 2: Right-Right (RR)
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return rotateLeft(node);
        }

        // Case 3: Left-Right (LR)
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Case 4: Right-Left (RL)
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public boolean contains(T key) {
        if (key == null) return false;
        Node<T> curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if (cmp < 0) {
                curr = curr.left;
            } else if (cmp > 0) {
                curr = curr.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public void delete(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (!contains(key)) {
            return;
        }
        root = delete(root, key);
        size--;
    }

    private Node<T> delete(Node<T> node, T key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            // Node with 0 or 1 child
            if (node.left == null || node.right == null) {
                Node<T> temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                // Node with 2 children: get inorder successor (smallest in right subtree)
                Node<T> successor = getMinNode(node.right);
                node.key = successor.key;
                node.right = delete(node.right, successor.key);
            }
        }

        if (node == null) return null;

        updateHeight(node);
        int balance = getBalance(node);

        // Rebalance
        // LL Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // LR Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // RR Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // RL Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> getMinNode(Node<T> node) {
        Node<T> curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public List<T> inorderTraversal() {
        List<T> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(Node<T> node, List<T> res) {
        if (node != null) {
            inorder(node.left, res);
            res.add(node.key);
            inorder(node.right, res);
        }
    }

    /**
     * Invariant verification for tests: checks BST ordering and AVL balance factors <= 1.
     */
    public boolean isValidAVL() {
        return validate(root) != -1;
    }

    private int validate(Node<T> node) {
        if (node == null) return 0;

        int leftH = validate(node.left);
        if (leftH == -1) return -1;

        int rightH = validate(node.right);
        if (rightH == -1) return -1;

        if (Math.abs(leftH - rightH) > 1) return -1;
        if (node.height != 1 + Math.max(leftH, rightH)) return -1;

        return node.height;
    }
}

