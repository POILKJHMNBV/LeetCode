package com.example.graph;

/**
 * <p>L329:矩阵中的最长递增路径</p>
 * @author zhenwu
 * @date 2024/12/8 20:46
 */
public class L329_LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int maxLength = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, cache, i, j));
            }
        }

        return maxLength;
    }

    private static int dfs(int[][] matrix, int[][] cache, int row, int col) {
        if (cache[row][col] != 0) {
            return cache[row][col];
        }

        int maxLength = 1;
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValid(matrix, newRow, newCol) && matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, cache, newRow, newCol));
            }
        }

        cache[row][col] = maxLength;
        return maxLength;
    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}
