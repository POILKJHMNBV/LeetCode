package com.example.dp;

/**
 * <p>L221:最大正方形</p>
 * <p>在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。</p>
 * @author zhenwu
 * @date 2024/11/3 21:38
 */
public class L221_MaximalSquare {
    public static void main(String[] args) {
        /*char[][] matrix = {
                {'0', '1', '1', '0', '0', '1', '0', '1', '0', '1'},
                {'0', '0', '1', '0', '1', '0', '1', '0', '1', '0'},
                {'1', '0', '0', '0', '0', '1', '0', '1', '1', '0'},
                {'0', '1', '1', '1', '1', '1', '1', '0', '1', '0'},
                {'0', '0', '1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0', '1', '1', '1', '1', '0'},
                {'0', '0', '0', '1', '1', '0', '0', '0', '1', '0'},
                {'1', '1', '0', '1', '1', '0', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '1', '0', '1', '0', '1', '1'}
        };*/
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquarePro(matrix));
    }

    /**
     * 计算最大正方形的面积
     * 动态规划
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     */
    private static int maximalSquarePro(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // dp[i][j] 表示以 matrix[i][j] 为右下角时正方形的最大边长
        int[][] dp = new int[m][n];
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0) && matrix[i][j] == '1') {
                    dp[i][j] = 1;
                } else {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                maxLen = Math.max(dp[i][j], maxLen);
            }
        }
        return maxLen * maxLen;
    }

    /**
     * 计算最大正方形的面积
     * 时间复杂度：O(m * n * min(m,n) * min(m,n))
     * 空间复杂度：O(1)
     * 超时
     */
    private static int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int step = 0;
                while (canExpand(matrix, i, j, step)) {
                    step++;
                }
                maxArea = Math.max(maxArea, step * step);
            }
        }
        return maxArea;
    }

    private static boolean canExpand(char[][] matrix, int i, int j, int step) {
        int m = matrix.length, n = matrix[0].length;
        if (i + step >= m || j + step >= n) {
            return false;
        }
        for (int k = i; k <= i + step; k++) {
            for (int l = j; l <= j + step; l++) {
                if (matrix[k][l] == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
