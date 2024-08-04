package com.example.dp;

/**
 * <p>最小路径和</p>
 * <p>给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。</p>
 * <p>说明：每次只能向下或者向右移动一步。</p>
 */
public class L64_MinPathSum {
    public static void main(String[] args) {

    }

    private static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 初始化dp
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 开始递推
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
