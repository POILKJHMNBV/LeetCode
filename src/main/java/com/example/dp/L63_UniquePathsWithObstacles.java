package com.example.dp;

/**
 * <p>L63:不同路径 II</p>
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。</p>
 * <p>现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？</p>
 * <p>网格中的障碍物和空位置分别用 1 和 0 来表示</p>
 */
public class L63_UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {1,0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];

        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < rows; i++) {
            if (dp[i - 1][0] == 1 && obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < cols; i++) {
            if (dp[0][i - 1] == 1 && obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            }
        }

        // 开始递推
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
