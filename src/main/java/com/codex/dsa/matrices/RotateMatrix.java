package com.codex.dsa.matrices;

/**
 * Concept:
 * In-place 90-degree clockwise rotation of an N x N 2D matrix.
 * Can be performed in two linear passes with O(1) auxiliary space:
 * 1. Transpose the matrix: swap matrix[i][j] with matrix[j][i].
 * 2. Reverse each row: reverse elements of matrix[i] from left to right.
 *
 * For counter-clockwise rotation:
 * 1. Transpose the matrix.
 * 2. Reverse each column.
 *
 * Time Complexity:
 * - O(N^2) total swaps.
 *
 * Space Complexity:
 * - O(1) auxiliary space (strict in-place).
 */
public class RotateMatrix {

    /**
     * Rotates an N x N matrix 90 degrees clockwise in-place.
     */
    public static void rotateClockwise(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        int n = matrix.length;

        // Step 1: Transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
